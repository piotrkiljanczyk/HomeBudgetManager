package pl.coderslab.budgetmanager.model.data;


public enum Category {
    HEALTH("Health"),
    HOUSE("House"),
    WITHDRAWAL("Withdrawal"),
    TRAVEL("Travel");
    private String description;
    Category(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
