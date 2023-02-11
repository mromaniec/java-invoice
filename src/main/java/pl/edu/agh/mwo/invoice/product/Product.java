package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;
//   git token:   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

public abstract class Product {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;

    protected Product(String name, BigDecimal price, BigDecimal tax) {
        if (name == null || name.isEmpty() ){
            throw new IllegalArgumentException("Product name cannot be null");
        }

        if (price == null || price.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Product price cannot be null or negative");
        }

        this.name = name;
        this.price = price;
        this.taxPercent = tax;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getTaxPercent() {return this.taxPercent;}

    public BigDecimal getPriceWithTax() {return this.price.multiply(this.taxPercent).add(this.price);}

}
