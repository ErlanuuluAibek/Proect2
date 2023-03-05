package product_Store.milkProduct;

import product_Store.milkProduct.MilkProducts;

import java.time.LocalDate;

public class Yogurt extends MilkProducts {

    public Yogurt(int id, String name, String companyProduction, LocalDate date) {
        super(id, name, companyProduction, date);
    }
}
