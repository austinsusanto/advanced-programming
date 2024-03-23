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
        String voucherCode = paymentData.get("bankName");
        int voucherCodeLength = voucherCode.length();

        int numCount = 0;
        for (int i = 0; i < voucherCodeLength; i++) {
            if (Character.isDigit(voucherCode.charAt(i))) {
                numCount++;
            }
        }

        if (voucherCodeLength == 16 && voucherCode.startsWith("ESHOP") && numCount == 8) {
            this.status = PaymentStatus.SUCCESS.getValue();
        } else {
            this.status = PaymentStatus.REJECTED.getValue();
        }
    }
}