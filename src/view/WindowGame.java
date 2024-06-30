package view;

import controller.GameController;

import java.util.Random;
import java.util.Scanner;

public class WindowGame {
    GameController gm;
    Scanner scanner;

    public WindowGame(String[] inputs){
        scanner = new Scanner(System.in);
        gm = new GameController(scanner);

        if (!gm.validInput(inputs)) settingsPlayer();
        gm.createPlayer();

        menuWindow();
        while (gm.getPlayer().isAlive()){
            choosePath();
        }
    }

    private void menuWindow(){
        System.out.println("Bem vindo ao jogo, " + gm.getPlayerName());
        System.out.println("Sua classe inicial é " + gm.getPlayerClass());
    }

    private void settingsPlayer(){
        if (gm.getPlayerName() == null) {
            System.out.print("Olá, primeiramente qual o seu nome, nobre guerreiro? ");
            String playerName = scanner.nextLine();

            gm.setPlayerName(playerName);

            System.out.println("Ótimo");
        }
        if (gm.getPlayerClass() == null) {

            int playerClass = 0;
            while (playerClass < 1 || playerClass > 5) {
                System.out.println("""
                        Qual classe você pertence?
                        1- Mago,
                        2- Guerreiro,
                        3- Arqueiro,
                        4- Barbaro,
                        5- Druída
                        """);
                playerClass = scanner.nextInt();
                if (playerClass > 5 || playerClass < 0) System.out.println("Classe inválida.");
            }

            gm.setPlayerClass(playerClass == 1 ? "MAGE" : playerClass == 2 ? "WARRIOR" : playerClass == 3 ? "ARCHER" : playerClass == 4 ? "BARBARIAN" : "DRUID");
        }
    }

    private void choosePath(){
        System.out.println("Três caminhos a se seguir: ");
        String[] paths = new String[3];

        for (int i = 0; i < 3; i++) {
            String path = gm.getRandomPath();
            System.out.println((i+1) + "- " + path);
            paths[i] = path;
        }

        int escolha = 0;
        while (escolha < 1 || escolha > 3){
            System.out.print("Sua escolha: ");
            escolha = scanner.nextInt();
        }

        System.out.println("Você segue pelo caminho: " + paths[escolha-1]);

        if (gm.battleOrXp()) {
            Random random = new Random();

            gm.getPlayer().setXp(gm.getPlayer().getXp() + random.nextInt(20));
        } else {
            gm.startBattle();
        }
    }
}
