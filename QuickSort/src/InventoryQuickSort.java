import java.util.Arrays;

public class InventoryQuickSort {

    public static void sort(Product[] inventory, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(inventory, low, high);

            // Sort the elements before the partition
            sort(inventory, low, partitionIndex - 1);

            // Sort the elements after the partition
            sort(inventory, partitionIndex + 1, high);
        }
    }

    private static int partition(Product[] inventory, int low, int high) {
        Product pivot = inventory[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (inventory[j].compareTo(pivot) <= 0) {
                i++;
                swap(inventory, i, j);
            }
        }

        swap(inventory, i + 1, high);
        return i + 1;
    }

    private static void swap(Product[] inventory, int i, int j) {
        Product temp = inventory[i];
        inventory[i] = inventory[j];
        inventory[j] = temp;
    }

    public static void main(String[] args) {
        // Create a large inventory array or read data from a file
        Product[] inventory = {
                new Product("Apple", 1, 2.99),
                new Product("Banana", 2, 1.49),
                new Product("Orange", 3, 1.99),
                new Product("Kiwi", 4, 3.49),
                new Product("Mango", 5, 2.79)
        };

        System.out.println("Unsorted inventory: " + Arrays.toString(inventory));

        long startTime = System.currentTimeMillis();
        sort(inventory, 0, inventory.length - 1);
        long endTime = System.currentTimeMillis();

        System.out.println("Sorted inventory: " + Arrays.toString(inventory));
        System.out.println("Sorting time: " + (endTime - startTime) + " ms");
    }
}