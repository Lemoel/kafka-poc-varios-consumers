package com.kafka.publisher.data

import java.math.BigDecimal

class Order(
    val code: String,
    val productName: String,
    val price: BigDecimal,
)