public class Factory {
    Player player;
    Dragon dragon;

    public Factory(Player player, Dragon dragon) {
        this.player = player;
        this.dragon = dragon;
    }

    public void fight() {
        try {
            Battle battle = new Battle(player, dragon);
            battle.start();
            battle.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
