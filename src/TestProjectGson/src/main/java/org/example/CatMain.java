package org.example;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.example.CatColorText.*;

public class CatMain {
    public static void main(String[] args) {

        CatTeam catTeamToGson = CatCreate.createCat();

        try (FileWriter writer = new FileWriter("dataFile.json")) {
            Gson gson = new Gson();
            writer.write(gson.toJson(catTeamToGson));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader("dataFile.json")) {
            Gson gson = new Gson();
            CatTeam catTeamFromGson = gson.fromJson(reader, CatTeam.class);
            printColor(catTeamFromGson.getCatTeamBand().toString(), GREEN);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
