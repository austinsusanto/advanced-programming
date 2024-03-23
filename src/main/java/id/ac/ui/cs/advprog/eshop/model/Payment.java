package id.ac.ui.cs.advprog.eshop.model;

import enums.PaymentStatus;
import enums.PaymentMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Builder
@Getter
public class Payment {
    String id;
    String method;
    String status;
    @Setter
    Map<String, String> paymentData;

    public Payment(String id, String method, String status, Map<String, String> paymentData) {
        this.id = id;
        this.paymentData = paymentData;
        setStatus(status);
        setMethod(method);
    }

    public Payment(String id, String method, Map<String, String> paymentData) {
        this(id, method, PaymentStatus.PENDING.getValue(), paymentData);
    }

    public void setStatus(String status) {
        if (PaymentStatus.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setMethod(String method) {
        if (PaymentMethod.contains(method)) {
            this.method = method;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
