package Textventure;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Storyteller {
    Scanner sc;

    public Storyteller() {
        this.sc = new Scanner(System.in);
        sc.useDelimiter("\\n");
    }

    public Player createPlayer() {
        System.out.println("Greetings noble developer!\nIf I may ask, what is your name?");
        Integer health = 0;
        Player player = new Player(sc.next(), health);
        return player;
    }

    public void askForContact(Player player) {
        System.out.println("Is it okay if we contact you later?\nAvaiable choices:\nYes\nNo");
        String input = sc.next();
        if (input.equals("Yes")) {
            askForName(player);
        } else if (input.equals("No")) {
            System.out.println("This is a pity, we will not contact you. Enjoy playing!");
        } else {
            System.out.println("Please input a valid command!");
            String[] args2 = new String[0];
            askForContact(player);
        }
    }

    private static final String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public void emailValidation(Player player) {

        System.out.println("Can you also give us an email address?");
        String input = sc.next();
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);
        String descision = matcher.matches() ? "true" : "false";
        if (descision.equals("true")) {
            player.contact.add(input);
        } else {
            System.out.println("Please input a valid email adress!");
            String[] args2 = new String[0];
            emailValidation(player);
        }
    }

    private void askForName(Player player) {
        System.out.println("Can we ask for your real name and an email adress?\nAvaiable choices:\nYes\nNo");
        String input = sc.next();
        if (input.equals("Yes")) {
            System.out.println("Okay, who should we save you as?");
            String input2 = sc.next();
            player.contact.add(input2);
            emailValidation(player);
        } else if (input.equals("No")) {
            System.out.println("This is unfortunate, if we should assign you later we will use your username.");
        } else {
            System.out.println("Please input a valid command!");
            String[] args2 = new String[0];
            askForName(player);
        }
    }


    public void story1(Player player) {
        System.out.println("With how many focus (the HP of this game) do you want to start this adventure?\nAvaiable choices:\n10 = Hard\n20 = Normal\n30 = Easy");
        Integer input = sc.nextInt();
        try {
            if (input.equals(10)) {
                player.healthPoints = 10;
                System.out.print("You start your adventure with 10 focus! Farewell and good luck! ");
            } else if (input.equals(20)) {
                player.healthPoints = 20;
                System.out.print("You start your adventure with 20 focus! Farewell and good luck! ");
            } else if (input.equals(30)) {
                player.healthPoints = 30;
                System.out.print("You start your adventure with 30 focus! Farewell and good luck! ");
            } else {
                System.out.println("Please input a valid command!");
                String[] args2 = new String[0];
                story1(player);
            }
            player.headache();
            player.progress = 2;
        } catch (InputMismatchException iME) {
            System.out.println("Please input a valid command!");
            String[] args2 = new String[0];
            story1(player);
        }
    }

    public void story2(Player player) {
        System.out.println("You wake up in a dark room full of green lettering. What do you want to do?\nAvaiable choices:\nExamine the room\nTry to read the green lettering");
        String input = sc.next();
        if (input.equals("Examine the room")) {
            System.out.println("You examine the room extensively until you notice a small crack in the black matter.");
            player.hurtPlayer(1);
            player.progress = 3;
            System.out.println("Your focus now is: " + player.healthPoints);
        } else if (input.equals("Try to read the green lettering")) {
            System.out.println("You start reading the green lettering. And truly, you can decipher individual lines. You're reading: Sys--m.--t.pri---n(\"G- co----ue!\")\nYou learn Java!");
            if (!player.inventory.contains("Java")) {
                player.inventory.add("Java");
            }
            if (!player.knowledge.contains("Java")) {
                System.out.println("Can you say that you know Java?\nAvaiable choices:\nYes\nNo");
                String input2 = sc.next();
                if (input2.equals("Yes")) {
                    System.out.println("That's great!");
                    player.knowledge.add("Java");
                } else if (input2.equals("No")) {
                    System.out.println("It's really fun, believe us!");
                } else {
                    System.out.println("Please input a valid command!");
                    String[] args2 = new String[0];
                    story2(player);
                }
            }
            player.progress = 4;
        } else {
            System.out.println("Please input a valid command!");
            String[] args2 = new String[0];
            story2(player);
        }

        player.headache();
    }

    public void story3(Player player) {
        System.out.println("You decide to squeeze into the small crack and then seem to fall infinitely long. The green font is getting closer and closer.\nAvaiable choices:\nEnlarge yourself\nTry to read the green lettering ");
        String input = sc.next();
        if (input.equals("Enlarge yourself")) {
            System.out.println("You try to enlarge yourself, but the walls come closer and closer. You see no way out and can only fall further, further and further into the infinite emptiness.");
            player.gameOver();
        } else if (input.equals("Try to read the green lettering")) {
            System.out.println("During your fall, you start deciphering the lines. There is little to see, but you can clearly see that it is Java. You remember your earlier days with Java.\nYou learn Java!\nYou see a bright light.");
            if (!player.inventory.contains("Java")) {
                player.inventory.add("Java");
            }
            if (!player.knowledge.contains("Java")) {
                System.out.println("Can you say that you know Java?\nAvaiable choices:\nYes\nNo");
                String input2 = sc.next();
                if (input2.equals("Yes")) {
                    System.out.println("That's great!");
                    player.knowledge.add("Java");
                } else if (input2.equals("No")) {
                    System.out.println("It's really fun, believe us!");
                } else {
                    System.out.println("Please input a valid command!");
                    String[] args2 = new String[0];
                    story3(player);
                }
            }
        } else {
            System.out.println("Please input a valid command!");
            String[] args2 = new String[0];
            story3(player);
        }
        player.headache();
        player.progress = 5;
    }

    public void story4(Player player) {
        System.out.println("As the message tells you, you go on and see light in the distance.\nAvaiable commands:\nFollow the Way\nLeave the hallway");
        String input = sc.next();
        if (input.equals("Follow the Way")) {
            System.out.println("You follow the bright light and enter it.");
        } else if (input.equals("Leave the hallway")) {
            System.out.println("You try to leave the hallway but the light seems to haunt you. It's getting closer and closer and when it reached you, everything was there, except your memory.");
            player.inventory.clear();
        } else {
            System.out.println("Please input a valid command!");
            String[] args2 = new String[0];
            story4(player);
        }
        player.headache();
        player.progress = 5;
    }

    public void story5(Player player) {
        System.out.println("You wake up in a room you know. But again, it consists only of black matter. The only light you can see is that of your laptop, which throws green lines again. What does all this mean?\nAvaiable choices:\nTry to understand what the laptop is writing\nExamine the room for clues");
        String input = sc.next();
        if (input.equals("Try to understand what the laptop is writing")) {
            if (player.inventory.contains("Java")) {
                System.out.println("Thanks to your experience with Java, you can decipher what the laptop writes. He loops the two words BE US! What could this BE US mean?");
            } else {
                System.out.println("Even after your best efforts, you don't understand what the laptop wants from you. All this has given you is a headache.");
                player.damageOverTime = 3;
            }
            player.progress = 6;
        } else if (input.equals("Examine the room for clues")) {
            System.out.println("You know your room best. Through your good memory, you can locate your door and leave the room. But what awaits you behind shakes you.");
            player.hurtPlayer(1);
            System.out.println("Your focus now is: " + player.healthPoints);
            player.progress = 7;
        } else {
            System.out.println("Please input a valid command!");
            String[] args2 = new String[0];
            story5(player);
        }
        player.headache();
    }

    public void story6(Player player) {
        System.out.println("Your well-known laptop is also your best friend here. After you work on it, the stream of lines changes and points to your door.\nAvaiable choices:\nFollow the stream of lines\nTry to understand the lines");
        String input = sc.next();
        if (input.equals("Follow the stream of lines")) {
            System.out.println("You follow the lines to the door of the room and walk through it. What you see next shakes you.");
            player.hurtPlayer(1);
            System.out.println("Your focus now is: " + player.healthPoints);
            player.progress = 7;
        } else if (input.equals("Try to understand the lines")) {
            System.out.println("The lines are similar, but not the same. What could they be?\nAvaiable choices:\nC#\nJavaScript");
            String input2 = sc.next();
            if (input2.equals("C#")) {
                System.out.println("Of course! It is C #. You remember your time working with C#.\nYou learn C#!");
                if (!player.inventory.contains("C#")) {
                    player.inventory.add("C#");
                }
                if (!player.knowledge.contains("C#")) {
                    System.out.println("Do you know how to write in C# yourself?\nAvaiable choices:\nYes\nNo");
                    String input3 = sc.next();
                    if (input3.equals("Yes")) {
                        player.knowledge.add("C#");
                        System.out.println("That's great!");
                    } else if (input3.equals("No")) {
                        System.out.println("It's really fun, believe us!");
                    } else {
                        System.out.println("Please input a valid command!");
                        String[] args2 = new String[0];
                        story6(player);
                    }
                }
            } else if (input2.equals("JavaScript")) {
                System.out.println("JavaScript? You get really confused and loose most of your knowledge");
                player.inventory.clear();
            }
            System.out.println("As soon as you seem to have understood everything, your eyes go black and you wake up in a new room.");
            player.progress = 8;
        } else {
            System.out.println("Please input a valid command!");
            String[] args2 = new String[0];
            story6(player);
        }
        player.headache();
    }

    public void story7(Player player) {
        System.out.println("You see seemingly endless doors and a deep gorge in front of you. What can you do and why are you here?\nAvaiable choices:\nTry to reach another door\nJump into the gorge");
        String input = sc.next();
        if (input.equals("Try to reach another door")) {
            System.out.println("You take a run and just manage to reach such a flood of doors. With all your strength you hold on to this and drag yourself through the door.");
            player.hurtPlayer(5);
            System.out.println("Your focus now is: " + player.healthPoints);
        } else if (input.equals("Jump into the gorge")) {
            System.out.println("You fall and fall deeper and deeper and never stop falling.");
            player.gameOver();
        } else {
            System.out.println("Please input a valid command!");
            String[] args2 = new String[0];
            story7(player);
        }
        player.progress = 8;
        player.headache();
    }

    public void story8(Player player) {
        System.out.println("Once again, you are in a room you know. In this case, it's your living room. Again only one light, this time it is the TV. Is this supposed to be a joke?\nAvaiable choices:\nFind an exit. Again\nWatch TV");
        String input = sc.next();
        if (input.equals("Find an exit. Again")) {
            System.out.println("You look for another exit and oh what a miracle, you find one. Do you really want to go through everything again?\nAvaiable choices:\nYes\nNo");
            String input2 = sc.next();
            if (input2.equals("Yes")) {
                System.out.println("Once again, everything is happening from the new. Again and again to infinity.");
                player.gameOver();
            } else if (input2.equals("No")) {
                System.out.println("You do nothing and relax in peace.");
                player.healPlayer(1);
                System.out.println("Your focus now is: " + player.healthPoints);
            } else {
                System.out.println("Please input a valid command!");
                String[] args2 = new String[0];
                story8(player);
            }
        } else if (input.equals("Watch TV")) {
            System.out.println("You sit down to watch TV and stay absorbed in the program. You start to get tired and you get in. When you wake up, you have a miserable headache.");
            player.damageOverTime = 3;
        } else {
            System.out.println("Please input a valid command!");
            String[] args2 = new String[0];
            story8(player);
        }
        player.progress = 9;
        player.headache();
    }

    public void story9(Player player) {
        System.out.println("Where am I, who am I, what am I doing here? That's how many questions you ask yourself when you wake up and the only thing you feel is a voice. Mechanically but understandably it speaks to you. --- ma-n(--gs : Ar--y<---ing>) {Pr--tln(\"Y— cre—ed -s!\")} The language seems familiar to you\nAvaiable choices:\nThink more about the spoken word\nWake up");
        String input = sc.next();
        if (input.equals("Think more about the spoken word")) {
            System.out.println("Oh, a coincidence. This language also seems familiar to you, but which was it again?\nAvaiable choices:\nJava\nKotlin");
            String input2 = sc.next();
            if (input2.equals("Java")) {
                System.out.println("Java? Close but not right, the confusion is approaching.");
                player.inventory.clear();
            } else if (input2.equals("Kotlin")) {
                System.out.println("Oh right, it was Kotlin! You read: You created us.\nYou learn Kotlin!");
                if (!player.inventory.contains("Kotlin")) {
                    player.inventory.add("Kotlin");
                }
                if (!player.knowledge.contains("Kotlin")) {
                    System.out.println("Can you work with Kotlin in real life?\nAvaiable choices:\nYes\nNo");
                    String input3 = sc.next();
                    if (input3.equals("Yes")) {
                        System.out.println("That's great!");
                        player.knowledge.add("Kotlin");
                    } else if (input3.equals("No")) {
                        System.out.println("It's really fun, believe us!");
                    } else {
                        System.out.println("Please input a valid command!");
                        String[] args2 = new String[0];
                        story9(player);
                    }
                } else {
                    System.out.println("Please input a valid command!");
                    String[] args2 = new String[0];
                    story9(player);
                }
            }
        } else if (input.equals("Wake up")) {
            System.out.println("You wake up and suddenly memories return.\nYou learn Kotlin!");
            if (!player.inventory.contains("Kotlin")) {
                player.inventory.add("Kotlin");
            }
        } else {
            System.out.println("Please input a valid command!");
            String[] args2 = new String[0];
            story9(player);
        }
        player.progress = 10;
        player.headache();
    }

    public void story10(Player player) {
        System.out.println("You, room, laptop.\nAvaiable choices:\nSearch for clues on your laptop\nWork with your laptop");
        String input = sc.next();
        if (input.equals("Search for clues on your laptop")) {
            if (player.inventory.contains("Kotlin")) {
                System.out.println("With your skills you managed to find clues on your laptop and while doing so your memories of C# returned.\nYou learn C#!");
                if (!player.inventory.contains("C#")) {
                    player.inventory.add("C#");
                }
            } else {
                System.out.println("You couldn't find any clues on your laptop.");
            }
        } else if (input.equals("Work with your laptop")) {
            if (player.inventory.contains("C#")) {
                System.out.println("Of course, you can work best with your laptop. On it you will find old files from websites that you have written. You remember times when you worked with JavaScript.\nYou learn JavaScript!");
                if (player.inventory.contains("JavaScript")) {
                    player.inventory.add("JavaScript");
                }
                if (!player.knowledge.contains("JavaScript")) {
                    System.out.println("Have you already worked with JavaScript yourself?\nAvaiable choices:\nYes\nNo");
                    String input3 = sc.next();
                    if (input3.equals("Yes")) {
                        System.out.println("That's great!");
                        player.knowledge.add("JavaScript");
                    } else if (input3.equals("No")) {
                        System.out.println("It's really fun, believe us!");
                    } else {
                        System.out.println("Please input a valid command!");
                        String[] args2 = new String[0];
                        story10(player);
                    }
                }
            } else {
                System.out.println("You somehow didn't manage to work properly with your laptop, really weird. Where have all your memories gone?");
            }
        } else {
            System.out.println("Please input a valid command!");
            String[] args2 = new String[0];
            story10(player);
        }
        player.progress = 11;
        player.headache();
    }

    public void story11(Player player) {
        System.out.println("After hard work with your laptop, you lie down on the floor to rest.\nAvaiable choices:\nSleep\nMeditate");
        String input = sc.next();
        if (input.equals("Sleep")) {
            if (!player.inventory.contains("JavaScript")) {
                System.out.println("You rest and fall asleep. In the dream you reflect on all your experiences and memories. Suddenly, something comes to mind again.\nYou learn JavaScript");
                player.inventory.add("JavaScript");
                System.out.println("Have you already worked with JavaScript yourself?\nAvaiable choices:\nYes\nNo");
                String input3 = sc.next();
                if (input3.equals("Yes")) {
                    System.out.println("That's great!");
                    player.knowledge.add("JavaScript");
                } else if (input3.equals("No")) {
                    System.out.println("It's really fun, believe us!");
                } else {
                    System.out.println("Please input a valid command!");
                    String[] args2 = new String[0];
                    story11(player);
                }
            } else {
                System.out.println("You rest and fall asleep. In the dream you reflect on all your experiences and memories.");
                player.healPlayer(1);
                System.out.println("Your focus is now: " + player.healthPoints);
            }
        } else if (input.equals("Meditate")) {
            if (!player.inventory.contains("JavaScript")) {
                System.out.println("You meditate on your experiences and suddenly lost memories return.\nYou learn JavaScript");
                player.inventory.add("JavaScript");
                System.out.println("Have you already worked with JavaScript yourself?\nAvaiable choices:\nYes\nNo");
                String input3 = sc.next();
                if (input3.equals("Yes")) {
                    System.out.println("That's great!");
                    player.knowledge.add("JavaScript");

                } else if (input3.equals("No")) {
                    System.out.println("It's really fun, believe us!");
                } else {
                    System.out.println("Please input a valid command!");
                    String[] args2 = new String[0];
                    story11(player);
                }
            } else {
                System.out.println("You meditate on your experiences");
                player.healPlayer(1);
                System.out.println("Your focus is now: " + player.healthPoints);
            }
        } else {
            System.out.println("Please input a valid command!");
            String[] args2 = new String[0];
            story11(player);
        }
        player.headache();
        player.progress = 12;
    }

    public void story12(Player player) {
        System.out.println("You pick yourself up and decide to look ahead.\nAvaiable choices:\nLeave the room\nStay in the room");
        String input = sc.next();
        if (input.equals("Leave the room")) {
            System.out.println("You leave the room and fall out of the door into the endless gorge.");
            player.gameOver();
        } else if (input.equals("Stay in the room")) {
            System.out.println("You decide to stay in the room. Out of boredom, you type around on your laptop and accidentally find a folder. When you open it, your eyes suddenly go black and you feel yourself moving.");
        } else {
            System.out.println("Please input a valid command!");
            String[] args2 = new String[0];
            story12(player);
        }
        player.progress = 13;
        player.headache();
    }

    public void story13(Player player) {
        System.out.println("You wake up and remember that you just played around with your laptop. You can see a floating VSCode screen in front of you.\nAvaiable choices:\nWrite something in the screen\nIgnore");
        String input = sc.next();
        if (input.equals("Write something in the screen")) {
            System.out.println("You write and write and write until memories return. Memories of TypeScript.\nYou learn TypeScript!");
            if (!player.inventory.contains("TypeScript")) {
                player.inventory.add("TypeScript");
            }
            if (!player.knowledge.contains("TypeScript")) {
                System.out.println("Have you ever gotten a taste for TypeScript and can work with it?\nAvaiable choices:\nYes\nNo");
                String input3 = sc.next();
                if (input3.equals("Yes")) {
                    System.out.println("That's great!");
                    player.knowledge.add("JavaScript");
                } else if (input3.equals("No")) {
                    System.out.println("It's really fun, believe us!");
                } else {
                    System.out.println("Please input a valid command!");
                    String[] args2 = new String[0];
                    story13(player);
                }
            }
        } else if (input.equals("Ignore")) {
            System.out.println("You ignore the screen and suddenly you hear a voice. When you look at him again, you see a nice man talking about TypeScript. After listening a little, you understand the topic and feel ready to apply it.\nYou learn TypeScript!");
            if (!player.inventory.contains("TypeScript")) {
                player.inventory.add("TypeScript");
            }
            if (!player.knowledge.contains("TypeScript")) {
                System.out.println("Have you ever gotten a taste for TypeScript and can work with it?\nAvaiable choices:\nYes\nNo");
                String input3 = sc.next();
                if (input3.equals("Yes")) {
                    System.out.println("That's great!");
                    player.knowledge.add("JavaScript");
                } else if (input3.equals("No")) {
                    System.out.println("It's really fun, believe us!");
                } else {
                    System.out.println("Please input a valid command!");
                    String[] args2 = new String[0];
                    story13(player);
                }
            } else {
                System.out.println("Please input a valid command!");
                String[] args2 = new String[0];
                story13(player);
            }
        }
        player.headache();
        player.progress = 14;
    }

    public void story14(Player player) {
        System.out.println("The screen has rekindled your interest. It occurred to you earlier that you were in a program. What happens when you write a kill method?\nAvaiable choices:\nWrite a kill program\nThat's just a stupid idea");
        String input = sc.next();
        if (input.equals("Write a kill program")) {
            if (player.inventory.size() == 5) {
                System.out.println("With all your accumulated knowledge, you manage to write a kill method and escape this nonsense. Shortly after executing you suddenly stand in your room, but this time it's your real one. Your laptop seems broken and scatters electronic sparks. Luckily you made it out!");
                player.progress = 15;
            } else {
                System.out.println("You aren't able to sucefully write a kill command. As the system notices you want to stop it, it quickly starts to lock it self. You get dizzy and everything disappears. Maybe you should have gathered all the knowledge that was available.");
                player.inventory.clear();
                player.progress = 2;
            }
        } else if (input.equals("That's just a stupid idea")) {
            System.out.println("Your stupid idea could have been the solution to your problems. Now you roam through this infinite emptiness until the end of your days. Some also call it void and your end is nothing.");
            player.gameOver();
        } else {
            System.out.println("Please input a valid command!");
            String[] args2 = new String[0];
            story14(player);
        }
        player.headache();
    }

    public void story15(Player player) {
        System.out.println("Congratulations! You have survived your own mistakes. Only the most persistent will be able to read this here. I hope you enjoyed this Fort!sventure and were able to gain great experiences. Now I wish you an eventful future!");
        player.progress = 16;
    }
}
