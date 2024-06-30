package model.abilities;

public class Skill {
    private String name;
    private int baseDamage;
    private double criticalRate;
    private boolean magical;
    private int healAmount;
    private int protection;
    private Effect effect;

    public Skill(String name, int baseDamage, double criticalRate, boolean magical, int healAmount, int protection, Effect effect) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.criticalRate = criticalRate;
        this.magical = magical;
        this.healAmount = healAmount;
        this.protection = protection;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public double getCriticalRate() {
        return criticalRate;
    }

    public void setCriticalRate(double criticalRate) {
        this.criticalRate = criticalRate;
    }

    public boolean isMagical() {
        return magical;
    }

    public void setMagical(boolean magical) {
        this.magical = magical;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
}
