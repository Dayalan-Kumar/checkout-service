package com.store.payment;

import com.store.domain.OrderDetails;
import com.store.domain.PaymentResponse;

public class PaymentService {
    public PaymentResponse makePayment(OrderDetails orderDetails){
       //implement a payment gateway that can handle the different kinds of payment.
       var paymentGateway = PaymentFactory.paymentGateway(orderDetails.card().cardType());
       //return PaymentResponse.SUCCESS;
       return paymentGateway.makePayment(orderDetails.card(), orderDetails.finalAmount());
    }
}
