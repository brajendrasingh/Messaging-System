/**
 * 
 */
package com.bksoft.rabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

/**
 * @author BRAJENDRA SINGH
 *
 */

@Configuration
public class ConsumerConfiguration implements RabbitListenerConfigurer {

	@Value("${app.rabbitmq.queue}")
	String queue;

	@Value("${app.rabbitmq.exchange}")
	String exchange;

	@Value("${app.rabbitmq.routingkey}")
	private String routingkey;

	@Bean
	Queue getQueue() {
		return new Queue(queue);
	}

	@Bean
	DirectExchange getExchange() {
		return new DirectExchange(exchange);
	}

	@Bean
	Binding getBinding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingkey);
	}

	@Bean
	public MappingJackson2MessageConverter jsonMessageConverter() {
		return new MappingJackson2MessageConverter();
	}

	@Bean
	public DefaultMessageHandlerMethodFactory rabbitHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
		factory.setMessageConverter(jsonMessageConverter());
		return factory;
	}

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(rabbitHandlerMethodFactory());

	}
}
