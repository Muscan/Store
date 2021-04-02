package user_interface;

import entity.Product;

public interface I_UI {

    /**
     *
     * @return - {@Product} A new product read from the user
     * Reads the Product fields, and creates a new object with
     */
    public Product addProduct();

    public Product editProduct();

    public int deleteProduct();

    /**
     * Shows the interface to the user. Interacts with the user.
     */
    public void run();
}
