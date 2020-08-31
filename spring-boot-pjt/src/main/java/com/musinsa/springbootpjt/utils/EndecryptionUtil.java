package com.musinsa.springbootpjt.utils;

import org.springframework.stereotype.Component;

/**
 * Base62 암복호화 Util.
 * @author kjh
 * @version 1.0
 */
@Component
public class EndecryptionUtil {

    // Base62 charaters
    static final char[] BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    // Base62 Encoding (int to string)
    public String encode(int value) {
        final StringBuilder sb = new StringBuilder();

        do {
            int i = value%62;
            sb.append(BASE62[i]);
            value /= 62;
        } while (value > 0);

        return sb.toString();
    }

    // Base62 Encoding (string to int)
    public int decode(String value) {
        int result = 0;
        int power = 1;
        for (int i = 0; i < value.length(); i++) {
            int digit = new String(BASE62).indexOf(value.charAt(i));
            result += digit * power;
            power *= 62;
        }
        return result;
    }
}