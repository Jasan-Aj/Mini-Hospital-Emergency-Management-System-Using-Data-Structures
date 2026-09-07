# Mini Hospital Emergency Management System

A simple console-based hospital management system made for DSA (Data Structures and Algorithms) course project.

## About

This program manages basic hospital operations like patient records, emergency waiting room, and treatment history using different data structures we learned in class.

## Data Structures Used

- **Binary Search Tree (BST)** - for storing and searching patient records (by patient ID)
- **Queue** - for the emergency waiting room (first come first serve)
- **Stack** - for keeping treatment history (latest treatment on top)
- **Linked List** - for storing visits of each patient

## Features

1. Patient Records
   - Register new patient
   - Find patient by ID
   - Delete patient
   - Show all patients
   - Add / delete / find visits for a patient

2. Emergency Waiting Room
   - Add patient to waiting line
   - Treat next patient in line
   - Show waiting patients

3. Treatment History
   - Save a finished treatment
   - Undo last treatment entry
   - Show all treatment history

## How to Run

```
javac src/*.java
java -cp src Main
```

## Files

| File | What it does |
|------|-------------|
| Main.java | Menu and user input |
| Patient.java | Patient info (id, name, age, phone, illness) |
| PatientTree.java | BST for patient records |
| TreeNode.java | Node for the BST |
| WaitingLine.java | Queue for emergency room |
| LineCell.java | Node for the queue |
| CareLog.java | Stack for treatment history |
| HistoryCell.java | Node for the stack |
| ClinicVisit.java | Visit info (date, doctor, diagnosis, medicine) |
| VisitLog.java | Linked list for patient visits |
| VisitCell.java | Node for the linked list |
| CareRecord.java | Treatment record info |

## Author

Jasan Aj
