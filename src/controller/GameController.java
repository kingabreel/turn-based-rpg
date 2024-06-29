package controller;

import model.Enemy;
import model.Player;
import model.types.PlayerType;

import java.util.Arrays;
import java.util.List;

public class GameController {
    private String playerName;
    private String playerClass;
    private Player player;
    private List<Enemy> enemies;

    public  void createPlayer(){
        this.player = new Player(playerName, PlayerType.valueOf(playerClass.toUpperCase()));
    }
    public boolean validInput(String[] inputs){
        if (inputs != null && inputs.length == 2) {
            List<String> classes = Arrays.asList("MAGO", "MAGE", "GUERREIRO", "WARRIOR", "ARCHER", "ARQUEIRO", "BARBARO", "BARBARIAN", "DRUIDA", "DRUID");

            playerName = inputs[0];

            if (classes.contains(inputs[1])){
                playerClass = inputs[1];
                return true;
            }
            return false;
        }

        return false;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }
}
