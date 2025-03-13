package org.green.lab3.Controller;

import org.green.lab3.Model.*;

public class FacultyCreator {
    public Faculty createFaculty(String name, Human head) {
        return new Faculty(name, head);
    }
}
