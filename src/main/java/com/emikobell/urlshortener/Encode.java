package com.emikobell.urlshortener;

public class Encode {
    static String encodeBase64(int base10) {
        String alphaNum = "012345689abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String hashString = "";

        while (base10 > 0) {
            hashString = alphaNum.charAt(base10 % 62) + hashString;
            base10 = base10/64;
        }
        return hashString; 
    }
}
