# Zoo Management - Training Project
- Just project with my team for a website which manages a zoo.
- **NOTE:** Do not use this as a real management unless you know what you're doing.

## Project Information:
- Use web language: Spring MVC (JavaServer Pages, Java Servlet).
- Database: MySQL

## Requirements:
- [JDK (v**17**)](https://adoptium.net/temurin/releases/)
- [MySQL/MariaDB Server](https://www.mysql.com/downloads/)
- [Apache Tomcat (v**10.1**)](https://tomcat.apache.org/download-11.cgi)
- IDE ([Eclipse](https://www.eclipse.org/downloads/), [IntelliJ IDEA](https://www.jetbrains.com/idea/),...)
  - You will need the latest version of Eclipse to add Apache Tomcat 10.1 or later.
  - You will need IntelliJ IDEA Ultimate if you want to run/debug project, as Web Support wasn't include in Community edition.
  - If you want to use a text editor (like [Visual Studio Code](https://code.visualstudio.com/download)), you need to use [Apache Maven](https://maven.apache.org/download.cgi) to manually build WAR file that for deploy to Apache Tomcat.

## Database
- View database template [here](zoo-management.sql).

## Build WAR file with Apache Maven
- **IMPORTANT:** You need to config database connection on [springmvc-servlet.xml](src/main/webapp/WEB-INF/springmvc-servlet.xml) before build or run project.
- Quick build: `mvn war:war`
- Clean: `mvn clean`
- Clean -> Install all dependencies -> Build: `mvn clean install -U war:war`
  - After done successful building, this WAR file and ZooManagement web file will be stored in {projectDir}/target.

## License
- [GPL 3.0](LICENSE)
