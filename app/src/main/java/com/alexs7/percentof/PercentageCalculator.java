package com.alexs7.percentof;

import java.math.BigDecimal;

/**
 * Created by alex on 14/06/2017.
 */

public class PercentageCalculator {

    public PercentageCalculator(){}

    public BigDecimal calculatePercentage(BigDecimal percentage, BigDecimal value){
        return percentage.multiply(value).divide(new BigDecimal(100.00), BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);
    };

}
