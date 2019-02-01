package com.example.practice;

import java.util.HashMap;

public class StringsAndArrays {
    public static boolean stringIsUnique(String str) {
        boolean[] charSet = new boolean[256];
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i); // str.charAt can either be integer or String
            if(charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }
        return true;
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
        string1 = string1.replace(" ", "");
        string2 = string2.replace(" ", "");

        if(string1.length() != string2.length()) {
            return false;
        }

        // hash map to keep track of each words letter count
        HashMap<Character, Integer> hash1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hash2 = new HashMap<Character, Integer>();

        for(int i = 0; i < string1.length(); i++) {
            char ch = string1.charAt(i);
            if(hash1.get(ch) == null) {
                hash1.put(ch, 1);
            } else {
                hash1.replace(ch, hash1.get(ch) + 1);
            }
        }
        for(int j = 0; j < string2.length(); j++) {
            char ch = string2.charAt(j);
            if(hash2.get(ch) == null) {
                hash2.put(ch, 1);
            } else {
                hash2.replace(ch, hash2.get(ch) + 1);
            }
        }

        for(Character key: hash1.keySet()) {
            if(hash2.get(key) != hash1.get(key)) {
                return false;
            }
        }
        return true;
    }


    public static boolean oneAway(String str1, String str2) {
        int errors = 0;
        // case 1: the 2 words are the same length (easy case)
        if(str1.length() == str2.length()) {
            for(int i = 0; i < str1.length(); i++) {
                if(str1.charAt(i) != str2.charAt(i)) {
                    errors++;
                    if(errors > 1) {
                        return false;
                    }
                }
            }
        } else if(Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        } else { // case 2: words are different length (harder case)
            int i = 0; // counter for string 1
            int j = 0; // counter for string 2
            while(i < str1.length() && j < str2.length()) {
                if(str1.charAt(i) != str2.charAt(j)) {
                    errors++;
                    if(str1.length() > str2.length()) {
                        i++; // choose to only advance the longer string
                    } else {
                        j++;
                    }
                    if(errors > 1) {
                        return false;
                    }
                }
                i++;
                j++;
            }
        }
        return true;
    }


    public static String stringCompression(String str) {
        Character prev = str.charAt(0);
        int letterCount = 0;

        StringBuilder compressedString = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            Character currentChar = str.charAt(i);

            if(prev != currentChar) {
                compressedString.append(prev).append(Integer.toString(letterCount));
                letterCount = 1;
            } else {
                letterCount++;
            }
            prev = currentChar;
        }
        compressedString.append(prev).append(Integer.toString(letterCount));
        return compressedString.length() < str.length() ? compressedString.toString() : str;
    }


    public static void main(String[] args) {
        System.out.println("URLify");
        String str = "Mr John Smith    ";
        System.out.println(str + " -> " + urlify(str));

        System.out.println();
        System.out.println("Check Permutation");
        String word1 = "abcdefghijklmnopqrstuvwxyz";
        String word2 = "zyxwvutsrqponmlkjihgfedcba";
        System.out.println(word1 + " and " + word2 + " = " + checkPermutation(word1, word2));

        System.out.println();
        System.out.println("One Away");
        System.out.println(oneAway("pale", "ple")); // true
        System.out.println(oneAway("pales", "pale")); // true
        System.out.println(oneAway("pale", "bale")); // true
        System.out.println(oneAway("pale", "bake")); // false

        System.out.println();
        System.out.println("String Compression");
        System.out.println("aabcccccaaa" + " -> " + stringCompression("aabcccccaaa"));
        System.out.println("abcdefga" + " -> " + stringCompression("abcdefga"));

        System.out.println();
        System.out.println("Is Unique");
        System.out.println("dustin" + " -> " + stringIsUnique("dustind"));
    }
}
