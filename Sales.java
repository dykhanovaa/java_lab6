import java.util.ArrayList;

public class Sales {
    private ArrayList<String> salesList;

    public Sales() {
        salesList = new ArrayList<>();
    }

    public void recordSale(String product) {
        salesList.add(product);  // Добавляем товар в список
    }

    public int getSales(String product) {
        int count = 0;
        for (String soldProduct : salesList) {
            if (soldProduct.equals(product)) {
                count++;
            }
        }
        return count;
    }

    public void printSales() {
        ArrayList<String> uniqueProducts = new ArrayList<>();  // Список для хранения уникальных товаров
        for (String product : salesList) {
            if (!uniqueProducts.contains(product)) {
                uniqueProducts.add(product);
            }
        }
        for (String product : uniqueProducts) {
            System.out.println(product + ": " + getSales(product));
        }
    }

    public static void main(String[] args) {
        Sales tracker = new Sales();

        tracker.recordSale("хлеб");
        tracker.recordSale("молоко");
        tracker.recordSale("хлеб");
        tracker.recordSale("яблоко");

        tracker.printSales();

        System.out.println("Сколько яблок продано: " + tracker.getSales("яблоко"));
        System.out.println("Сколько хлеба продано: " + tracker.getSales("хлеб"));
    }
}