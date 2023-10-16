package com.marius.demo.products.use.cases.impl;

import com.marius.demo.constants.ServiceStatus;
import com.marius.demo.constants.Constants;
import com.marius.demo.dtos.SuccessfulResponseDto;
import com.marius.demo.products.dtos.PricesResponseDto;
import com.marius.demo.products.use.cases.GetPriceByPriority;
import com.marius.demo.products.use.cases.GetPricesMain;
import com.marius.demo.products.use.cases.PricesDtoMapper;
import com.marius.demo.services.GetProductsFromDb;
import com.marius.demo.services.Validate;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * Main interactor
 */
@Slf4j
@Service
@Builder
public class GetPricesMainInteractor implements GetPricesMain {
    GetProductsFromDb getProductsFromDb;
    Validate validate;
    GetPriceByPriority getPriceByPriority;
    PricesDtoMapper pricesDtoMapper;

    /**
     * Functional logic to get the price from a price list
     * @param entryData end point entry data
     * @return price
     */
    public Mono<SuccessfulResponseDto<PricesResponseDto>> execute(final Map<String, String> entryData){
        var applicationDate = entryData.get(Constants.APPLICATION_DATE);
        var brandId = entryData.get(Constants.BRAND_ID);
        var productId = entryData.get(Constants.PRODUCT_ID);

        //validate data, brandId, productId
        validate.validateNotBlankAndFixedLength(applicationDate, Constants.APPLICATION_DATE,19);
        validate.validateNotBlankAndFixedLength(brandId, Constants.BRAND_ID,1);
        validate.validateNotBlankAndFixedLength(productId, Constants.PRODUCT_ID,5);

        //get list of prices
        return getProductsFromDb.getPrices(applicationDate, brandId, productId)
                .map(priceList ->{
                    //get price from price list by priority
                    var price = getPriceByPriority.getPrice(priceList);
                    //map priceDto to pricesResponseDto
                    var result = pricesDtoMapper.ToPricesResponseDto(price, applicationDate);
                    //return Mono<SuccessfulResponseDto<PricesResponseDto>>
                    return SuccessfulResponseDto.<PricesResponseDto>builder()
                            .status(HttpStatus.OK.getReasonPhrase())
                            .message(HttpStatus.OK.getReasonPhrase())
                            .data(result)
                            .messageId(String.valueOf(ServiceStatus.OK.getMessageId()))
                            .build();
        });
    }
}
