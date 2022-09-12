package creatures;

import game.DamageMod;
import game.Status;
import items.Armor;
import java.util.List;

public class Creature {
  private int health;
  private final int maxHealth;
  private final double poise;
  private final double speed;
  private final double precision;
  private final List<DamageMod> damageMods;
  private final List<Status> statuses;

  public Creature(int maxHealth, double poise, double speed, double precision,
      List<DamageMod> damageMods, List<Status> statuses) {
    this.health = maxHealth;
    this.maxHealth = maxHealth;
    this.poise = poise;
    this.speed = speed;
    this.precision = precision;
    this.damageMods = damageMods;
    this.statuses = statuses;
  }

  public void setHealth(int newHealth) {
    this.health = newHealth;
  }

  public int getHealth() {
    return health;
  }

  public int getMaxHealth() {
    return maxHealth;
  }

  public double getPoise() {
    return poise;
  }

  public double getSpeed() {
    return speed;
  }

  public double getPrecision() {
    return precision;
  }

  public List<DamageMod> getDamageMods() {
    return damageMods;
  }

  public List<Status> getStatuses() {
    return statuses;
  }
}
