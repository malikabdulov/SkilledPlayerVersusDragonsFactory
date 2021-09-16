public class Player extends Being{
    int maxHp;
    public Player(String name) {
        super(name,10, 10, 10, 1, 0, 10);
        this.maxHp = hp;
        System.out.println("Newbie " + name + " connected to the game");
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }

    public void increaseGold(int delta){
        gold += delta;
    }

    public void increaseExp(int delta){
        exp += delta;
        while(exp >= 1000){
            exp -= 1000;
            lvlUp();
        }
    }

    public void lvlUp(){
        System.out.println("Congrats! You are earned a new level");
        lvl++;
        str++;
        agi++;
        maxHp += 10;
    }

    public void status(){
        System.out.print("level:" + this.lvl);
        System.out.print(" strength:" + this.str);
        System.out.print(" agility:" + this.agi);
        System.out.println(" gold:" + this.gold);

        System.out.println("HP[==" + this.hp + "/" + this.maxHp + "==]");
        System.out.println("EXP [==" + this.exp + "/1000==]");
    }
}


