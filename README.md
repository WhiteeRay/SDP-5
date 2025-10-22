#  Online Education Platform (LMS)

##  Overview
This project is a **Spring Boot** application that simulates an **Online Learning Management System (LMS)**.  
It demonstrates two key **Design Patterns**:
- **Decorator Pattern** — for adding dynamic features to courses.
- **Facade Pattern** — for simplifying student interactions with the system.

Students can enroll in different types of courses and enhance them with additional features like **Certificates**, **Mentor Support**, and **Gamification**.

---

##  Design Patterns

###  1. Decorator Pattern — Course Features
The **Decorator Pattern** allows adding new behaviors to existing courses at runtime without altering their structure.

**Structure:**
- **Base Component:** `Course` interface (`deliverContent()` method)
- **Concrete Components:**
    - `MathCourse`
    - `ProgrammingCourse`
- **Decorators:**
    - `CertificateDecorator` → adds certificate upon completion
    - `MentorSupportDecorator` → adds personal mentor support
    - `GamificationDecorator` → adds points & leaderboard


## 2. Facade Pattern — StudentPortalFacade
# The Facade Pattern provides a simple interface for students to interact with the system.

Responsibilities:

Enroll in courses

Start learning

Complete courses

Internally manage progress and decorated course features

Methods:



##  API Endpoints
````
Method	Endpoint	Description
POST	/api/enroll	Enroll in a new course
POST	/api/start	Start learning a course
POST	/api/complete	Complete a course
````
