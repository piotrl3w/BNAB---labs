package pl.arsonproject.bnabd.bnabd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Purchaser;
    private String Email;
    private String Address;
    private String City;
    private String Zip;
    private String Country;

    @OneToMany
    private List<OrderProducts> OrderProductsList;

    public List<OrderProducts> getOrderProductsList() {
        return OrderProductsList;
    }

    public void setOrderProductsList(List<OrderProducts> orderProductsList) {
        OrderProductsList = orderProductsList;
    }

    public Long getId() {
        return Id;
    }

    public String getPurchaser() {
        return Purchaser;
    }

    public void setPurchaser(String purchaser) {
        Purchaser = purchaser;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        Zip = zip;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
