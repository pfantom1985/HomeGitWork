package tasktwo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;

public final class LoggerSingleton {

    private static LoggerSingleton instance;
    LocalDateTime dateTime = LocalDateTime.now();
    public String informationalText;

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
        try (FileOutputStream fos = new FileOutputStream("/Users/aleksey/GITwork/HomeGitWork/src/tasktwo/myLogFile.txt", true);
             PrintStream printStream = new PrintStream(fos)) {
            String logText = informationalText + " < " + dateTime + " >; ";
            byte[] message_toBytes = logText.getBytes();
            printStream.write(message_toBytes);
            System.out.println(" in file < " + "myLogFile.txt" + " > has been written.");
        } catch (IOException ex) {
            ex.getMessage();
            System.out.println(ex.getMessage());
        }
    }

}
