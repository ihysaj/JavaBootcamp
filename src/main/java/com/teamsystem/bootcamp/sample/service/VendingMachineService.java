package com.teamsystem.bootcamp.sample.service;

import com.teamsystem.bootcamp.sample.entity.Coin;
import com.teamsystem.bootcamp.sample.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

    public List<Double> getChange(String countryCode, Double toPay, Double paid)  {
        List<BigDecimal> coins = getAllByCountry(countryCode)
                .stream()
                .sorted(Comparator.comparing(Coin::getValue).reversed())
                .map(Coin::getValue).toList();

        Optional<BigDecimal> coinFound = coins.stream()
                .filter(it -> it.compareTo(BigDecimal.valueOf(paid).subtract(BigDecimal.valueOf(toPay))) <= 0)
                .findFirst();

        if (coinFound.isEmpty())
            return List.of();
        else {
            return Stream.concat(
                        Stream.of(coinFound.get().doubleValue()),
                        getChange(countryCode, toPay + coinFound.get().doubleValue(), paid).stream()
                    )
                    .collect(Collectors.toList());
        }
    }
}
