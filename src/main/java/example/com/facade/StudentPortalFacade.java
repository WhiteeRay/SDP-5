package example.com.facade;


import example.com.model.course.Course;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StudentPortalFacade {

    private final Map<String, Course> enrolledCourses = new HashMap<>();
    private final Map<String, String> courseStatus = new HashMap<>();


    public String enrollInCourse(String name, Course course) {
        String normalizeName = name.toLowerCase();
        if (enrolledCourses.containsKey(normalizeName)) {
            return "Already enrolled in " + name;
        }
        enrolledCourses.put(normalizeName, course);
        courseStatus.put(normalizeName, "enrolled");
        return " Enrolled in " + name;
    }

    public String startLearning(String name) {
        String normalizeName = name.toLowerCase();
        if (!enrolledCourses.containsKey(normalizeName)) {
            return " You must enroll in " + name + " before starting.";
        }
        if ("started".equals(courseStatus.get(normalizeName))) {
            return "Already started " + name;
        }
        if ("completed".equals(courseStatus.get(normalizeName))) {
            return " You have already completed " + name;
        }

        courseStatus.put(normalizeName, "started");

        return enrolledCourses.get(normalizeName).deliverContent();
    }

    public String completeCourse(String name) {
        String normalizeName = name.toLowerCase();
        if (!enrolledCourses.containsKey(normalizeName)) {
            return " You must enroll in " + name + " before completing.";
        }
        if (!"started".equals(courseStatus.get(normalizeName))) {
            return "You must start " + name + " before completing.";
        }

        courseStatus.put(normalizeName, "completed");

        Course course = enrolledCourses.get(normalizeName);
        return " Completed " + name + " with features: " + course.getFeatures();
    }

    public String getStatus(String name) {
        String normalizeName = name.toLowerCase();
        if (!enrolledCourses.containsKey(normalizeName)) {
            return "Not enrolled in " + name;
        }

        Course course = enrolledCourses.get(normalizeName);
        String status = courseStatus.get(normalizeName);

        return "Status of " + name + ": " + status + " | Features: " + course.getFeatures();
    }


}
