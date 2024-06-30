package controller;

import model.Enemy;
import model.Player;
import model.types.EnemyType;
import model.types.PlayerType;

import java.util.*;

public class GameController {
    private String playerName;
    private String playerClass;
    private Player player;
    private Enemy enemy;
    private int battleIndex = 1;
    private final Random random;
    private final Scanner scanner;
    private int turn;

    String[] paths = {"Floresta Negra", "Floresta Comum", "Deserto", "Lago", "Pântano", "Montanha Gelada", "Caverna Sombria", "Praia Deserta",
            "Cidade Abandonada", "Ruínas Antigas", "Vale Místico", "Planície Serena", "Cânion Profundo", "Ilha Misteriosa", "Vila Fantasma",
            "Floresta Encantada", "Caverna de Cristal", "Deserto de Areia", "Templo Esquecido", "Montanha dos Dragões", "Praia dos Náufragos",
            "Pântano Venenoso", "Bosque das Fadas", "Vulcão Ativo", "Ruínas Submersas", "Caverna dos Goblins", "Campo de Batalha",
            "Floresta de Pinheiros", "Lago Congelado", "Praia de Conchas"};

    String[] enemyName = {"Goruk", "Thrag", "Zoltar", "Ragnar", "Morgana", "Vlad", "Zara", "Krug", "Drake", "Nimue", "Hagor", "Xara", "Brutus",
            "Elara", "Fang", "Ulric", "Selene", "Gorn", "Luna", "Balor", "Draug", "Ravena", "Orin", "Lyra", "Torek", "Nyx", "Grimm", "Morwen",
            "Thorn", "Yara", "Axel", "Zira", "Galen", "Freyja", "Sargon", "Kira", "Thalia", "Magnus", "Rhea", "Vorn", "Astrid", "Thorg",
            "Helga", "Zarek", "Loki", "Fenrir", "Osric", "Ivy", "Bryn"};

    public GameController(Scanner scanner) {
        random = new Random();
        this.scanner = scanner;
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

    public void startBattle(){
        createEnemy();
        battle();
    }

    private void createEnemy(){
        EnemyType[] enemies = EnemyType.values();
        int randomIndex = random.nextInt(enemies.length);

        Enemy enemy = new Enemy(enemyName[random.nextInt(49)], random.nextInt(player.getLevel() + 3),
                random.nextInt(player.getLife() + 30), true, random.nextInt(player.getMagicDefense() + 20),
                random.nextInt(player.getPhysicalDefense() + 20), random.nextInt(player.getBaseDamage() + 30),
                new ArrayList<>(), enemies[randomIndex]);

        enemy.setXpReward(random.nextInt(10, 101));
        this.enemy = enemy;

        System.out.println("===Inimigo encontrado===");
        System.out.println(enemy);
        System.out.println("""

                Iniciando batalha
                """);
    }

    private void battle(){
        turn = 1;

        BattleController battle = new BattleController(player, enemy);
        battle.setBattleRunning(true);

        String[] classOptions = classOptions();

        while (battle.isBattleRunning()){
            if (turn == 1) {
                System.out.println(player.getLife() + "hp" + "\t" + "Inimigo: " + enemy.getLife());

                int choice = showBattleOptions(classOptions);

                playerAction((choice - 1), battle);

                if (enemy.getLife() <= 0){
                    enemy.setLife(0);
                    battle.setBattleRunning(false);
                    player.setXp(player.getXp() + enemy.getXpReward());
                    System.out.println("Inimigo derrotado, " + enemy.getXpReward() + "xp recebidos.");
                }
                turn *= -1;
            } else {
                int enemyChoice = random.nextInt(2);
                enemyAction(enemyChoice, battle);

                if (player.getLife() <= 0){
                    player.setLife(0);
                    battle.setBattleRunning(false);
                }
                turn *= -1;
            }
            System.out.println("===============");
        }
    }

    private String[] classOptions(){
        String[] arr = new String[3];
        switch (player.getType()){
            case MAGE:
                arr[0] = "Ataque";
                arr[1] = "Cura";
                arr[2] = "Proteger";
                break;
            case WARRIOR, BARBARIAN:
                arr[0] = "Ataque";
                arr[1] = "Ataque pesado";
                arr[2] = "Proteger";
                break;
            case DRUID:
                arr[0] = "Cura";
                arr[1] = "Ataque";
                arr[2] = "Ataque pesado";
                break;
            case ARCHER:
                arr[0] = "Ataque";
                arr[1] = "Ataque pesado";
                arr[2] = "Acionar armadilha";
                break;
        }
        return arr;
    }

    private int showBattleOptions(String[] classOptions){
        int playerOption = 0;

        while (playerOption > 3 || playerOption < 1) {
            for (int i = 0; i < classOptions.length; i++) {
                System.out.println((i + 1) + "- " + classOptions[i]);
            }
            playerOption = scanner.nextInt();
            if (playerOption > 3 || playerOption < 1) System.out.println("Escolha inválida");
        }

        return playerOption;
    }

    private void playerAction(int action, BattleController battle){
        switch (player.getType()){
            case MAGE -> {
                if (action == 0) calculateAttack(action, battle);
                else if (action == 1) {
                    calculateHealing(action, battle);
                    calculateProtection(action, battle);
                } else calculateProtection(action, battle);
            }
            case WARRIOR -> {
                if (action == 0) {
                    calculateAttack(action, battle);
                    calculateHealing(action, battle);
                } else if (action == 1) {
                    calculateAttack(action, battle);
                    calculateProtection(action, battle);
                } else calculateProtection(action, battle);
            }
            case DRUID -> {
                if (action == 0) calculateAttack(action, battle);
                else if (action == 1) {
                    calculateAttack(action, battle);
                    calculateProtection(action, battle);
                } else calculateAttack(action,battle);
            }
            case ARCHER -> calculateAttack(action, battle);
            case BARBARIAN -> {
                if (action == 0 || action == 1) calculateAttack(action, battle);
                else calculateProtection(action, battle);
            }
        }
    }
    private void enemyAction(int action, BattleController battle){
        switch (enemy.getEnemyType()){
            case ORC, DRAGON -> calculateAttack(action, battle);
            case DEMON, SKELETON -> {
                if (action == 0)  calculateAttack(action, battle);
                else {
                    calculateHealing(action, battle);
                    calculateProtection(action, battle);
                }
            }
            case GHOST, GOBLIN, WEREWOLF -> {
                if (action == 0) calculateAttack(action, battle);
                else calculateProtection(action, battle);
            }
            case TROLL -> {
                if (action == 0) calculateAttack(action, battle);
                else calculateHealing(action, battle);

            }
            case ZOMBIE -> {
                if (action == 0){
                    calculateHealing(action, battle);
                    calculateAttack(action, battle);
                    calculateProtection(action, battle);
                } else  calculateProtection(action, battle);
            }
            case VAMPIRE -> {
                if (action == 0) {
                    calculateHealing(action, battle);
                    calculateAttack(action, battle);
                    calculateProtection(action, battle);
                } else calculateAttack(action, battle);
            }
        }
    }

    private void calculateAttack(int action, BattleController battle){
        battle.calculateAttack(battle.attack(turn, action), turn);
    }

    private void calculateHealing(int action, BattleController battle){
        battle.calculateHeal(battle.heal(turn, action), turn);
    }

    private void calculateProtection(int action, BattleController battle){
        battle.calculateProtection(battle.defense(turn, action), turn);
    }
}
