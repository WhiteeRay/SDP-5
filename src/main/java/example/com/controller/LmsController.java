package example.com.controller;


import example.com.facade.StudentPortalFacade;
import example.com.model.course.Course;
import example.com.model.MathCourse;
import example.com.model.ProgrammingCourse;
import example.com.decorator.CertificateDecorator;
import example.com.decorator.GamificationDecorator;
import example.com.decorator.MentorSupportDecorator;
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

        return portal.enrollInCourse(course, selectedCourse);
    }

    @GetMapping("/start")
    public String startCourse(@RequestParam String course) {
        return portal.startLearning(course);
    }

    @GetMapping("/complete")
    public String completeCourse(@RequestParam String course) {
        return portal.completeCourse(course);
    }

    @GetMapping("/status")
    public String getStatus(@RequestParam String course) {
        return portal.getStatus(course);
    }
}
