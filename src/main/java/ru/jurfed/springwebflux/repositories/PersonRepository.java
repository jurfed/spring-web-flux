package ru.jurfed.springwebflux.repositories;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.jurfed.springwebflux.domain.Person;




public interface PersonRepository extends ReactiveCrudRepository<Person, Integer> {


    Flux<Person> findByName(Mono<String> lastname);



}
