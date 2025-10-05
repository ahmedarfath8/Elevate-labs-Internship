package com.arfath.elevenlabs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    int correctOption;

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctOption;
    }
}

public class Task8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> quiz = new ArrayList<>();

        quiz.add(new Question("What is the capital of France?",
                new String[]{"1. Paris", "2. Rome", "3. Madrid", "4. Berlin"}, 1));
        quiz.add(new Question("Which language is used for Android development?",
                new String[]{"1. Java", "2. Swift", "3. Python", "4. Kotlin"}, 4));
        quiz.add(new Question("Which keyword is used to inherit a class in Java?",
                new String[]{"1. this", "2. extends", "3. implements", "4. super"}, 2));
        quiz.add(new Question("Which of the following is not an OOP concept?",
                new String[]{"1. Inheritance", "2. Polymorphism", "3. Compilation", "4. Encapsulation"}, 3));
        quiz.add(new Question("Which data type is used to store a single character in Java?",
                new String[]{"1. String", "2. Char", "3. Character", "4. Both 2 and 3"}, 4));

        int score = 0;
        System.out.println("=== Welcome to the Online Quiz App ===\n");

        for (int i = 0; i < quiz.size(); i++) {
            Question q = quiz.get(i);
            System.out.println("Q" + (i + 1) + ": " + q.questionText);
            for (String opt : q.options) {
                System.out.println(opt);
            }

            System.out.print("Enter your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            if (q.isCorrect(userAnswer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct answer was option " + q.correctOption + "\n");
            }
        }

        System.out.println("=== Quiz Completed! ===");
        System.out.println("Your final score: " + score + "/" + quiz.size());
        double percentage = (score * 100.0) / quiz.size();
        System.out.printf("Percentage: %.2f%%\n", percentage);

        if (percentage >= 80)
            System.out.println("Excellent Work!");
        else if (percentage >= 50)
            System.out.println("Good Job!");
        else
            System.out.println("Keep Practicing!");

        scanner.close();
    }
}
