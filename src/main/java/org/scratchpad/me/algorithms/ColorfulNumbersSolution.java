package org.scratchpad.me.algorithms;

import java.util.Hashtable;

public class ColorfulNumbersSolution {

    Hashtable<Integer, Integer> ht = new Hashtable<>();
    boolean [] used; // for creating powerset, every digit, either
    //it will be selected or not
    public int [] getdigits(int Number){
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
    public boolean getColorFul(int Number){
        ht.clear();
        int [] A = getdigits(Number);
        used = new boolean[A.length];

        return powerSet(A, used, 0);
    }
    public boolean powerSet(int [] A, boolean [] used, int x){
        if(x==used.length-1){
            used[x] = false;
            boolean b = insertInHash(A, used);
            if(b){
                used[x] = true;
                return insertInHash(A, used);
            }else{
                return false;
            }
        }
        used[x] = false;
        boolean p = powerSet(A, used, x+1);
        used[x] = true;
        return p & powerSet(A, used, x+1);
    }
                            // A=[2,3,4,5]  used=[false, false, false, false]
    public boolean insertInHash(int [] A, boolean [] used){
        int Sum=0;
        for(int i = 0;i<used.length;i++){
            if(used[i]){
                if(Sum==0){
                    Sum =A[i];
                }
                else{
                    Sum*=A[i];
                }

            }
        }
        if(ht.containsKey(Sum)){
            return false;
        }else{
            ht.put(Sum, 1);
            return true;
        }

    }
    public static void main(String[] args) {
        ColorfulNumbersSolution c = new ColorfulNumbersSolution();
        System.out.println(" 326 Colorful?? " + c.getColorFul(326));
        //System.out.println(" 3245 Colorful?? " + c.getColorFul(3245));

    }

}