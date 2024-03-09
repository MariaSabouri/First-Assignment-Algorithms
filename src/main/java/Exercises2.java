import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public int[] twoSum(int[] nums, int target) {
        List<int[]> arr=new ArrayList<int[]>();
        for (int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target) {
                    int[] x=new int[2];
                    x[0]=i;
                    x[1]=j;
                    arr.add(x);
                }
            }
        }
        //System.out.println(arr.get(0));
        return arr.get(0);
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */

    public int romanToInt(String s) {
        int size=s.length();
        int output=0;
        for (int i=0;i<size;i++){
            switch (s.charAt(i)){
                case 'I':
                    if(i+1!=size && (s.charAt(i+1)=='V' || s.charAt(i+1)=='X')){
                        output-=1;
                    }
                    else output+=1;
                    continue;
                case 'X':
                    if(i+1!=size &&(s.charAt(i+1)=='L' || s.charAt(i+1)=='C')){
                        output-=10;
                    }
                    else output+=10;
                    continue;
                case 'C':
                    if(i+1!=size &&(s.charAt(i+1)=='D' || s.charAt(i+1)=='M')){
                        output-=100;
                    }
                    else output+=100;
                    continue;
                case 'V': output+=5;continue;
                case 'L': output+=50;continue;
                case 'D': output+=500;continue;
                case 'M': output+=1000;
            }
        }
        System.out.println(output);
        return output;
    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> my_nums=new ArrayList<>();
        for (int num : nums) {
            my_nums.add(num);
        }
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> body=my_nums.subList(0,1);
        output.add(body);
        //System.out.println("first body"+body);
        //System.out.println("first output"+output);
        for (int i=1;i<my_nums.size();i++){

            List<List<Integer>> output_copy = mkListListcopy(output);
            //System.out.println("output_copy"+output_copy);
            for (int x=output_copy.size()-1;x>=0 && output_copy.get(x).size()==i;x--){
                body=output.get(x);
                //System.out.println("body"+body);
                for (int j=0;j<body.size()+1;j++){
                    List<Integer> copy=mkcopy(body);
                    copy.add(j,my_nums.get(i));
                    //System.out.println("copy"+copy);
                    output.add(copy);
                }
                //System.out.println("output"+output);
            }
        }
        List<List<Integer>> Final_output=output.subList(output.size()-factorial(my_nums.size()),output.size());
        System.out.println("YOUR HOLY PERMUTATION LIST!!\n"+Final_output);
        return Final_output;
    }
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
    public static List<List<Integer>> mkListListcopy(List<List<Integer>> output){
        return new ArrayList<List<Integer>>(output);
    }

    public static List<Integer> mkcopy(List<Integer> List){
        List<Integer> x=new ArrayList<>();
        for (int i=0;i<List.size();i++){
            x.add(List.get(i));
        }
        return x;
    }


    public static void main(String[] args) {
        // test your code here!
    }
}