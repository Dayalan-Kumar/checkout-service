package com.store.domain;

public record OrderDetails(String orderId,
                           Card card,
                           double finalAmount) {
}
