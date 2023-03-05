package product_Store;

import java.util.ArrayList;

public class ProductDao {
    private ArrayList<Product> products=new ArrayList<>();

    public ProductDao(ArrayList<Product> products) {
        this.products = products;
    }

    public ProductDao() {
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "product_Store.ProductDao: " +
                " products: " + products;
    }
}
