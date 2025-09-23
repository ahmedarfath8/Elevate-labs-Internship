package com.arfath.elevenlabs;

import java.util.ArrayList;
import java.util.Scanner;

class Student{
    int id;
    String name;
    int marks;

    public Student(int id,String name,int marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString(){
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }

    public static void start(){
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("welcome to student management system");
            System.out.println("1. Add Student\n2. View Students\n3. Update Student\n4. Delete Student\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();
                    students.add(new Student(id, name, marks));
                    System.out.println("Student added successfully!");
                }
                case 2 -> {
                    System.out.println("\nStudent List");
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Enter ID of student to update: ");
                    int id = sc.nextInt();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.id == id) {
                            System.out.print("Enter new name: ");
                            s.name = sc.next();
                            System.out.print("Enter new marks: ");
                            s.marks = sc.nextInt();
                            System.out.println("Student updated!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with ID " + id + " not found.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter ID of student to delete: ");
                    int id = sc.nextInt();
                    boolean removed = students.removeIf(s -> s.id == id);
                    if (removed) {
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Student with ID " + id + " not found.");
                    }
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
        sc.close();
    }
}

public class Task2 {
    public static void main(String[] args) {
        Student.start();
    }
}
