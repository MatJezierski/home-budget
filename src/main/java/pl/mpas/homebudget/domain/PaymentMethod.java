package pl.mpas.homebudget.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum PaymentMethod {

    CASH,
    DEBIT,
    CREDIT,
    ONLINE_PAYMENT;

    public static List<PaymentMethod> getAllPaymentMethods() {
        return Arrays.stream(PaymentMethod.values())
                .sorted(Comparator.comparing(Enum::toString))
                .collect(Collectors.toList());
    }
}
