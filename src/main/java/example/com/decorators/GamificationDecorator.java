package example.com.decorators;

import example.com.Course;

public class GamificationDecorator extends CourseDecorator{
    private Course course;
    public GamificationDecorator(Course course) {
        super(course);
        this.course=course;
    }

    @Override
    public String deliverContent() {
        return super.deliverContent() + " Earn points and climb the leaderboard!";
    }

    @Override
    public String getFeatures() {
        return course.getFeatures().equals("No extra features")
                ? "Gamification"
                : course.getFeatures() + ", Gamification";
    }
}
