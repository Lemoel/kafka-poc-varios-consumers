package com.kafka.poc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NotificationConsumer02Application

fun main(args: Array<String>) {
	runApplication<NotificationConsumer02Application>(*args)
}
