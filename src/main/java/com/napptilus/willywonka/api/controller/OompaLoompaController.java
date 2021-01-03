package com.napptilus.willywonka.api.controller;

import com.napptilus.willywonka.api.request.OLRequest;
import com.napptilus.willywonka.api.response.OLResponse;
import com.napptilus.willywonka.document.OompaLoompa;
import com.napptilus.willywonka.reactive.service.IOompaLoompaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static com.napptilus.willywonka.helper.WebHelper.PER_PAGE_COUNT;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isNumeric;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * OompaLoompa Rest Controller
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class OompaLoompaController {

    /**
     * Property service Object
     */
    private final IOompaLoompaService oompaLoompaService;

    /**
     * Constructor
     * @param oompaLoompaService oompaloompa service obj
     */
    public OompaLoompaController(@Autowired IOompaLoompaService oompaLoompaService) {
        this.oompaLoompaService = oompaLoompaService;
    }

    /**
     * Get All Method
     * @param page pageno
     * @param limit records count per page
     * @return list of oompa loompa
     */
    @GetMapping
    public ResponseEntity<Flux<OLResponse>> getAllOompaLoompas(@RequestParam(value = "page", required = false) String page,
                                                               @RequestParam(value = "limit", required = false) String limit) {
        LOG.info("Open getAllOompaLoompas {}", this.getClass().getSimpleName());
        long offset = isNotEmpty(page) && isNumeric(page) ? Integer.parseInt(page) : 0;
        long size = isNotEmpty(limit) && isNumeric(limit) ? Integer.parseInt(limit) : PER_PAGE_COUNT;
        Flux<OLResponse> olResponseFlux = oompaLoompaService.findAll().skip(offset * size).take(size).flatMap(oompaLoompa -> {
            OLResponse response = OLResponse.builder().name(oompaLoompa.getName()).age(oompaLoompa.getAge()).jobTitle(oompaLoompa.getJobTitle()).build();
            return Flux.just(response).cache(Duration.ofSeconds(2));
        });
        return ResponseEntity.ok(olResponseFlux);
    }

    /**
     * Get By Id Method
     * @param id string
     * @return OompaLoompa Object
     */
    @GetMapping("/{id}")
    public ResponseEntity<Mono<OompaLoompa>> getOompaLoompaByID(@PathVariable("id") String id) {
        LOG.info("Open getOompaLoompaByID {}", this.getClass().getSimpleName());
        return ResponseEntity.ok(oompaLoompaService.findById(id).cache(Duration.ofSeconds(2)));
    }

    /**
     * Save Method
     * @param olRequest Oompaloompa dto
     * @return Oompaloompa object
     */
    @PostMapping
    public ResponseEntity<Mono<OompaLoompa>> addOompaLoompa(@RequestBody OLRequest olRequest) {
        LOG.info("Open addOompaLoompa {}", this.getClass().getSimpleName());
        OompaLoompa oompaLoompa = OompaLoompa.builder().name(olRequest.getName()).age(olRequest.getAge())
                .height(olRequest.getHeight()).weight(olRequest.getWeight()).jobTitle(olRequest.getJobTitle())
                .description(olRequest.getDescription()).createdAt(Date.from(Instant.now())).updatedAt(Date.from(Instant.now())).build();

        return new ResponseEntity<>(oompaLoompaService.save(oompaLoompa).cache(Duration.ofSeconds(2)), HttpStatus.CREATED);
    }

    /**
     * Update Method
     * @param id string
     * @param olRequest oompaloompa dto
     * @return oompaloompa Object
     */
    @PutMapping("/{id}")
    public ResponseEntity<Mono<OompaLoompa>> updateOompaLoompaByID(@PathVariable("id") String id, @RequestBody OLRequest olRequest) {
        LOG.info("Open updateOompaLoompaByID {}", this.getClass().getSimpleName());
        Mono<OompaLoompa> savedOompaLoompa = oompaLoompaService.findById(id);

        Mono<OompaLoompa> updatedOompaLoompa = savedOompaLoompa.flatMap(oompaLoompa -> {
            OompaLoompa modifiedOompaLoompa = oompaLoompa.toBuilder().name(olRequest.getName()).age(olRequest.getAge())
                    .height(olRequest.getHeight()).weight(olRequest.getWeight()).jobTitle(olRequest.getJobTitle())
                    .description(olRequest.getDescription()).updatedAt(Date.from(Instant.now())).build();

            return oompaLoompaService.save(modifiedOompaLoompa).cache(Duration.ofSeconds(2));
        });

        return new ResponseEntity<>(updatedOompaLoompa, HttpStatus.OK);
    }
}
