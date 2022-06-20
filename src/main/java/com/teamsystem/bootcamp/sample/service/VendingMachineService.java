package com.teamsystem.bootcamp.sample.service;

import com.teamsystem.bootcamp.sample.entity.Coin;
import com.teamsystem.bootcamp.sample.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
