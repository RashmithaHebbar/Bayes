package com.bayes.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "heroes")
public class Heroes extends AuditModel {
    @Id
    private Long id;
    private String name;
    private String real_name;
    private Integer health;
    private Integer armour;
    private Integer shield;
    @OneToMany(targetEntity = Abilities.class, mappedBy = "heroes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Abilities> abilitiesList;

    public Heroes(Long id, String name, String real_name, Integer health, Integer armour, Integer shield) {
        this.id = id;
        this.name = name;
        this.real_name = real_name;
        this.health = health;
        this.armour = armour;
        this.shield = shield;
    }

    public Heroes() {
    }

    public Long getId() {
        return id;
    }

    public Heroes setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Heroes setName(String name) {
        this.name = name;
        return this;
    }

    public String getReal_name() {
        return real_name;
    }

    public Heroes setReal_name(String real_name) {
        this.real_name = real_name;
        return this;
    }

    public Integer getHealth() {
        return health;
    }

    public Heroes setHealth(Integer health) {
        this.health = health;
        return this;
    }

    public Integer getArmour() {
        return armour;
    }

    public Heroes setArmour(Integer armour) {
        this.armour = armour;
        return this;
    }

    public Integer getShield() {
        return shield;
    }

    public Heroes setShield(Integer shield) {
        this.shield = shield;
        return this;
    }
}
