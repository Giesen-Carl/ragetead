package environment;

import game.Rarity;
import items.Item;
import java.util.List;

public class Chest {
  private final Rarity rarity;
  private final List<Item> loot;
  private boolean locked;

  public Chest(Rarity rarity, List<Item> loot, boolean locked) {
    this.rarity = rarity;
    this.loot = loot;
    this.locked = locked;
  }

  public Rarity getRarity() {
    return rarity;
  }

  public List<Item> getLoot() {
    return loot;
  }

  public boolean isLocked() {
    return locked;
  }

  public void setLocked(boolean locked) {
    this.locked = locked;
  }
}
