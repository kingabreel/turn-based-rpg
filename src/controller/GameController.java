package controller;

import model.Enemy;
import model.Player;
import model.types.EnemyType;
import model.types.PlayerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameController {
    private String playerName;
    private String playerClass;
    private Player player;
    private List<Enemy> enemies;
    private int battleIndex = 1;
    Random random = new Random();

    String[] paths = {"Floresta Negra", "Floresta Comum", "Deserto", "Lago", "Pântano", "Montanha Gelada", "Caverna Sombria", "Praia Deserta",
            "Cidade Abandonada", "Ruínas Antigas", "Vale Místico", "Planície Serena", "Cânion Profundo", "Ilha Misteriosa", "Vila Fantasma",
            "Floresta Encantada", "Caverna de Cristal", "Deserto de Areia", "Templo Esquecido", "Montanha dos Dragões", "Praia dos Náufragos",
            "Pântano Venenoso", "Bosque das Fadas", "Vulcão Ativo", "Ruínas Submersas", "Caverna dos Goblins", "Campo de Batalha",
            "Floresta de Pinheiros", "Lago Congelado", "Praia de Conchas"};

    String[] enemyName = {"Goruk", "Thrag", "Zoltar", "Ragnar", "Morgana", "Vlad", "Zara", "Krug", "Drake", "Nimue", "Hagor", "Xara", "Brutus",
            "Elara", "Fang", "Ulric", "Selene", "Gorn", "Luna", "Balor", "Draug", "Ravena", "Orin", "Lyra", "Torek", "Nyx", "Grimm", "Morwen",
            "Thorn", "Yara", "Axel", "Zira", "Galen", "Freyja", "Sargon", "Kira", "Thalia", "Magnus", "Rhea", "Vorn", "Astrid", "Thorg",
            "Helga", "Zarek", "Loki", "Fenrir", "Osric", "Ivy", "Bryn"};

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

    public Player getPlayer(){
        return player;
    }
    public int getBattleIndex(){
        return this.battleIndex;
    }

    public void updateBattleIndex(){
        battleIndex++;
    }

    public String getRandomPath(){
        return paths[random.nextInt(30)];
    }

    public  void createPlayer(){
        this.player = new Player(playerName, PlayerType.valueOf(playerClass.toUpperCase()));
    }

    public boolean battleOrXp(){
        return random.nextBoolean();
    }

    public void startBatle(){
        enemies = new ArrayList<>();
        createEnemy();

    }

    private void createEnemy(){
        EnemyType[] enemies = EnemyType.values();
        int randomIndex = random.nextInt(enemies.length);

        Enemy enemy = new Enemy(enemyName[random.nextInt(50)], random.nextInt(player.getLevel() + 3),
                random.nextInt(player.getLife() + 30), true, random.nextInt(player.getMagicDefense() + 20),
                random.nextInt(player.getPhysicalDefense() + 20), random.nextInt(player.getBaseDamage() + 30),
                new ArrayList<>(), enemies[randomIndex]);

        this.enemies.add(enemy);
        System.out.println("===Inimigo encontrado===");
        System.out.println(enemy);
        System.out.println("\n" + "Iniciando batalha");
    }

    private void battle(){

    }
}
