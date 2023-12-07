package com.example.finalprojectapteka.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    @NotEmpty(message = "First Name is required")
    private String firstName;
    @NotEmpty(message = "Second Name is required")
    private String secondName;
    @NotEmpty(message = "Middle Name is required")
    private String middleName;
    @NotEmpty(message = "phone is required")
    private String phone;


    @ManyToMany
    @JoinTable (name="product_client",
            joinColumns=@JoinColumn (name="client_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    private List<Product> products;

    public int getId() {
        return id;
    }

    public Client(int id, String firstName, String secondName, String middleName, String phone, List<Product> products, Recipe recipe, List<Order> orders) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.phone = phone;
        this.products = products;
        this.recipe = recipe;
        this.orders = orders;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @OneToMany(mappedBy = "client")
    private List<Order> orders;

    public Client() {

    }

}

