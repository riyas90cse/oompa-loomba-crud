package com.napptilus.willywonka.integration;

import com.napptilus.willywonka.api.response.OLResponse;
import com.napptilus.willywonka.document.OompaLoompa;
import com.napptilus.willywonka.reactive.service.IOompaLoompaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * Controller API Integration Test
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OompaLoompaAPITest {

    /**
     * Property Server Port No
     */
    @Value("${server.port}")
    private int serverPort;

    /**
     * Property Host URI
     */
    private String uriHost = "http://localhost:";

    /**
     * Property OompaLoompa Service Interface Object
     * Autowiring & SpyBean
     */
    @SpyBean
    @Autowired
    private IOompaLoompaService oompaLoompaService;

    /**
     * Property WebClient
     */
    private WebClient webClient;

    /**
     * Before Each Method Setup
     */
    @BeforeEach
    public void setUp() {
        webClient = WebClient.create();
    }

    /**
     * Test Get All Method
     */
    @Tag(value = "fast")
    @Test
    @DisplayName(value = "Get All OompaLoompa")
    public void getAllAPI() {
        OompaLoompa oompaLoompa = OompaLoompa.builder()
                .name("Smith").age(Short.parseShort("23"))
                .height(52.3f).weight(78.8f)
                .jobTitle("Supervisor").description("Joined on Jan 2020")
                .createdAt(Date.from(Instant.now())).updatedAt(Date.from(Instant.now())).build();
        oompaLoompaService.save(oompaLoompa);

        Flux<OLResponse> olResponseFlux = webClient.get().uri(uriHost + serverPort + "/api")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve().bodyToFlux(OLResponse.class);

        olResponseFlux.subscribe(olResponse -> {
            assertThat(olResponse).isNotNull();
            assertThat(olResponse.getAge()).isEqualTo(Short.parseShort("23"));
        });

    }

    /**
     * Test Save Method
     */
    @Tag(value = "fast")
    @Test
    @DisplayName(value = "Save Oompa Loompa")
    public void postAPI() {
        OompaLoompa oompaLoompa = OompaLoompa.builder()
                .name("Riyas").age(Short.parseShort("28"))
                .height(56.5f).weight(72.8f)
                .jobTitle("Developer").description("Joined on May 2019").build();

        Mono<OompaLoompa> oompaLoompaMono = webClient.post()
                .uri(uriHost + serverPort + "/api")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(oompaLoompa))
                .retrieve().bodyToMono(OompaLoompa.class);

        oompaLoompaMono.subscribe(olResponse -> {
            assertThat(olResponse).isNotNull();
            assertThat(olResponse.getId()).isNotNull();
            assertThat(olResponse.getAge()).isEqualTo(Short.parseShort("28"));
            assertThat(olResponse.getCreatedAt()).isNotNull();
        });

    }

    /**
     * Test Update Method
     */
    @Tag(value = "fast")
    @Test
    @DisplayName(value = "Update Oompa Loompa")
    public void putAPI() {
        OompaLoompa oompaLoompa = OompaLoompa.builder()
                .name("Stark").age(Short.parseShort("55"))
                .height(50.3f).weight(68.8f)
                .jobTitle("Senior Supervisor").description("Joined on Dec 2018")
                .createdAt(Date.from(Instant.now())).updatedAt(Date.from(Instant.now())).build();
        OompaLoompa savedOompaLoompa = oompaLoompaService.save(oompaLoompa).block();

        assert savedOompaLoompa != null;
        String updatedId = savedOompaLoompa.getId();
        OompaLoompa modifiedOompaLoompa = OompaLoompa.builder()
                .name("Tony Stark").age(Short.parseShort("67"))
                .height(55.3f).weight(78.5f)
                .jobTitle("Supervisor").description("Joined on Dec 2016").build();

        Mono<OompaLoompa> oompaLoompaMono = webClient.put()
                .uri(uriHost + serverPort + "/api/" + updatedId)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(modifiedOompaLoompa))
                .retrieve().bodyToMono(OompaLoompa.class);

        oompaLoompaMono.subscribe(olResponse -> {
            assertThat(olResponse).isNotNull(); // should not be null
            assertThat(olResponse.getId()).isEqualTo(updatedId); // id should be same
            // age should be same as modified OompaLoompa
            assertThat(olResponse.getAge()).isEqualTo(modifiedOompaLoompa.getAge());
            assertThat(olResponse.getName()).isEqualTo(modifiedOompaLoompa.getName());
            // createdAt should be same as original OompaLoompa createdAt
            assertThat(olResponse.getCreatedAt()).isEqualTo(oompaLoompa.getCreatedAt());
            assertThat(olResponse.getUpdatedAt()).isNotNull();
            // updatedAt should not be same as original OompaLoompa updatedAt
            assertThat(olResponse.getUpdatedAt()).isNotEqualTo(oompaLoompa.getUpdatedAt());
        });

    }

}