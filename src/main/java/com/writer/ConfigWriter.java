package com.writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.amqp.AmqpItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Config.BatchConfig;
import com.dao.Student;

@Configuration
public class ConfigWriter {

	@Autowired
	private BatchConfig batchConfig;
	
	Logger log = LoggerFactory.getLogger(ConfigWriter.class);

	@Bean
	public AmqpItemWriter<Student> amqpWriter() {
		log.trace("Writing to RMQ from CSV..");
		AmqpItemWriter<Student> amqpItemWriter = new AmqpItemWriter<>(batchConfig.rabbitTemplate());
		return amqpItemWriter;
	}
	
}
