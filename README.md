# URL Shortener

The URL Shortener is a CLI made to shorten long URLs into more easily usable ones. The app takes the URL, creates a key, converts the key to a base62 format, and returns the shortened version to the user. When the shortened URL is accessed, the server redirects users to the original URL!

![URL Shortener CLI](/static/url-shortener-1.png)

The application also includes validation:

![URL Shortener validation](/static/url-shortener-2.png)


## Tech Stack
### Backend
- Java
- Spring Boot
- Spring Data MongoDB
- Maven
- MongoDB
- JUnit (for testing)

### Frontend
- Javascript
- Node.js
- AJAX
- Inquirer

## Installation

### Requirements

- Node.js 20
- Maven 3.9
- JDK 20

### Steps

#### Setting up the server:

1. Clone the github repository.
```zsh
git clone https://github.com/emikobell/url-shortener
```

2. Create and connect your MongoDB database by creating an application.properties file under src/main/resources. The format should look like:
```
spring.data.mongodb.uri=mongodb+srv://<username>:<pwd>@<cluster>.mongodb.net/urldata
spring.data.mongodb.database=urldata
```

3. Run the Spring Boot application.
```zsh
mvn spring-boot:run
```

4. If there are no exceptions, the server is now up!

5. Navigate to cli and install the node dependencies in package.json:
```zsh
cd cli
npm install
```

6. Install the url-shortener CLI. The -g flag installs it globally (you can omit this if you would like).
```zsh
npm install -g .
```

7. Run the url shortener application.
```zsh
url-shortener
```

## Future features:
- Docker containers