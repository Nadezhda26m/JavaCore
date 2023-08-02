package ru.core.part2.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Manager extends Worker {
    public Manager(String fullName, String heldPost, String phone,
                   int salary, LocalDate birthdate) {
        super(fullName, heldPost, phone, salary, birthdate);
    }

    public static void upSalary(ArrayList<Worker> workers, int minAge, int addSalary) {
        if (workers == null) throw new RuntimeException("Массив не инициализирован");
        if (workers.size() == 0) throw new RuntimeException("Пустой массив");
        if (minAge < 18 || minAge > 80)
            throw new RuntimeException("Неверно указан возраст");
        if (addSalary < 1) throw new RuntimeException("Неверно указана з/п");
        for (Worker worker : workers) {
            if (worker.getAge() >= minAge && !(worker instanceof Manager)) {
                worker.salary += addSalary;
            }
        }
    }
}
