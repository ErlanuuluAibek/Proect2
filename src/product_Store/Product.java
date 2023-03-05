package product_Store;

import javax.swing.*;
import java.time.LocalDate;

public abstract class Product {
    private int id;
    private String name;

    private String companyProduction;
    private LocalDate date;

    public Product(int id, String name, String companyProduction, LocalDate date) {
        this.id = id;
        this.name = name;
        this.companyProduction = companyProduction;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyProduction() {
        return companyProduction;
    }

    public void setCompanyProduction(String companyProduction) {
        this.companyProduction = companyProduction;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Product: " +
                " id: " + id +
                " name: " + name  +
                " companyProduction: " + companyProduction + '\'' +
                " date: " + date;
    }
}
