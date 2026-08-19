# Registration Login Portal (Java)

A simple Registration and Login portal implemented in Java with HTML front-end pages. This project demonstrates basic user registration, login, session handling, and account deletion using servlets.

**🌐 Live Website:** https://myportal-image-latest.onrender.com

## Website Preview

### Welcome Page
![Welcome to My Portal](https://github.com/subhadip2004999/Registration-Login-Portal-in-Java/raw/main/assets/image1.png)

### Login Page
![Welcome Back - Login](https://github.com/subhadip2004999/Registration-Login-Portal-in-Java/raw/main/assets/image2.png)

### Registration Page
![Create an Account](https://github.com/subhadip2004999/Registration-Login-Portal-in-Java/raw/main/assets/image3.png)

### Profile Dashboard
![Profile Overview](https://github.com/subhadip2004999/Registration-Login-Portal-in-Java/raw/main/assets/image4.png)

## Repository structure

- src/ — Java servlet source code (package: `myPackage`)
- Web pages (HTML / JSP) — front-end views
- .classpath, .project, .settings — IDE project files (Eclipse)

The repository is primarily Java (≈81.5%) with HTML markup (≈18.5%).

## Features

- User registration with validation
- User login with session creation
- Account deletion
- Simple form validation and user flow (register → login → welcome)
- Responsive UI with modern design

## Database

This application uses **Supabase** (a PostgreSQL-based backend service) as the database, which is publicly available. Database credentials and connection details are securely configured in the application.

- **Database Service:** Supabase (PostgreSQL)
- **Status:** Publicly available
- **Table:** `register` with columns: `id`, `Name`, `Email`, `Password`, `Gender`, `Mobile`, `City`

## Workflow

The user interaction workflow follows these steps:

1. **User arrives at the portal** → Lands on the welcome page with two options: "Log In" or "Register"
2. **New User (Register)** → Fills registration form with personal details (Name, Email, Mobile, Gender, City, Password) → Account is created in the database
3. **Existing User (Login)** → Enters email and password → System validates credentials against the database → Session is created upon successful login
4. **Dashboard** → User views their profile information and can log out or delete their account
5. **Account Deletion** → User account and associated data are removed from the database

## Prerequisites

- Java Development Kit (JDK) 8 or newer
- A servlet container such as Apache Tomcat (9+ recommended)
- Supabase account with database configured
- PostgreSQL JDBC driver on the server's classpath or added to the project
- An IDE such as Eclipse or IntelliJ IDEA (optional)

## Database setup

The `register` table in Supabase should have the following structure:

```sql
CREATE TABLE register (
  id SERIAL PRIMARY KEY,
  Name VARCHAR(100),
  Email VARCHAR(150) UNIQUE,
  Password VARCHAR(255),
  Gender VARCHAR(10),
  Mobile VARCHAR(20),
  City VARCHAR(100),
  created_at TIMESTAMP DEFAULT NOW()
);
```

## Configuration

The database connection is configured using Supabase credentials:

- **Host:** Your Supabase PostgreSQL host
- **Database:** Your Supabase project database name
- **Username:** Your Supabase database user
- **Password:** Your Supabase database password

For production or shared projects, use one of the following approaches:

- Move DB credentials to a configuration file (properties file) and load them at runtime.
- Use environment variables provided by the servlet container or deployment platform (e.g., Render, Heroku).
- Use connection pooling (e.g., Apache DBCP or HikariCP) for better performance.

## Build & Run

1. Clone the repository:

   ```bash
   git clone https://github.com/subhadip2004999/Registration-Login-Portal-in-Java.git
   cd Registration-Login-Portal-in-Java
   ```

2. Import the project into your IDE (Eclipse: File → Import → Existing Projects into Workspace) or build with your preferred build tool.

3. Add PostgreSQL JDBC driver to your project (add to `WEB-INF/lib/` or configure in your build tool).

4. Configure your Supabase database credentials in the application (update connection parameters in the servlet files or configuration files).

5. Deploy the project to a servlet container (Tomcat/Jetty) as a WAR or run it from your IDE's server configuration.

6. Open the application in a browser and use the provided HTML/JSP pages to register and login.

7. For live deployment (like on Render), ensure environment variables are set for database credentials.

## Deployment

The application is currently deployed and running at: **https://myportal-image-latest.onrender.com**

### Deployment Steps (Render.com)
1. Push your code to GitHub
2. Connect your GitHub repository to Render
3. Set environment variables for Supabase credentials in Render dashboard
4. Deploy as a web service
5. Access your live application via the Render URL

## Security notes & improvements

- Passwords are stored securely and should use proper hashing (e.g., bcrypt, Argon2).
- All user input is validated and sanitized to prevent SQL injection and XSS attacks.
- Database credentials are stored in environment variables, not hard-coded.
- Consider implementing:
  - Two-factor authentication (2FA)
  - Email verification for new accounts
  - Password reset functionality
  - HTTPS enforcement
  - CSRF token protection

## Tests

No automated tests are included. You can add unit and integration tests (JUnit, Mockito) under a `test/` directory and a CI configuration if desired.

## Contributing

Contributions are welcome. Please open issues for bugs or feature requests and submit pull requests for proposed changes.

## License

No license file is included in this repository. If you want others to use or contribute to this project, consider adding an open source license (for example: MIT, Apache-2.0).

---

**Developer:** Subhadip Biswas  
**Technologies:** Java • JSP • JDBC • PostgreSQL (Supabase) • HTML • CSS
