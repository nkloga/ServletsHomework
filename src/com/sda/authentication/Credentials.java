package com.sda.authentication;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Credentials {
    private static Map<String, String> usersList = new HashMap<String, String>() {
        {
            put("John", "5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5"); //SHA-256 value
        }
    };

    public static boolean credentialsCheck(String valueByKey, String password){
        if (!valueByKey.equals("") && usersList.containsKey(valueByKey)) {
            return usersList.get(valueByKey).equals(getSHA(password));
        } else return false;
    }

    public static String getSHA(String input)
    {

        try {

            // Static getInstance method is called with hashing SHA
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // digest() method called
            // to calculate message digest of an input
            // and return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown"
                    + " for incorrect algorithm: " + e);

            return null;
        }
    }
}