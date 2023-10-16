package com.marius.demo.services;

public interface Validate {
    void validateNotBlankAndFixedLength(String item, String itemName, int length);
}
