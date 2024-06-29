package model.abilities;


public enum Effect {
    POISON(new ActiveEffect()),
    FIRE(new ActiveEffect()),
    SLEEP(new ActiveEffect()),
    STUN(new ActiveEffect()),
    BLIND(new ActiveEffect());

    private final ActiveEffect activeEffect;

    Effect(ActiveEffect activeEffect) {
        this.activeEffect = activeEffect;
    }
}
