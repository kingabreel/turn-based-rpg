package view;

import controller.GameController;

import java.util.Scanner;

public class WindowGame {
    GameController gm = new GameController();
    Scanner scanner = new Scanner(System.in);

    public WindowGame(String[] inputs){
        if (!gm.validInput(inputs)) settingsPlayer();
        gm.createPlayer();

        menuWindow();
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
                        \n""");
                playerClass = scanner.nextInt();
                if (playerClass > 5 || playerClass < 0) System.out.println("Classe inválida.");
            }

            gm.setPlayerClass(playerClass == 1 ? "MAGE" : playerClass == 2 ? "WARRIOR" : playerClass == 3 ? "ARCHER" : playerClass == 4 ? "BARBARIAN" : "DRUID");
        }
    }
}
