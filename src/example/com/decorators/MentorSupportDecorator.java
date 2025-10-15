package example.com.decorators;

import example.com.Course;


public class MentorSupportDecorator extends Decorator {
    public MentorSupportDecorator(Course decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public void deliverContent() {
        super.deliverContent();
        addMentorSupport();
    }

    private void addMentorSupport() {
        System.out.println("A personal mentor has been assigned to help you through your learning journey!");
    }
}
