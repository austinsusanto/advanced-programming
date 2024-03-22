package id.ac.ui.cs.advprog.eshop.model;

import enums.PaymentMethod;
import enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentTest {
    private Map<String, String> paymentData;
    @BeforeEach
    void setup() {
        this.paymentData = new HashMap<String, String>();
    }

    @Test
    void testCreateValidPayment() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData);

        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        assertEquals(PaymentMethod.VOUCHER.getValue(), payment.getMethod());
    }

}
