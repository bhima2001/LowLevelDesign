package VendingSlot;

public class Slot {
    protected String slotId;
    protected Product product;
    protected int soh; //stock on hand

    public Slot(String slotId, Product product, int soh) {
        this.slotId = slotId;
        this.product = product;
        this.soh = soh;
    }

    public Boolean changeProduct(Product newProduct) {
        this.product = newProduct;
        return true;
    }

    public void creditQuantity(int qty) {
        this.soh += qty;
    }

    public Boolean debitQuantity(int qty) {
        if(qty > this.soh) return false;
        this.soh -= qty;
        return  true;
    }

    public int getSOH() {
        return this.soh;
    }

    public Product getProduct(){
        return this.product;
    }

    public void updateQuantity(int quantity) {
        this.soh = quantity;
    }
}
