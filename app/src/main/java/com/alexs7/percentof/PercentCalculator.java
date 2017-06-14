package com.alexs7.percentof;

import java.math.BigDecimal;

/**
 * Created by alex on 14/06/2017.
 */

public class PercentCalculator {

    public PercentCalculator(){}

    public BigDecimal calculatePercentage(BigDecimal percentage, BigDecimal value){
        return percentage.multiply(value).divide(new BigDecimal(100.00)).setScale(2);
    };

}
