/**
 * 
 */
package com.dhanjyothi.util;

import org.springframework.stereotype.Component;

/**
 * @author KundanSingh
 *
 */

public enum TransactionEnum {
	CREDIT("CREDIT", 1), DEBIT("DEBIT", 0);

    private final String key;
    private final Integer value;

    TransactionEnum(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }
}
