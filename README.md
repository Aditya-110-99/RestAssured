# 🔍 REST Assured API Automation Framework (Java 20 + TestNG + Maven)

This is a **lightweight, modular, and powerful REST API automation framework** developed in **Java 20** using **REST Assured**, **TestNG**, and **Maven**. It is designed to help QA engineers and developers write clean, maintainable, and reusable API test scripts with ease.

🧠 Ideal for: Learners, professionals, and teams who want a plug-and-play REST Assured framework that supports real-world testing needs and integrations.

---

## 📌 Tech Stack

- **Java 20**
- **REST Assured 5.5.5**
- **TestNG 7.11.0**
- **Maven** for build and dependency management
- **JSON & XML Path support**
- **JSON Schema Validator**
- **OAuth2 support (ScribeJava)**
- **org.json** for working with raw JSON objects

---

## 🚀 Features

- ✅ End-to-end API Testing with REST Assured  
- ✅ TestNG for assertions and test structure  
- ✅ JSON & XML response handling  
- ✅ Schema validation  
- ✅ Data-driven testing capabilities  
- ✅ Extensible structure for test modules  
- ✅ OAuth 2.0 authentication ready (via ScribeJava)  
- ✅ Easy integration with Jenkins or CI/CD pipelines  

---

## 📁 Project Structure

```
Rest_Assured_Framework/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── utils/              # Utility classes like config reader, logger, etc.
│   └── test/
│       └── java/
│           ├── tests/              # Test classes organized by endpoint
│           └── data/               # Static test data
├── testng.xml                      # TestNG suite runner
├── pom.xml                         # Maven configuration
└── README.md                       # You're here!
```

---

## 🛠️ How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/<your-username>/Rest_Assured_Framework.git
   cd Rest_Assured_Framework
   ```

2. **Import into IntelliJ IDEA or Eclipse**

3. **Build the project**
   ```bash
   mvn clean install
   ```

4. **Run tests via Maven**
   ```bash
   mvn test
   ```

---

## 📊 Reports

If you're using Extent Reports (recommended), the report is generated after execution under:

```
/test-output/ExtentReports/
```

Open the `.html` report in any browser for detailed results, logs, and screenshots (if implemented).

---

## 📚 Learning Outcomes

By using or contributing to this project, you'll understand how to:

- Build a scalable REST API test framework  
- Use REST Assured for various HTTP methods  
- Validate JSON schemas and extract values  
- Handle OAuth2 and other token-based authentication  
- Structure automation code for large-scale projects  

---

## 🧪 Sample Test Snippet

```java
given()
    .baseUri("https://api.example.com")
    .header("Authorization", "Bearer <token>")
    .when()
    .get("/users")
    .then()
    .statusCode(200)
    .body("data.size()", greaterThan(0));
```

---

## 🧩 Future Enhancements

- 🔄 CI/CD integration with Jenkins/GitHub Actions  
- 📊 Allure or Extent Reporting support  
- 📁 Externalize test data (JSON/Excel)  
- 🔐 JWT/OAuth2 token generation module  
- 📌 Dockerized Test Execution (optional)  

---

## 🤝 Contributing

Have something to add or improve? Fork this repo, create a branch, and raise a pull request.

---

## ⭐ Connect With Me

If this framework helps you in any way, **drop a ⭐** on the repo and connect with me on [LinkedIn](www.linkedin.com/in/contact-adityagupta/).  
Let’s build, learn, and grow together! 🌱

