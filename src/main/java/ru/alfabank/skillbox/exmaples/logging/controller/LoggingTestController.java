package ru.alfabank.skillbox.exmaples.logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Slf4j
@RestController
public class LoggingTestController {

    @GetMapping
    public ResponseEntity<?> get(WebRequest request, @RequestParam String param1) {
        log.trace("A TRACE message with {}", param1);
        var elements = List.of(param1);
        log.debug("A DEBUG Message with param {} and elements {}", param1, elements);
        log.info("An INFO Message for logging request {}", request);
        log.warn("A WARN Message ");
        try {
            doSomething();
        } catch (Exception ex) {
            log.error("An ERROR Message", ex);
        }
        return ResponseEntity.ok("Hello, world!!!");
    }

    private void doSomething() {
        throw new RuntimeException("Inner Exception occur");
    }
}
