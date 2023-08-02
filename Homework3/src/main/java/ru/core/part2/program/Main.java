package ru.core.part2.program;

import ru.core.part2.models.Manager;
import ru.core.part2.models.Worker;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Worker> workers = new ArrayList<>(6);

            workers.add(new Worker("ФИО1", "водитель", "+71234",
                    12455, LocalDate.of(2000, 2, 12)));
            workers.add(new Worker("ФИО2", Worker.post.водитель.toString(),
                    "+74567", 12345, LocalDate.of(1990, 4, 23)));
            workers.add(new Worker("ФИО3", "водитель", "+745567",
                    26345, LocalDate.of(1991, 8, 13)));
            workers.add(new Worker("ФИО4", Worker.post.кассир.name(),
                    "+7424577", 24345, LocalDate.of(1972, 12, 22)));
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
        } catch (RuntimeException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void upSalary(ArrayList<Worker> workers, int minAge, int addSalary) {
        for (Worker worker : workers) {
            if (worker.getAge() >= minAge) {
                worker.increaseSalary(addSalary);
            }
        }
    }

    public static void printWorkers(ArrayList<Worker> workers) {
        if (workers == null || workers.size() == 0) {
            System.out.println("Список сотрудников пустой");
            return;
        }
        System.out.println("Список сотрудников: ");
        for (Worker worker : workers) {
            if (worker instanceof Manager)
                System.out.println(">" + worker);
            else System.out.println(worker);
        }
    }
}
