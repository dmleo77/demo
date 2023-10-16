package com.marius.demo.products.use.cases;

import com.marius.demo.dtos.SuccessfulResponseDto;
import com.marius.demo.products.dtos.PricesResponseDto;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface GetPricesMain {
    Mono<SuccessfulResponseDto<PricesResponseDto>> execute(final Map<String, String> entryData);
}
