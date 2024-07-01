package view;

import controller.GameController;
import model.Item;

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
            battlePreparation();
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
                        1- Mago
                        2- Guerreiro
                        3- Arqueiro
                        4- Barbaro
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
            int xpGanho = random.nextInt(20);

            System.out.println("Nenhum monstro encontrado! ");
            gm.getPlayer().setXp(gm.getPlayer().getXp() + xpGanho);
            System.out.println(xpGanho + "xp ganho!");
            gm.getPlayer().checkLevelUp();

            Item item = gm.itemAfterLuckyPath();

            if (item != null) {
                System.out.println("Item encontrado!");
                gm.getPlayer().getItemList().add(item);
            }
        } else {
            gm.startBattle();

            Item item = gm.itemAfterBattle();

            if (item != null) {
                System.out.println("Item encontrado!");

                gm.getPlayer().getItemList().add(item);
            }
        }
        System.out.println("====================");
    }

    private void battlePreparation(){
        System.out.println("Qual sua escolha: " + "\n" + "1- Batalhar" + "\n" + "2- Equipamento");
        int choice = 0;
        while (choice < 1 || choice > 2){
            choice = scanner.nextInt();
        }

        if (choice == 2) {
            while (choice != 0) {
                System.out.println("""
                        1- Equipar um item
                        2- Desequipar um item
                        3- Ver itens equipados
                        4- Ver itens na mochila
                        0- Sair
                        """);
                choice = -1;

                while (choice < 0 || choice > 4) {
                    choice = scanner.nextInt();
                }

                switch (choice) {
                    case 1:
                        if (gm.getPlayer().getItemList().isEmpty()) {
                            System.out.println("Você não possui itens para equipar");
                        } else {
                            System.out.println("Itens que podem ser equipados: ");
                            for (int i = 0; i < gm.getPlayer().getItemList().size(); i++) {
                                System.out.println((i + 1) + "- " + gm.getPlayer().getItemList().get(i));
                            }

                            System.out.println("0- Sair");
                            System.out.print("\n" + "Qual item deseja equipar? ");
                            int itemChoice = scanner.nextInt();

                            for (int i = 0; i < gm.getPlayer().getEquipedItens().length; i++) {
                                if (gm.getPlayer().getEquipedItens()[i] == null) {
                                    gm.getPlayer().getEquipedItens()[i] = gm.getPlayer().getItemList().get(i);
                                    break;
                                }
                                itemChoice = -1;
                            }
                            if (itemChoice > 0 && itemChoice < gm.getPlayer().getItemList().size()) {
                                gm.getPlayer().equipedItens();
                                System.out.println("Qual item deseja substituir por " + gm.getPlayer().getItemList().get(itemChoice - 1));

                                int index = scanner.nextInt();

                                if (index > 0 && index < gm.getPlayer().getEquipedItens().length) {
                                    gm.getPlayer().removeItem(index - 1);
                                    gm.getPlayer().addItem(index - 1, gm.getPlayer().getItemList().get(itemChoice - 1));
                                } else System.out.println("Escolha inválida.");
                            }
                        }
                        break;

                    case 2:
                        if (gm.getPlayer().getEquipedItens()[0] == null &&
                                gm.getPlayer().getEquipedItens()[1] == null &&
                                gm.getPlayer().getEquipedItens()[2] == null) System.out.println("Você não possui itens equipados");
                        else {
                            gm.getPlayer().equipedItens();
                            System.out.print("Qual item a ser removido? ");

                            int index = scanner.nextInt();

                            if (index > 0 && index < gm.getPlayer().getEquipedItens().length) {
                                gm.getPlayer().removeItem(index - 1);
                            }
                        }
                        break;

                    case 3:
                        if (gm.getPlayer().getEquipedItens()[0] == null &&
                                gm.getPlayer().getEquipedItens()[1] == null &&
                                gm.getPlayer().getEquipedItens()[2] == null) System.out.println("Você não possui itens equipados");
                        else gm.getPlayer().equipedItens();
                        break;

                    case 4:
                        if (gm.getPlayer().getItemList().isEmpty()) System.out.println("Você não possui itens na mochila");
                        else gm.getPlayer().itensOnBag();
                        break;

                    default:
                        choice = 0;
                }
            }
        }
    }
}
