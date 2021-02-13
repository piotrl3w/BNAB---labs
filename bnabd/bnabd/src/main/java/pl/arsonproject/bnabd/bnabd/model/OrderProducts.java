package pl.arsonproject.bnabd.bnabd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderProducts {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    private Product Product;

    private int Quantity;

    public Long getId() {
        return Id;
    }

//    public Orders getOrders() {
//        return Orders;
//    }
//
//    public void setOrders(Orders orders) {
//        Orders = orders;
//    }

    public pl.arsonproject.bnabd.bnabd.model.Product getProduct() {
        return Product;
    }

    public void setProduct(pl.arsonproject.bnabd.bnabd.model.Product product) {
        Product = product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
