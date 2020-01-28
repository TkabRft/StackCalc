package com.company;

import java.util.Scanner;

public class CalcTest {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Calc c = new Calc();
        while (true) {
            System.out.println("Введите формулу -> ");
            c.compile(scan.nextLine().toCharArray());
            }
    }
}
