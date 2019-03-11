package com.suan.one;

import java.util.Scanner;

public class IntToExcel {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        IntToExcel excel = new IntToExcel();

        while(true) {
            int num = sc.nextInt();
            System.out.println(excel.transfer1(num));
        }
    }

    public String transfer(int num){
        String result = "";
        if (num <= 0) {
            return result;
        }
        num--;
        do {
            if (result.length() > 0) {
                num--;
            }
            result = ((char) (num % 26 + (int) 'A')) + result;
            num = (int) ((num - num % 26) / 26);

        } while (num > 0);
        return result;
    }

    public String transfer1(int num){
        String result = "";
        if (num <= 0) {
            return result;
        }
        if(num > 26){
            result += transfer1((num - 1) / 26);
        }
        result += ((char) ((num - 1) % 26 + (int) 'A'));

        return result;
    }

}
