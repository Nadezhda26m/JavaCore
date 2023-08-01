package ru.core.part2.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Manager extends Worker {
    public Manager(String fullName, String heldPost, String phone,
                   int salary, LocalDate birthdate) {
        super(fullName, heldPost, phone, salary, birthdate);
    }

    public static void upSalary(ArrayList<Worker> workers, int minAge, int addSalary) {
        for (Worker worker : workers) {
            if (worker.getAge() >= minAge && !(worker instanceof Manager)) {
                worker.salary += addSalary;
            }
        }
    }
}
