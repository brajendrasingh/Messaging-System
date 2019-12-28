/**
 * 
 */
package com.bksoft.rabbitmq.configuration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author BRAJENDRA SINGH
 *
 */

@Configuration
public class ProducerConfiguration {

	@Bean
	public Jackson2JsonMessageConverter object2JsonConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(object2JsonConverter());
		return rabbitTemplate;
	}
}
