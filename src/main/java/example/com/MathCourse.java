package example.com;

import org.springframework.stereotype.Component;

@Component
public class MathCourse implements Course {
    @Override
    public String deliverContent() {
        return "Learning Math fundamentals.";
    }
}
