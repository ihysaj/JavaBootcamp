package com.teamsystem.bootcamp.sample.repository;

import com.teamsystem.bootcamp.sample.entity.Coin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinRepository extends CrudRepository<Coin, Long> {
    List<Coin> findAllByCountryId(String countryId);

    Integer countAllByCountryId(String countryId);

    @Query(value = "SELECT count(*) FROM COIN WHERE COUNTRY_ID = :countryId ",
    nativeQuery = true)
    Integer nativeCountAllByCountryId(String countryId);

    @Query(value = "select  country_id from coin group by country_id order by count(country_id) DESC LIMIT 1",
    nativeQuery = true)
    String getCountryWithMaxNumberOfCoins();

}