import entity.Product;
import enumeration.ProductCategory;
import repository.ProductFileRepo;
import user_interface.UI;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        ProductFileRepo productFileRepo = new ProductFileRepo("D:\\Projects\\Store\\src\\file\\products.txt");
         //---Adding one by one items
        //Product product = new Product(2, "Apple", 10, ProductCategory.FRUITS, 1.1f, LocalDate.of(2021,3,31));
        //productFileRepo.addProduct(product);
        /*System.out.println("Before: ");
        productFileRepo.getProducts().forEach(System.out::println);
        productFileRepo.deleteProduct(2);
        System.out.println("After: ");
        productFileRepo.getProducts().forEach(System.out::println);*/
        //while(true)
        //iei de la tastatura un numar (0 - > cate functionalitati ai + exit)
        //if(userInput == 0) exit(0)
        //if(userInput == 1) citesti de la tastatura ce iti trebuie pentru un produs + productFileRepo.addProduct(product);
        //if(userInput == 2) citesti un id(int) de la tastatura + productFileRepo.deleteProduct(id);
        UI ui = new UI(productFileRepo);
        ui.run();
    }
}

//TODO Repo for all other entities (except person and user)
//TODO add in main
//TODO add files in package file
//TODO delete and edit
//TODO add in MySql

//TODO for Worker (Crud)
//TODO for buyer