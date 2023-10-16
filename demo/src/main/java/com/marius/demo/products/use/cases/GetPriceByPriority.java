package com.marius.demo.products.use.cases;

import com.marius.demo.products.dtos.PricesDto;

import java.util.List;

public interface GetPriceByPriority {
    PricesDto getPrice(List<PricesDto> priceList);
}
