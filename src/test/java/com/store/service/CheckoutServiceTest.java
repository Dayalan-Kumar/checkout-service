package com.store.service;

import com.store.domain.Card;
import com.store.domain.CardType;
import com.store.domain.CheckOutStatus;
import com.store.domain.OrderDetails;
import com.store.payment.PaymentService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutServiceTest {

    PaymentService paymentService = new PaymentService();

    CheckoutService checkoutService = new CheckoutService(paymentService);

    @EnumSource(CardType.class)
    @ParameterizedTest(name = "Checkout for Car Type : {0}")
    void checkout(CardType cardType){
        var orderDetails = orderDetails(cardType);
        var response = checkoutService.checkoutOrder(orderDetails);
        assertEquals(CheckOutStatus.SUCCESS, response);
    }

    static OrderDetails orderDetails(CardType cardType){
        var card = new Card("ABC","767676767676767"
        ,"4567","09/99",cardType);
        return new OrderDetails("1234", card, 99.0);
    }

}