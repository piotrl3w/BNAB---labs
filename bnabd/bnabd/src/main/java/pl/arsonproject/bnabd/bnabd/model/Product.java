package pl.arsonproject.bnabd.bnabd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Name;

    @ManyToOne
    private Category Category;

    private String Description;

    private Double Price;

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

    @Column(name = "category")
    public pl.arsonproject.bnabd.bnabd.model.Category getCategory() {
        return Category;
    }

    public void setCategory(pl.arsonproject.bnabd.bnabd.model.Category category) {
        Category = category;
    }

    @Column(name = "description",nullable = false)
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Column(name = "price",nullable = false)
    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }
}
