package creatures;

import game.DamageMod;
import game.Status;
import items.Item;
import items.Weapon;
import java.util.List;

public class Monster extends Enemy {
  private final Weapon weapon;

  public Monster(int maxHealth, double poise, double speed, double precision,
      List<DamageMod> damageMods, List<Status> statuses, int threatLevel,
      List<Item> loot, String description, Weapon weapon) {
    super(maxHealth, poise, speed, precision, damageMods, statuses, threatLevel, loot, description);
    this.weapon = weapon;
  }

  public Weapon getWeapon() {
    return weapon;
  }
}
