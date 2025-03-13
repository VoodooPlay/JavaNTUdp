package org.green.lab3.Controller;

import org.green.lab3.Model.*;

public class HumanCreator {
    public Human createHuman(String firstName, String lastName, String patronymic, Sex sex) {
        return new Human(firstName, lastName, patronymic, sex) {};
    }
}
