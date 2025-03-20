package org.green.lab4.Test;

import org.green.lab4.JSON.JSONManager;
import org.green.lab4.Model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniTest {
    // Тестування серіалізації і десеріалізації об'єкта University в/з JSON формату
    @Test
    public void testJsonSerialization() throws IOException {
        // Створення університету з назвою "Test University" та студентом "John Doe"
        University oldUniversity = new University("Test University", new Student("John", "Doe", "Michael", Human.Sex.MALE, "S90"));

        // Створення факультету "Faculty of Science" та студента "Alice Smith"
        Faculty faculty1 = new Faculty("Faculty of Science", new Student("Daniel", "Evans", "Michael", Human.Sex.MALE, "S91"));
        Faculty faculty2 = new Faculty("Faculty of Humanities", new Student("Sophia", "Clark", "Elizabeth", Human.Sex.FEMALE, "S92"));

        // Створення кафедр
        Department department11 = new Department("Mathematical Modeling", new Student("Irina", "Zakharova", "Alexeevna", Human.Sex.FEMALE, "S93"));
        Department department12 = new Department("Statistics and Data Analysis", new Student("Maxim", "Sergeyenko", "Grigorievich", Human.Sex.MALE, "S94"));
        Department department21 = new Department("Optimization and Operations Research", new Student("Elena", "Kravchenko", "Vasilyevna", Human.Sex.FEMALE, "S95"));
        Department department22 = new Department("Computer Modeling", new Student("Vadim", "Polyakov", "Andreevich", Human.Sex.MALE, "S96"));


        // Створення груп
        Group group111 = new Group("CS-101", new Student("John", "Doe", "Michael", Human.Sex.MALE, "S97"));
        Group group112 = new Group("CS-102", new Student("Alice", "Smith", "Jane", Human.Sex.FEMALE, "S98"));
        Group group121 = new Group("CS-103", new Student("David", "Brown", "Robert", Human.Sex.MALE, "S99"));
        Group group122 = new Group("CS-104", new Student("Emma", "Johnson", "Rose", Human.Sex.FEMALE, "S100"));
        Group group211 = new Group("CS-105", new Student("Michael", "Williams", "James", Human.Sex.MALE, "S101"));
        Group group212 = new Group("CS-106", new Student("Sophia", "Miller", "Anne", Human.Sex.FEMALE, "S102"));
        Group group221 = new Group("CS-107", new Student("Daniel", "Taylor", "Thomas", Human.Sex.MALE, "S103"));
        Group group222 = new Group("CS-108", new Student("Olivia", "Anderson", "Grace", Human.Sex.FEMALE, "S104"));

        // Додавання студентів до групи
        group111.addStudent(new Student("Charlie", "Johnson", "David", Human.Sex.MALE, "S105"));
        group111.addStudent(new Student("Emma", "Williams", "Sophia", Human.Sex.FEMALE, "S106"));
        group112.addStudent(new Student("Liam", "Brown", "James", Human.Sex.MALE, "S107"));
        group112.addStudent(new Student("Olivia", "Jones", "Grace", Human.Sex.FEMALE, "S108"));
        group121.addStudent(new Student("Noah", "Garcia", "Henry", Human.Sex.MALE, "S109"));
        group121.addStudent(new Student("Ava", "Martinez", "Isabella", Human.Sex.FEMALE, "S110"));
        group122.addStudent(new Student("William", "Davis", "Benjamin", Human.Sex.MALE, "S111"));
        group122.addStudent(new Student("Sophia", "Rodriguez", "Charlotte", Human.Sex.FEMALE, "S112"));
        group211.addStudent(new Student("James", "Lopez", "Elijah", Human.Sex.MALE, "S113"));
        group211.addStudent(new Student("Mia", "Hernandez", "Scarlett", Human.Sex.FEMALE, "S114"));
        group212.addStudent(new Student("Benjamin", "Gonzalez", "Lucas", Human.Sex.MALE, "S115"));
        group212.addStudent(new Student("Charlotte", "Wilson", "Avery", Human.Sex.FEMALE, "S116"));
        group221.addStudent(new Student("Elijah", "Anderson", "Daniel", Human.Sex.MALE, "S117"));
        group221.addStudent(new Student("Amelia", "Thomas", "Evelyn", Human.Sex.FEMALE, "S118"));
        group222.addStudent(new Student("Lucas", "Taylor", "Jack", Human.Sex.MALE, "S119"));
        group222.addStudent(new Student("Harper", "Moore", "Lillian", Human.Sex.FEMALE, "S120"));


        // Додавання групи до кафедри, кафедри до факультету та факультету до університету
        department11.addGroup(group111);
        department11.addGroup(group112);
        department12.addGroup(group121);
        department12.addGroup(group122);
        department21.addGroup(group211);
        department21.addGroup(group212);
        department22.addGroup(group221);
        department22.addGroup(group222);

        faculty1.addDepartment(department11);
        faculty1.addDepartment(department12);
        faculty2.addDepartment(department21);
        faculty2.addDepartment(department22);

        oldUniversity.addFaculty(faculty1);
        oldUniversity.addFaculty(faculty2);

        // Збереження об'єкта oldUniversity у файл "university.json" у JSON форматі
        JSONManager.saveToFile(oldUniversity, "university.json");

        // Завантаження університету з JSON файлу в об'єкт newUniversity
        University newUniversity = JSONManager.loadFromFile("university.json");

        // Перевірка чи рівні об'єкти oldUniversity і newUniversity
        System.out.println("Are universities equal? " + oldUniversity.equals(newUniversity));

        // Використовуємо JUnit assertEquals для порівняння об'єктів
        // Якщо об'єкти однакові, тест пройде успішно
        assertEquals(oldUniversity, newUniversity);
    }
}
