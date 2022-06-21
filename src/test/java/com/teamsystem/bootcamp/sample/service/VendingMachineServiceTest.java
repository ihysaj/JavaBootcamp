package com.teamsystem.bootcamp.sample.service;

import com.teamsystem.MainApplication;
import com.teamsystem.bootcamp.sample.entity.Coin;
import com.teamsystem.bootcamp.sample.repository.CoinRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplication.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VendingMachineServiceTest {

 //   @Autowired
    private VendingMachineService vendingMachineService;

    @Mock
    private CoinRepository coinRepository;

    @BeforeAll
    public void setup() {
        when(coinRepository.getCountryWithMaxNumberOfCoins()).thenReturn("FR");
        when(coinRepository.countAllByCountryId(any())).thenReturn(10);
        when(coinRepository.countAllByCountryId(any())).thenReturn(5);
        vendingMachineService = new VendingMachineService(coinRepository);
    }

    @Test
    public void test() {
  //      System.out.println(vendingMachineService.getAllByCountry("IT"));
  //      System.out.println(vendingMachineService.getAllByCountry("AL"));
        System.out.println(vendingMachineService.countAllByCountry("IT"));
        System.out.println(vendingMachineService.countAllByCountry("AL"));

        System.out.println(vendingMachineService.nativeCountAllByCountry("IT"));
        System.out.println(vendingMachineService.nativeCountAllByCountry("AL"));

        System.out.println(vendingMachineService.getCountryWithMaxNumberOfCoins());

        vendingMachineService.getChange("IT", 4.0, 5.0);

        Assertions.assertEquals(Arrays.asList(2.0, 0.5, 0.2, 0.1, 0.01), vendingMachineService.getChange("IT", 2.19,5.0));
        Assertions.assertEquals(List.of(), vendingMachineService.getChange("IT", 10.0, 10.0));
        Assertions.assertEquals(List.of(0.01), vendingMachineService.getChange("IT", 0.04, 0.05));
        Assertions.assertEquals(Arrays.asList(0.50, 0.20, 0.10, 0.05), vendingMachineService.getChange("IT", 2.15, 3.0));
        Assertions.assertEquals(Arrays.asList(2.0, 1.0, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01), vendingMachineService.getChange("IT", 0.12, 4.0));
        Assertions.assertEquals(Arrays.asList(2.0, 2.0, 1.0, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01), vendingMachineService.getChange("IT", 0.12, 6.0));
        Assertions.assertEquals(Arrays.asList(1.0, 0.10, 0.02, 0.02), vendingMachineService.getChange("IT", 4.86, 6.0));
        Assertions.assertEquals(Arrays.asList(2.0, 1.0, 0.50, 0.20, 0.10, 0.05, 0.02, 0.02), vendingMachineService.getChange("IT", 0.11, 4.0));
    }
}
