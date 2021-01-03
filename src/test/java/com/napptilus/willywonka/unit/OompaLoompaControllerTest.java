package com.napptilus.willywonka.unit;

import com.napptilus.willywonka.api.controller.OompaLoompaController;
import com.napptilus.willywonka.document.OompaLoompa;
import com.napptilus.willywonka.reactive.repository.OompaLoompaRepository;
import com.napptilus.willywonka.reactive.service.IOompaLoompaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * OompaLoompa Controller Unit Test
 */
@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = OompaLoompaController.class)
@Import(OompaLoompaController.class)
public class OompaLoompaControllerTest {

    /**
     * Property IoompaLoompaService
     * Mock Bean
     */
    @MockBean
    private IOompaLoompaService oompaLoompaService;

    /**
     * Property OompaLoompaRepository
     * Mock Bean
     */
    @MockBean
    private OompaLoompaRepository repository;

    /**
     * Property WebTestClient
     */
    @Autowired
    private WebTestClient webClient;

    /**
     * Test Get All Method
     */
    @Tag(value = "fast")
    @Test
    @DisplayName(value = "Get All OompaLoompa")
    void testGetAllOompaLoompa() {
        OompaLoompa oompaLoompa1 = OompaLoompa.builder()
                .name("Stark").age(Short.parseShort("55"))
                .height(50.3f).weight(68.8f)
                .jobTitle("Senior Supervisor").description("Joined on Dec 2018")
                .createdAt(Date.from(Instant.now())).updatedAt(Date.from(Instant.now())).build();

        OompaLoompa oompaLoompa2 = OompaLoompa.builder()
                .name("John").age(Short.parseShort("26"))
                .height(57.3f).weight(88.8f)
                .jobTitle("Supervisor Tester").description("Joined on July 2020")
                .createdAt(Date.from(Instant.now())).updatedAt(Date.from(Instant.now())).build();

        List<OompaLoompa> list = new ArrayList<>(Arrays.asList(oompaLoompa1, oompaLoompa2));
        Flux<OompaLoompa> oompaLoompaFlux = Flux.fromIterable(list);

        Mockito.when(oompaLoompaService.findAll()).thenReturn(oompaLoompaFlux);

        List<OompaLoompa> oompaLoompaList = webClient.get().uri("/api")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(OompaLoompa.class).returnResult().getResponseBody();

        Mockito.verify(oompaLoompaService, times(1)).findAll();
        assertThat(oompaLoompaList).isNotNull();
        assertThat(oompaLoompaList).hasSize(2);
    }

    /**
     * Test Get By Id Method
     */
    @Tag(value = "fast")
    @Test
    @DisplayName(value = "Get OompaLoompa By Id")
    void testGetOompaLoompaById() {
        OompaLoompa oompaLoompa = OompaLoompa.builder()
                .id("9456789987678")
                .name("Stark").age(Short.parseShort("55"))
                .height(50.3f).weight(68.8f)
                .jobTitle("Senior Supervisor").description("Joined on Dec 2018")
                .createdAt(Date.from(Instant.now())).updatedAt(Date.from(Instant.now())).build();

        Mono<OompaLoompa> oompaLoompaMono = Mono.just(oompaLoompa);

        Mockito.when(oompaLoompaService.findById("9456789987678")).thenReturn(oompaLoompaMono);

        webClient.get().uri("/api/{id}", "9456789987678")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus().isOk()
                .expectBody(OompaLoompa.class);

        Mockito.verify(oompaLoompaService, times(1)).findById("9456789987678");
    }

    /**
     * Test Get By Id With JsonPath Method
     */
    @Tag(value = "fast")
    @Test
    @DisplayName(value = "Get OompaLoompa By Id And JsonPath")
    void testGetOompaLoompaByIDWithJsonPath() {
        OompaLoompa oompaLoompa = OompaLoompa.builder()
                .id("9456789987678")
                .name("Stark").age(Short.parseShort("55"))
                .height(50.3f).weight(68.8f)
                .jobTitle("Senior Supervisor").description("Joined on Dec 2018")
                .createdAt(Date.from(Instant.now())).updatedAt(Date.from(Instant.now())).build();

        Mono<OompaLoompa> oompaLoompaMono = Mono.just(oompaLoompa);

        Mockito.when(oompaLoompaService.findById("9456789987678")).thenReturn(oompaLoompaMono);

        webClient.get().uri("/api/{id}", "9456789987678")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name").isNotEmpty()
                .jsonPath("$.id").isEqualTo("9456789987678")
                .jsonPath("$.height").isEqualTo(50.3f)
                .jsonPath("$.weight").isEqualTo(68.8f);

        Mockito.verify(oompaLoompaService, times(1)).findById("9456789987678");

    }

    /**
     * Test Save Method
     */
    @Tag(value = "fast")
    @Test
    @DisplayName(value = "Save OompaLoompa")
    void testPostOompaLoompa() {
        OompaLoompa oompaLoompa = OompaLoompa.builder()
                .id("567898765678")
                .name("John").age(Short.parseShort("26"))
                .height(57.3f).weight(88.8f)
                .jobTitle("Supervisor Tester").description("Joined on July 2020")
                .createdAt(Date.from(Instant.now())).updatedAt(Date.from(Instant.now())).build();

        Mockito.when(oompaLoompaService.save(any())).thenReturn(Mono.just(oompaLoompa));

        OompaLoompa responseBody = webClient.post()
                .uri("/api")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(oompaLoompa))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(OompaLoompa.class).returnResult().getResponseBody();

        Mockito.verify(oompaLoompaService, times(1)).save(any());
        assertThat(responseBody).isNotNull();
        assertThat(responseBody.getName()).isEqualTo("John");
    }

    /**
     * Test Update Method
     */
    @Tag(value = "fast")
    @Test
    @DisplayName(value = "Update OompaLoompa")
    void testUpdateOompaLoompa() {
        OompaLoompa oompaLoompa = OompaLoompa.builder()
                .id("567898765678")
                .name("John").age(Short.parseShort("26"))
                .height(57.3f).weight(88.8f)
                .jobTitle("Supervisor Tester").description("Joined on July 2020")
                .createdAt(Date.from(Instant.now())).updatedAt(Date.from(Instant.now())).build();

        OompaLoompa updatedOompaLoompa = oompaLoompa.toBuilder().name("John Smith").build();

        Mockito.when(oompaLoompaService.findById("567898765678")).thenReturn(Mono.just(oompaLoompa));

        Mockito.when(oompaLoompaService.save(any())).thenReturn(Mono.just(updatedOompaLoompa));

        OompaLoompa responseBody = webClient.put()
                .uri("/api/{id}", "567898765678")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(oompaLoompa))
                .exchange()
                .expectStatus().isOk()
                .expectBody(OompaLoompa.class).returnResult().getResponseBody();

        Mockito.verify(oompaLoompaService, times(1)).findById("567898765678");
        Mockito.verify(oompaLoompaService, times(1)).save(any());
        assertThat(responseBody).isNotNull();
        assertThat(responseBody.getName()).isEqualTo("John Smith");
    }
}
