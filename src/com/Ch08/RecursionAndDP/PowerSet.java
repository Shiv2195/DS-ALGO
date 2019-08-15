package com.Ch08.RecursionAndDP;

import java.util.ArrayList;

public class PowerSet {

    private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubSets;
        if (set.size() == index) {
            allSubSets = new ArrayList<ArrayList<Integer>>();
            allSubSets.add((new ArrayList<>()));
        } else {
            allSubSets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubSets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allSubSets) {
                ArrayList<Integer> newSubSet = new ArrayList<>();
                newSubSet.addAll(subset);
                newSubSet.add(item);
                moreSubSets.add(newSubSet);
            }
            allSubSets.addAll(moreSubSets);
        }
        return allSubSets;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }

        ArrayList<ArrayList<Integer>> subsets2 = getSubsets(list, 0);
        System.out.println(subsets2.toString());

    }


}