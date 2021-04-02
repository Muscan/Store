package user_interface;

import entity.Product;
import enumeration.ProductCategory;
import repository.ProductFileRepo;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class UI implements I_UI{
    private ProductFileRepo fileRepo;//The repo we are using to do crud operations on

    public UI(ProductFileRepo fr){
        this.fileRepo = fr;
    }

    @Override
    public Product readProduct() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Insert ID ");
        int id = reader.nextInt();
        System.out.println("Insert Product name");
        String sparseLine = reader.nextLine();
        String name = reader.nextLine();
        System.out.println("Insert quantity (int) ");
        int quantity = reader.nextInt();
        System.out.println("Insert Category Name  FRUITS,\n" +
                "    VEGETABLES,\n" +
                "    SWEETS,\n" +
                "    TOOLS,\n" +
                "    FURNITURE");
        //sparseLine = reader.nextLine();
        String categoryName = reader.nextLine();
        ProductCategory pc = ProductCategory.valueOf(categoryName.toUpperCase());
        System.out.println("Insert price ");
        float price = reader.nextFloat();
        System.out.println("Insert date (yyyy-MM-dd)");
        //sparseLine = reader.nextLine();
        String ldd = reader.nextLine();
        LocalDate ld = LocalDate.parse(ldd);
        return new Product(id,name,quantity,pc,price,ld);
    }


    @Override
    public void run() {
        while(1==1){
            System.out.println("===Menu===\n" +
                    "0. Exit\n" +
                    "1. Add new Product\n" +
                    "2. Remove Product\n" +
                    "3. Print all products\n" +
                    "4. Update product\n" +
                    "Insert your choice: ");
            Scanner reader = new Scanner(System.in);
            int  userChoice = reader.nextInt();
            switch (userChoice){
                case(0) -> {
                    return;
                }
                case(1) -> {
                    //We create a new product read from the user
                    Product newProduct = this.readProduct();
                    //We add it to the repo using the function from there
                    this.fileRepo.addProduct(newProduct);
                    //Sends the object to the method in the repo
                    //The repo adds it into memory and into the file
                }
                case(2) -> {
                    System.out.println("Insert product ID to remove by ");
                    int productID = reader.nextInt();
                    //We send the read ID to the repo, who will is it to remove a product
                    this.fileRepo.deleteProduct(productID);
                }
                case(3) -> {
                    //We get the list of objects from the repo
                    var product = this.fileRepo.getProducts();
                    //We go through the list of products
                    for(int i = 0; i<product.size(); i++)
                        //for each product we call toString() to put it on the screen
                        System.out.println(product.get(i).toString());
                }
                case(4) -> {
                    //We create a new product read from the user
                    Product newProduct = this.readProduct();
                    //We add it to the repo using the function from there
                    this.fileRepo.update(newProduct);
                    //Sends the object to the method in the repo
                    //The repo updates the object, and also overwrites the file
                }
            }

        }
    }
}
