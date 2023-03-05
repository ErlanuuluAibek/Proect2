package product_Store.meatProduct;

import product_Store.Product;

import java.awt.*;
import java.time.LocalDate;

public abstract class MeatProducts extends Product {

    public MeatProducts(int id, String name, String companyProduction, LocalDate date) {
        super(id, name, companyProduction, date);
    }
}
