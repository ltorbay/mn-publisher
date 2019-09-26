package com.ltorbay.mn.publisher;

import io.micronaut.configuration.rabbitmq.annotation.Binding;
import io.micronaut.configuration.rabbitmq.annotation.RabbitClient;
import io.micronaut.configuration.rabbitmq.annotation.RabbitProperty;
import io.reactivex.Single;

@RabbitClient("entrypoint")
@RabbitProperty(name = "replyTo", value = "amq.rabbitmq.reply-to")
public interface EntrypointClient {

	@Binding("validation")
	<T> Single<T> validation(T message);

}
