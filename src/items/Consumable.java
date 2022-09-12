package items;

import game.Status;

public class Consumable extends Item {
  private int charges;
  private final Status status;

  public Consumable(int charges, Status status) {
    this.charges = charges;
    this.status = status;
  }

  public void dec() {
    if (charges > 0) {
      charges--;
    }
  }

  public int getCharges() {
    return charges;
  }

  public Status getStatus() {
    return status;
  }
}
