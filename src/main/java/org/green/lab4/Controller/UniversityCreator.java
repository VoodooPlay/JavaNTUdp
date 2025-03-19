package org.green.lab4.Controller;

import org.green.lab4.Model.Faculty;
import org.green.lab4.Model.Human;
import org.green.lab4.Model.University;

public class UniversityCreator {
    public University createUniversity(String name, Human head) {
        return new University(name, head);
    }

    public void addFaculty(University university, Faculty faculty) {
        university.addFaculty(faculty);
    }
}
