package items;

import game.Status;

public class Spell extends Item {
  private final int manaCost;
  private final Status status;

  public Spell(int manaCost, Status status) {
    this.manaCost = manaCost;
    this.status = status;
  }

  public int getManaCost() {
    return manaCost;
  }

  public Status getStatus() {
    return status;
  }
}
