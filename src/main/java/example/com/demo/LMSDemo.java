package main.java.example.com.demo;

import main.java.example.com.Course;
import main.java.example.com.MathCourse;
import main.java.example.com.ProgrammingCourse;
import main.java.example.com.decorators.CertificateDecorator;
import main.java.example.com.decorators.GamificationDecorator;
import main.java.example.com.decorators.MentorSupportDecorator;
import main.java.example.com.facade.StudentPortalFacade;

import java.util.Scanner;

public class LMSDemo {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        StudentPortalFacade portal = new StudentPortalFacade();

        System.out.println("===============================================");
        System.out.println("        Welcome to the Online Education Hub");
        System.out.println("===============================================");
        System.out.print("Please enter your name: ");
        String studentName = scanner.nextLine();
        System.out.println("\nHello, " + studentName + "! Let's start your learning journey.\n");

        boolean running = true;
        while (running) {
            System.out.println("===== MAIN MENU =====");
            System.out.println("1. Enroll in a Course");
            System.out.println("2. Start Learning a Course");
            System.out.println("3. Complete a Course");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    enrollMenu(scanner, portal);
                    break;

                case "2":
                    System.out.print("Enter the course name to start: ");
                    String startCourse = scanner.nextLine().trim().toLowerCase();
                    portal.startLearning(startCourse);
                    System.out.println("You have started learning " + startCourse + ". Keep going!\n");
                    break;

                case "3":
                    System.out.print("Enter the course name to complete: ");
                    String completeCourse = scanner.nextLine().trim().toLowerCase();
                    portal.completeCourse(completeCourse);
                    System.out.println("Congratulations, " + studentName + "! You have completed the " + completeCourse + " course.\n");
                    break;

                case "4":
                    System.out.println("Thank you for using the Online Education Hub, " + studentName + ". Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid selection. Please choose between 1 and 4.\n");
                    break;
            }
        }

        scanner.close();
    }

    private void enrollMenu(Scanner scanner, StudentPortalFacade portal) {
        System.out.println("\nAvailable Courses:");
        System.out.println("1. MathCourse");
        System.out.println("2. ProgrammingCourse");
        System.out.print("Choose your course (1 or 2): ");

        String courseChoice = scanner.nextLine().trim();
        Course course = null;
        String courseName = "";

        switch (courseChoice) {
            case "1":
                course = new MathCourse();
                courseName = "mathcourse";
                break;
            case "2":
                course = new ProgrammingCourse();
                courseName = "programmingcourse";
                break;
            default:
                System.out.println("Invalid course selection.\n");
                return;
        }

        System.out.println("\nChoose additional features for your course:");
        System.out.println("1. Add Mentor Support");
        System.out.println("2. Add Certificate");
        System.out.println("3. Add Gamification");
        System.out.println("4. Continue without extras");
        System.out.print("Enter your choices separated by commas (e.g., 1,3): ");

        String[] featureChoices = scanner.nextLine().trim().split(",");
        for (String feature : featureChoices) {
            switch (feature.trim()) {
                case "1" -> {
                    course = new MentorSupportDecorator(course);
                    System.out.println("Mentor support has been added.");
                }
                case "2" -> {
                    course = new CertificateDecorator(course);
                    System.out.println("Certificate feature has been added.");
                }
                case "3" -> {
                    course = new GamificationDecorator(course);
                    System.out.println("Gamification feature has been added.");
                }
                case "4" -> System.out.println("No additional features selected.");
                default -> {
                }
            }
        }

        System.out.println("\nEnrolling you in " + courseName + "...");
        portal.enrollInCourse(courseName, course);
        System.out.println("You have successfully enrolled in " + courseName + ".\n");
    }
}
