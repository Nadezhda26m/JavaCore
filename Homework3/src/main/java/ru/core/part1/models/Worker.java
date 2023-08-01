package ru.core.part1.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Worker {
    public String fullName;
    public String heldPost;
    public String phone;
    public int salary;
    private final LocalDate birthdate;

    public Worker(String fullName, String heldPost, String phone,
                  int salary, LocalDate birthdate) {
        this.fullName = fullName;
        this.heldPost = heldPost;
        this.phone = phone;
        this.salary = salary;
        this.birthdate = birthdate;
    }
    public int getAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return String.format("Сотрудник: %s, %s, полных лет: %d, тел.: %s, з/п: %d руб.",
                fullName, heldPost, getAge(), phone, salary);
    }

    public static void upSalary(ArrayList<Worker> workers, int minAge, int addSalary) {
        for (Worker worker : workers) {
            if (worker.getAge() >= minAge) {
                worker.salary += addSalary;
            }
        }
    }

    public static double middleAge(ArrayList<Worker> workers) {
        if (workers == null || workers.size() == 0)
            throw new RuntimeException("В массиве нет данных");
        double sumAge = 0;
        for (Worker worker : workers) {
            sumAge += worker.getAge();
        }
        return sumAge / workers.size();
    }

    public static double middleSalary(ArrayList<Worker> workers) {
        if (workers == null || workers.size() == 0)
            throw new RuntimeException("В массиве нет данных");
        double sumSalary = 0;
        for (Worker worker : workers) {
            sumSalary += worker.salary;
        }
        return sumSalary / workers.size();
    }
}
