package ru.core.part2.program;

import ru.core.part2.models.Manager;
import ru.core.part2.models.Worker;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>(5);

        workers.add(new Worker("ФИО1", "водитель", "+71234",
                12455, LocalDate.of(2000, 2, 12)));
        workers.add(new Worker("ФИО2", "водитель", "+74567",
                12345, LocalDate.of(1990, 4, 23)));
        workers.add(new Worker("ФИО3", "водитель", "+745567",
                26345, LocalDate.of(1991, 8, 13)));
        workers.add(new Worker("ФИО4", "кассир", "+7424577",
                24345, LocalDate.of(1972, 12, 22)));
        workers.add(new Worker("ФИО5", "уборщик", "+742347",
                12248, LocalDate.of(1995, 6, 3)));
        workers.add(new Manager("ФИО6", "менеджер", "+775847",
                56248, LocalDate.of(1975, 9, 7)));

        printWorkers(workers);
        upSalary(workers, 45, 5000);
        printWorkers(workers);
        Manager.upSalary(workers, 30, 3000);
        printWorkers(workers);
        System.out.println(Worker.showMiddleAgeAndSalary(workers));
    }

    public static void upSalary(ArrayList<Worker> workers, int minAge, int addSalary) {
        for (Worker worker : workers) {
            if (worker.getAge() >= minAge) {
                worker.increaseSalary(addSalary);
            }
        }
    }

    public static void printWorkers(ArrayList<Worker> workers) {
        System.out.println("Список сотрудников: ");
        for (Worker worker : workers) {
            if (worker instanceof Manager)
                System.out.println(">" + worker);
            else System.out.println(worker);
        }
    }
}
