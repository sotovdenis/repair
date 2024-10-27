package com.example.repairs.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class BaseEntity {
    private String id;

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string",
            strategy = "org.hibernate.id.UUIDGenerator")

    public String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }
}
