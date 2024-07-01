package model;

public enum Item {
    SWORD_OF_FLAME("Lendário", 0, 20, 0, 0),
    SHIELD_OF_AEGIS("Raro", 5, 2, 4, 8),
    HELM_OF_VALOR("Comum", 2, 0, 4, 0),
    ARMOR_OF_TITANS("Épico", 20, 0, 0, 5),
    BOOTS_OF_SPEED("Incomum", 3, 0, 7, 0),
    RING_OF_POWER("Lendário", 0, 5, 5, 5),
    CLOAK_OF_SHADOWS("Raro", 0, 8, 5, 0),
    GLOVES_OF_STRENGTH("Comum", 7, 0, 3, 0),
    BELT_OF_GIANTS("Epic", 0, 10, 3, 0),
    AMULET_OF_WISDOM("Incomum", 5, 5, 5, 0),
    STAFF_OF_THE_MAGI("Lendário", 0, 5, 3, 20),
    DAGGER_OF_VENOM("Raro", 8, 0, 0, 0),
    SHIELD_OF_LIGHT("Comum", 0, 4, 5, 10),
    HELMET_OF_FURY("Epic", 15, 0, 10, 0),
    ARMOR_OF_THE_DRAGON("Incomum", 10, 5, 5, 0),
    BOOTS_OF_LEAPING("Lendário", 10, 0, 10, 0),
    RING_OF_INVISIBILITY("Raro", 0, 0, 10, 10),
    CLOAK_OF_RESISTANCE("Comum", 0, 5, 5, 0),
    GLOVES_OF_DEXTERITY("Epico", 5, 0, 15, 5),
    BELT_OF_PROTECTION("Incomum", 0, 10, 5, 0);

    private final String rarity;
    private final int extraLife;
    private final int extraDamage;
    private final int extraPhysicalDefense;
    private final int extraMagicalDefense;


    Item(String rarity, int extraLife, int extraDamage, int extraPhysicalDefense, int extraMagicalDefense) {
        this.rarity = rarity;
        this.extraLife = extraLife;
        this.extraDamage = extraDamage;
        this.extraPhysicalDefense = extraPhysicalDefense;
        this.extraMagicalDefense = extraMagicalDefense;
    }

    public String getRarity() {
        return rarity;
    }

    public int getExtraLife() {
        return extraLife;
    }

    public int getExtraDamage() {
        return extraDamage;
    }

    public int getExtraPhysicalDefense() {
        return extraPhysicalDefense;
    }

    public int getExtraMagicalDefense() {
        return extraMagicalDefense;
    }
}
