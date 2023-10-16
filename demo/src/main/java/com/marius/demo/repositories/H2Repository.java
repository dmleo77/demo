package com.marius.demo.repositories;

import com.marius.demo.products.dtos.PricesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository for H2 database
 */
public interface H2Repository extends JpaRepository<PricesDto, Long> {

    @Query(value = "SELECT * FROM prices p WHERE p.start_date <= :application_date AND p.end_date >= :application_date AND p.brand_id = :brand_id AND p.product_id = :product_id",
            nativeQuery = true)
    List<PricesDto> findByDataAndBrandIdAndProductId(
            @Param("application_date") String applicationDate,
            @Param("brand_id") String salary,
            @Param("product_id") String productId);
}
