package example.com.decorators;

import example.com.Course;

public class MentorSupportDecorator extends CourseDecorator {
    private final Course course;
    public MentorSupportDecorator(Course course) {
        super(course);
        this.course = course;
    }

    @Override
    public String deliverContent() {
        return super.deliverContent() + " Includes personal mentor support.";
    }
    @Override
    public String getFeatures() {
        return course.getFeatures().equals("No extra features")
                ? "Mentor Support"
                : course.getFeatures() + ", Mentor Support";
    }
}
