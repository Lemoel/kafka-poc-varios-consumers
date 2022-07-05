package com.kafka.poc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
class FinanceiroConsumer01

fun main(args: Array<String>) {
	runApplication<FinanceiroConsumer01>(*args)
}
