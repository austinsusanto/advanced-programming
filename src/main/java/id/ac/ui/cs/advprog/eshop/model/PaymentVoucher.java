package id.ac.ui.cs.advprog.eshop.model;

import enums.PaymentStatus;

import java.util.Map;

public class PaymentVoucher extends Payment{
    public PaymentVoucher(String id, String method, String status, Map<String, String> paymentData) {
        super(id, method, status, paymentData);
    }
}