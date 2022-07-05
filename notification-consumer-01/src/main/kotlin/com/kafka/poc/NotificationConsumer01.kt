package com.kafka.poc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
class NotificationConsumer01Application

fun main(args: Array<String>) {
	runApplication<NotificationConsumer01Application>(*args)
}
