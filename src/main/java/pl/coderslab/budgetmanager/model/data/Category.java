package pl.coderslab.budgetmanager.model.data;


public enum Category {
//"Codzienne wydatki",
//                "Dom i rachunki", "Dzieci", "Finanse i ubezpieczenia",
//                "Firmowe", "Inwestycje", "Okazjonalne wydaki", "Rozrywka i edukacja",
//                "Samochód i transport", "Wakacje i podróże", "Wypłata gotówki",
//                "Zdrowie i uroda", "Pozostałe wydatki"
    DAILY_EXPENSES("Codzienne wydatki"),//0
    HOUSE("Dom i rachunki");//1
    private String description;
    Category(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
