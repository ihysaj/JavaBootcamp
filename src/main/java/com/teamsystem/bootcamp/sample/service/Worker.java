package com.teamsystem.bootcamp.sample.service;

public class Worker implements Person{
    public Address address;
    public Account account;

    public Worker(String name, String notificationPreference, String street, String city) {
        address = new Address(street, city);
        account = new Account(name, notificationPreference);
    }

    @Override
    public String printLessonTimeTable() {
        return null;
    }

    @Override
    public String printWorkingHistory() {
        return account.getName() + ": I have 10 years experience";
    }
}
