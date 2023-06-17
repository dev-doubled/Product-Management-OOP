/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author DevDD
 */
public class Order {
    private String proID;
    private String proName;
    private String proPrice;
    private int proQuantity;
    private int totalPrice;

    public Order() {
    }

    public Order(String proID, String proName, String proPrice, int proQuantity, int totalPrice) {
        this.proID = proID;
        this.proName = proName;
        this.proPrice = proPrice;
        this.proQuantity = proQuantity;
        this.totalPrice = totalPrice;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProPrice() {
        return proPrice;
    }

    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }

    public int getProQuantity() {
        return proQuantity;
    }

    public void setProQuantity(int proQuantity) {
        this.proQuantity = proQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
}
