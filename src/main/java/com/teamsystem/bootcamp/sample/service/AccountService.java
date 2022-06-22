package com.teamsystem.bootcamp.sample.service;


public class AccountService {

    public void notifyAccount(Account account, String message) {

        switch (account.getNotificationPreference()) {
            case "sms":
              sendSMS(account.getName(), message);
              break;
            case "email":
            default:
              sendEmail(account.getName(), message);
        }
    }

    public void sendSMS(String name, String message) {
        System.out.println("SMS sent to " + name + " with message: "+message);
    }

    public void sendEmail(String name, String message) {
        System.out.println("Email sent to " + name + " with message: "+message);
    }
}