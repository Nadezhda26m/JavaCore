package ru.core.part2.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Worker {
    protected String fullName;
    public enum post {
        водитель, кассир, менеджер, уборщик
    }
    protected String heldPost;
    protected String phone;
    protected int salary;
    protected final LocalDate birthdate;

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

    public void increaseSalary(int addSalary) {
        salary += addSalary;
    }

    @Override
    public String toString() {
        return String.format("Сотрудник: %s, %s, полных лет: %d, тел.: %s, з/п: %d руб.",
                fullName, heldPost, getAge(), phone, salary);
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

    public static String showMiddleAgeAndSalary(ArrayList<Worker> workers) {
        return String.format("Средний возраст: %.0f%n" +
                "Средняя з/п: %.2f руб.",
                Worker.middleAge(workers),
                Worker.middleSalary(workers));
    }
}
