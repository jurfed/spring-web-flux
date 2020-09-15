package ru.jurfed.springwebflux.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import ru.jurfed.springwebflux.domain.Person;
import ru.jurfed.springwebflux.repositories.PersonRepository;

import java.time.Duration;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@RestController
@RequestMapping("/")
public class FluxController {


    private PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction() {
        HandlerFunction<ServerResponse> hello = request ->
                ok().body(fromPublisher(Flux.range(1, 10),
                        Integer.class));
        return route(GET("/hello"), hello);
    }

    @GetMapping("/customer")
    public Flux<Person> list() {
        return personRepository.findAll();
    }

    @Bean
    RouterFunction<ServerResponse> getEmployeeByIdRoute() {
        return route(GET("/employees/{id}"),
                req -> ok().body(
                        personRepository.findById(Integer.parseInt(req.pathVariable("id"))), Person.class));
    }
}
