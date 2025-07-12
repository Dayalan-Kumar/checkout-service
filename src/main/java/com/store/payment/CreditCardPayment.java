package com.store.payment;

import com.store.domain.Card;
import com.store.domain.PaymentResponse;

public final class CreditCardPayment extends PaymentGateway{
    @Override
    public PaymentResponse makePayment(Card card, double amount) {
        System.out.println("Acquire credit card payment for the amount ="+amount);
        return PaymentResponse.SUCCESS;
    }
}
