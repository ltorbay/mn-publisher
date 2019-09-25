package com.ltorbay.mn.publisher;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

@Controller("/exec")
public class ExecController {

	private final EntrypointProducer entrypointProducer;

	public ExecController(final EntrypointProducer entrypointProducer) {
		this.entrypointProducer = entrypointProducer;
	}

	@Get()
	public void execute(@QueryValue final String text) {
		entrypointProducer.execute(text);
	}
}
