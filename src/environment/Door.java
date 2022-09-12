package environment;

import game.Direction;

public class Door {
  private final Direction direction;
  private boolean locked;
  private final Room room;

  public Door(Direction direction, boolean locked, Room room) {
    this.direction = direction;
    this.locked = locked;
    this.room = room;
  }

  public Direction getDirection() {
    return direction;
  }

  public boolean isLocked() {
    return locked;
  }

  public void setLocked(boolean locked) {
    this.locked = locked;
  }

  public Room getRoom() {
    return room;
  }
}
