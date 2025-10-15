package main.java.example.com.facade;

import main.java.example.com.Course;

import java.util.HashMap;
import java.util.Map;

public class StudentPortalFacade {
    private Map<String, Course> enrolledCourses = new HashMap<>();

    public void enrollInCourse(String name, Course course) {
        enrolledCourses.put(name, course);
        System.out.println("You have successfully enrolled in " + name);
    }

    public void startLearning(String name) {
        System.out.println("\n Starting your course " + name + "...");
        Course course = enrolledCourses.get(name);
        if (course != null) {
            course.deliverContent();
        } else {
            System.out.println("You are not enrolled in " + name + ". Please enroll first.");
        }
    }

    public void completeCourse(String name) {
        System.out.println("You have completed " + name + "!\n");
        sendNotification("Congratulations! You successfully finished " + name + "!");
    }

    private void sendNotification(String message) {
        System.out.println("Notification: " + message);
    }
}
