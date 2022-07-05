package com.kafka.poc.service

import mu.KotlinLogging
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class ConsumerEventService {

    companion object {
        private val logger = KotlinLogging.logger { }
    }

    @KafkaListener(
        topics = ["save-order"],
        groupId = "consumer-group-notification"
    )
    fun execute(record: ConsumerRecord<String, String>) {
        logger.info { "consumer-notification-02" }
        logger.info { "key: ${record.key()}" }
        logger.info { "headers: ${record.headers()}" }
        logger.info { "value: ${record.value()}" }
    }

}