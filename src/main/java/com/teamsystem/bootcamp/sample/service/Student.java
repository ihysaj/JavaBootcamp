package com.teamsystem.bootcamp.sample.service;

public class Student implements Person{
    public Address address;
    public Account account;

    public Student(String name, String notificationPreference, String street, String city) {
        address = new Address(street, city);
        account = new Account(name, notificationPreference);
    }

    @Override
    public String printLessonTimeTable() {
        return account.getName() + ": 4h/day bootcamp for 8 weeks";
    }

    @Override
    public String printWorkingHistory() {
        return null;
    }
}
