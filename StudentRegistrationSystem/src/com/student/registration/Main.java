package com.student.registration;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n=== Student Registration System ===");
            System.out.println("1. Register Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    Student s = new Student(name, roll, dept);
                    if (dao.addStudent(s)) {
                        System.out.println("✅ Student registered successfully!");
                    } else {
                        System.out.println("❌ Registration failed.");
                    }
                    break;

                case 2:
                    List<Student> students = dao.getAllStudents();
                    System.out.println("\n--- Student List ---");
                    for (Student st : students) {
                        System.out.println(st);
                    }
                    break;

                case 3:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
