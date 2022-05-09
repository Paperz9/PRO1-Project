package Zipfile;

import java.beans.ConstructorProperties;

public class PercentDiscount extends Discount {
    private final int discountPercentage;

    public PercentDiscount(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getDiscount(double price) {
        return price - price * discountPercentage / 100;
    }
}
