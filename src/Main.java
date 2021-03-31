import entity.Product;
import enumeration.ProductCategory;
import repository.ProductFileRepo;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        ProductFileRepo productFileRepo = new ProductFileRepo("D:\\Projects\\Store\\src\\file\\products.txt");

        Product product = new Product(1, "Banana", 10, ProductCategory.FRUITS, 5.3f, LocalDate.of(2021,3,31));
        productFileRepo.addProduct(product);
    }
}

//TODO Repo for all other entities (except person and user)
//TODO add in main
//TODO add files in package file
//TODO delete and edit
//TODO add in MySql