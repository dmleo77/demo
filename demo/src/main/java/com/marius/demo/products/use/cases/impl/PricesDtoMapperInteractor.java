package com.marius.demo.products.use.cases.impl;

import com.marius.demo.constants.Constants;
import com.marius.demo.products.dtos.PricesDto;
import com.marius.demo.products.dtos.PricesResponseDto;
import com.marius.demo.products.use.cases.PricesDtoMapper;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Simple mapper class
 */
@Slf4j
@Service
@Builder
public class PricesDtoMapperInteractor implements PricesDtoMapper {

    /**
     * Map values from pricesDto and  applicationDate to PricesResponseDto
     * @param pricesDto price
     * @param applicationDate application date
     * @return PricesResponseDto
     */
    public PricesResponseDto ToPricesResponseDto(PricesDto pricesDto, String applicationDate){
        log.info("ToPricesResponseDto -> pricesDto: " + pricesDto + " | applicationDate: " + applicationDate);
        return PricesResponseDto.builder()
                .productId(pricesDto.getProductId())
                .brandId(pricesDto.getBrandId())
                .priceList(pricesDto.getPriceList())
                .applicationDate(applicationDate)
                .price(pricesDto.getPrice().toString())
                .build();
    }
}
