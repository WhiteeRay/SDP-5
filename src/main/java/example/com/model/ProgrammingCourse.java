package example.com.model;

import example.com.model.course.Course;
import org.springframework.stereotype.Component;

@Component
public class ProgrammingCourse implements Course {
    @Override
    public String deliverContent() {
        return "Java programming course started.";
    }
    @Override
    public String getFeatures() {
        return "No extra features";
    }
}
