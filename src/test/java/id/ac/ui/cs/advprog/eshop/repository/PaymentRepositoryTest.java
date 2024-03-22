package id.ac.ui.cs.advprog.eshop.repository;

import enums.PaymentMethod;
import enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Repository
public class PaymentRepositoryTest {
    PaymentRepository paymentRepository;
    Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();
        paymentData = new HashMap<>();
    }

    @Test
    void testSavePaymentData() {
        paymentData.put("voucherCode", "ESHOP1234567890A");
        Payment payment = new Payment(
                "--PAYMENT ID 1--",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );
        paymentRepository.save(payment);

        assertEquals(PaymentStatus.SUCCESS.getValue(), paymentRepository.findById(payment.getId()).getStatus());
    }

    @Test
    void testEditExistingPaymentData() {
        paymentData.put("voucherCode", "ESHOP1234567890A");
        Payment payment = new Payment(
                "--PAYMENT ID 1--",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );
        paymentRepository.save(payment);

        payment = paymentRepository.findById(payment.getId());
        payment.setMethod(PaymentMethod.TRANSFER.getValue());
        payment.setStatus(PaymentStatus.REJECTED.getValue());
        paymentRepository.save(payment);

        assertEquals(PaymentStatus.REJECTED.getValue(), paymentRepository.findById(payment.getId()).getStatus());
        assertEquals(PaymentMethod.TRANSFER.getValue(), paymentRepository.findById(payment.getId()).getMethod());
    }

    @Test
    void testFindById() {
        paymentData.put("voucherCode", "ESHOP1234567890A");
        Payment payment = new Payment(
                "--PAYMENT ID 1--",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );
        paymentRepository.save(payment);

        assertEquals(payment, paymentRepository.findById(payment.getId()));
    }

    @Test
    void testFindAll() {
        List<Payment> paymentList = new ArrayList<>();
        paymentData.put("voucherCode", "ESHOP1234567890A");

        Payment payment = new Payment(
                "--PAYMENT ID 1--",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );
        paymentRepository.save(payment);
        paymentList.add(payment);

        payment = new Payment(
                "--PAYMENT ID 2--",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                paymentData
        );
        paymentRepository.save(payment);
        paymentList.add(payment);

        assertEquals(paymentList, paymentRepository.findAll());
    }
}
