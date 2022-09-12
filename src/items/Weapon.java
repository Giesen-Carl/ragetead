package items;

import game.DamageType;
import game.Status;
import java.util.List;

public class Weapon extends Item {
  private final int damage;
  private final DamageType damageType;
  private final double speedMod;
  private final double precisionMod;
  private final double stagger;
  List<Status> statusEffects;

  public Weapon(int damage, DamageType damageType, double speedMod, double precisionMod,
      double stagger, List<Status> statusEffects) {
    this.damage = damage;
    this.damageType = damageType;
    this.speedMod = speedMod;
    this.precisionMod = precisionMod;
    this.stagger = stagger;
    this.statusEffects = statusEffects;
  }

  public int getDamage() {
    return damage;
  }

  public DamageType getDamageType() {
    return damageType;
  }

  public double getSpeedMod() {
    return speedMod;
  }

  public double getPrecisionMod() {
    return precisionMod;
  }

  public double getStagger() {
    return stagger;
  }
}
