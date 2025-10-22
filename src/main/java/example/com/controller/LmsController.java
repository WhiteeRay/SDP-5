package example.com.controller;

import example.com.Course;
import example.com.MathCourse;
import example.com.ProgrammingCourse;
import example.com.decorators.CertificateDecorator;
import example.com.decorators.GamificationDecorator;
import example.com.decorators.MentorSupportDecorator;
import example.com.facade.StudentPortalFacade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lms")
public class LmsController {

    private final StudentPortalFacade portal;

    public LmsController(StudentPortalFacade portal) {
        this.portal = portal;
    }

    @GetMapping("/enroll")
    public String enrollCourse(@RequestParam String course,
                               @RequestParam(required = false) String decorators) {

        Course selectedCourse;

        switch (course.toLowerCase()) {
            case "math" -> selectedCourse = new MathCourse();
            case "programming" -> selectedCourse = new ProgrammingCourse();
            default -> {
                return "Unknown course: " + course;
            }
        }

        if (decorators != null) {
            for (String decorator : decorators.split(",")) {
                switch (decorator.trim().toLowerCase()) {
                    case "mentor" -> selectedCourse = new MentorSupportDecorator(selectedCourse);
                    case "certificate" -> selectedCourse = new CertificateDecorator(selectedCourse);
                    case "gamification" -> selectedCourse = new GamificationDecorator(selectedCourse);
                    default -> {
                        return "Unknown decorator: " + decorator;
                    }
                }
            }
        }

        portal.enrollInCourse(course, selectedCourse);
        return "Enrolled in " + course + " with " +
                (decorators != null ? decorators : "no extra features") + ".";
    }

    @GetMapping("/start")
    public String startCourse(@RequestParam String course) {
        portal.startLearning(course);
        return "Started course: " + course;
    }


    @GetMapping("/complete")
    public String completeCourse(@RequestParam String course) {
        portal.completeCourse(course);
        return "Completed course: " + course;
    }
}
