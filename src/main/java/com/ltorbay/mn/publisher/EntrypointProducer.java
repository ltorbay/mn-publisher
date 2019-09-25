package com.ltorbay.mn.publisher;

import io.micronaut.configuration.rabbitmq.annotation.Binding;
import io.micronaut.configuration.rabbitmq.annotation.RabbitClient;

@RabbitClient("entrypoint")
public interface EntrypointProducer {

	@Binding("validation")
	void execute(Object message);

}
