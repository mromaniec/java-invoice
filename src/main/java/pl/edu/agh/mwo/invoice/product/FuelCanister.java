package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class FuelCanister extends Product{

    protected FuelCanister(String name, BigDecimal price, BigDecimal tax) {
        super(name, price, tax);
    }
}
