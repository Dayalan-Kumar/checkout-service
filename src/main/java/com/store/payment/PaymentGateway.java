package com.store.payment;

import com.store.domain.Card;
import com.store.domain.PaymentResponse;

public sealed abstract class PaymentGateway permits CreditCardPayment, DebitCardPayment, RewardsCardPayment {
    public abstract PaymentResponse makePayment(Card card, double amount);
}
