package com.store.service;

import com.store.domain.CheckOutStatus;
import com.store.domain.OrderDetails;
import com.store.domain.PaymentResponse;
import com.store.payment.PaymentService;

public class CheckoutService {
    private final PaymentService paymentService;

    public CheckoutService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public CheckOutStatus checkoutOrder(OrderDetails orderDetails){
        var paymentResponse = paymentService.makePayment(orderDetails);
        if(paymentResponse.equals(PaymentResponse.SUCCESS)){
            return CheckOutStatus.SUCCESS;
        }
        return CheckOutStatus.FAILURE;
    }
}
