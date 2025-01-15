package com.example.employee.controller;

public class TestMain {


    public static void main(String[] args) {

        int i = 3245672;

        int[] arr = {1,2,3,4,5,6,7,8,9,10};



        System.out.println(reverseNumber(i));
    }

    private static int reverseNumber(int i) {
  int reversed = 0;
        while(i != 0) {
            int digit = i % 10;
            reversed = reversed * 10 + digit;
            i = i /10;
            //System.out.print(digit);
        }
        return  reversed;
    }
}
