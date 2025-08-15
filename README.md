
# E2E QA Automation Framework – Web, API & Mobile (Ecommerce Domain)

A production-style test automation framework showcasing **Web UI (Selenium + TestNG + Cucumber)**, **API (RestAssured)**, **Mobile (Appium)**, **DB checks (H2 + JDBC)**, **Performance (JMeter plan)**, and **CI/CD (Jenkins + GitHub Actions)**. Built to be plug‑and‑play for interviews and real projects.

## 🔧 Tech Stack
- Java 11, Maven
- Selenium 4, TestNG, Cucumber BDD
- RestAssured (API), Jackson
- Appium (Android sample)
- H2 (sample DB), JDBC
- Jenkinsfile, GitHub Actions

## ▶️ Quick Start
**Prereqs:** Java 11+, Maven 3.8+, Chrome. (Optional: Appium + emulator for mobile)
```bash
# Web suite (TestNG)
mvn clean test -P web
# BDD suite (Cucumber)
mvn clean test -P bdd
# API suite
mvn clean test -P api
# Mobile suite (requires Appium server)
mvn clean test -P mobile
```

**Config:** `src/main/resources/config.properties`
```
baseUrl=https://demowebshop.tricentis.com
browser=chrome
implicitWait=10
apiBaseUrl=https://fakestoreapi.com
db.url=jdbc:h2:mem:testdb
db.user=sa
db.pass=
```

**Reports:**  
- TestNG: `target/surefire-reports/index.html`  
- Cucumber: `target/cucumber-report.html`

**CI:**  
- Jenkins: `Jenkinsfile`  
- GitHub Actions: `.github/workflows/ci.yml`

## 📁 Structure
```
E2E-QA-Automation-Framework
 ├─ src
 │  ├─ main/java/framework (base, utils)
 │  ├─ main/resources (config, data, sql)
 │  └─ test/java
 │     ├─ pages (POM)
 │     ├─ tests (TestNG)
 │     ├─ apiTests (RestAssured)
 │     ├─ bdd (features, steps, runner)
 │     └─ mobileTests (Appium)
 ├─ jmeter/SearchAPI.jmx
 ├─ postman/FakeStore.postman_collection.json
 ├─ Jenkinsfile
 └─ pom.xml
```
