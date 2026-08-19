# Registration Login Portal (Java)

A simple Registration and Login portal implemented in Java with HTML front-end pages. This project demonstrates basic user registration, login, session handling, and account deletion using servlets and a MySQL database.

## Repository structure

- src/ — Java servlet source code (package: `myPackage`)
- Web pages (HTML / JSP) — front-end views
- .classpath, .project, .settings — IDE project files (Eclipse)

The repository is primarily Java (≈92.7%) with a few HTML/JSP views (≈7.3%).

## Features

- User registration
- User login with session creation
- Account deletion
- Simple form validation and user flow (register → login → welcome)

## Prerequisites

- Java Development Kit (JDK) 8 or newer
- A servlet container such as Apache Tomcat (9+ recommended)
- MySQL server (or compatible) and a database/user for the application
- MySQL Connector/J (JDBC driver) on the server's classpath or added to the project
- An IDE such as Eclipse or IntelliJ IDEA (optional)

## Database setup

Create a database and a `register` table that matches the columns used in the code. Example SQL:

```sql
CREATE DATABASE IF NOT EXISTS MyPortal;
USE MyPortal;

CREATE TABLE IF NOT EXISTS register (
  id INT AUTO_INCREMENT PRIMARY KEY,
  Name VARCHAR(100),
  Email VARCHAR(150) UNIQUE,
  Password VARCHAR(255),
  Gender VARCHAR(10),
  Mobile VARCHAR(20),
  City VARCHAR(100)
);
```

Note: The code in this repository expects a database named `MyPortal` and a table named `register` with columns `Name`, `Email`, `Password`, `Gender`, `Mobile`, and `City`.

## Configuration

The database connection is currently configured in the servlets (for example, `Login.java` and `Delete.java`) with these values:

- URL: `jdbc:mysql://localhost:3306/MyPortal`
- Username: `root`
- Password: `S12345s@`

For production or shared projects, avoid hard-coding credentials. Instead, consider using one of the following approaches:

- Move DB credentials to a configuration file (properties file) and load them at runtime.
- Use context parameters in `web.xml` or environment variables provided by the servlet container.
- Use a connection pool (e.g., Apache DBCP or HikariCP) configured in the container for better performance.

## Build & Run

1. Clone the repository:

   git clone https://github.com/subhadip2004999/Registration-Login-Portal-in-Java.git

2. Import the project into your IDE (Eclipse: File → Import → Existing Projects into Workspace) or build with your preferred build tool.

3. Make sure the MySQL JDBC driver (Connector/J) is available to the servlet container (put the jar in Tomcat's `lib/` directory or add it to the project `WEB-INF/lib/`).

4. Deploy the project to a servlet container (Tomcat/Jetty) as a WAR or run it from your IDE's server configuration.

5. Open the application in a browser (e.g., http://localhost:8080/<your-app-context>/) and use the provided HTML/JSP pages to register and login.

## Security notes & improvements

- Passwords are stored in plaintext in the current code. Replace this with a secure password hashing strategy (e.g., bcrypt, Argon2) before using the app in any real environment.
- Validate and sanitize all user input to avoid SQL injection and XSS. Although prepared statements are used in places, ensure all DB access uses parameterized queries.
- Replace hard-coded DB credentials with configuration or environment variables.

## Tests

No automated tests are included. You can add unit and integration tests (JUnit, Mockito) under a `test/` directory and a CI configuration if desired.

## Contributing

Contributions are welcome. Please open issues for bugs or feature requests and submit pull requests for proposed changes.

## License

No license file is included in this repository. If you want others to use or contribute to this project, consider adding an open source license (for example: MIT, Apache-2.0).

---

If you'd like, I can:
- Expand the README with step-by-step deployment instructions for Tomcat including exact paths and commands.
- Add an example `web.xml` or show how to move DB credentials to a properties file or environment variables.
- Add a LICENSE file (tell me which license you prefer).
