package game;

import creatures.Enemy;
import creatures.Player;
import environment.Door;
import environment.Floor;
import environment.Map;
import environment.Room;
import items.Weapon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Game {

  Map map;
  Player player;
  BufferedReader bf;
  Room activeRoom;

  public Game() {
    bf = new BufferedReader(new InputStreamReader(System.in));
    map = fakeMap();
    Weapon axe = new Weapon(12, DamageType.PHYSICAL, 1, 1, 10, null);
    player = new Player(100, 50, 20, 32, null, null, 1, 20, axe, null, null, null);
  }

  private Map fakeMap() {
    ArrayList<Enemy> r1enemies = new ArrayList<>();
    ArrayList<Door> r1doors = new ArrayList<>();
    ArrayList<Enemy> r2enemies = new ArrayList<>();
    ArrayList<Door> r2doors = new ArrayList<>();

    Room r1 = new Room(r1doors, r1enemies, null);
    Room r2 = new Room(r2doors, r2enemies, null);

    r1doors.add(new Door(Direction.NORTH, false, r2));
    r2doors.add(new Door(Direction.SOUTH, false, r1));

    r1enemies.add(new Enemy(100, 20, 15, 23, null, null, 1, null, "A Hog with gray scales"));
    r1enemies.add(new Enemy(100, 20, 15, 23, null, null, 1, null, "A Hog with white scales"));
    r2enemies.add(new Enemy(100, 20, 15, 23, null, null, 1, null, "A Hog with yellow scales"));

    ArrayList<Room> rooms = new ArrayList<>();
    rooms.add(r1);
    rooms.add(r2);

    ArrayList<Floor> floors = new ArrayList<>();
    floors.add(new Floor(rooms));

    activeRoom = r1;

    return new Map(floors);
  }

  private String getInput() {
    for (; ; ) {
      try {
        System.out.println("What do you want to do?");
        String input = bf.readLine();
        return input;
      } catch (IOException exception) {
        exception.printStackTrace();
      }
    }
  }

  private void act(String command) {
    switch (command) {
      case "open" -> open();
      case "attack" -> attack();
    }
  }

  private void open() {
    System.out.println("You open the door");
    activeRoom = activeRoom.doors().get(0).getRoom();
    enterRoomDescription(activeRoom);
  }

  private void attack() {
    System.out.println("Attack enemy");
  }

  private void enterRoomDescription(Room room) {
    boolean multiple = room.enemies().size() > 1;
    System.out.println("You enter a room with " + room.enemies().size() + (multiple ? " enemies" : " enemy"));
    for (Enemy enemy : room.enemies()) {
      boolean last = room.enemies().indexOf(enemy) == room.enemies().size() - 1;
      System.out.print(enemy.getDescription() + (last ? "" : " and "));
    }
    System.out.println();
  }

  public void loop() {
    String input;
    do {
      input = getInput();
      act(input);
    } while (!input.equals("exit"));

  }

  public static void main(String[] args) {
    Game game = new Game();
    game.loop();
  }

}
