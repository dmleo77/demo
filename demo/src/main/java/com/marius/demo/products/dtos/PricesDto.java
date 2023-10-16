package com.marius.demo.products.dtos;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Class for data from H2 database
 */
@Builder
@Entity
@Table(name = "prices")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PricesDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "BRAND_ID")
    String brandId;
    @Column(name = "START_DATE")
    Timestamp startDate;
    @Column(name = "END_DATE")
    Timestamp endDate;
    @Column(name = "PRICE_LIST")
    String priceList;
    @Column(name = "PRODUCT_ID")
    String productId;
    @Column(name = "PRIORITY")
    Integer priority;
    @Column(name = "PRICE")
    BigDecimal price;
    @Column(name = "CURR")
    String curr;
}
