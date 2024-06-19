import java.util.*;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/two-sum/description/

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
*/
public class LC_1_TwoSum {
    public static void main(String[] args) {
        int[] numArray = {1, 3, 6, 9, 10, 7, 8};
        var ans = twoSum(numArray, 9);
        printArray(ans);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] numbers = new int[2];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (var i = 0; i < nums.length; i++) {
            var num2 = target - nums[i];
            System.out.println("num1: " + nums[i]);
            System.out.println("num2: " + num2);
            printMap(indexMap);
            if (indexMap.containsKey(nums[i])) {
                numbers[0] = indexMap.get(nums[i]);
                numbers[1] = i;
                return numbers;
            } else {
                indexMap.put(num2, i);
            }
        }
        return numbers;
    }


    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    public static void printArray(int[] arr){
        var array = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" , "));
        System.out.println(">>> " + array);
    }
}
