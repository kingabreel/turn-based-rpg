package model.abilities;


public enum Effect {
    POISON(3, 5, 5),
    FIRE(2, 5, 4),
    SLEEP(2, 0, 100),
    STUN(1, 0, 100),
    BLIND(3, 0, 50),
    BLEED(3, 3, 0),
    SACRED(2, 5, 0),
    EVIL(2, 5, 0);

    private int damage;
    private int rounds;
    private int missRateAttack;

    Effect(int rounds, int damage, int missRateAttack) {
        this.damage = damage;
        this.rounds = rounds;
        this.missRateAttack = missRateAttack;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getMissRateAttack() {
        return missRateAttack;
    }

    public void setMissRateAttack(int missRateAttack) {
        this.missRateAttack = missRateAttack;
    }
}
