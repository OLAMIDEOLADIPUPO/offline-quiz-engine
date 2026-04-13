# Offline Quiz Engine

A console-based quiz application built in Java that loads questions from a JSON file, runs an interactive quiz session, calculates scores, and saves attempts to disk.

---

## Features

- Loads questions dynamically from a `questions.json` file
- Interactive console quiz with A/B/C/D input validation
- Score calculation and percentage grading
- Saves every attempt to `attempts.json` automatically
- Clean OOP design with separated packages

---

## Project Structure

```
src/
├── Main.java                  # Entry point
├── controller/
│   └── QuizEngine.java        # Runs quiz logic and user interaction
├── model/
│   ├── Question.java          # Holds question text, options, correct answer
│   └── Attempt.java           # Holds username, score, and date of attempt
├── service/
│   └── Quiz.java              # Manages quiz state and scoring
└── repository/
    └── FileService.java       # Loads questions and saves attempts to disk
```

---

## Getting Started

### Prerequisites
- Java JDK 17 or higher
- [Gson 2.13.2](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.13.2) JAR added to your classpath

### Setup
1. Clone the repository
   ```bash
   git clone https://github.com/YOURUSERNAME/quiz-engine.git
   ```

2. Add the Gson JAR to your project dependencies

3. Place `questions.json` in the project root folder (one is provided)

4. Run `Main.java`

---

## Question Format

Questions are loaded from `questions.json` in the following format:

```json
[
    {
        "questionText": "What is the capital of France?",
        "options": ["Paris", "London", "Berlin", "Rome"],
        "correctAnswerIndex": 0
    }
]
```

- `questionText` — the question string
- `options` — list of answer choices (up to 26)
- `correctAnswerIndex` — zero-based index of the correct option

---

## How It Works

1. `FileService` reads `questions.json` and deserializes it into a `List<Question>`
2. `Quiz` is initialized with those questions and tracks state
3. `QuizEngine` loops through each question, validates user input, and submits answers
4. On completion, score and percentage are displayed
5. The attempt is appended to `attempts.json` as a single JSON line

---

## Example Output

```
Enter username: John

What is the capital of France?
A. Paris
B. London
C. Berlin
D. Rome

Enter your answer (e.g A,B,C,D): A

===== QUIZ COMPLETE =====
Player : John
Score  : 18 / 22
Grade  : 81.8%
```

---

## Concepts Practiced

- Object-Oriented Programming (encapsulation, separation of concerns)
- File I/O (reading and writing JSON files)
- JSON parsing with Gson
- Input validation and exception handling
- Package structure (controller, service, model, repository)

---

## Author

Built as an intermediate beginner OOP project in Java.
