package creatures;

import game.DamageMod;
import game.Status;
import items.Item;
import items.Spell;
import items.Weapon;
import java.util.List;

public class Boss extends Enemy {
  private final int numberOfAction;
  private final List<Weapon> weapons;
  private final List<Spell> spells;

  public Boss(int maxHealth, double poise, double speed, double precision,
      List<DamageMod> damageMods, List<Status> statuses, int threatLevel,
      List<Item> loot, String description, int numberOfAction,
      List<Weapon> weapons, List<Spell> spells) {
    super(maxHealth, poise, speed, precision, damageMods, statuses, threatLevel, loot, description);
    this.numberOfAction = numberOfAction;
    this.weapons = weapons;
    this.spells = spells;
  }

  public int getNumberOfAction() {
    return numberOfAction;
  }

  public List<Weapon> getWeapons() {
    return weapons;
  }

  public List<Spell> getSpells() {
    return spells;
  }
}
