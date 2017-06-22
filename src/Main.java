import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static String rawData[][];
    private static String classificationProbability[][];
    private static Scanner scanner;

    private static int lengthColumn;
    private static int lengthRow;
    private static int probabilityAnswer;

    public static void main(String[] args) {
        readFile();

        rawData   = new String[lengthRow][lengthColumn];

        saveFileData();
        classificationProbability();
        printData();
    }

    /**
     * Digunakan untuk membaca file txt
     */
    private static void readFile()
    {
        try
        {
            scanner = new Scanner(new File("src/sources/weather.txt"));
            int i = 0;
            while (scanner.hasNext())
            {
                String data = scanner.nextLine();
                String arrayData[] = data.split("\\s",-1);
                lengthColumn = arrayData.length;
                i++;
                lengthRow = i;
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception: "+e);
        }
    }

    /**
     * Digunakan untuk menyimpan data dalam variable local
     */
    private static void saveFileData()
    {
        try
        {
            scanner = new Scanner(new File("src/sources/weather.txt"));
            int lastState = 0;
            while (scanner.hasNext())
            {
                String data = scanner.nextLine();
                String newValue[] = data.split("\\s",-1);
                for (int i = lastState; i < lengthRow; i++)
                {
                    for (int j = 0; j < lengthColumn; j++)
                    {
                        rawData[i][j] = newValue[j];
                    }
                }
                lastState++;
            }
        }
        catch (Exception e)
        {
            System.out.print("Exception: "+e);
        }
    }

    /**
     * Digunakan untuk melakukan klasifikasi jawaban yang akan muncul
     */
    private static void classificationProbability()
    {
        ArrayList<String> currentAnswer = new ArrayList<>();
        for (int i = 0; i < lengthRow; i++)
        {
            if(!currentAnswer.contains(rawData[i][lengthColumn-1]))
            {
                currentAnswer.add(rawData[i][lengthColumn-1]);
            }
        }

        System.out.println(currentAnswer);
    }

    /**
     * Digunakan untuk melakukan debugging terhadap variable local
     */
    private static void printData()
    {
        for (int i = 0; i < lengthRow; i++)
        {
            for (int j = 0; j < lengthColumn; j++)
            {
                System.out.print(rawData[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
