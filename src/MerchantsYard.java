public class MerchantsYard {
    Player player;

    public MerchantsYard(Player player) {
        this.player = player;
    }

    public void choppingWood(){
        for (int i = 0; i < 10; i++){
            try {
                System.out.println("*chop*");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thanks, here's your potion");
        player.drinkPotion();
    }


}
