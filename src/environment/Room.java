package environment;

import creatures.Enemy;
import java.util.List;

public record Room(List<Door> doors, List<Enemy> enemies,
                   List<Chest> chests) {
}
