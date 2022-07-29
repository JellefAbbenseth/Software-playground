package Game;

import java.io.*;
import java.util.Scanner;

public class SaveGame {

    File saveGame = new File("SaveGame");
    File saveOne = new File("SaveGame/saveOne.txt");
    File saveTwo = new File("SaveGame/saveTwo.txt");
    File saveThree = new File("SaveGame/saveThree.txt");

    public void SaveMyGame(String textSaveGame, int i) {

        if (!saveGame.exists()) saveGame.mkdir();

        switch (i) {
            case 1:
                if(!saveOne.exists()) CreateSaveOne();
                try{
                    OutputStream stream = new FileOutputStream(saveOne);
                    stream.write(textSaveGame.getBytes());
                    stream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                if(!saveTwo.exists()) CreateSaveTwo();
                try{
                    OutputStream stream = new FileOutputStream(saveTwo);
                    stream.write(textSaveGame.getBytes());
                    stream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                if(!saveThree.exists()) CreateSaveThree();
                try{
                    OutputStream stream = new FileOutputStream(saveThree);
                    stream.write(textSaveGame.getBytes());
                    stream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private void CreateSaveOne() {

        try{
            saveOne.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void CreateSaveTwo() {

        try{
            saveTwo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void CreateSaveThree() {

        try{
            saveThree.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean SaveGameExists(){
        boolean exists = FolderExists();

        if(exists) exists = SaveExists();

        return exists;
    }

    public boolean FolderExists(){
        boolean exists = false;

        if (saveGame.exists()) {
            exists = true;
        }

        return exists;
    }

    public boolean SaveExists(){
        boolean exists = false;

        if(saveOne.exists()) exists = true;
        else if(saveTwo.exists()) exists = true;
        else if(saveThree.exists()) exists = true;

        return exists;
    }

    public boolean SaveExists(int i){
        boolean exists = false;

        switch (i) {
            case 1: if(saveOne.exists()) exists = true;
                break;
            case 2: if(saveTwo.exists()) exists = true;
                break;
            case 3: if(saveThree.exists()) exists = true;
        }
        return exists;
    }

    public String loadMyGame(int i) {
        String text = "noGame";

        if(saveGame.exists()){
            switch (i) {
                case 1: if(saveOne.exists()) {
                            text = "";
                            try {
                                Scanner sc = new Scanner(saveOne);
                                while (sc.hasNext()) {
                                    text += sc.next();
                                }
                                sc.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    break;
                case 2: if(saveTwo.exists()){
                            text = "";
                            try{
                                Scanner sc = new Scanner(saveTwo);
                                while (sc.hasNext()) {
                                    text += sc.next();
                                }
                                sc.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    break;
                case 3: if(saveThree.exists()){
                    text = "";
                    try{
                        Scanner sc = new Scanner(saveThree);
                        while (sc.hasNext()) {
                            text += sc.next();
                        }
                        sc.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return text;
    }
}
