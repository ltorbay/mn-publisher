package com.ltorbay.mn.publisher;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.reactivex.Single;

@Controller("/exec")
public class ExecController {

    private final EntrypointClient entrypointClient;

    public ExecController(final EntrypointClient entrypointProducer) {
        this.entrypointClient = entrypointProducer;
    }

    @Get()
    public Single<Object> execute(@QueryValue final String text) {
        return entrypointClient.validation(text);
    }
}
