package creatures;

import game.DamageMod;
import game.Status;
import items.Armor;
import items.Item;
import items.Spell;
import items.Weapon;
import java.util.List;

public class Player extends Creature {
  private int level;
  private int exp;
  private int mana;
  private int maxMana;
  private Weapon weapon;
  private Armor armor;
  private final List<Item> inventory;
  private final List<Spell> spells;

  public Player(int maxHealth, double poise, double speed, double precision,
      List<DamageMod> damageMods, List<Status> statuses, int level, int exp, int mana,
      int maxMana, Weapon weapon, Armor armor, List<Item> inventory,
      List<Spell> spells) {
    super(maxHealth, poise, speed, precision, damageMods, statuses);
    this.level = level;
    this.exp = exp;
    this.mana = mana;
    this.maxMana = maxMana;
    this.weapon = weapon;
    this.armor = armor;
    this.inventory = inventory;
    this.spells = spells;
  }

  public int getLevel() {
    return level;
  }

  public int getExp() {
    return exp;
  }

  public int getMana() {
    return mana;
  }

  public int getMaxMana() {
    return maxMana;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public Armor getArmor() {
    return armor;
  }

  public List<Item> getInventory() {
    return inventory;
  }

  public List<Spell> getSpells() {
    return spells;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public void setExp(int exp) {
    this.exp = exp;
  }

  public void setMana(int mana) {
    this.mana = mana;
  }

  public void setMaxMana(int maxMana) {
    this.maxMana = maxMana;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public void setArmor(Armor armor) {
    this.armor = armor;
  }
}
