package product_Store.milkProduct;

import product_Store.Product;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class MilkProducts extends Product {


    public MilkProducts(int id, String name, String companyProduction, LocalDate date) {
        super(id, name, companyProduction, date);
    }

}
