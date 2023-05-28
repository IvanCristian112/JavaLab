package com.example.demo;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ClientService {

    private final WebClient webClient;
    private Database database = Database.getInstance();

    public ClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082").build(); // replace with the URL of the service
    }

    public Mono<List<Game>> getGames() {
        return webClient.get()
                .uri("/games")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Game>>() {
                });
    }

    public Mono<List<Player>> getPlayers() {
        return webClient.get()
                .uri("/players")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Player>>() {
                });
    }


    public Mono<ResponseEntity<String>> addPlayer(String name) {
        Player player = new Player(name, database.getPlayers().size() + 1);
        return webClient.post()
                .uri("/players")
                .bodyValue(player)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ResponseEntity<String>>() {
                });
    }


    public Mono<ResponseEntity<String>> updatePlayer(int id, String name) {
        return webClient.put()
                .uri("/players/" + id)
                .bodyValue(name)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ResponseEntity<String>>() {
                });
    }

    public Mono<ResponseEntity<String>> deletePlayer(int id) {
        return webClient.delete()
                .uri("/players/" + id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ResponseEntity<String>>() {
                });
    }

}
