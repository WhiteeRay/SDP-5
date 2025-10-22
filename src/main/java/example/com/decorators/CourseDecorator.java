package example.com.decorators;

import example.com.Course;

public abstract class CourseDecorator implements Course {
    protected Course decoratedCourse;

    public CourseDecorator(Course decoratedCourse) {
        this.decoratedCourse = decoratedCourse;
    }

    @Override
    public String deliverContent() {
        return decoratedCourse.deliverContent();
    }
}
