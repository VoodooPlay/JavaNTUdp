package org.green.lab3.Controller;

import org.green.lab3.Model.*;

public class StudentCreator {
    public Student createStudent(String firstName, String lastName, String patronymic, Sex sex) {
        return new Student(firstName, lastName, patronymic, sex);
    }
}
