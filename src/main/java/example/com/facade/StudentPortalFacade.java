package example.com.facade;


import example.com.Course;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StudentPortalFacade {

    private final Map<String, Course> enrolledCourses = new HashMap<>();
    private final Map<String, String> courseStatus = new HashMap<>();


    public String enrollInCourse(String name, Course course) {
        if (enrolledCourses.containsKey(name)) {
            return "Already enrolled in " + name;
        }
        enrolledCourses.put(name, course);
        courseStatus.put(name, "enrolled");
        return " Enrolled in " + name;
    }

    public String startLearning(String name) {
        if (!enrolledCourses.containsKey(name)) {
            return " You must enroll in " + name + " before starting.";
        }
        if ("started".equals(courseStatus.get(name))) {
            return "Already started " + name;
        }
        if ("completed".equals(courseStatus.get(name))) {
            return " You have already completed " + name;
        }

        courseStatus.put(name, "started");
        enrolledCourses.get(name).deliverContent();
        return "Started learning " + name;
    }

    public String completeCourse(String name) {
        if (!enrolledCourses.containsKey(name)) {
            return " You must enroll in " + name + " before completing.";
        }
        if (!"started".equals(courseStatus.get(name))) {
            return "You must start " + name + " before completing.";
        }

        courseStatus.put(name, "completed");

        Course course = enrolledCourses.get(name);
        return " Completed " + name + " with features: " + course.getFeatures();
    }

    public String getStatus(String name) {
        if (!enrolledCourses.containsKey(name)) {
            return "Not enrolled in " + name;
        }

        Course course = enrolledCourses.get(name);
        String status = courseStatus.get(name);

        return "Status of " + name + ": " + status + " | Features: " + course.getFeatures();
    }


}
