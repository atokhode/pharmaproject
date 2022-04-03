package com.web.pharmacy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class DrugData{
    @Id
    private String id;
    private String itemName;
    private double price, quantity, amount;


    public DrugData() {
    }

    public DrugData(String id, String itemName, double price, double quantity, double amount){
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
    }

    public DrugData(String itemName, double price, double quantity, double amount){
        this(UUID.randomUUID().toString(), itemName,price,quantity,amount);
    }

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }
    public String getItemName(){
        return itemName;
    }

    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }

    public void setQuantity(double quantity){
        this.quantity = quantity;
    }

    public double getQuantity(){
        return quantity;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public double getAmount(){
        return amount;
    }
}
