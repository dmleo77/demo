package com.marius.demo.products;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * For tests to work you have to run first the main app
 */
@ExtendWith(SpringExtension.class)
class IntegrationTests {
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    void test1() throws JSONException {
        // Given
        headers.setBearerAuth("Auth");
        String applicationDate = "2020-06-14 10.00.00";
        String productId = "35455";
        String brandId = "1";
        String url =  "http://localhost:9150/v1/get-price/"+applicationDate +"/"+productId +"/"+brandId;

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        String expected = """
                {
                  "status": "OK",
                  "messageId": "00",
                  "message": "OK",
                  "data": {
                    "productId": "35455",
                    "brandId": "1",
                    "priceList": "1",
                    "applicationDate": "2020-06-14 10.00.00",
                    "price": "35.50"
                  }
                }""";

        //Then
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    void test2() throws JSONException {
        // Given
        headers.setBearerAuth("Auth");
        String applicationDate = "2020-06-14 16.00.00";
        String productId = "35455";
        String brandId = "1";
        String url =  "http://localhost:9150/v1/get-price/"+applicationDate +"/"+productId +"/"+brandId;

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        String expected = """
                {
                  "status": "OK",
                  "messageId": "00",
                  "message": "OK",
                  "data": {
                    "productId": "35455",
                    "brandId": "1",
                    "priceList": "2",
                    "applicationDate": "2020-06-14 16.00.00",
                    "price": "25.45"
                  }
                }""";

        //Then
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    void test3() throws JSONException {
        // Given
        headers.setBearerAuth("Auth");
        String applicationDate = "2020-06-14 21.00.00";
        String productId = "35455";
        String brandId = "1";
        String url =  "http://localhost:9150/v1/get-price/"+applicationDate +"/"+productId +"/"+brandId;

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        String expected = """
                {
                  "status": "OK",
                  "messageId": "00",
                  "message": "OK",
                  "data": {
                    "productId": "35455",
                    "brandId": "1",
                    "priceList": "1",
                    "applicationDate": "2020-06-14 21.00.00",
                    "price": "35.50"
                  }
                }""";

        //Then
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    void test4() throws JSONException {
        // Given
        headers.setBearerAuth("Auth");
        String applicationDate = "2020-06-15 10.00.00";
        String productId = "35455";
        String brandId = "1";
        String url =  "http://localhost:9150/v1/get-price/"+applicationDate +"/"+productId +"/"+brandId;

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        String expected = """
                {
                  "status": "OK",
                  "messageId": "00",
                  "message": "OK",
                  "data": {
                    "productId": "35455",
                    "brandId": "1",
                    "priceList": "3",
                    "applicationDate": "2020-06-15 10.00.00",
                    "price": "30.50"
                  }
                }""";

        //Then
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    void test5() throws JSONException {
        // Given
        headers.setBearerAuth("Auth");
        String applicationDate = "2020-06-16 21.00.00";
        String productId = "35455";
        String brandId = "1";
        String url =  "http://localhost:9150/v1/get-price/"+applicationDate +"/"+productId +"/"+brandId;

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        String expected = """
                {
                  "status": "OK",
                  "messageId": "00",
                  "message": "OK",
                  "data": {
                    "productId": "35455",
                    "brandId": "1",
                    "priceList": "4",
                    "applicationDate": "2020-06-16 21.00.00",
                    "price": "38.95"
                  }
                }""";

        //Then
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }
}