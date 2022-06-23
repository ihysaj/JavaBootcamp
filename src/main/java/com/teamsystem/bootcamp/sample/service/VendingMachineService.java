package com.teamsystem.bootcamp.sample.service;

import com.teamsystem.bootcamp.sample.entity.Coin;
import com.teamsystem.bootcamp.sample.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class VendingMachineService {
    @Autowired
    private final CoinRepository coinRepository;

    public VendingMachineService(CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    public List<Coin> getAllByCountry(String countryCode) {
        return coinRepository.findAllByCountryId(countryCode);
    }

    public Integer countAllByCountry(String countryCode) {
        return coinRepository.countAllByCountryId(countryCode);
    }

    public Integer nativeCountAllByCountry(String countryCode) {
        return coinRepository.nativeCountAllByCountryId(countryCode);
    }

    public String getCountryWithMaxNumberOfCoins() {
        return coinRepository.getCountryWithMaxNumberOfCoins();
    }

    public List<Double> getChange(String country, double toPay, double paid) {
        //List<Double> coins = Arrays.asList(2.0, 1.0, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01);

        List<BigDecimal> coins = coinRepository.findAllByCountryId(country)
                .stream()
                .sorted(Comparator.comparing(Coin::getValue).reversed())
                .map(it -> it.getValue()).toList();

        List<Double> changes = new ArrayList<Double>();
        BigDecimal difference = BigDecimal.valueOf(paid).subtract(BigDecimal.valueOf(toPay));
        for (BigDecimal coin : coins) {
                // keep adding the current coin until it's more than the difference
                while (difference.compareTo(coin) >= 0) { //>=
                    changes.add(coin.doubleValue());
                    difference = difference.subtract(coin);
                }
            }
        return changes;
    }



    }
