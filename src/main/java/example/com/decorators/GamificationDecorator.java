package main.java.example.com.decorators;

import main.java.example.com.Course;


public class GamificationDecorator extends Decorator {
    public GamificationDecorator(Course decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public void deliverContent() {
        super.deliverContent();
        addGamification();
    }

    private void addGamification() {
        System.out.println("You have unlocked the Gamification Mode!");
    }
}
