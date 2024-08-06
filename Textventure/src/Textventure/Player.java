package Textventure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    String playerName;
    Integer healthPoints;
    Integer damage;
    Integer heal;
    Integer progress = 0;
    Integer damageOverTime = 0;
    List<String> inventory;
    List<String> knowledge;
    List<String> contact;

    public Player(String initialPlayerName, Integer initialHealthPoints) {
        this.playerName = initialPlayerName;
        this.healthPoints = initialHealthPoints;
        this.inventory = new ArrayList<String>();
        this.knowledge = new ArrayList<String>();
        this.contact = new ArrayList<String>();
    }

    public void hurtPlayer(Integer intitalDamage) {
        this.damage = intitalDamage;
        this.healthPoints -= intitalDamage;
        if (this.healthPoints.equals(0)) {
            gameOver();
        }
    }

    public void healPlayer(Integer initialHeal) {
        this.heal = initialHeal;
        this.healthPoints += initialHeal;
        if (this.healthPoints.equals(0)) {
            gameOver();
        }
    }

    public void gameOver() {
        System.out.println(this.playerName + " Died!");
        System.out.println("GAME OVER!");
        System.exit(0);
    }

    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream("savegame" + playerName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            DataStorage dStorage = new DataStorage();
            dStorage.playerName = this.playerName;
            dStorage.healthPoints = this.healthPoints;
            dStorage.progress = this.progress;
            dStorage.inventory = this.inventory;
            dStorage.knowledge = this.knowledge;
            dStorage.contact = this.contact;
            oos.writeObject(dStorage);
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void load() {
        try {
            FileInputStream fis = new FileInputStream("savegame" + playerName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            DataStorage dStorage = (DataStorage) ois.readObject();
            this.playerName = dStorage.playerName;
            this.healthPoints = dStorage.healthPoints;
            this.progress = dStorage.progress;
            this.inventory = dStorage.inventory;
            this.knowledge = dStorage.knowledge;
            this.contact = dStorage.contact;
            ois.close();
            //System.out.println(dStorage);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void gimme() {
        System.out.println("Your playername is: "+this.playerName);
        System.out.println("Your focus is: "+this.healthPoints);
        System.out.println("Your progress value is: "+this.progress);
        System.out.println("Your inventory contains: "+this.inventory);
        System.out.println("Your knowledge is: "+this.knowledge);
        System.out.println("Your contact is: "+this.contact);
    }

    public void headache() {
        if (this.damageOverTime >= 1) {
            this.healthPoints--;
            this.damageOverTime--;
            System.out.println("You lost 1 focus because of your headache!");
        }
    }
}
