package taskten;
/*
Задание 75. Напишите программу, которая будет разбирать xml файл с помощью StAX и выводит его
            на экран в текстовом виде.Каждая точка должна выводитьcя на отдельной строке в виде двух
            чисел, разделенных зарятой, при этом должна ыводиться единица измерения. Например: 10рх, 30рх.
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StaxProject {

    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String RESET = "\033[0m";

    public static void main(String[] args) {
        final String fileName = "testxml.xml";

        try {
            XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(fileName, new FileInputStream(fileName));

            while (xmlr.hasNext()) {
                xmlr.next();
                if (xmlr.isStartElement()) {
                    System.out.println(BLUE + xmlr.getLocalName() + RESET);
                } else if (xmlr.isEndElement()) {
                    System.out.println(GREEN + "/" + xmlr.getLocalName() + RESET);
                } else if (xmlr.hasText() && xmlr.getText().trim().length() > 0) {
                    System.out.println(YELLOW + "   " + xmlr.getText() + RESET);
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
