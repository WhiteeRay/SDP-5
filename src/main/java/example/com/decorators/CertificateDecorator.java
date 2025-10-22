package example.com.decorators;

import example.com.Course;

public class CertificateDecorator extends CourseDecorator {
    public CertificateDecorator(Course course) {
        super(course);
    }

    @Override
    public String deliverContent() {
        return super.deliverContent() + " Certificate awarded upon completion.";
    }
}
