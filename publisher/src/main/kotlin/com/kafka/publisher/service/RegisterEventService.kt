package com.kafka.publisher.service

import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class RegisterEventService(
    val template: KafkaTemplate<String, String>
) {
    fun <T> addEvent(topic: String, data: T, key: String?) {
        val producerRecord = ProducerRecord(topic, key, data.toString())
        template.send(producerRecord)
    }
}