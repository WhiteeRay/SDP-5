package example.com.model;

import example.com.model.course.Course;
import org.springframework.stereotype.Component;

@Component
public class MathCourse implements Course {
    @Override
    public String deliverContent() {
        return "Math course started.";
    }

    @Override
    public String getFeatures() {
        return "No extra features";
    }
}
