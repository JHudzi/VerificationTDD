package cm;
import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 *
 *  Created by Josh Hudziak on 25/03/2021.
 *
 */

interface ICalculateRate {
    BigDecimal calculate(BigDecimal rate);
}

class VisitorBehaviour implements ICalculateRate {

    // First 8 if free
    private BigDecimal visitorRateNoCharge = BigDecimal.valueOf(8.00);
    // 50% discount on amount above 8
    private BigDecimal visitorRateReduced = BigDecimal.valueOf(0.50);

    @Override
    public BigDecimal calculate(BigDecimal rate) {
        rate = (visitorRateReduced.multiply(rate.subtract(visitorRateNoCharge)));
        return (rate.compareTo(BigDecimal.ZERO) > 0) ? rate.setScale(2, RoundingMode.CEILING) : BigDecimal.ZERO;
    }
}

class ManagementBehaviour implements ICalculateRate {
    private BigDecimal managementRateMin = BigDecimal.valueOf(3.00);

    @Override
    public BigDecimal calculate(BigDecimal rate) {
        //normal rates apply over 3
        if (rate.compareTo(BigDecimal.valueOf(3)) > 0){
            return rate.setScale(2, RoundingMode.CEILING);
        }
        //If pay period doesn't exist it's free
        else if(rate.compareTo(BigDecimal.ZERO) == 0)
        {
            return BigDecimal.ZERO;
        }
        //Min fee 3
        else {
            return managementRateMin;
        }
    }
}

class StudentBehaviour implements ICalculateRate {

    // A regular fee up to 5.50
    private BigDecimal studentRegPrice = BigDecimal.valueOf(5.50);
    // 25% reduction after 5.50
    private BigDecimal studentOverallReduction = BigDecimal.valueOf(0.25);

    @Override
    public BigDecimal calculate(BigDecimal rate) {
        if (rate.compareTo(studentRegPrice) > 0) {
            rate = studentRegPrice.add(((rate)
                    .subtract(studentRegPrice))
                    .subtract(((rate)
                            .subtract(studentRegPrice))
                            .multiply(studentOverallReduction)));
        }
        return (rate.compareTo(BigDecimal.ZERO) > 0) ? rate.setScale(2, RoundingMode.CEILING) : BigDecimal.ZERO;
    }
}

class StaffBehaviour implements ICalculateRate {

    // Max fee is 16
    private BigDecimal staffRateMaxCharge = BigDecimal.valueOf(16.00);

    @Override
    public BigDecimal calculate(BigDecimal rate) {
        return (rate.compareTo(staffRateMaxCharge) <= 0) ? rate.setScale(2, RoundingMode.CEILING) : staffRateMaxCharge;
    }
}