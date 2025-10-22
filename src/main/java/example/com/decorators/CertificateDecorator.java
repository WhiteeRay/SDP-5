package example.com.decorators;

import example.com.Course;

public class CertificateDecorator extends CourseDecorator {
    private final Course course;
    public CertificateDecorator(Course course) {
        super(course);
        this.course=course;
    }

    @Override
    public String deliverContent() {
        return super.deliverContent() + " Certificate awarded upon completion.";
    }
    @Override
    public String getFeatures() {
        return course.getFeatures() + ", Certificate";
    }
}
