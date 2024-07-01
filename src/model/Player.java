package model;

import model.types.PlayerType;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character{
    private final PlayerType type;
    private int xp;
    private Item[] equipedItens = new Item[3];
    private List<Item> itemList;

    public Player(String name, PlayerType type) {
        super(name, 1, type.getLife(), true, type.getMagicDefense(), type.getPhysicalDefense(), 5, new ArrayList<>());
        this.type = type;
        this.xp = 0;
        itemList = new ArrayList<>();
    }

    public PlayerType getType() {
        return type;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void checkLevelUp() {
        int xpNewLevel = getLevel() * 25;

        if (getXp() >= xpNewLevel) {
            setLevel(getLevel() + 1);
            setLife(getLife() + getLevel() + 3);
            setMagicDefense(getMagicDefense() + getLevel());
            setPhysicalDefense(getPhysicalDefense() + getLevel());
            getType().getAbilities().forEach(skill -> {
                int damage = skill.getBaseDamage();
                int heal = skill.getHealAmount();
                int protection = skill.getProtection();

                if (damage != 0) skill.setBaseDamage(damage + getLevel());
                if (heal != 0) skill.setHealAmount(heal + getLevel());
                if (protection != 0) skill.setProtection(protection + getLevel() - 1);
            });
            System.out.println("======================");
            System.out.println("Você subiu de nível!\n" + "Nível atual: " + getLevel());
            System.out.println("======================");
        }
    }

    public void addItem(int slot, Item item){
        if (slot >= 0 && slot < equipedItens.length) equipedItens[slot] = item;
        else System.out.println("Espaço na não válido");
    }

    public void removeItem(int slot){
        if (slot >= 0 && slot < equipedItens.length) equipedItens[slot] = null;
        else System.out.println("Espaço na não válido");
    }
    
    public void equipedItens(){
        System.out.println("===== Lista de itens equipados =====");
        int k = 1;
        for (Item i : equipedItens) {
            if (i == null) continue;
            System.out.println("Item " + k);
            System.out.println(i.name() + ": " + i.getRarity());
            if (i.getExtraDamage() != 0) System.out.println("Dano extra: " + i.getExtraDamage());
            if (i.getExtraLife() != 0) System.out.println("Vida extra: " + i.getExtraDamage());
            if (i.getExtraMagicalDefense() != 0) System.out.println("Defesa Mágica extra: " + i.getExtraDamage());
            if (i.getExtraPhysicalDefense() != 0) System.out.println("Defesa Física extra: " + i.getExtraDamage());
            k++;
        }
    }
    
    public void itensOnBag(){
        itemList.forEach(System.out::println);
    }

    public Item[] getEquipedItens() {
        return equipedItens;
    }

    public void setEquipedItens(Item[] equipedItens) {
        this.equipedItens = equipedItens;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
