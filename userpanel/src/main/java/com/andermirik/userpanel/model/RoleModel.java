package com.andermirik.userpanel.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="roles")
public class RoleModel  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name="name")
    private String name;

    RoleModel(){

    }

    RoleModel(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
