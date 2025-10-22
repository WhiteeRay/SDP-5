package example.com.decorator;

import example.com.model.course.Course;

public class GamificationDecorator extends CourseDecorator{
    private Course course;
    public GamificationDecorator(Course course) {
        super(course);
        this.course=course;
    }

    @Override
    public String deliverContent() {
        return super.deliverContent() + " Points & leaderboard added for gamification!";
    }

    @Override
    public String getFeatures() {
        return course.getFeatures().equals("No extra features")
                ? "Gamification"
                : course.getFeatures() + ", Gamification";
    }
}
