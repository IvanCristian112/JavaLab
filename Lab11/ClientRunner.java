package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ClientRunner implements CommandLineRunner {

    private final ClientService clientService;

    public ClientRunner(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void run(String... args) throws Exception {
        clientService.getGames()
                .doOnNext(gameList -> gameList.forEach(game -> System.out.println(game.getMoves())))
                .thenMany(clientService.getPlayers())
                .doOnNext(playerList -> playerList.forEach(player -> System.out.println(player.getName())))
                .subscribe(response -> System.out.println(response));
    }
}
