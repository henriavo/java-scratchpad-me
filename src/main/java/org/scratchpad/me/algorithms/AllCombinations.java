package org.scratchpad.me.algorithms;

public class AllCombinations {

    //static int[] B = { 1, 2, 3, 4 };
    static int[] B = { 3,2,6};

    // PERMUTATIONS aka COMBINATIONS aka POWERSET
    public void powerSet(int[] A, int x) {
        if (x == A.length - 1) {
            A[x] = 0; // last digit, don't select it
            printArray(A); // print the set
            A[x] = 1; //// last digit, select it
            printArray(A);
            return;
        }
        A[x] = 0;   //either you will not select this digit
        powerSet(A, x + 1);
        A[x] = 1;  //either you will select this digit
        powerSet(A, x + 1);
    }

    public void printArray(int[] A) {
        System.out.print("{");

        for (int i = 0; i < B.length; i++) {
            if (A[i] == 1) {
                System.out.print(B[i]);
            }
        }
        System.out.print("}");
        System.out.print(" ");
    }

    public static void main(String[] args) {
        AllCombinations a = new AllCombinations();
        int[] A = new int[B.length];
        a.powerSet(A, 0);

    }

}
