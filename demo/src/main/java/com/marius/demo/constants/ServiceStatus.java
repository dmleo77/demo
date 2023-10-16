package com.marius.demo.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Class that lists the application statues.
 * Each status contains and id and an associated message.
 * For example, an HTTP status 200 - OK,
 * can be linked to ServiceStatus.OK(...)
 */
@Getter
@AllArgsConstructor
public enum ServiceStatus {

    OK("00", "Information retrieved successfully"),
    CREATED("01", "Information updated successfully"),
    NO_CONTENT("02", "No content available for requested resources"),
    PARTIAL_CONTENT("03", "The service couldn't find all the requested resources"),
    BAD_REQUEST("93", "The request sent is wrong. Try to fix it and try again"),
    UNAUTHORIZED("94", "You need to be authenticated to perform the action"),
    FORBIDDEN("95", "You need to have permissions to perform the action"),
    NOT_FOUND("96", "The service couldn't find an appropriate response"),
    NOT_ACCEPTABLE("97", "Impossible to find the content according to the established criteria"),
    CONFLICT("98", "The request sent conflicts with the current server status"),
    INTERNAL_SERVER_ERROR("99", "Something went wrong. Please try again");

    private final String messageId;
    private final String message;
}
