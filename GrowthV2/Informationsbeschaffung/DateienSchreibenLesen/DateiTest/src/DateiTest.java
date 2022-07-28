import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class DateiTest
{
    File folder1 = new File("Folder");
    File file1 = new File("Folder/text.txt");

    public static void main(String[] args)
    {
        new DateiTest();
    }

    public DateiTest()
    {
        if(folder1.exists())
        {
            System.out.println("Folder exists!");
        } else
        {
            folder1.mkdir();
            System.out.println("Folder was created!");
        }

        if(file1.exists())
        {
            System.out.println("File exists!");
        } else
        {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Scanner sc = new Scanner(file1);

            while(sc.hasNext())
            {
                System.out.println(sc.next() +" ");
            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            OutputStream stream = new FileOutputStream(file1);

            String text = "Hallo Welt!\r\nDer Tag ist schön.";
            stream.write(text.getBytes());
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
