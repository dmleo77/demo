package com.marius.demo.constants;

/**
 * Class designed to hold constants used by different domains.
 * These constants can be used by layers(adapters and use cases) other
 * than the domain layer
 */
public class Constants {

    private Constants() {
        throw new IllegalStateException("SharedConstants should not be instantiated");
    }

    // Fields used on error responses
    public static final String CODE = "code";
    public static final String MESSAGE = "message";
    public static final String SUCCESS = "Success";

    // Formats
    public static final String TIMESTAMP_FORMAT = "dd-MM-yyyy HH:mm:ss";

    // OpenAPI types
    public static final String OPEN_API_STRING_TYPE = "string";

    // Fields used on requests/responses
    public static final String STATUS = "status";
    public static final String MESSAGE_ID = "messageId";
    public static final String DATA = "data";

    //Fields used in controller
    public static final String APPLICATION_DATE = "applicationDate";
    public static final String PRODUCT_ID = "productId";
    public static final String BRAND_ID = "brandID";
}
