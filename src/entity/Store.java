package entity;

import java.util.List;

public class Store {
    List<Product> products;
    List<Worker> workers;

    public Store(List<Product> products, List<Worker> workers) {
        this.products = products;
        this.workers = workers;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> product) {
        this.products = products;
    }

    public List<Worker> getWorker() {
        return workers;
    }

    public void setWorker(List<Worker> worker) {
        this.workers = workers;
    }

    public void addProduct(Product product){
        products.add(product);

    }

    public void addWorker(Worker worker){
        workers.add(worker);
    }

    @Override
    public String toString() {
        return "Store{" +
                "product=" + products +
                ", worker=" + workers +
                '}';
    }
}
