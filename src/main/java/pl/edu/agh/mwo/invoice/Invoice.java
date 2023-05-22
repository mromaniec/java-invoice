package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    //private Collection<Product> products;
    private Map<Product, Integer> products;


    public void addProduct(Product product) {
    }

    public void addProduct(Product product, Integer quantity) {
        //this.products.put(product, quantity);
        //for int i = 0; i <quantity; i++){    - jeśli pracowalibysmy na kolekcji
        //    products.add(product);
        // }

        if (product == null || quantity <= 0){
            throw new IllegalArgumentException("quantity must be greater than 0");
        }
        products.put(product, quantity);

    }

    public BigDecimal getSubtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            subtotal = subtotal.add(product.getPrice().multiply(new BigDecimal(products.get(product))));
        }
        return subtotal;

       // return BigDecimal.ZERO;
    }

    public BigDecimal getTax() {
        BigDecimal tax = new BigDecimal(0);
        for (Product product : products.keySet()) {
            tax = tax.add(product.getPrice().multiply(product.getTaxPercent()));
        }
        return tax;
        // return BigDecimal.ZERO;
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0);
        for (Product product : products.keySet()) {
            BigDecimal price = product.getPrice();
            BigDecimal priceWithTax = price.add(price.multiply(product.getTaxPercent()));
            total = total.add(priceWithTax.multiply(new BigDecimal(products.get(product))));
        }
        return total;
        //return BigDecimal.ZERO;
    }
}
