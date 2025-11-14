📌Todo App with Emotion Insight (Spring Boot + JPA + MySQL)
-

A powerful and modern Todo Management Application built using Spring Boot, with upcoming support for emotion detection based on user task descriptions.
The app currently supports full CRUD operations, search, filtering, and a clean scalable structure to integrate AI-powered emotion analysis.

🚀 Features (Current) 

 ✅ Core Todo Features :-
  -

- Create a new Todo.

- Fetch all Todos.

- Fetch a Todo by ID.

- Update an existing Todo.

- Delete a Todo.

- Search Todos by keyword.

- Filter Todos by completion status.


🧱 Clean Architecture :-
-                          
- Controller Layer → Handles REST endpoints .

- Service Layer → Business logic.

- Repository Layer → Database operations.

- Model Layer → Entity definitions.

 🗄️ Database :-
-

- Supports MySQL (production).

- Supports H2 (development & testing).

🔮 Features (Upcoming Roadmap) :-
-
- [ ] 🤖 Phase 1 – Local Emotion Analysis

- Analyze user’s Todo text using a rule-based emotion engine
(e.g., “meeting”, “deadline”, “urgent”, “frustrated”, “happy”).

----------------------------------------------
- [ ] 🤝 Phase 2 – AI-Powered Emotional Insight

- Integrate advanced AI models (HuggingFace / Local NLP) to detect:

- mood hidden in tasks

- emotional patterns

- stress indicators

- productivity sentiment

----------------------------------------------

- [ ] 🧠 Phase 3 – Hybrid Emotion Decision Layer

- The backend chooses:

- Local Analyzer for simple detection

- AI Analyzer for uncertain cases

- Stores emotion confidence in DB

----------------------------------------------

- [ ] 📊 Phase 4 – Weekly Mood Analytics

- Dashboard showing:

- mood trend

- task patterns

- stress peaks

- productivity graph

----------------------------------------------

👨‍💻Technologies Used :-
-
- Backend

- Spring Boot

- Spring Web (REST API)

- Spring Data JPA

- Hibernate ORM

- Database

- MySQL

- H2 Database (dev/testing)

-----------------------------------------------
🛠️ Tools :-
-
- Postman (API testing)
- VS Code
- Git and GitHub
- Maven

## 📁 Project Structure

```
src/
└── main/
    └── java/
        └── com/example/todo
            ├── controller
            │   └── TodoController.java
            ├── service
            │   ├── TodoService.java
            │   └── EmotionService.java (future)
            ├── model
            │   └── Todo.java
            ├── repository
            │   └── TodoRepository.java
            └── emotion
                ├── LocalEmotionAnalyzer.java (future)
                └── AIEmotionAnalyzer.java (future)
```

  
📡 API Endpoints :-
-
Method	Endpoint	Description
```
GET	  /api/todo	Get all todos.

GET	  /api/todo/{id}	Get todo by ID.

POST	/api/todo	Create a todo.

PUT	  /api/todo	Update a todo.

DELETE	/api/todo/{id}	Delete todo by ID.

GET	   /api/todo/search/{keyword}	Search todos.

GET	   /api/todo/status/{completed}	Filter todos by status.
```
----------------------------------------------

🔧 How to Run the Project
-
1️⃣ Clone the Repo :- 
```
git clone https://github.com/AmanSoni1-apex/SMART-TODO.git 
```
----------------------------------------------

2️⃣ Configure MySQL :- 
-
```
spring.datasource.url=jdbc:mysql://localhost:3306/tododb

spring.datasource.username=root

spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
```
----------------------------------------------

3️⃣ Run the app :- 
-
```
mvn spring-boot:run
```
----------------------------------------------

🧪 Testing with Postman (CRUD) :-
-
Example request (POST):-
```
{
  "title": "Complete Assignment",
  "description": "Finish Java project",
  "completed": false
}
```
----------------------------------------------

⭐ Future Vision 

This project will evolve from a simple Todo app to a self-awareness productivity system that helps users understand:

their emotional state

hidden stress

burnout patterns

motivation drops

A Todo app that doesn’t just store tasks —
it understands the person behind those tasks.

----------------------------------------------

🧑‍💻 Author :- 

Aman Soni 🌞

 Java Backend Developer (Spring Boot)

• GSoC 2026 Aspirant 

• Problem Solver
• Builder
