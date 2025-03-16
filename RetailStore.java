 class Product {
        private String name;
        private double price;
        private int quantity;
        private String category;
    
        // Constructor
        public Product(String name, double price, int quantity, String category) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.category = category;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public double getPrice() {
            return price;
        }
    
        public void setPrice(double price) {
            this.price = price;
        }
    
        public int getQuantity() {
            return quantity;
        }
    
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    
        public String getCategory() {
            return category;
        }
    
        // Display product details
        public void displayDetails() {
            System.out.println("Name: " + name);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Category: " + category);
            System.out.println("---------------------------");
        }
    }

class Fruits extends Product {
    private boolean organic;

    public Fruits(String name, double price, int quantity, boolean organic) {
        super(name, price, quantity, "Fruit");
        this.organic = organic;
    }

    public boolean isOrganic() {
        return organic;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Organic: " + (organic ? "Yes" : "No"));
        System.out.println("---------------------------");
    }
}


class Vegetables extends Product {
    private boolean seasonal;

    public Vegetables(String name, double price, int quantity, boolean seasonal) {
        super(name, price, quantity, "Vegetable");
        this.seasonal = seasonal;
    }

    public boolean isSeasonal() {
        return seasonal;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Seasonal: " + (seasonal ? "Yes" : "No"));
        System.out.println("---------------------------");
    }
}

class Store {
    private Product[] products;
    private int productCount;
    private static final int MAX_PRODUCTS = 100;

    public Store() {
        products = new Product[MAX_PRODUCTS];
        productCount = 0;
    }

    // Add a product to the store
    public void addProduct(Product product) {
        if (productCount < MAX_PRODUCTS) {
            products[productCount] = product;
            productCount++;
            System.out.println("Product added successfully!");
        } else {
            System.out.println("Store is full! Cannot add more products.");
        }
    }

    // Edit a product by ID
    public void editProduct(String name, double price, int quantity) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(name)) {
                products[i].setPrice(price);
                products[i].setQuantity(quantity);
                System.out.println("Product updated successfully!");
                return;
            }
        }
        System.out.println(name + " not found!");
    }

    // Delete a product by ID
    public void deleteProduct(String name) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(name)) {
                // Move all products one position back
                for (int j = i; j < productCount - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[productCount - 1] = null;
                productCount--;
                System.out.println("Product deleted successfully!");
                return;
            }
        }
        System.out.println(name+ " not found!");
    }

    // Display all products
    public void displayAllProducts() {
        if (productCount == 0) {
            System.out.println("No products available in the store!");
            return;
        }
        
        System.out.println("\n===== AVAILABLE PRODUCTS =====\n");
        for (int i = 0; i < productCount; i++) {
            products[i].displayDetails();
        }
    }

    // Display products by category
    public void displayProductsByCategory(String category) {
        boolean found = false;
        System.out.println("\n===== " + category.toUpperCase() + " PRODUCTS =====\n");
        
        for (int i = 0; i < productCount; i++) {
            if (products[i].getCategory().equalsIgnoreCase(category)) {
                products[i].displayDetails();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No " + category + " products available!");
        }
    }

    // Search product by name
    public void searchProductByName(String name) {
        boolean found = false;
        System.out.println("\n===== SEARCH RESULTS =====\n");
        
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().toLowerCase().contains(name.toLowerCase())) {
                products[i].displayDetails();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No products found with name containing '" + name + "'");
        }
    }
}

public class RetailStore {
    public static void main(String[] args) {
        
        Store store = new Store();
        
        // Add products to the store
        store.addProduct(new Fruits("Apple", 1.99, 100, true));
        store.addProduct(new Fruits("Banana", 0.99, 150, false));
        store.addProduct(new Vegetables("Carrot", 1.49, 80, true));
        store.addProduct(new Vegetables("Spinach", 2.49, 50, true));
        store.addProduct(new Grocery("Rice", 5.99, 30, "Basmati", "2025-12-31"));
        store.addProduct(new Grocery("Cereal", 4.49, 25, "Kellogg's", "2025-06-30"));
        
        // Display all products
        store.displayAllProducts();
        
        System.out.println("\n===== AFTER EDITING =====\n");
        
        // Edit a product
        store.editProduct("Green Apple", 2.49, 75);
        
        // Delete a product
        store.deleteProduct("G002");
        
        // Display all products after modifications
        store.displayAllProducts();
        
        // Display products by category
        store.displayProductsByCategory("Fruit");
        
        // Search product by name
        store.searchProductByName("apple");
    }
}