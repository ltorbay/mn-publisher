package com.ltorbay.mn.publisher;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import io.micronaut.configuration.rabbitmq.connect.ChannelInitializer;

import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class MnPublisherChanneInitializer extends ChannelInitializer {

	@Override
	public void initialize(final Channel channel) throws IOException {
		channel.exchangeDeclare("entrypoint", BuiltinExchangeType.DIRECT, true);
		channel.queueDeclare("validation", true, false, false, null);
		channel.queueBind("validation", "entrypoint", "validation");
		channel.queueDeclare("exec", true, false, false, null);
		channel.queueBind("exec", "entrypoint", "exec");
	}
}
