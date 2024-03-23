package id.ac.ui.cs.advprog.eshop.service;

import enums.OrderStatus;
import enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        String orderId = order.getId();
        Payment existingPayment = paymentRepository.findById(orderId);

        if (existingPayment == null || existingPayment.getStatus().equals(PaymentStatus.REJECTED.getValue())) {
            Payment newPayment = new Payment(orderId, method, paymentData);
            paymentRepository.save(newPayment);
            return newPayment;
        }

        return null;
    }

    @Override
    public Payment setStatus(Payment payment, String status) {
        Payment editedPayment = paymentRepository.findById(payment.getId());

        if (editedPayment == null) {
            throw new NoSuchElementException();
        }

        Order editedOrder = orderRepository.findById(editedPayment.getId());
        editedPayment = new Payment(
                editedPayment.getId(),
                editedPayment.getMethod(),
                status,
                editedPayment.getPaymentData()
        );

        if (status.equals(PaymentStatus.SUCCESS.getValue())) {
            editedOrder.setStatus(OrderStatus.SUCCESS.getValue());
        } else if (status.equals(PaymentStatus.REJECTED.getValue())) {
            editedOrder.setStatus(OrderStatus.FAILED.getValue());
        }

        paymentRepository.save(editedPayment);
        orderRepository.save(editedOrder);

        return editedPayment;
    }

    @Override
    public Payment getPayment(String paymentId) {
        return paymentRepository.findById(paymentId);
    }
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

}
