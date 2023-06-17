/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author DevDD
 */
public class Product implements Comparable<Product> {

    private String productID;
    private String productName;
    private String unitPrice;
    private String quantity;
    private String saled;
    private String NSX;
    private String HSD;
    private String status;

    public Product() {
    }

    public Product(String productID, String productName, String unitPrice, String quantity, String saled, String NSX, String HSD, String status) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.saled = saled;
        this.NSX = NSX;
        this.HSD = HSD;
        this.status = status;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNSX() {
        return NSX;
    }

    public void setNSX(String NSX) {
        this.NSX = NSX;
    }

    public String getHSD() {
        return HSD;
    }

    public void setHSD(String HSD) {
        this.HSD = HSD;
    }

    public String getSaled() {
        return saled;
    }

    public void setSaled(String saled) {
        this.saled = saled;
    }
    
    @Override
    public String toString() {
        return productID + "," + productName + "," + unitPrice + "," + quantity + "," + saled + "," + NSX + "," + HSD + "," + status;
    }

    @Override
    public int compareTo(Product o) {
        return this.getProductName().compareTo(o.getProductName());
    }

    public void output() {
        System.out.format("|  %-5s |   %-8s  |  %-7s |     %-5s    |   %-5s |   %-10s    |   %-10s    |   %-13s  |\n", productID, productName, unitPrice, quantity, saled, NSX, HSD, status);
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
    }
}
