package ArrayString.ManipulationAndHashing;

// ques: https://neetcode.io/problems/design-hashset/question?list=neetcode250

import java.util.ArrayList;
import java.util.List;

public class DesignHashset {

    private List<List<Integer>> list;
    private final int cap = 15000;

    public DesignHashset() {
        list = new ArrayList<>(cap);
        for (int i = 0; i < cap; i++) {
            list.add(new ArrayList<>());
        }
    }

    public void add(int key) {
        int idx = key % cap;
        if(!list.get(idx).contains(key))
            list.get(idx).add(key);
    }

    public void remove(int key) {
        int idx = key % cap;
        list.get(idx).remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int idx = key % cap;
        for(int i : list.get(idx)){
            if(i == key)
                return true;
        }
        return false;
    }

    private static class DesignHashsetBruteForce {
        boolean[] arr;

        public DesignHashsetBruteForce() {
            arr = new boolean[1000000];
        }

        public void add(int key) {
            arr[key] = true;
        }

        public void remove(int key) {
            arr[key] = false;
        }

        public boolean contains(int key) {
            return arr[key];
        }
    }

}