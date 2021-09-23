package org.scratchpad.me.algorithms;

import java.util.Arrays;
import java.util.HashMap;

public class ColorfulNumbers {
    public static HashMap<Integer, Integer> ht = new HashMap<Integer, Integer>();

    public static void main(String[] args){
        System.out.println("Is 3245 a colorful number? " + getColorful(3245));
        System.out.println("Is 326 a colorful number? " + getColorful(326));
    }

    public static boolean getColorful(int number){
        ht.clear();
        int[] digits = getdigits(number);
        int[] permission = new int[digits.length];
        return powerSet(digits, permission, 0);
    }

    public static boolean powerSet(int[] digits, int[] permission, int i){
        if(i == digits.length -1){
            permission[i] = 0;
            //printCombination(digits, permission);
            boolean b = insertHash(digits, permission);
            permission[i] = 1;
            //printCombination(digits, permission);
            return b & insertHash(digits, permission);
        }
        permission[i] = 0;
        boolean b = powerSet(digits, permission, i +1);
        permission[i] = 1;
        return b & powerSet(digits, permission, i +1);
    }

    public static boolean insertHash(int[] digits, int[] permission){
        int result = 1;
        for(int i =0; i<digits.length; i++){
            if(permission[i] == 1){
                result *= digits[i];
            }
        }
        //System.out.println("***" + result);
        if(ht.containsKey(result))
            return false;
        else {
            ht.put(result, 1);
            return true;
        }

    }

    public static void printCombination(int[] digits, int[]permission){
        System.out.print("{");
        for(int i = 0; i< digits.length; i++){
            if (permission[i] == 1){
                System.out.print(digits[i]);
            }
        }
        System.out.print("} ");
    }

    public static int [] getdigits(int Number){
        int length = String.valueOf(Number).length();
        int A [] = new int [length];
        int counter = length-1; //start filling from the end
        while(Number>0){
            int x = Number%10;
            Number = Number/10;
            A[counter]=x;
            counter--;
        }
        return A;
    }
}
