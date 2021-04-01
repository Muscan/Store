package repository;

import entity.Buyer;
import entity.Product;
import enumeration.ProductCategory;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BuyerFileRepo {
    private final List<Buyer> buyers;
    private final String fileName;
    public BuyerFileRepo(List<Buyer> buyers, String fileName) {
        this.buyers = buyers;
        this.fileName = fileName;
        this.read();
    }
    public void write() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.fileName))){
            for (Buyer buyer : buyers) {
                bw.write(buyer.getId() + ", " + buyer.getName() + ", " + buyer.getPassword()
                + ", " + buyer.getRegistrationDate());
                bw.newLine();
            }
            System.out.println("Fisierul " + fileName + " a fost modificat (Buyer) ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Buyer> getBuyers() {
        return buyers;
    }

    public boolean buyerExists(Buyer buyer){
        for(Buyer b: buyers){
            if(b.getId() == buyer.getId())
                return true;
        }
        return false;
    }
    public void addBuyer(Buyer buyer) {
        if(!buyerExists(buyer)){
            this.buyers.add(buyer);
            write();
        }
        else{
            System.out.println("The buyer " + buyer.getName() + " with Id " + buyer.getId() +
                    "with registration date" + buyer.getRegistrationDate() + "already exists"
            );
        }
    }
    public void deleteBuyer(int id){
        try {
            this.buyers.removeIf(buyer -> buyer.getId() == id);
            this.write();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update (Buyer updatedBuyer){
        for(var buyer : this.buyers){
            if(buyer.getId() == updatedBuyer.getId()){
                buyer.setName(updatedBuyer.getName());
                buyer.setPassword(updatedBuyer.getPassword());
                buyer.setRegistrationDate(updatedBuyer.getRegistrationDate());

                this.write();
                return;
            }
            System.out.println("Object with this id " + buyer.getId() + " does not exists");
        }
    }
     public void read(){
         DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
             String line;

             while ((line = br.readLine()) != null) {
                 String[] args = line.split(",");
                 this.buyers.add(new Buyer(
                         Integer.parseInt(args[0]),
                         args[1],
                         args[2],
                         LocalDate.parse(args[3], dateFormatter)
                 ));
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

}
