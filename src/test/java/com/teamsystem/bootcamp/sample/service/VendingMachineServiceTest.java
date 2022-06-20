package com.teamsystem.bootcamp.sample.service;

import com.teamsystem.MainApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplication.class})
public class VendingMachineServiceTest {

    @Autowired
    private VendingMachineService vendingMachineService;
    @Test
    public void test() {
        System.out.println(vendingMachineService.getAllByCountry("IT"));
        System.out.println(vendingMachineService.getAllByCountry("AL"));
        System.out.println(vendingMachineService.countAllByCountry("IT"));
        System.out.println(vendingMachineService.countAllByCountry("AL"));

        System.out.println(vendingMachineService.nativeCountAllByCountry("IT"));
        System.out.println(vendingMachineService.nativeCountAllByCountry("AL"));

        System.out.println(vendingMachineService.getCountryWithMaxNumberOfCoins());
    }
}
