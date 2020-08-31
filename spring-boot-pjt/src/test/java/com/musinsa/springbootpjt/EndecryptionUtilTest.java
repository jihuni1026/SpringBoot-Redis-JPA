package com.musinsa.springbootpjt;

import static org.junit.Assert.assertEquals;

import com.musinsa.springbootpjt.utils.EndecryptionUtil;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Base62 암복호화 Util.
 * @author kjh
 * @version TEST
 */
public class EndecryptionUtilTest {

    @Autowired
    EndecryptionUtil endecryptionUtil;
 
    @Test
    public void testEnDecode() {
        double dValue = Math.random();
        int iValue = (int) (dValue * 10) + 1000000;
        String shorteningUrl = endecryptionUtil.encode(iValue);
System.out.println("Encode : " + shorteningUrl);

        int iValue2  = endecryptionUtil.decode(shorteningUrl);
System.out.println("Decode : " + iValue2); 

        assertEquals(iValue, iValue2);
    }
}