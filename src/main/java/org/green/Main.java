package org.green;

import org.green.lab0.lab0;
import org.green.lab2.lab2;
import org.green.lab3.Model.*;
import org.green.lab3.Controller.*;

public class Main {
    public static void main(String[] args) {
        lab0.start();
        System.out.println();
        lab2.start();
        System.out.println();
        Run.main();
    }
}

class Run {
    public static University createTypicalUniversity() {
        UniversityCreator universityCreator = new UniversityCreator();
        HumanCreator humanCreator = new HumanCreator();
        StudentCreator studentCreator = new StudentCreator();

        Human rector = humanCreator.createHuman("Ivan", "Ivanov", "Ivanovich", Sex.MALE);
        University university = universityCreator.createUniversity("Best University", rector);

        return university;
    }

    public static void main() {
        University university = createTypicalUniversity();
        System.out.println("University Created: " + university);
    }
}