package com.marius.demo.services.impl;

import com.marius.demo.constants.Constants;
import com.marius.demo.error.ServiceException;
import com.marius.demo.products.dtos.PricesDto;
import com.marius.demo.products.use.cases.PricesDtoMapper;
import com.marius.demo.repositories.H2Repository;
import com.marius.demo.services.GetProductsFromDb;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Get items from database and send as Mono
 */
@Slf4j
@Service
@Builder
public class GetProductsFromDbImpl implements GetProductsFromDb {
    @Autowired
    H2Repository h2Repository;
    @Autowired
    PricesDtoMapper pricesDtoMapper;

    /**
     * Get prices for a product from H2 database for a specific date and brand
     * @param applicationDate application date for the price
     * @param brandId brand id
     * @param productId product id
     * @return list of prices dto
     */
    public Mono<List<PricesDto>> getPrices(String applicationDate, String brandId, String productId){
        log.info("getPrices -> applicationDate: " + applicationDate + " | brandId: " + brandId + " | productId: " + productId);
        //get price list from h2 database
        List<PricesDto> result = h2Repository.findByDataAndBrandIdAndProductId(applicationDate, brandId, productId);
        log.info("Result: " + result.toString());
        //error if price list is empty
        if(result.isEmpty()){
            log.error("No price found for applicationDate: " + applicationDate + " | brandId: " + brandId + " | productId: " + productId);
            throw new ServiceException(String.valueOf(HttpStatus.NOT_FOUND.value()), "No price found for applicationDate: " + applicationDate + " | brandId: " + brandId + " | productId: " + productId);
        }
        log.info(Constants.SUCCESS);
        //return the result
        return Mono.just(result);
    }
}
