import java.util.Random;

public class DarkWood {
    Player player;
    boolean isGoblin = new Random().nextBoolean();

    public DarkWood(Player player) {
        this.player = player;
    }

    protected Being getOpponent() {
        if (isGoblin) {
            return new Goblin("Goblin");
        } else {
            return new Skeleton("Skeleton");
        }
    }

    public void fight() {
        try {
            Being monster = getOpponent();
            Battle battle = new Battle(player, monster);
            battle.start();
            battle.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
