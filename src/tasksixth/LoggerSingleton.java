package tasksixth;

import java.io.*;
import java.time.LocalDateTime;

public class LoggerSingleton {

    private static LoggerSingleton instance;
    public String informationalText;

    LocalDateTime dateTime = LocalDateTime.now();

    private LoggerSingleton(String informationalText) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.informationalText = informationalText;
    }

    public static synchronized LoggerSingleton getInstance(String informationalText) {
        if (instance == null) {
            instance = new LoggerSingleton(informationalText);
        }
        return instance;
    }

    public void fileWriter(String informationalText) {
        try (FileOutputStream fos = new FileOutputStream("/Users/aleksey/GITwork/HomeGitWork/src/tasksixth/myLogFile.txt", true);
             PrintStream printStream = new PrintStream(fos)) {
            String logText = informationalText + " < " + dateTime + " >; ";
            byte[] message_toBytes = logText.getBytes();
            printStream.write(message_toBytes);
            System.out.println(" is written to the file < " + "myLogFile.txt" + " >.");
        } catch (IOException e) {
            e.getMessage();
            System.out.println(e.getMessage());
        }
    }

}

