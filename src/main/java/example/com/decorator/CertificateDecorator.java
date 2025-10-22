package example.com.decorator;

import example.com.model.course.Course;

public class CertificateDecorator extends CourseDecorator {
    private final Course course;
    public CertificateDecorator(Course course) {
        super(course);
        this.course=course;
    }

    @Override
    public String deliverContent() {
        return super.deliverContent() + " You can have certificate after completion.";
    }
    @Override
    public String getFeatures() {
        return course.getFeatures() + ", Certificate";
    }
}
