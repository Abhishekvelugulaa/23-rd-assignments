package com.projectday23;
import java.util.Scanner;
import java.util.*;
//8. Online Quiz SystemDescription: A program to create and conduct quizzes.

//Features:Classes: Question, Quiz, User.Methods: Add questions, take quiz, calculate scores.

class Question {
    private String questionText;
    private List<String> options;
    private int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(int choice) {
        return choice == correctOption;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(questionText + "\n");
        for (int i = 0; i < options.size(); i++) {
            sb.append((i + 1) + ". " + options.get(i) + "\n");
        }
        return sb.toString();
    }
}

class Quiz {
    private List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void conductQuiz() {
        try (Scanner scanner = new Scanner(System.in)) {
			int score = 0;

			for (Question question : questions) {
			    System.out.println(question);
			    System.out.print("Enter your choice: ");
			    int choice = scanner.nextInt();
			    if (question.isCorrect(choice)) {
			        score++;
			    }
			}

			System.out.println("Quiz completed! Your score: " + score + "/" + questions.size());
		}
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Q8onlinequizz{
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        Question q1 = new Question("What is the capital of india?",
                Arrays.asList("Berlin", "Delhi", "Madrid", "Rome"), 2 );
        Question q2 = new Question("What is 5 + 3?",
                Arrays.asList("5", "8", "10", "15"), 2);

        quiz.addQuestion(q1);
        quiz.addQuestion(q2);

        User user = new User("Mike");
        System.out.println("Welcome, " + user.getName() + "! Let's start the quiz.");

        quiz.conductQuiz();
    }
}
