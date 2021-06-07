package com.exadel.sandbox.model.location;

import com.exadel.sandbox.model.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
