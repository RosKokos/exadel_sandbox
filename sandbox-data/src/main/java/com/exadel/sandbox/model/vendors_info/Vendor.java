package com.exadel.sandbox.model.vendors_info;

import com.exadel.sandbox.model.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vendor")
public class Vendor extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String description;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column
    private String email;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinTable(name = "vendors_event",
            joinColumns = @JoinColumn(name = "vendor_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<Event> events;

    public Vendor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
