package Textventure;

import java.io.Serializable;
import java.util.List;

public class DataStorage implements Serializable {
    Integer progress;
    String playerName;
    Integer healthPoints;
    List<String> inventory;
    List<String> knowledge;
    List<String> contact;
    //public String toString() {
    //    String infos = "";
    //    infos += "Your progress is: "+this.progress+"\n";
    //    infos += "Your name is: "+this.playerName+"\n";
    //    infos += "Your focus is: "+this.healthPoints+"\n";
    //    infos += "Your inventory has: "+this.inventory+"\n";
    //    infos += "Your knowledge consists of: "+this.knowledge+"\n";
    //    infos += "Your contacts are: "+this.contact+"\n";
    //    return infos;
    //}
}

