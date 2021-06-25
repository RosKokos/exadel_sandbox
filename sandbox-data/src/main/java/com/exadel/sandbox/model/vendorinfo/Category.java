package com.exadel.sandbox.model.vendorinfo;

import com.exadel.sandbox.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "events")
@EqualsAndHashCode(callSuper = false, exclude = "events")
public class Category extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Event> events = new HashSet<>();

}
