package com.bayes.data;

import javax.persistence.*;

@Entity
@Table(name = "abilities")
public class Abilities extends AuditModel {
    @Id
    private Long id;
    private String name;
    private String description;
    private boolean is_ultimate;
    @ManyToOne()
    @JoinColumn(name = "heroesId")
    private Heroes heroes;

    public Abilities(Long id, String name, String description, boolean is_ultimate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.is_ultimate = is_ultimate;
    }

    public Abilities() {
    }

    public Long getId() {
        return id;
    }

    public Abilities setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Abilities setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Abilities setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isIs_ultimate() {
        return is_ultimate;
    }

    public Abilities setIs_ultimate(boolean is_ultimate) {
        this.is_ultimate = is_ultimate;
        return this;
    }
}

