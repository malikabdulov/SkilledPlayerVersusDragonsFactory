public abstract class Being {
    int hp, str, agi, lvl, exp, gold;
    String name;


    public Being(String name, int hp, int str, int agi, int lvl, int exp, int gold) {
        this.name = name;
        this.hp = hp;
        this.str = str;
        this.agi = agi;
        this.lvl = lvl;
        this.exp = exp;
        this.gold = gold;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int getStr() {
        return str;
    }

    public int getAgi() {
        return agi;
    }

    public void increaseHp(int delta){
        hp += delta;
    }

    public void decreaseHp(int delta){
        hp -= delta;
    }

    public int getExp() {
        return exp;
    }

    public int getGold() {
        return gold;
    }
}
