package example.com.decorators;

import example.com.Course;

public class GamificationDecorator extends CourseDecorator {
    public GamificationDecorator(Course course) {
        super(course);
    }

    @Override
    public String deliverContent() {
        return super.deliverContent() + " Earn points and climb the leaderboard!";
    }
}
