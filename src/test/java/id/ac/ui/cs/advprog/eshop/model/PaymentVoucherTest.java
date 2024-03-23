package id.ac.ui.cs.advprog.eshop.model;

import enums.PaymentMethod;
import enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PaymentVoucherTest {
    Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        paymentData = new HashMap<String, String>();
    }

    @Test
    void testCreateValidPaymentData() {
        paymentData.put("voucherCode", "ESHOP1234567890A");
        PaymentVoucher payment = new PaymentVoucher(
                "13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethod.VOUCHER.getValue(),
                paymentData
        );

        payment.setPaymentData(this.paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }
}