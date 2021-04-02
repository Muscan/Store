package user_interface;

import entity.Product;
import enumeration.ProductCategory;
import repository.ProductFileRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UI implements I_UI{
    Scanner scanner = new Scanner(System.in);
    private final ProductFileRepo fileRepo;//The repo we are using to do crud operations on

    public UI(ProductFileRepo fr){
        this.fileRepo = fr;
    }

    public void displayProductCategories(){
        System.out.println("Available categories:");
        System.out.println("FRUITS");
        System.out.println("VEGETABLES");
        System.out.println("SWEETS");
        System.out.println("TOOLS");
        System.out.println("FURNITURE");
    }

    public String readProductCategory() {
        // declarare lista cu cele 5 categorii
        // citit de la tastatura categoria
        // daca categoria nu se afla in lista, recistesti categorie si reverifici
        // practic vei fi intr-un while pana citesti calumea

        List<String> categories = new ArrayList<>() {
            {
                add("FRUITS");
                add("VEGETABLES");
                add("SWEETS");
                add("TOOLS");
                add("FURNITURE");
            }
        };

        System.out.print("Insert category: ");
        scanner.nextLine();
        String category = scanner.nextLine();
        while(!categories.contains(category)){
            System.out.print("Reinsert cateogry: ");
            category = scanner.nextLine();
        }
        return category;
    }

    public int readInt(String message){

        while(true){
            try{
                System.out.print(message);
                return scanner.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("You need to read a number!");
                scanner.nextLine();
            }
        }
    }

    @Override
    public Product addProduct() {
        System.out.println("*********** Add product functionality ***********");
        System.out.print("Insert name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        int quantity = readInt("Insert quantity: ");
        displayProductCategories();
        String categoryName = readProductCategory();
        ProductCategory category = ProductCategory.valueOf(categoryName.toUpperCase());
        System.out.print("Insert price: ");
        float price = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Insert date (yyyy-MM-dd): ");
        String date = scanner.nextLine();
        LocalDate productdate = LocalDate.parse(date);
        return new Product(name,quantity,category,price,productdate);
    }

    @Override
    public Product editProduct() {
        System.out.println("*********** Edit product functionality ***********");
        int id = readInt("Insert id: ");
        System.out.print("Insert name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        int quantity = readInt("Insert quantity: ");
        displayProductCategories();
        String categoryName = readProductCategory();
        ProductCategory category = ProductCategory.valueOf(categoryName.toUpperCase());
        System.out.print("Insert price: ");
        float price = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Insert date (yyyy-MM-dd): ");
        String date = scanner.nextLine();
        LocalDate productDate = LocalDate.parse(date);
        return new Product(id, name, quantity, category, price, productDate);
    }

    @Override
    public int deleteProduct() {
        this.fileRepo.displayProducts();
        System.out.print("Insert product id: ");
        return scanner.nextInt();
    }

//    public void backup(){
//        while(1==1){
//            Scanner reader = new Scanner(System.in);
//            int  userChoice = reader.nextInt();
//            switch (userChoice){
//                case(0) -> {
//                    return;
//                }
//                case(1) -> {
//                    //We create a new product read from the user
//                    Product newProduct = this.readProduct();
//                    //We add it to the repo using the function from there
//                    this.fileRepo.addProduct(newProduct);
//                    //Sends the object to the method in the repo
//                    //The repo adds it into memory and into the file
//                }
//                case(2) -> {
//                    System.out.println("Insert product ID to remove by ");
//                    int productID = reader.nextInt();
//                    //We send the read ID to the repo, who will is it to remove a product
//                    this.fileRepo.deleteProduct(productID);
//                }
//                case(3) -> {
//                    //We get the list of objects from the repo
//                    var product = this.fileRepo.getProducts();
//                    //We go through the list of products
//                    for(int i = 0; i<product.size(); i++)
//                        //for each product we call toString() to put it on the screen
//                        System.out.println(product.get(i));
//                }
//                case(4) -> {
//                    //We create a new product read from the user
//                    Product newProduct = this.readProduct();
//                    //We add it to the repo using the function from there
//                    this.fileRepo.update(newProduct);
//                    //Sends the object to the method in the repo
//                    //The repo updates the object, and also overwrites the file
//                }
//            }
//
//        }
//    }

    // cum am facut eu mainMenu() adica doar afisari, trebuie sa faci pentru produs
    // da, stiu ca deja este facut
    public void displayProductMenu()
    {
        System.out.println("*********** Product Menu ***********");
        System.out.println("1. Add product");
        System.out.println("2. Show products");
        System.out.println("3. Edit product");
        System.out.println("4. Delete product");
        System.out.println("0. Back to main menu");
    }


    public void productMenu()
    {
        boolean end = false;
        while(!end){
            displayProductMenu();
            System.out.print("Insert option: ");
            int option = scanner.nextInt();

            switch(option)
            {
                case(1) -> {
                    Product product = addProduct();
                    this.fileRepo.addProduct(product);
                }
                case(2) -> {
                    this.fileRepo.displayProducts();
                }
                case(3) -> {
                    Product product = editProduct();
                    this.fileRepo.update(product);
                }
                case(4) -> {
                    int id = deleteProduct();
                    this.fileRepo.deleteProduct(id);
                }
                case(0) -> {
                    System.out.println("Back to main menu...");
                    end = true;
                }
            }
        }
    }

    public void buyerMenu()
    {

    }

    public void workerMenu()
    {

    }

    public void displayMainMenu(){
        System.out.println("*********** Main Menu ***********");
        System.out.println("1. Product menu");
        System.out.println("2. Buyer menu");
        System.out.println("3. Worker menu");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        boolean end = false;
        while(!end){
            displayMainMenu();
            System.out.print("Insert option: ");
            int option = scanner.nextInt();

            switch(option)
            {
                case(1) -> {
                    productMenu();
                }
                case(2) -> {
                    buyerMenu();
                }
                case(3) -> {
                    workerMenu();
                }
                case(0) -> {
                    System.out.println("Exit of application...");
                    end = true;
                }
            }
        }
    }
}
