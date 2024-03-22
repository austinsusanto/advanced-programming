package id.ac.ui.cs.advprog.eshop.repository;

import enums.PaymentMethod;
import enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Repository
public class PaymentRepositoryTest {
    PaymentRepository paymentRepository;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();
    }

    @Test
    void testSaveValidVoucherPaymentData() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234567890A");

        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );
        paymentRepository.save(payment);

        assertEquals(PaymentStatus.SUCCESS.getValue(), paymentRepository.findById(payment.getId()).getStatus());
    }

    @Test
    void testSaveInvalidVoucherPaymentData() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "--INVALID VOUCHER DATA--");

        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );
        paymentRepository.save(payment);

        assertEquals(PaymentStatus.REJECTED.getValue(), paymentRepository.findById(payment.getId()).getStatus());
    }

    @Test
    void testSaveValidBankTransferData() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("bankName", "Bank Universitas Indonesia");
        paymentData.put("referenceCode", "12345");

        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethod.TRANSFER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );
        paymentRepository.save(payment);

        assertEquals(PaymentStatus.SUCCESS.getValue(), paymentRepository.findById(payment.getId()).getStatus());
    }

    @Test
    void testSaveInvalidBankTransferData1() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("bankName", "");
        paymentData.put("referenceCode", "");

        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethod.TRANSFER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );
        paymentRepository.save(payment);

        assertEquals(PaymentStatus.REJECTED.getValue(), paymentRepository.findById(payment.getId()).getStatus());
    }

    @Test
    void testSaveInvalidBankTransferData2() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("bankName", null);
        paymentData.put("referenceCode", null);

        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethod.TRANSFER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );
        paymentRepository.save(payment);

        assertEquals(PaymentStatus.REJECTED.getValue(), paymentRepository.findById(payment.getId()).getStatus());
    }

    @Test
    void testEditExistingPaymentData() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234567890A");

        Payment payment = new Payment(
                "--PAYMENT ID 1--",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );
        paymentRepository.save(payment);

        assertEquals(PaymentStatus.SUCCESS.getValue(), paymentRepository.findById(payment.getId()).getStatus());

        paymentData.clear();
        paymentData.put("bankName", "Bank Universitas Indonesia");
        paymentData.put("referenceCode", "12345");

        payment = new Payment(
                "--PAYMENT ID 2--",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );
        paymentRepository.save(payment);

        assertEquals(PaymentStatus.SUCCESS.getValue(), paymentRepository.findById(payment.getId()).getStatus());

        paymentData.clear();

        payment = paymentRepository.findById("--PAYMENT ID 1--");
        payment.setPaymentData(paymentData);
        paymentRepository.save(payment);

        assertEquals(PaymentStatus.REJECTED.getValue(), paymentRepository.findById(payment.getId()).getStatus());

        payment = paymentRepository.findById("--PAYMENT ID 2--");
        payment.setPaymentData(paymentData);
        paymentRepository.save(payment);

        assertEquals(PaymentStatus.REJECTED.getValue(), paymentRepository.findById(payment.getId()).getStatus());
    }
}
