package com.napptilus.willywonka.reactive.repository;

import com.napptilus.willywonka.document.OompaLoompa;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * OompaLoompa Reactive Repository
 */
@Repository
public interface OompaLoompaRepository extends ReactiveMongoRepository<OompaLoompa, String> {

    /**
     * Find By Name Method
     * @param name name
     * @return OompaLoompa
     */
    Mono<OompaLoompa> findByName(String name);

}
