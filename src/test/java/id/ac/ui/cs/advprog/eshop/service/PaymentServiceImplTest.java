package id.ac.ui.cs.advprog.eshop.service;

import enums.OrderStatus;
import enums.PaymentMethod;
import enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplTest {
    @InjectMocks
    PaymentServiceImpl paymentService;
    @Mock
    PaymentRepository paymentRepository;
    @Mock
    OrderRepository orderRepository;

    List<Payment> payments;
    List<Product> products;
    Order order;
    Map<String, String> voucherPaymentData;
    Map<String, String> bankPaymentData;

    @BeforeEach
    void setUp() {
        payments = new ArrayList<>();
        products = new ArrayList<>();

        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        products.add(product);

        order = new Order(
                "ORDER 1",
                products,
                1708560000L,
                "Austin Susanto"
        );

        voucherPaymentData = new HashMap<>();
        voucherPaymentData.put("voucherCode", "ESHOP1234567890A");
        Payment payment1 = new Payment(
                "ORDER 1",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                voucherPaymentData
        );

        bankPaymentData = new HashMap<>();
        bankPaymentData.put("bankName", "Bank Universitas Indonesia");
        bankPaymentData.put("referenceCode", "12345");
        Payment payment2 = new Payment(
                "PAYMENT 2",
                PaymentMethod.TRANSFER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                bankPaymentData
        );

        payments.add(payment1);
        payments.add(payment2);

    }

    @Test
    void testAddPayment() {
        Payment payment = payments.get(0);
        doReturn(payment).when(paymentRepository).findById(payment.getId());

        assertNull(paymentService.addPayment(order, payment.getMethod(), payment.getPaymentData()));
    }


}
