package game;

public record Effect(int damage, DamageType damageType, double poiseMod, double speedMod,
                     DamageMod resistanceMod) {
}
