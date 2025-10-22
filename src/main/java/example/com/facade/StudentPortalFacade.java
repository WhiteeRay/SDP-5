package example.com.facade;


import example.com.Course;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentPortalFacade {
    private final Map<String, Course> enrolledCourses = new HashMap<>();

    public void enrollInCourse(String name, Course course) {
        enrolledCourses.put(name, course);
        System.out.println("✅ Enrolled in " + name);
    }

    public void startLearning(String name) {
        Course course = enrolledCourses.get(name);
        if (course != null) {
            System.out.println("🚀 Starting: " + name);
            System.out.println(course.deliverContent());
        } else {
            System.out.println("⚠️ Course not found!");
        }
    }

    public void completeCourse(String name) {
        if (enrolledCourses.containsKey(name)) {
            System.out.println("🎉 Completed: " + name);
            System.out.println("📩 Notification sent to student.");
        }
    }
}
