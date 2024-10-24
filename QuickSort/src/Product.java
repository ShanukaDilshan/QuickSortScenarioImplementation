class Product implements Comparable<Product> {
    private String name;
    private int id;
    private double price;

    public Product(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        // Compare products based on their names
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }
}