package example.com.demo;

import example.com.Course;
import example.com.MathCourse;
import example.com.ProgrammingCourse;
import example.com.decorators.CertificateDecorator;
import example.com.decorators.GamificationDecorator;
import example.com.decorators.MentorSupportDecorator;
import example.com.facade.StudentPortalFacade;

public class LMSDemo {
    public void run(){
        StudentPortalFacade portal = new StudentPortalFacade();


        Course mathCourse = new CertificateDecorator(
                new MentorSupportDecorator(
                        new MathCourse()
                ));

        Course programmingCourse = new GamificationDecorator(new ProgrammingCourse());


        portal.enrollInCourse("MathCourse", mathCourse);
        portal.enrollInCourse("ProgrammingCourse", programmingCourse);


        portal.startLearning("MathCourse");
        portal.completeCourse("MathCourse");

        portal.startLearning("ProgrammingCourse");
        portal.completeCourse("ProgrammingCourse");
    }
}
