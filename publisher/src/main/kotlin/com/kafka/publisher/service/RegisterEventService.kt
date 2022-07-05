package com.kafka.publisher.service

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class RegisterEventService(
    val template: KafkaTemplate<Any, Any>
) {

    fun <T> addEvent(topic: String, data: T) {
        template.send(topic, data)
    }

}