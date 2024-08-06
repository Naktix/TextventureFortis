package Textventure;

import java.io.File;
import java.util.Scanner;

public class Logic {
    public Logic() {

    }

    public boolean checkSaveGame(Player player) {
        File dStorage = new File("C:/Users/nilsb/Desktop/IntelliJ/Textventure/Textventure/savegame" + player.playerName); //filepath hier rein!
        boolean exist = dStorage.exists();
        return exist;
    }

    public void chooseStory(Player player, Storyteller story) {
        switch (player.progress) {
            case 0:
                player.save();
                story.askForContact(player);
                player.progress = 1;
                break;
            case 1:
                player.save();
                story.story1(player);
                player.progress = 2;
                break;
            case 2:
                player.save();
                story.story2(player);
                break;
            case 3:
                player.save();
                story.story3(player);
                break;
            case 4:
                player.save();
                story.story4(player);
                break;
            case 5:
                player.save();
                story.story5(player);
                break;
            case 6:
                player.save();
                story.story6(player);
                break;
            case 7:
                player.save();
                story.story7(player);
                break;
            case 8:
                player.save();
                story.story8(player);
                break;
            case 9:
                player.save();
                story.story9(player);
                break;
            case 10:
                player.save();
                story.story10(player);
                break;
            case 11:
                player.save();
                story.story11(player);
                break;
            case 12:
                player.save();
                story.story12(player);
                break;
            case 13:
                player.save();
                story.story13(player);
                break;
            case 14:
                player.save();
                story.story14(player);
                break;
            case 15:
                player.save();
                story.story15(player);
                break;
        }
    }

    public void loadPlayer(Player player, Scanner sc) {
        if (this.checkSaveGame(player)) {
            System.out.println("Do you want to load your existing character? (Type No if you don't want to load the savegame)");
            if (!sc.next().equals("No")) {
                player.load();
            }
        } else {
            System.out.println("There wasn't an existing savegame. Your adventure will start now.");
        }
    }
}





