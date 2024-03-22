package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {
    private List<Payment> paymentData = new ArrayList<>();
    public Payment save(Payment payment) {
        Payment existingPayment = this.findById(payment.getId());

        if (existingPayment != null) {
            paymentData.remove(existingPayment);
        }
        paymentData.add(payment);

        return payment;
    }
    public Payment findById(String id) {
        for (Payment payment : paymentData) {
            if (id.equals(payment.getId())) {
                return payment;
            }
        }

        return null;
    }
    public List<Payment> findAll() {
        return paymentData;
    }
}