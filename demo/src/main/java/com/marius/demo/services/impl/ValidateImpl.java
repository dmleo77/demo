package com.marius.demo.services.impl;

import com.marius.demo.constants.Constants;
import com.marius.demo.error.ServiceException;
import com.marius.demo.services.Validate;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Service for validations
 */
@Slf4j
@Service
@Builder
public class ValidateImpl implements Validate {

    /**
     * Validates string for blank and fixed length
     * Throw service exception when not valid
     * @param item string to be validated
     * @param itemName name to be included in error message
     * @param length length to compare
     */
    public void validateNotBlankAndFixedLength(String item, String itemName, int length) {
        log.info("validateNotBlankAndFixedLength -> item: " + item + " | itemName: " + itemName + " | length: " + length);
        if (StringUtils.isBlank(item) || item.length() != length) {
            log.error("validateNotBlankAndFixedLength -> item: " + item + " | itemName: " + itemName + " | length: " + length);
            throw new ServiceException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Incorrect length for " + itemName);
        }
        log.info(Constants.SUCCESS);
    }
}
