package com.exadel.sandbox.model.location;

import com.exadel.sandbox.model.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location extends AbstractEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "map_point")
    private MapPoint point;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address")
    private Address address;

    public Location() {
    }

    public MapPoint getPoint() {
        return point;
    }

    public void setPoint(MapPoint point) {
        this.point = point;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
