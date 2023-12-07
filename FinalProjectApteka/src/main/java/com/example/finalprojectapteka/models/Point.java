package com.example.finalprojectapteka.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "point")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty(message = "Name Store is required")
    private String namePoint;
    @NotEmpty(message = "Store Address is required")
    private String address;

    @OneToMany(mappedBy = "point")
    private List<Product> products;

    public Point(long id, String namePoint, String address) {
        this.id = id;
        this.namePoint = namePoint;
        this.address = address;
    }

    public Point() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamePoint() {
        return namePoint;
    }

    public void setNamePoint(String namePoint) {
        this.namePoint = namePoint;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
