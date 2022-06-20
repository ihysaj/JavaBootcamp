package com.teamsystem.bootcamp.sample.repository;

import com.teamsystem.bootcamp.sample.entity.Coin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinRepository extends CrudRepository<Coin, Long> {
    List<Coin> findAllByCountry(String country);
}