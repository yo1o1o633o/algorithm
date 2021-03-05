package stock;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class US {
    private static final Boolean isSell = true;

    private static final BigDecimal platformUsageRatio = new BigDecimal(0.005);

    private static final BigDecimal commissionRatio = new BigDecimal(0.0049);

    private static final BigDecimal settlementRatio = new BigDecimal(0.003);

    private static final BigDecimal securitiesRatio = new BigDecimal(0.0000221);

    private static final BigDecimal transactionRatio = new BigDecimal(0.000119);

    public static void main(String[] args) {
        BigDecimal count = new BigDecimal(10);

        BigDecimal commission = count.multiply(commissionRatio).setScale(2, RoundingMode.HALF_UP);
        if (commission.doubleValue() < 0.99) {
            commission = new BigDecimal("0.99");
        }

        // 交收费
        BigDecimal settlementFee = count.multiply(settlementRatio).setScale(2, RoundingMode.HALF_UP);

        // 证监会规费
        BigDecimal securitiesFee = count.multiply(securitiesRatio).setScale(2, RoundingMode.HALF_UP);
        if (securitiesFee.doubleValue() < 0.01) {
            securitiesFee = new BigDecimal("0.01");
        }

        // 交易活动费
        BigDecimal transactionFee = count.multiply(transactionRatio).setScale(2, RoundingMode.HALF_UP);
        if (transactionFee.doubleValue() < 0.01) {
            transactionFee = new BigDecimal("0.01");
        }
        if (transactionFee.doubleValue() > 5.95) {
            transactionFee = new BigDecimal("5.95");
        }

        // 平台使用费
        BigDecimal platformFee = count.multiply(platformUsageRatio).setScale(2, RoundingMode.HALF_UP);
        if (platformFee.doubleValue() < 1) {
            platformFee = new BigDecimal("1");
        }

        BigDecimal f = commission.add(settlementFee).add(platformFee);

        if (isSell) {
            f = f.add(transactionFee).add(securitiesFee);
        }

        System.out.println(f);
    }
}
