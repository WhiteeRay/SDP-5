🎓 Online Education Platform (LMS)
🧩 Overview

This project is a Spring Boot application that simulates an Online Learning Management System (LMS).
It demonstrates two key Design Patterns:

Decorator Pattern — for adding dynamic features to courses.

Facade Pattern — for simplifying student interactions with the system.

Students can enroll in different types of courses and enhance them with additional features like Certificates, Mentor Support, and Gamification.

🧠 Design Patterns
🧱 1. Decorator Pattern — Course Features

The Decorator Pattern allows adding new behaviors to existing courses at runtime without altering their structure.

Structure:

Base Component: Course interface (deliverContent() method)

Concrete Components:

MathCourse

ProgrammingCourse

Decorators:

CertificateDecorator → adds certificate upon completion

MentorSupportDecorator → adds personal mentor support

GamificationDecorator → adds points & leaderboard

Example:

Course mathCourse = new CertificateDecorator(
new MentorSupportDecorator(new MathCourse())
);

Course programmingCourse = new GamificationDecorator(
new ProgrammingCourse()
);

🎛️ 2. Facade Pattern — StudentPortalFacade

The Facade Pattern provides a simple interface for students to interact with the system.

Responsibilities:

Enroll in courses

Start learning

Complete courses

Internally manage progress and decorated course features

Methods:

void enrollInCourse(String name, Course course)
void startLearning(String name)
void completeCourse(String name)

🚀 3. Demo

You can simulate a full student learning journey using the DemoController.

Example flow:

Student enrolls in MathCourse with Mentor Support + Certificate

Student enrolls in ProgrammingCourse with Gamification

The system then starts and completes both courses, logging progress in the console

🖥️ API Endpoints
Method	Endpoint	Description
POST	/api/enroll	Enroll in a new course
POST	/api/start	Start learning a course
POST	/api/complete	Complete a course
GET	/api/demo	Run the sample demo journey
🧪 Example Request
Enroll a course
POST /api/enroll
Content-Type: application/json

{
"name": "MathCourse",
"type": "MathCourse",
"features": ["MentorSupport", "Certificate"]
}

Start learning
POST /api/start
Content-Type: application/json

{
"name": "MathCourse"
}

Complete course
POST /api/complete
Content-Type: application/json

{
"name": "MathCourse"
}

🧰 Tech Stack

Java 17+

Spring Boot 3+

Maven

RESTful API

Design Patterns: Decorator, Facade

📦 Project Structure
src/
└── main/java/com/example/lms/
├── course/
│   ├── Course.java
│   ├── MathCourse.java
│   ├── ProgrammingCourse.java
│   ├── CertificateDecorator.java
│   ├── MentorSupportDecorator.java
│   └── GamificationDecorator.java
├── facade/
│   └── StudentPortalFacade.java
├── controller/
│   └── CourseController.java
└── LmsApplication.java

🏁 Running the Application

Clone this repository:

git clone https://github.com/yourusername/lms-decorator-facade.git


Navigate into the project folder:

cd lms-decorator-facade


Run the app:

mvn spring-boot:run


Visit:

http://localhost:8080/api/demo