package example.com.decorators;

import example.com.Course;

public class MentorSupportDecorator extends CourseDecorator {
    public MentorSupportDecorator(Course course) {
        super(course);
    }

    @Override
    public String deliverContent() {
        return super.deliverContent() + " Includes personal mentor support.";
    }
}
