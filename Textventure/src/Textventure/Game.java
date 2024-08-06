package Textventure;

import java.util.Scanner;

public class Game extends GUI{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logic logic = new Logic();
        Storyteller story = new Storyteller();

        Player player = story.createPlayer();
        logic.loadPlayer(player, sc);
        while (player.progress < 16) {
            logic.chooseStory(player, story);
        }

    }
}