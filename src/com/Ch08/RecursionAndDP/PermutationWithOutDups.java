package com.Ch08.RecursionAndDP;

import java.util.ArrayList;

public class PermutationWithOutDups {

    private static ArrayList<String> getPerms(String str) {
        ArrayList<String> result = new ArrayList<>();
        getPerms("", str, result);
        return result;

    }

    private static void getPerms(String prefix, String remainder, ArrayList<String> result) {
        if (remainder.length() == 0) {
            result.add(prefix);
        }
        int len = remainder.length();
        for (int i = 0; i < len; i++) {
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, len);
            char c = remainder.charAt(i);
            getPerms(prefix + c, before + after, result);
        }
    }


    public static void main(String[] args) {
        ArrayList<String> list = getPerms("abcde");
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
    }


}
