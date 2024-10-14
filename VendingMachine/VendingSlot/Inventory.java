package VendingSlot;
import java.util.HashMap;

public class Inventory {
    private HashMap<String, Slot> Slots;

    public Inventory() {
        Slots = new HashMap<String, Slot>();
    }

    public String addSlot(Product product, String slotId, int soh) {
        if(this.checkKeyPresence(slotId))return "Slot with this Id is already present.";

        this.Slots.put(slotId, new Slot(slotId, product, soh));
        return "Slot: " + slotId + " has been added.";
    }

    public String removeSlot(String slotId) {
        if(!this.checkKeyPresence(slotId))return "Slot: "+ slotId + " is not present in the vending machine";

        Slot slot = this.Slots.get(slotId);
        slot.debitQuantity(slot.getSOH());
        this.Slots.remove(slotId);
        return "The slot: " + slotId + " has been removed successfully.";
    }

    public String replaceProduct(String slotId, Product newProduct, int quantity) {
        if(!this.checkKeyPresence(slotId))return "Slot: "+ slotId + " is not present in the vending machine";

        Slot slot = this.Slots.get(slotId);
        slot.changeProduct(newProduct);
        slot.updateQuantity(quantity);
        return "The Slot: " + slotId + " is updated with product " + newProduct.getName();
    }

    private Boolean checkKeyPresence(String slotId) {
        if(this.Slots.containsKey(slotId))return true;
        return false;
    }
}
