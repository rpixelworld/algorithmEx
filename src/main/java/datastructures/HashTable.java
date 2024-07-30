package datastructures;

import java.util.*;

public class HashTable {

    int size;
    Node[] dataMap;

    HashTable() {
        this.size = 7;
        this.dataMap = new Node[this.size];
    }
    HashTable (int size) {
        this.size = size;
        this.dataMap = new Node[this.size];
    }

    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public Node[] getDataMap() {
        return dataMap;
    }

    private int hash(String key) {
        int hash = 0;
        char[] charArray = key.toCharArray();
        for(int i = 0; i<charArray.length; i++) {
            hash = (hash + charArray[i]*23) % size;
        }
        return hash;
    }

    public void set(String key, int value) {
        int hash = hash(key);
        Node link = dataMap[hash];

        Node newNode = new Node(key, value);
        if(link == null) {
            dataMap[hash] = newNode;
            return;
        }
        Node temp = link;
        while (temp.next!=null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public int get(String key) {
        int hash = hash(key);
        Node link = dataMap[hash];

        if(link==null) {
            return 0;
        }

        Node temp = link;
        while (temp!=null) {
            if(key.equals(temp.key)) {
                return temp.value;
            }
            temp = temp.next;
        }

        return 0;
    }

    public List keys() {
        List<String> keys = new ArrayList<>();
        for(int i=0; i<size; i++) {
            Node list = dataMap[i];
            if(list==null)
                continue;

            Node temp = list;
            while (temp!=null) {
                keys.add(temp.key);
                temp = temp.next;
            }
        }
        return keys;
    }

    public void printTable() {
        for(int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            if(dataMap[i] != null) {
                Node temp = dataMap[i];
                while (temp != null) {
                    System.out.println("   {" + temp.key + ", " + temp.value + "}");
                    temp = temp.next;
                }
            }
        }
    }

    public static boolean itemInCommon(int[] array1, int[] array2) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i: array1) {
            if(map.containsKey(i)) {
                return true;
            }
            map.put(i, true);
        }
        for(int i: array2) {
            if(map.containsKey(i)) {
                return true;
            }
            map.put(i, true);
        }
        return false;
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();

        for(int i : nums) {
            if(map.containsKey(i) && !duplicates.contains(i)) {
                duplicates.add(i);
            }
            else {
                map.put(i, true);
            }
        }
        return duplicates;
    }

    public static Character firstNonRepeatingChar(String str) {
        Map<Character, Boolean> map = new HashMap<>();

        char[] charArray = str.toCharArray();
        for(char c: charArray) {
            if(!map.containsKey(c)) {
                map.put(c, false);
            }
            else {
                map.put(c, true);
            }
        }
        for(char c: charArray) {
            if(!map.get(c)){
                return c;
            }
        }
        return null;
    }

    public static List<List<String>> groupAnagrams(String[] strings) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str: strings) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String key = String.valueOf(charArray);
            if(map.containsKey(key)) {
                map.get(key).add(str);
            }
            else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(key, newList);
            }
        }
        List result = new ArrayList();
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            int addition = target - num;
            if(map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }

            map.put(addition, i);
        }
        return new int[]{};
    }

    public static int[] subarraySum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for(int endIndex = 0; endIndex<nums.length; endIndex++) {
            sum += nums[endIndex];
            if(sum==target) {
                return new int[]{0, endIndex};
            }

            int toMinus = sum-target;
            map.put(toMinus, endIndex);
        }

        sum = 0;
        for(int index=0; index<nums.length; index++) {
            sum += nums[index];
            if(map.containsKey(sum)) {
                return new int[] {index+1, map.get(sum)};
            }
        }

        return new int[]{};
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {

        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int n1: arr1) {
            map.put(target-n1, n1);
        }
        for(int n2: arr2) {
            if(map.containsKey(n2)) {
                result.add(new int[]{map.get(n2), n2});
            }
        }
        return result;
    }

    public static int longestConsecutiveSequence(int[] nums) {
        if(nums.length==0)
            return 0;

        Arrays.sort(nums);
        int count = 1, maxi=1;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i]==nums[i+1])
                continue;
            if(nums[i]+1 == nums[i+1]){
                count ++;
            }
            else {
                maxi = Math.max(count, maxi);
                count = 1;
            }
        }
        maxi = Math.max(maxi, count);
        return maxi;
    }
}
