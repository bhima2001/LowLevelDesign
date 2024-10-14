package VendingSlot;

public enum Note {
    TEN(10), TWENTY(20), FIFTY(50), HUNDERED(100), FIVEHUNDERED(500), THOUSAND(1000);

    int value;
    Note(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
