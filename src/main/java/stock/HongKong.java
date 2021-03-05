package stock;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HongKong {
    private static final BigDecimal platformUsageFee = new BigDecimal(15);
    // 交易系统使用费
    private static final BigDecimal usageFee = new BigDecimal(0.5);
    // 是否有佣金
    private static final Boolean isCommission = false;

    private static final BigDecimal commissionRatio = new BigDecimal(0.0003);

    private static final BigDecimal settlementRatio = new BigDecimal(0.00002);

    private static final BigDecimal stampRatio = new BigDecimal(0.001);

    private static final BigDecimal transactionRatio = new BigDecimal(0.00005);

    private static final BigDecimal transactionLevyRatio = new BigDecimal(0.000027);

    public static void main(String[] args) {
        BigDecimal money = new BigDecimal(5400);
        // 佣金
        BigDecimal commission = new BigDecimal(0.00);
        if (isCommission) {
            commission = money.multiply(commissionRatio);
            if (commission.doubleValue() < 3) {
                commission = new BigDecimal(3);
            }
        }
        // 交收费
        BigDecimal settlementFee = money.multiply(settlementRatio);
        if (settlementFee.doubleValue() < 2) {
            settlementFee = new BigDecimal(2.00);
        }
        if (settlementFee.doubleValue() > 100) {
            settlementFee = new BigDecimal(100.00);
        }
        System.out.println("交收费: " + settlementFee);
        // 印花税
        BigDecimal stampDuty = money.multiply(stampRatio);
        if (stampDuty.doubleValue() < 1) {
            stampDuty = new BigDecimal(1);
        }
        stampDuty = stampDuty.setScale(2, RoundingMode.HALF_UP);
        System.out.println("印花税: " + stampDuty);
        // 交易费
        BigDecimal transactionFee = money.multiply(transactionRatio).setScale(2, RoundingMode.HALF_UP);
        if (transactionFee.doubleValue() < 0.01) {
            transactionFee = new BigDecimal(0.01);
        }
        System.out.println("交易费: " + transactionFee);
        // 交易征收
        BigDecimal transactionLevy = money.multiply(transactionLevyRatio).setScale(2, RoundingMode.HALF_UP);
        if (transactionLevy.doubleValue() < 0.01) {
            transactionLevy = new BigDecimal(0.01);
        }
        System.out.println("交易征收: " + transactionLevy);
        BigDecimal f = platformUsageFee.add(commission).add(usageFee).add(settlementFee).add(stampDuty).add(transactionFee).add(transactionLevy);

        System.out.println(f.doubleValue());
    }
}
