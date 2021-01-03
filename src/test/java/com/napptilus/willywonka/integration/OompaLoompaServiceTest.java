package com.napptilus.willywonka.integration;

import com.napptilus.willywonka.document.OompaLoompa;
import com.napptilus.willywonka.reactive.repository.OompaLoompaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * OompaLoompa Service Object Integration Test
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OompaLoompaServiceTest {

    /**
     * Property OompaLoompaRepository
     */
    private final OompaLoompaRepository repository;

    /**
     * Property ReactiveMongoOperations
     */
    private final ReactiveMongoOperations operations;

    /**
     * Parameterized Constructor
     * @param repository OompaLoompaRepository
     * @param operations ReactiveMongoOperations
     */
    public OompaLoompaServiceTest(@Autowired OompaLoompaRepository repository, @Autowired ReactiveMongoOperations operations) {
        this.repository = repository;
        this.operations = operations;
    }

    /**
     * BeforeEach Setup
     */
    @BeforeEach
    public void setUp() {
        operations.collectionExists(OompaLoompa.class)
                .flatMap(exists -> exists ? operations.dropCollection(OompaLoompa.class) : Mono.empty())
                .flatMap(o -> operations.createCollection(OompaLoompa.class, CollectionOptions.empty()))
                .then()
                .block();

        OompaLoompa oompaLoompa1 = OompaLoompa.builder()
                .name("Smith").age(Short.parseShort("23"))
                .height(52.3f).weight(78.8f)
                .jobTitle("Supervisor").description("Joined on Jan 2020")
                .createdAt(Date.from(Instant.now())).updatedAt(Date.from(Instant.now())).build();

        OompaLoompa oompaLoompa2 = OompaLoompa.builder()
                .name("John").age(Short.parseShort("26"))
                .height(57.3f).weight(88.8f)
                .jobTitle("Supervisor Tester").description("Joined on July 2020")
                .createdAt(Date.from(Instant.now())).updatedAt(Date.from(Instant.now())).build();

        OompaLoompa oompaLoompa3 = OompaLoompa.builder()
                .name("Stark").age(Short.parseShort("55"))
                .height(50.3f).weight(68.8f)
                .jobTitle("Senior Supervisor").description("Joined on Dec 2018")
                .createdAt(Date.from(Instant.now())).updatedAt(Date.from(Instant.now())).build();

        OompaLoompa oompaLoompa4 = OompaLoompa.builder()
                .id("45678998765678909")
                .name("Riyas").age(Short.parseShort("28"))
                .height(56.5f).weight(72.8f)
                .jobTitle("Developer").description("Joined on May 2019")
                .createdAt(Date.from(Instant.now())).updatedAt(Date.from(Instant.now())).build();

        repository
                .saveAll(Flux.just(oompaLoompa1, oompaLoompa2, oompaLoompa3, oompaLoompa4))
                .then()
                .block();
    }

    /**
     * Test FindAll Method
     */
    @Tag(value = "fast")
    @Test
    @DisplayName(value = "Get All OompaLoompa")
    public void findByAllTest() {
        Flux<OompaLoompa> oompaLoompaFlux = repository.findAll();
        assertThat(oompaLoompaFlux).isNotNull();
    }

    /**
     * Test FindByIdAndVerify Method
     */
    @Tag(value = "fast")
    @Test
    @DisplayName(value = "Find OompaLoompa Object And Verify")
    public void findByIdAndVerify() {
        OompaLoompa oompaLoompaMono = repository.findById("45678998765678909").block();
        assertThat(oompaLoompaMono).isNotNull();
        assertThat(oompaLoompaMono.getName()).isEqualTo("Riyas");
        assertThat(oompaLoompaMono.getJobTitle()).isEqualTo("Developer");
        assertThat(oompaLoompaMono.getHeight()).isEqualTo(56.5f);
    }

    /**
     * Test FindAllAndVerifySize Method
     */
    @Tag(value = "fast")
    @Test
    @DisplayName(value = "Find All OompaLoompa And Verify its Size")
    public void findAllAndVerifySize() {
        List<OompaLoompa> oompaLoompaList = repository.findAll().collectList().block();
        assertThat(oompaLoompaList).hasSize(4);
    }

    /**
     * Test FindByName Method
     */
    @Tag(value = "fast")
    @Test
    @DisplayName(value = "Find OompaLoompa Object By Name")
    public void findByName() {
        OompaLoompa oompaLoompa = repository.findByName("John").block();
        assertThat(oompaLoompa).isNotNull();
    }

}
