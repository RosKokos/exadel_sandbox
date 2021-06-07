package com.exadel.sandbox.model.location;

import com.exadel.sandbox.model.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address extends AbstractEntity {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city")
    private City city;

    @Column
    private String street;

    @Column(name = "building_number")
    private int buildingNumber;

    public Address() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }
}
