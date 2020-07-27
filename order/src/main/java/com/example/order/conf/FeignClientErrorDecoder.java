//package com.example.order.conf;
//
//import feign.Response;
//import feign.Util;
//import feign.codec.ErrorDecoder;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//import java.nio.charset.Charset;
//
//@Slf4j
//@Configuration
//public class FeignClientErrorDecoder implements ErrorDecoder {
////    private static final Gson gson = new Gson();
//
//    @Override
//    public Exception decode(String s, Response response) {
//        if (response.status() >= 400 && response.status() <= 499) {
////            return new StashClientException(
////                    response.status(),
////                    response.reason()
////            );
//            System.out.println(response.status());
//            System.out.println(response.reason());
//        }
//        if (response.status() >= 500 && response.status() <= 599) {
////            return new StashServerException(
////                    response.status(),
////                    response.reason()
////            );
//            try {
//                String abc = Util.toString(response.body().asReader());
//                String errorContent = Util.toString(response.body().asReader(Charset.defaultCharset()));
//                int a = 0;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println(response.status());
//            System.out.println(response.reason());
//        }
////        return errorStatus(methodKey, response);
//        return new Exception(response.reason());
//
////        if (response.status() != HttpStatus.OK.value()) {
////            if (response.status() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
////                String errorContent;
////                try {
////                    errorContent = Util.toString(response.body().asReader());
//////                    InternalApiException internalApiException = gson.fromJson(errorContent, InternalApiException.class);
//////                    return internalApiException;
////                    int a = 0;
////                } catch (IOException e) {
////                    log.error("handle error exception");
//////                    return new InternalApiException(500, "unknown error");
////                }
////            }
////        }
////        return new Exception();
//    }
//}
