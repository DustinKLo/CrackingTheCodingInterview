package com.example.practice;

import java.util.HashMap;

public class StringsAndArrays {
    public boolean stringIsUnique(String str) {
        boolean[] charSet = new boolean[256];

        return false;
    }


    public static String urlify(String str) {
        str = str.trim();
        StringBuilder url = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char w = str.charAt(i);

            if(w == ' ') {
                url.append("%20");
            } else {
                url.append(w);
            }
        }
        return url.toString();
    }


    public static Boolean checkPermutation(String string1, String string2) {

        // hash map to keep track of each words letter count
        HashMap<Character, Integer> hash1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hash2 = new HashMap<Character, Integer>();

        for(int i = 0; i < string1.length(); i++) {
            char ch = string1.charAt(i);
            if(hash1.get(string1.charAt(i)) == null) {
                hash1.put(ch, 1);
            } else {
                hash1.replace(ch, hash1.get(ch) + 1);
            }
        }

        for(int j = 0; j < string2.length(); j++) {
            char ch = string2.charAt(j);
            if(hash2.get(string2.charAt(j)) == null) {
                hash2.put(ch, 1);
            } else {
                hash2.replace(ch, hash2.get(ch) + 1);
            }
        }

        System.out.println(hash1);
        System.out.println(hash2);

        return true;
    }


    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        System.out.println(urlify(str));

        checkPermutation("ddddustin lo", "dustin");
    }
}
