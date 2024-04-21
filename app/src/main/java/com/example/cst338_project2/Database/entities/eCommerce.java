package com.example.cst338_project2.Database.entities;

import androidx.annotation.NonNull;

import java.time.LocalDate;
import java.util.Objects;

@Entity(tableName = "eCommerceDatabase.eCommerceTable")
public class eCommerce {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String product_name;
    private double price;
    private int product_id;
    private int product_price;
    private String product_desc;
    private Boolean in_stock;
    private LocalDate date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public Boolean getIn_stock() {
        return in_stock;
    }

    public void setIn_stock(Boolean in_stock) {
        this.in_stock = in_stock;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    //constructor
    public eCommerce(String product_name, double price, int product_id, int product_price, String product_desc, Boolean in_stock) {
        this.product_name = product_name;
        this.price = price;
        this.product_id = product_id;
        this.product_price = product_price;
        this.product_desc = product_desc;
        this.in_stock = in_stock;
        date = LocalDate.now(); //current time stamp
    }

    //hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        eCommerce eCommerce = (eCommerce) o;
        return id == eCommerce.id && Double.compare(price, eCommerce.price) == 0 && product_id == eCommerce.product_id && product_price == eCommerce.product_price && Objects.equals(product_name, eCommerce.product_name) && Objects.equals(product_desc, eCommerce.product_desc) && Objects.equals(in_stock, eCommerce.in_stock) && Objects.equals(date, eCommerce.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product_name, price, product_id, product_price, product_desc, in_stock, date);
    }
}
