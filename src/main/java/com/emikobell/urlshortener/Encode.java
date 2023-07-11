package com.emikobell.urlshortener;

import java.lang.Math;

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

    static long decodeBase62(String base62) {
        long urlKey = 0;
        int power = base62.length()-1;
        int indx = 0;
        while (power >= 0) {
            int baseVal = ALPHANUM.indexOf(base62.charAt(indx));
            urlKey += (baseVal) * Math.pow(62, power);
            power --;
            indx ++;
        }
        return urlKey;
    }
}
