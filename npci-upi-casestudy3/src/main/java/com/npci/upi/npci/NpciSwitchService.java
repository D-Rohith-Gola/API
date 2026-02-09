package com.npci.upi.npci;

import com.npci.upi.model.PaymentRequest;
import com.npci.upi.model.PaymentResponse;

public interface NpciSwitchService {
    PaymentResponse process(PaymentRequest request);
}