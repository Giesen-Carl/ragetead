package items;

import game.DamageMod;
import java.util.List;

public class Armor extends Item {
  private final List<DamageMod> damageMods;
  private final double speedMod;
  private final double poiseMod;

  public Armor(List<DamageMod> damageMods, double speedMod, double poiseMod) {
    this.damageMods = damageMods;
    this.speedMod = speedMod;
    this.poiseMod = poiseMod;
  }

  public List<DamageMod> getDamageMods() {
    return damageMods;
  }

  public double getSpeedMod() {
    return speedMod;
  }

  public double getPoiseMod() {
    return poiseMod;
  }
}
