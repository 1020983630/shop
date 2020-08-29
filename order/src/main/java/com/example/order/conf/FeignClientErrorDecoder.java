package com.example.order.conf;

import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.lang.reflect.Type;

@Slf4j
@Configuration
public class FeignClientErrorDecoder implements Decoder {

    @Override
    public Exception decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        log.info("feign client response:", response);
        String body = null;
        try {
            body = Util.toString(response.body().asReader());
        } catch (IOException e) {
            log.error("feign.IOException", e);
        }
        if (response.status() >= 400 && response.status() <= 500) {
            throw Exceptions.badRequestParams(body);
        }
        return errorStatus(methodKey, response);
    }
}
