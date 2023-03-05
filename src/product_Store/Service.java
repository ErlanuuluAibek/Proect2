package product_Store;

import product_Store.Manager;
import product_Store.Product;
import product_Store.ProductDao;
import product_Store.meatProduct.Fish;
import product_Store.meatProduct.Meat;
import product_Store.meatProduct.MeatProducts;
import product_Store.meatProduct.Sausage;
import product_Store.milkProduct.Kefir;
import product_Store.milkProduct.Milk;
import product_Store.milkProduct.MilkProducts;
import product_Store.milkProduct.Yogurt;
import product_Store.wheatProduct.Bread;
import product_Store.wheatProduct.Pasta;
import product_Store.wheatProduct.Torment;
import product_Store.wheatProduct.WheatProducts;

import java.awt.*;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Service {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private Manager manager;
    private ArrayList<Product> showcaseForDiscounts;

    private ProductDao productDao = new ProductDao();


    public Service(Manager manager, ArrayList<Product> showcaseForDiscounts) {
        this.manager = manager;
        this.showcaseForDiscounts = showcaseForDiscounts;
    }

    public void addProduct(ArrayList<Product> product, ArrayList<ArrayList> products) {
        LocalDate date = LocalDate.now();
        for (Product value : product) {
            if (value.getCompanyProduction().equals("NUR") || value.getCompanyProduction().equals("MILKA")
                    || value.getCompanyProduction().equals("TOIBOSS")) {
                if (value.getDate().isAfter(date)) {
                    productDao.getProducts().add(value);
                    System.out.println("Принято: " + value);
                    if (value instanceof MilkProducts) {
                        if (value instanceof Kefir) {
                            ArrayList<Kefir> kefirs = new ArrayList<>();
                            kefirs.add((Kefir) value);
                            products.add(kefirs);
                        } else if (value instanceof Milk) {
                            ArrayList<Milk> milkArrayList = new ArrayList<>();
                            milkArrayList.add((Milk) value);
                            products.add(milkArrayList);
                        } else {
                            ArrayList<Yogurt> yogurtArrayList = new ArrayList<>();
                            yogurtArrayList.add((Yogurt) value);
                            products.add(yogurtArrayList);
                        }
                    } else if (value instanceof MeatProducts) {
                        if (value instanceof Meat) {
                            ArrayList<Meat> meats = new ArrayList<>();
                            meats.add((Meat) value);
                            products.add(meats);
                        } else if (value instanceof Fish) {
                            ArrayList<Fish> fish = new ArrayList<>();
                            fish.add((Fish) value);
                            products.add(fish);
                        } else {
                            ArrayList<Sausage> sausages = new ArrayList<>();
                            sausages.add((Sausage) value);
                            products.add(sausages);
                        }
                    } else {
                        if (value instanceof Torment) {
                            ArrayList<Torment> torments = new ArrayList<>();
                            torments.add((Torment) value);
                            products.add(torments);
                        } else if (value instanceof Pasta) {
                            ArrayList<Pasta> pastas = new ArrayList<>();
                            pastas.add((Pasta) value);
                            products.add(pastas);
                        } else {
                            ArrayList<Bread> breads = new ArrayList<>();
                            breads.add((Bread) value);
                            products.add(breads);
                        }
                    }
                } else {
                    System.out.println(ANSI_RED + "Отказано из-за срока годности" + ANSI_RESET + value);
                }
            } else {
                System.out.println(ANSI_RED + "Отказано из за компании" + ANSI_RESET);
            }
        }
        products.forEach(System.out::println);
    }

    public void login(String password, String login) {
        if (manager.getLogin().equals(login)) {
            if (manager.getPassword().equals(password)) {
                System.out.println(ANSI_GREEN + "Вы вошли в систему" + ANSI_RESET);
                for (int i = 0; i < productDao.getProducts().size(); i++) {
                    System.out.println(productDao.getProducts().get(i));
                }
            } else {
                System.out.println(ANSI_RED + "Неверный пароль" + ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED + "Неверный логин" + ANSI_RESET);
        }

    }

    public void checkingDates(ArrayList<Product> products, List<Product> list) {
        for (int i = 0; i < products.size() ; i++) {
            if (products.get(i).getDate().isAfter(LocalDate.now())) {

            }else{
                System.out.println(ANSI_RED + "Данный товар списан: " + products.get(i) + ANSI_RESET);
                products.remove(products.get(i));
            }
        }
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getDate().minusDays(7).isAfter(LocalDate.now())){

            }else{
                System.out.println(ANSI_BLUE + "Данный товар отправляется на витрину скидок: " + products.get(i) + ANSI_RESET);
                list.add(products.get(i));
            }
        }


    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ArrayList<Product> getShowcaseForDiscounts() {
        return showcaseForDiscounts;
    }

    public void setShowcaseForDiscounts(ArrayList<Product> showcaseForDiscounts) {
        this.showcaseForDiscounts = showcaseForDiscounts;
    }

    @Override
    public String toString() {
        return "Service: " +
                " manager: " + manager +
                " showcaseForDiscounts: " + showcaseForDiscounts;
    }
}
