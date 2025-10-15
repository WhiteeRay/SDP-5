package main.java.example.com.decorators;

import main.java.example.com.Course;


public abstract class Decorator implements Course {
    protected Course decoratedCourse;

    public Decorator(Course decoratedCourse) {
        this.decoratedCourse = decoratedCourse;
    }

    @Override
    public void deliverContent() {
        decoratedCourse.deliverContent();
    }
}
