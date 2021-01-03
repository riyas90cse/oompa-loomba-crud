package com.napptilus.willywonka.reactive.service;

import com.napptilus.willywonka.document.OompaLoompa;
import com.napptilus.willywonka.reactive.repository.OompaLoompaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * OompaLoompa Service Implementation
 */
@Service
@Slf4j
public class OompaLoompaService implements IOompaLoompaService {

    /**
     * Property OL Repository Object
     */
    private final OompaLoompaRepository oompaLoompaRepository;

    /**
     * Constructor
     * @param oompaLoompaRepository oompaLoompaRepository
     */
    public OompaLoompaService(@Autowired OompaLoompaRepository oompaLoompaRepository) {
        this.oompaLoompaRepository = oompaLoompaRepository;
    }

    /**
     * Save Method
     * @param oompaLoompa object
     * @return object
     */
    @Override
    public Mono<OompaLoompa> save(OompaLoompa oompaLoompa) {
        LOG.info("Save Oompa Loompa Document {}", oompaLoompa);
        return oompaLoompaRepository.save(oompaLoompa);
    }

    /**
     * Save All Method
     * @param oompaLoompas list of object
     * @return Objects
     */
    @Override
    public Flux<OompaLoompa> saveAll(List<OompaLoompa> oompaLoompas) {
        LOG.info("Save all Oompa Loompa Documents - total size {}", oompaLoompas.size());
        return oompaLoompaRepository.saveAll(oompaLoompas);
    }

    /**
     * Find By Id Method
     * @param id String
     * @return Object
     */
    @Override
    public Mono<OompaLoompa> findById(String id) {
        LOG.info("Find Oompa Loompa Document by ID {}", id);
        return oompaLoompaRepository.findById(id);
    }

    /**
     * Find All Method
     * @return list of Objects
     */
    @Override
    public Flux<OompaLoompa> findAll() {
        LOG.info("Find all Oompa Loompa Documents");
        return oompaLoompaRepository.findAll();
    }

}
