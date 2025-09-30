# Virtual Classroom Manager

## Overview

**Virtual Classroom Manager** is a **console-based Java application** that simulates the backend of a virtual classroom system for an EdTech platform.  

It allows you to:

- Create and manage classrooms  
- Enroll students into classrooms  
- Schedule assignments  
- Submit assignments  
- List classrooms, students, and assignments  

This project demonstrates **OOP best practices**, **SOLID principles**, and **structural design patterns** such as **Composite** and **Facade**.

---

## Features

1. **Classroom Management**
   - Add new classrooms  
   - Remove classrooms  
   - List all classrooms  

2. **Student Management**
   - Enroll students into classrooms  
   - List students in a classroom  

3. **Assignment Management**
   - Schedule assignments for classrooms  
   - Submit assignments by students  
   - List assignments and track submissions  

4. **Robustness**
   - Logging using `LoggerUtil`  
   - Custom exception handling via `ClassroomException`  
   - Handles invalid inputs gracefully  

---

### Explanation of Folders

- **`src/`** → Contains all source code.
- **`Main.java`** → Entry point of the program.
- **`facade/`** → Facade class (`VirtualClassroomManager.java`) that provides a unified interface.
- **`composite/`** → Implements the Composite Design Pattern for classrooms, students, and assignments.
- **`manager/`** → Manages classroom, student, and assignment operations.
- **`utils/`** → Utility class for logging (`LoggerUtil.java`).
- **`exceptions/`** → Custom exception handling (`ClassroomException.java`).

---


##  Design Patterns Used

### **1. Composite Pattern**
- `Classroom` is the composite.  
- `Student` and `Assignment` are leaves.  
- All implement `ClassroomComponent`.  
- Enables **uniform handling** of students and assignments.

### **2. Facade Pattern**
- `VirtualClassroomManager` acts as a **single interface** for the terminal to interact with multiple managers:  
  - `ClassroomManager`  
  - `StudentManager`  
  - `AssignmentManager`  

---

##  Setup & Run

1. Navigate to the `src` folder:
```bash
cd VirtualClassroomManager/src
```

2. Compile all Java files:
```bash
javac Main.java facade/*.java composite/*.java manager/*.java utils/*.java exceptions/*.java
```

3. Run the application:
```bash
java Main
```