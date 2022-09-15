package game;

public class StatusBuilder {

  private static int iteration = 0;

  /*
  Level 1 - 10
  Level 1-3: Damage | Heal | 1 StatusMod, 1-5 rounds
  Level 4-6: (Damage | Heal) & 1 StatusMod | 2 StatusMod, 3-6 rounds
  Level 7-10: (Damage | Heal) & 2 StatusMod | 3 StatusMod, 4-7 rounds
   */
//  public static Status generateStatus(boolean positive, int level) {
//    int damage;
//    DamageType damageType;
//    int power;
//    int remainingRounds;
//    double poiseMod;
//    double speedMod;
//    DamageMod resistanceMod;
//
//    switch (level) {
//      case 1:
//        if (positive) {
//
//        } else {
//
//        }
//    }
//
//    Effect effect = new Effect(damage, damageType, poiseMod, speedMod, resistanceMod);
//    Status status = new Status("status_" + iteration, power, remainingRounds, effect);
//    iteration++;
//    return status;
//  }
}
