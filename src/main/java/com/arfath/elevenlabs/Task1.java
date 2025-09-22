package com.arfath.elevenlabs;

import java.util.Scanner;

public class Task1 {

    public  static void operation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome User");
        boolean d = true;
        while(d){
            System.out.print("Enter the first number : ");
            int a = sc.nextInt();
            System.out.print("Enter the second number : ");
            int b = sc.nextInt();
            System.out.print("Enter the operation -> 1 to add , 2 to sub , 3 to mul , 4 to div : ");
            int c = sc.nextInt();
            Task1 obj = new Task1();
            switch (c){
                case 1 -> System.out.println("the addition of "+a+" and "+b+ " is : "+obj.add(a,b));
                case 2 -> System.out.println("the subtraction of "+a+" and "+b+ " is : "+obj.sub(a,b));
                case 3 -> System.out.println("the multiplication of "+a+" and "+b+ " is : "+obj.mul(a,b));
                case 4 -> System.out.println("the division of "+a+" and "+b+ " is : "+obj.div(a,b));
                default -> System.out.println("Please enter the correct option ");
            }
            System.out.print("would you like to continue Y or N : ");
            String x = sc.next();
            if(x.equals("N") || x.equals("n")){
                System.out.println("thankyou.....");
                d = false;
            }
        }
    }

    public int add(int a,int b){
        return a+b;
    }

    public int sub(int a,int b){
        return a-b;
    }

    public int mul(int a,int b){
        return a*b;
    }

    public int div(int a,int b){
        return a/b;
    }

    public static void main(String[] args) {
        operation();
    }
}
