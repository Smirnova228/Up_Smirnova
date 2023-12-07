package com.example.finalprojectapteka.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "typeMedicine")
public class TypeMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty(message = "Name is required")
    private String nameTypeMedicine;

    @OneToMany(mappedBy = "typeMedicine")
    private List<Product> products;


    public TypeMedicine() {

    }

    public TypeMedicine(long id, String nameTypeMedicine, List<Product> products) {
        this.id = id;
        this.nameTypeMedicine = nameTypeMedicine;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameTypeMedicine() {
        return nameTypeMedicine;
    }

    public void setNameTypeMedicine(String nameTypeMedicine) {
        this.nameTypeMedicine = nameTypeMedicine;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
