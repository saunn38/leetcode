package main.java.leetcode;

public class Easy {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int key = 0;
        for (int i = 0; i < nums.length; i++) {
            key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[] { map.get(key), i };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }

    public static int reverseInteger(int x) {

        if (x < 0) {
            return false;
        }
        long res = 0;
        // long y = x;
        while (x / 10 > res) {
            res = res * 10 + x % 10;
            x = x / 10;

        }
        return res > Integer.MAX_VALUE ? false : x > (int) res ? x / 10 == (int) res : x == (int) res;
    }

    public static boolean palindromeNumber(int input) {
        long reverse = 0;
        int unit = 1;
        while (input >= unit) {
            reverse = reverse * 10 + input % 10;
            input /= 10;
            unit *= 10;
        }
        unit /= 10;
        // reverse 的位數不正確
        if (reverse / unit < 0) {
            return false;
        }
        // reverse 的位數大於 x input
        if (input / unit < 1) {
            reverse /= 10;
        }
        return reverse > Integer.MAX_VALUE ? false : (input == (int) reverse);
    }

    public static String longestCommonPrefix(String[] strs) {
        String result = strs[0];
        int index = strs.length - 1;
        while (result.length() > 0 && index > 0) {
            if (!strs[index].startsWith(result)) {
                result = result.substring(0, result.length() - 1);
            } else {
                index--;
            }
        }
        return result;
    }

    public static boolean validParentheses(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.contains("()")) {
            return isValid(s.replace("()", ""));
        }
        if (s.contains("[]")) {
            return isValid(s.replace("[]", ""));
        }
        if (s.contains("{}")) {
            return isValid(s.replace("{}", ""));
        }
        return false;
    }

    public int romanToInteger(String s) {
        Map<Character, Integer> mapping = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);// 1
                put('X', 10);// 2
                put('L', 50);// 10
                put('C', 100);// 20
                put('D', 500);// 100
                put('M', 1000);// 200
            }
        };

        char[] array = s.toCharArray();
        int result = mapping.get(array[array.length - 1]);
        for (int i = 0; i < array.length - 1; i++) {
            if (mapping.get(array[i]) < mapping.get(array[i + 1])) {
                result -= mapping.get(array[i]);
            } else {
                result += mapping.get(array[i]);
            }
        }

        return result;
    }
    
}
