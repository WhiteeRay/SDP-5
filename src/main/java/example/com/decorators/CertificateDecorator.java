package main.java.example.com.decorators;


import main.java.example.com.Course;

public class CertificateDecorator extends Decorator {
    public CertificateDecorator(Course decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public void deliverContent() {
        super.deliverContent();
        grantCertificate();
    }

    private void grantCertificate() {
        System.out.println("Great job! You have earned a certificate for completing this course!");
    }
}
