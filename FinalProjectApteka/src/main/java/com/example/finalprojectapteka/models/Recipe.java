package com.example.finalprojectapteka.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty(message = "Name Product is required")
    private String numberRecipe;

    @OneToOne(mappedBy = "recipe")
    private Client client;

    public Recipe(long id, String numberRecipe, Client client) {
        this.id = id;
        this.numberRecipe = numberRecipe;
        this.client = client;
    }

    public Recipe() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumberRecipe() {
        return numberRecipe;
    }

    public void setNumberRecipe(String numberRecipe) {
        this.numberRecipe = numberRecipe;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
