package com.marius.demo.products.dtos;

import com.marius.demo.constants.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

/**
 * Class for end point response
 */
@Value
@Builder
public class PricesResponseDto {
    @Schema(name = "productId",
            example = "35455",
            type = Constants.OPEN_API_STRING_TYPE)
    String productId;
    @Schema(name = "brandId",
            example = "1",
            type = Constants.OPEN_API_STRING_TYPE)
    String brandId;
    @Schema(name = "priceList",
            example = "2",
            type = Constants.OPEN_API_STRING_TYPE)
    String priceList;
    @Schema(name = "applicationDate",
            example = "2020-06-15-15:00:00",
            type = Constants.OPEN_API_STRING_TYPE)
    String applicationDate;
    @Schema(name = "price",
            example = "30.50",
            type = Constants.OPEN_API_STRING_TYPE)
    String price;
}
