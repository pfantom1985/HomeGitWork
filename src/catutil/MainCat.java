package catutil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainCat {

    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String RED = "\033[0;31m";
    public static final String RESET = "\033[0m";

    private static final String CAT_DATA_BASE = "/Users/aleksey/GITwork/HomeGitWork/src/catutil/catDataFile.json";

    public static void main(String[] args) {

        CatBand catBand = CatUtil.createBand();
        Gson catGson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        System.out.println(RED + catGson.toJson(catBand) + RESET);

        try (FileOutputStream fos = new FileOutputStream(CAT_DATA_BASE)) {
            byte[] buffer = catGson.toJson(catBand).getBytes();
            fos.write(buffer, 0, buffer.length);
            System.out.println("Запись Cat в файл произведена!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        StringBuilder text = new StringBuilder();
        try (FileInputStream fin = new FileInputStream(CAT_DATA_BASE)) {
            byte[] buffer = new byte[256];
            int count;
            while ((count = fin.read(buffer)) != -1) {
                for (int i = 0; i < count; i++) {
                    System.out.print(YELLOW + (char) buffer[i] + RESET);
                    text.append((char) buffer[i]);
                }
            }
            System.out.println("\nФайл Cat из файла прочитан!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(BLUE + text + RESET);

        String catFromDataFile = String.valueOf(text);
        CatBand catBandTemp = new Gson().fromJson(catFromDataFile, CatBand.class);

        System.out.println(YELLOW + "Какие имеются ключи объектов: " + catBandTemp.getCatBand().entrySet() + RESET);
        System.out.println(GREEN + "Данные из объекта по ключу Betty: " + catBandTemp.getCatBand().get("Betty") + RESET);
        System.out.println(GREEN + "Содержимое объекта: "
                           + catBandTemp.getCatBand().get("Betty").getName() + " "
                           + catBandTemp.getCatBand().get("Betty").getColor() + " "
                           + catBandTemp.getCatBand().get("Betty").getAge()
                           + RESET);

        System.out.println(BLUE + "Данные из объекта по ключу Bonny: " + catBandTemp.getCatBand().get("Bonny") + RESET);
        System.out.println(BLUE + "Содержимое объекта: "
                           + catBandTemp.getCatBand().get("Bonny").getName() + " "
                           + catBandTemp.getCatBand().get("Bonny").getColor() + " "
                           + catBandTemp.getCatBand().get("Bonny").getAge()
                           + RESET);
    }
}

