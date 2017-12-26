package com.chieftain.simple.chain.simplechain;

import org.apache.commons.codec.digest.DigestUtils;

public class HashUtils {


    public static String calculateHash (String stringText){
        String sha256hex = DigestUtils.sha256Hex(stringText);
        return sha256hex;
    }

}
