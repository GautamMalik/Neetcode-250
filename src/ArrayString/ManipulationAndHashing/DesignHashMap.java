package ArrayString.ManipulationAndHashing;

// ques: https://neetcode.io/problems/design-hashmap/question

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesignHashMap {

    List<List<Pair>> list;
    int cap=15000;

    public DesignHashMap() {
        list = new ArrayList<>(cap);
        for(int i=0; i<=cap; i++){
            list.add(new ArrayList<>());
        }
    }

    public void put(int key, int value) {
        int idx = key%cap;
        for(Pair pair : list.get(idx)){
            if(pair.key == key) {
                pair.value = value;
                return;
            }
        }
        list.get(idx).add(new Pair(key,value));
    }

    public int get(int key) {
        int idx = key%cap;
        for(Pair pair : list.get(idx)){
            if(pair.key == key)
                return pair.value;
        }
        return -1;
    }

    public void remove(int key) {
        int idx = key%cap;
        List<Pair> bucket = list.get(idx);
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key == key) {
                bucket.remove(i);
                return;
            }
        }
    }

    private static class Pair{
        int key;
        int value;

        Pair(int key, int value){
            this.key= key;
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }

    private static class DesignHashMapBrute {

        int[] arr;

        public DesignHashMapBrute() {
            arr= new int[1000000];
            Arrays.fill(arr,-1);
        }

        public void put(int key, int value) {
            arr[key] = value;
        }

        public int get(int key) {
            return arr[key];
        }

        public void remove(int key) {
            arr[key] = -1;
        }
    }
}
