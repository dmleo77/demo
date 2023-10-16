package com.marius.demo.products.use.cases;

import com.marius.demo.products.dtos.PricesDto;
import com.marius.demo.products.dtos.PricesResponseDto;

public interface PricesDtoMapper {
    PricesResponseDto ToPricesResponseDto(PricesDto pricesDto, String applicationDate);
}
