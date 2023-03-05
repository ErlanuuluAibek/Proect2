package product_Store;

import product_Store.Manager;
import product_Store.Product;
import product_Store.meatProduct.Fish;
import product_Store.meatProduct.Meat;
import product_Store.milkProduct.Kefir;
import product_Store.milkProduct.Milk;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager("Aibek", "gg");
        Milk milk = new Milk(1, "milk", "TOIBOSS", LocalDate.of(2023, 3, 10));
        Kefir kefir = new Kefir(1, "kefir", "", LocalDate.of(2023, 3, 11));
        Milk milk1 = new Milk(2, "milk", "NUR", LocalDate.of(2023, 3, 9));
        Kefir kefir1 = new Kefir(2, "kefir", "NUR", LocalDate.of(2023, 3, 2));
        Meat meat=new Meat(1,"meat","TOIBOSS",LocalDate.of(2023,4,3));
        Meat meat2=new Meat(2,"meat2","TOIBOSS",LocalDate.of(2023,4,3));
        Fish fish=new Fish(1,"fish","NUR",LocalDate.of(2023,4,12));
        Fish fish2=new Fish(2,"fish","NUR",LocalDate.of(2023,3,2));
        ArrayList<Product> showcaseForDiscounts = new ArrayList<>();
        Service service = new Service(manager, showcaseForDiscounts);
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<ArrayList> arrayLists = new ArrayList<>();
        List<Product> list = new ArrayList<>();
        products.add(milk);
        products.add(milk1);
        products.add(kefir1);
        products.add(kefir);
        products.add(meat);
        products.add(meat2);
        products.add(fish2);
        products.add(fish);

        service.addProduct(products, arrayLists);
        service.checkingDates(products, list);
        service.login(scanner.nextLine(), scanner.nextLine());



    }
}