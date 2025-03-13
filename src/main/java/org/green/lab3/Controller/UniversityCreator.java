package org.green.lab3.Controller;

import org.green.lab3.Model.*;

public class UniversityCreator {
    public University createUniversity(String name, Human head) {
        return new University(name, head);
    }
}
