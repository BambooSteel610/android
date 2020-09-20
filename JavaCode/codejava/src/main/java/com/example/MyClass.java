package com.example;

import java.util.Scanner;

public class MyClass {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String name = "";
        System.out.print("Vui lòng nhập vào họ tên \n");
        name = scanner.nextLine();

        System.out.print(name);
    }
}
