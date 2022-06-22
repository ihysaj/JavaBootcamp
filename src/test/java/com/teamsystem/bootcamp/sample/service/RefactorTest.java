package com.teamsystem.bootcamp.sample.service;


import org.junit.jupiter.api.Test;

//@RunWith(SpringRunner.class)
public class RefactorTest {

    private AccountService accountService = new AccountService();
    @Test
    void accountNotificationTest() {
        Student ben = new Student("Ben", "email", "via Cornalia", "Milano");
        Worker cecilia = new Worker("Cecilia", "sms", "via Cornalia", "Milano");
        Student john = new Student("John", "unknown", "via Cornalia", "Milano");

        accountService.notifyAccount(ben.account, "Hello World");
        accountService.notifyAccount(cecilia.account, "Hello World");
        accountService.notifyAccount(john.account, "Hello World");

        System.out.println(ben.printLessonTimeTable());
        System.out.println(cecilia.printLessonTimeTable());
        System.out.println(cecilia.printWorkingHistory());
        System.out.println(john.printWorkingHistory());
        /*
        * EXPECTED OUTPUT
        * Email sent to Ben with message: Hello World
        * SMS sent to Cecilia with message: Hello World
        * Email sent to John with message: Hello World
        * Ben: 4h/day bootcamp for 8 weeks
        * null
        * Cecilia: I have 10 years experience
        * null
        * */
    }
}
