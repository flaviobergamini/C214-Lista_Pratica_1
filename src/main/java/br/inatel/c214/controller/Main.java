package br.inatel.c214.controller;

import br.inatel.c214.model.Games;
import br.inatel.c214.model.Platform;
import br.inatel.c214.model.Publisher;
import br.inatel.c214.view.GamesView;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;

import java.io.File;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            Path path = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
            List<Games> gameList = GamesView.showGames(path);

            List<Games> gameListPC = GamesView.researchGamePlatform(gameList, Platform.PC);
            System.out.println("-----------PC Platform-----------");
            System.out.println("Number of games: " + gameListPC.size());
            System.out.println("=-=-=-=-=-=-=-Games-=-=-=-=-=-=-=");
            for (Games pc:gameListPC) {
                System.out.println(pc.getName());
            }

            List<Games> gamesListActivision = GamesView.researchGamePublisher(gameList, Publisher.Activision);
            System.out.println("\n\n------Activision Publisher-------");
            System.out.println("Number of games: " + gamesListActivision.size());
            System.out.println("=-=-=-=-=-=-=-Games-=-=-=-=-=-=-=");
            for (Games g:gamesListActivision) {
                System.out.println(g.getName());
            }
        }catch(URISyntaxException e){
            System.out.println("Erro: " + e.getMessage());
        }


    }
}
