package product_Store.wheatProduct;

import product_Store.Product;

import java.time.LocalDate;
import java.util.LinkedList;

public abstract class WheatProducts extends Product {
    public WheatProducts(int id, String name, String companyProduction, LocalDate date) {
        super(id, name, companyProduction, date);
    }
}
