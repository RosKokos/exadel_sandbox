package com.exadel.sandbox.model.vendors_info;

import com.exadel.sandbox.model.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String description;

    @ManyToMany
    @JoinTable(name = "products_events",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<Event> events;

    @OneToMany
    private List<Category> categories;

    public Product() {
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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
