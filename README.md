# MoodBoard

A social platform for sharing moods and emotions, built with Spring Boot and Thymeleaf.

## Features

- User profiles with mood tracking
- Visual mood posts with images
- Mood distribution analytics
- Interactive UI with Bootstrap 5
- Responsive design for mobile and desktop

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Your favorite IDE (IntelliJ IDEA, Eclipse, or VS Code/Cursor)

## Getting Started

1. Clone the repository:
   ```bash
   git clone [your-repository-url]
   cd MoodBoard
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

   Or run the JAR file directly:
   ```bash
   java -jar target/moodboard-1.0.0.jar
   ```

4. Open your browser and navigate to:
   ```
   http://localhost:8080
   ```

## Project Structure

```
MoodBoard/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── moodboard/
│   │   │           ├── controller/
│   │   │           ├── model/
│   │   │           ├── service/
│   │   │           └── MoodBoardApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── css/
│   │       │   ├── js/
│   │       │   └── images/
│   │       └── templates/
│   │           ├── home.html
│   │           └── profile.html
├── pom.xml
└── README.md
```

## Development

To work on this project in Cursor:

1. Open Cursor
2. File > Open Folder
3. Select the MoodBoard directory
4. Wait for the project to load and index

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
