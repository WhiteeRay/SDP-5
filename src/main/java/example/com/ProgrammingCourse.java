package example.com;

import org.springframework.stereotype.Component;

@Component
public class ProgrammingCourse implements Course {
    @Override
    public String deliverContent() {
        return "Learning Java programming concepts.";
    }
}
