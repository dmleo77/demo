package com.marius.demo.services;

import com.marius.demo.products.dtos.PricesDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface GetProductsFromDb {
    Mono<List<PricesDto>> getPrices(String data, String brandId, String productId);
}
