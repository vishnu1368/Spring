package com.project.SpringBoot;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class UTF_BASE64 {
    public static void main(String[] args){

        /*
            Text is a common format which is used to represent all the formats - UTF8, Base64.
            UTF-8("hello") → bytes → Base64(bytes) → Base64 text
            Base64 text → bytes → UTF-8 decode → text

        KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
        SecretKey key = keyGen.generateKey();
        RAW_SECRET = new String(key.getEncoded(), StandardCharsets.UTF_8);

        Key insight: raw crypto bytes ≠ text, so UTF-8 cannot safely turn them into a readable string.
            UTF-8 is designed for text, not random bytes.
            Random binary keys often contain byte sequences that are invalid UTF-8.
            Converting them to a string destroys the data — it’s no longer the original key.
         */

        String str = "hello";
        System.out.println("==========ENCODE==========");
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

        System.out.print("UTF-8 Encoded String : ");
        for(byte b : bytes)
            System.out.print(b + " ");
        System.out.println();

        String base64 = Base64.getEncoder().encodeToString(bytes);
        System.out.println("Base64 Encoded string : " + base64);

        System.out.println("==========DECODE==========");
        byte[] decoded = Base64.getDecoder().decode("aGVsbG8=");
        System.out.print("Base64 decoded String : ");
        for(byte b : decoded)
            System.out.print(b + " ");
        System.out.println();

        String text = new String(decoded, StandardCharsets.UTF_8);
        System.out.print("UTF-8 Encoded String : " + text);

    }
}
