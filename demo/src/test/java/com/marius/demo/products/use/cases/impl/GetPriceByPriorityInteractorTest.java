package com.marius.demo.products.use.cases.impl;

import com.marius.demo.products.dtos.PricesDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test
 */
class GetPriceByPriorityInteractorTest {
    @Mock
    Logger log;
    @InjectMocks
    GetPriceByPriorityInteractor getPriceByPriorityInteractor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPrice() {
        List<PricesDto> priceList = new ArrayList<>();
        priceList.add(PricesDto.builder()
                .id(1)
                .brandId("1")
                .startDate(null)
                .endDate(null)
                .priceList("")
                .productId("3455")
                .priority(1)
                .price(new BigDecimal(5))
                .curr("EUR")
                .build());
        priceList.add(PricesDto.builder()
                .id(1)
                .brandId("1")
                .startDate(null)
                .endDate(null)
                .priceList("")
                .productId("3455")
                .priority(2)
                .price(new BigDecimal(10))
                .curr("EUR")
                .build());
        PricesDto result = getPriceByPriorityInteractor.getPrice(priceList);
        Assertions.assertEquals(new BigDecimal(10), result.getPrice());

    }

    @Test
    void testBuilder() {
        GetPriceByPriorityInteractor.GetPriceByPriorityInteractorBuilder result = GetPriceByPriorityInteractor.builder();
        Assertions.assertNotEquals(null, result);
    }
}
