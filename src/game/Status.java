package game;

public class Status {
  private final String name;
  private final int power;
  private int remainingRounds;
  private final Effect effect;

  public Status(String name, int power, int remainingRounds, Effect effect) {
    this.name = name;
    this.power = power;
    this.remainingRounds = remainingRounds;
    this.effect = effect;
  }

  public void dec() {
    if (remainingRounds > 0) {
      remainingRounds--;
    }
  }

  public String getName() {
    return name;
  }

  public int getPower() {
    return power;
  }

  public int getRemainingRounds() {
    return remainingRounds;
  }

  public Effect getEffect() {
    return effect;
  }
}
