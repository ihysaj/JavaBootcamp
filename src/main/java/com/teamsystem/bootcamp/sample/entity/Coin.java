package com.teamsystem.bootcamp.sample.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "COIN")
public class Coin {
    @Id
    private long id;
    @ManyToOne
    private Country country;
    private BigDecimal value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString () {
        return country.getDescription() + " " + country.getId() + " " + value;
    }

}
