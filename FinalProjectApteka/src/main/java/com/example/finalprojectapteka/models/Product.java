package com.example.finalprojectapteka.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty(message = "Name is required")
    private String name;
    @PositiveOrZero(message = "Count should be a positive number or zero")
    private int count;
    @PositiveOrZero(message = "Price should be a positive number or zero")
    private int price;

    @ManyToOne
    @JoinColumn(name = "type_medicine_id")
    private TypeMedicine typeMedicine;

    @ManyToOne
    @JoinColumn(name = "point_id")
    private Point point;

    @OneToMany(mappedBy = "product")
    private List<Order> orders;

    @ManyToMany
    @JoinTable (name="client_product",
            joinColumns=@JoinColumn (name="product_id"),
            inverseJoinColumns=@JoinColumn(name="client_id"))
    private List<Client> clients;


    public Product() {

    }

    public Product(long id, String name, int count, int price, TypeMedicine typeMedicine, Point point, List<Order> orders, List<Client> clients) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.typeMedicine = typeMedicine;
        this.point = point;
        this.orders = orders;
        this.clients = clients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TypeMedicine getTypeMedicine() {
        return typeMedicine;
    }

    public void setTypeMedicine(TypeMedicine typeMedicine) {
        this.typeMedicine = typeMedicine;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
