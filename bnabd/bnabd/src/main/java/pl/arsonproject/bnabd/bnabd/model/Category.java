package pl.arsonproject.bnabd.bnabd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Name;

    @Column(name = "id",nullable = false)
    public Long getId() {
        return Id;
    }

    @Column(name = "name",nullable = false)
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
