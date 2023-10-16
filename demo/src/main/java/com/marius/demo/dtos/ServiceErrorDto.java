package com.marius.demo.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.marius.demo.constants.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Class to map exceptions thrown inside the application.
 * This class is used as a response model in case something went wrong
 */
@Getter
@Schema(name = "ErrorResponse")
public class ServiceErrorDto {

    // Node names in the JSON
    private static final String ERRORS_NODE = "errors";
    private static final String ERROR_DETAILS_NODE = "errorDetails";
    private static final String TIMESTAMP_NODE = "timestamp";

    @JsonProperty(Constants.CODE)
    private final int code;

    @JsonProperty(Constants.MESSAGE)
    private final String message;

    @JsonProperty(TIMESTAMP_NODE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.TIMESTAMP_FORMAT)
    private final LocalDateTime timestamp;

    /**
     * Constructor with all parameters
     * @param code Code associated with the exception
     * @param message Exception message
     */
    public ServiceErrorDto(
            final int code, final String message
    ) {
        this.code = code;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}

