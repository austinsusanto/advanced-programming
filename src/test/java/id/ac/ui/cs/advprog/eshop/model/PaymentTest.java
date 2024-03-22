package id.ac.ui.cs.advprog.eshop.model;

import enums.PaymentMethod;
import enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaymentTest {
    private Map<String, String> paymentData;
    @BeforeEach
    void setup() {
        this.paymentData = new HashMap<String, String>();
    }

    @Test
    void testCreateValidPaymentStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );

        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testCreateValidPaymentMethod() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );

        assertEquals(PaymentMethod.VOUCHER.getValue(), payment.getMethod());
    }

    @Test
    void testCreateInvalidPaymentStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment(
                    "13652556-012a-4c07-b546-54eb1396d79b",
                    PaymentMethod.VOUCHER.getValue(),
                    "--INVALID PAYMENT STATUS--",
                    paymentData
            );
        });
    }

    @Test
    void testCreateInvalidPaymentMethod() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment(
                    "13652556-012a-4c07-b546-54eb1396d79b",
                    "--INVALID PAYMENT METHOD--",
                    PaymentStatus.SUCCESS.getValue(),
                    paymentData
            );
        });
    }

    @Test
    void testSetValidPaymentStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );
        payment.setStatus(PaymentStatus.REJECTED.getValue());

        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testSetInvalidPaymentStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );

        assertThrows(IllegalArgumentException.class, () -> {
           payment.setStatus("--INVALID PAYMENT STATUS--");
        });
    }

    @Test
    void testSetValidPaymentMethod() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );
        payment.setMethod(PaymentMethod.TRANSFER.getValue());

        assertEquals(PaymentMethod.TRANSFER.getValue(), payment.getMethod());
    }

    @Test
    void testSetInvalidPaymentMethod() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );

        assertThrows(IllegalArgumentException.class, () -> {
            payment.setMethod("--INVALID PAYMENT METHOD--");
        });
    }

}
