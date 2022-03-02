package br.inatel.c214.view;

import br.inatel.c214.model.Games;
import br.inatel.c214.model.Platform;
import br.inatel.c214.model.Publisher;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//import java.io.FileReader;

public class GamesView {

    public static List<Games> showGames(Path csvPath){

        List<Games> listaDeJogos=new ArrayList<>();

        try{
            Reader reader = Files.newBufferedReader(csvPath);
            CsvToBean<Games> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Games.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            listaDeJogos = csvToBean.parse();
        } catch(
                IOException e)

        {
            e.printStackTrace();
        }
        return listaDeJogos;

    }
    public ArrayList<Games> mostraGames(Path csvPath) {
        ArrayList<Games> listaGames = new ArrayList<>();

        try {
            Reader reader = Files.newBufferedReader(csvPath);
            CsvToBean<Games> csvToBean = new CsvToBeanBuilder(reader)//.withSkipLines(1).build();
                    .withType(Games.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            listaGames = (ArrayList<Games>) csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaGames;
    }

    public static List<Games> researchGamePlatform(List<Games> games, Platform platform){
        List<Games> platforms=new ArrayList<>();
        games.stream().filter(game->game.getPlatform().equals(platform.name())).forEach(game->platforms.add(game));
        return platforms;
    }

    public static List<Games> researchGamePublisher(List<Games> games, Publisher publisher){
        List<Games> publishers=new ArrayList<>();
        games.stream().filter(game->game.getPublisher().equals(publisher.name())).forEach(game->publishers.add(game));
        return  publishers;
    }
}
