package com.me.poc.repository;

import com.me.poc.domain.game.Game;
import com.me.poc.domain.game.Player;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class GameRepository {

    static final String DEFAULT_LOCATION = "data/";
    static final String DEFAULT_EXTENSION = ".ser";

    static final boolean SUCCESS = Boolean.TRUE;
    static final boolean FAILURE = Boolean.FALSE;

    public void save(Game game, String fileName) {


    }

    public boolean savePlayer(Player player, String fileName) {

        String pathToFile = DEFAULT_LOCATION + fileName + DEFAULT_EXTENSION;


        Path path = Paths.get(DEFAULT_LOCATION);
        boolean pathExists =
                Files.exists(path,
                        new LinkOption[]{LinkOption.NOFOLLOW_LINKS});

        if (!pathExists) {
            try {
                Path newDir = Files.createDirectory(path);
            } catch (FileAlreadyExistsException e) {
                // the directory already exists.
            } catch (IOException e) {
                //something else went wrong
                e.printStackTrace();
            }
        }
        try (FileOutputStream fileOut =
                     new FileOutputStream(pathToFile);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(player);

            System.out.printf("Serialized data is saved in " +pathToFile);

            return SUCCESS;
        } catch (IOException e) {
            e.printStackTrace();
            return FAILURE;
        }
    }


    public List<String> list() {

        System.out.println("Listing  games for location: " + DEFAULT_LOCATION);
        Path path = Paths.get(DEFAULT_LOCATION);
        List<String> filesFound = new ArrayList<>();

        if (!Files.exists(path,
                new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
            return filesFound;
        }


        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileString = file.getFileName().toString();


                    if (fileString.endsWith(DEFAULT_EXTENSION)) {
                        System.out.println("file found at path: " + file.toAbsolutePath());
                        filesFound.add(fileString.substring(0, fileString.lastIndexOf(DEFAULT_EXTENSION)));
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filesFound;
    }

    public Game findByName(String name) {
        //TODO: to implement
        System.out.println("Found  game for name: " + name);
        return null;
    }

    public Player readPlayer(String fileName) {

        Player deserializedPlayer = null;
        String pathToFile = DEFAULT_LOCATION + fileName + DEFAULT_EXTENSION;

        Path path = Paths.get(pathToFile);

        boolean pathExists =
                Files.exists(path,
                        new LinkOption[]{LinkOption.NOFOLLOW_LINKS});

        if (!pathExists) {
            System.out.println("File not found");
            return null;
        }

        try (FileInputStream fileIn = new FileInputStream(path.toFile());
             ObjectInputStream in = new ObjectInputStream(fileIn);) {

            return (Player) in.readObject();

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }


        return null;
    }

    public Game read(String fileName) {


        return null;
    }

}
