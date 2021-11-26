package fr.gamedev.question.greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author djer1
 */
@RestController
public class GreetingController {

/**@param
*Pré-format du greeting
 */
private static final String TEMPLATE = "Hello, %s!";
/**@param
 *Compteur du nombre de greeting
 */
private final AtomicLong counter = new AtomicLong();

@GetMapping("/greeting")
public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") final String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
}
}
