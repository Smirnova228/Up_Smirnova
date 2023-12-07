package com.example.finalprojectapteka.models;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @PositiveOrZero(message = "Order Count should be a positive number or zero")
    private int count;
    @PositiveOrZero(message = "Order Price should be a positive number or zero")
    private int price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Order(long id, int count, int price, Product product, Client client) {
        this.id = id;
        this.count = count;
        this.price = price;
        this.product = product;
        this.client = client;
    }

    public Order() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
