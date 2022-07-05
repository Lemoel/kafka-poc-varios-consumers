package com.kafka.publisher

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
class PublisherApplication

fun main(args: Array<String>) {
	runApplication<PublisherApplication>(*args)
}
