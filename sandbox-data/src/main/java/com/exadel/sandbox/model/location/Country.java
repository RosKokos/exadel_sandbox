package com.exadel.sandbox.model.location;

import com.exadel.sandbox.model.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
public class Country extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(
            mappedBy = "country",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<City> cities;

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
