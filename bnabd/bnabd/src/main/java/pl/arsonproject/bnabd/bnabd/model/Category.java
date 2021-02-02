package pl.arsonproject.bnabd.bnabd.model;

import javax.persistence.*;

@Entity
public class Category {

    private Long Id;
    private String Name;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Column(name = "Name",nullable = false)
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
