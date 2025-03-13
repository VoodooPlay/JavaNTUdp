package org.green.lab3.Controller;

import org.green.lab3.Model.*;

public class DepartmentCreator {
    public Department createDepartment(String name, Human head) {
        return new Department(name, head);
    }
}
