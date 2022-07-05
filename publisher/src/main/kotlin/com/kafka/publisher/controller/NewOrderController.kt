package com.kafka.publisher.controller

import com.kafka.publisher.data.Order
import com.kafka.publisher.service.RegisterEventService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class NewOrderController(
    val registerEventService: RegisterEventService
) {
    @PostMapping("order")
    fun saveOrder(
       @RequestBody order: Order,
    ): ResponseEntity<String> {
        registerEventService.addEvent("save-order", order)
        return ResponseEntity.ok("Sucesso")
    }
}