package id.ac.ui.cs.advprog.eshop.model;

import enums.PaymentStatus;

import java.util.Map;

public class PaymentBankTransfer extends Payment{
    public PaymentBankTransfer(String id, String method, String status, Map<String, String> paymentData) {
        super(id, method, status, paymentData);
    }

    public PaymentBankTransfer(String id, String method, Map<String, String> paymentData) {
        super(id, method, PaymentStatus.PENDING.getValue(), paymentData);
    }

    @Override
    public void setPaymentData(Map<String, String> paymentData) {
        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.paymentData = paymentData;
        String bankName = paymentData.get("bankName");
        String referenceCode = paymentData.get("referenceCode");

        if (bankName == null || referenceCode == null || bankName.isEmpty() || referenceCode.isEmpty()) {
            this.status = PaymentStatus.REJECTED.getValue();
        } else {
            this.status = PaymentStatus.SUCCESS.getValue();
        }
    }
}