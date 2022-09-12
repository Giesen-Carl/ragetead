package creatures;

import game.DamageMod;
import game.Status;
import items.Item;
import java.util.List;

public class Enemy extends Creature {
  private final int threatLevel;
  private final List<Item> loot;
  private final String description;

  public Enemy(int maxHealth, double poise, double speed, double precision,
      List<DamageMod> damageMods, List<Status> statuses, int threatLevel,
      List<Item> loot, String description) {
    super(maxHealth, poise, speed, precision, damageMods, statuses);
    this.threatLevel = threatLevel;
    this.loot = loot;
    this.description = description;
  }

  public int getThreatLevel() {
    return threatLevel;
  }

  public List<Item> getLoot() {
    return loot;
  }

  public String getDescription() {
    return description;
  }
}
