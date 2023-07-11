package com.emikobell.urlshortener;

public class Encode {

    public static final String ALPHANUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    static String encodeBase62(long base10) {
        String hashString = "";
        while (base10 > 0) {
            int rem = Math.toIntExact(base10 % 62);
            hashString = ALPHANUM.charAt(rem) + hashString;
            base10 = base10 / 62;
        }
        return hashString; 
    }
}
