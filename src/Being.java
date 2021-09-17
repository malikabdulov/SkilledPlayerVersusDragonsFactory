public abstract class Being {
    int hp, maxHp, str, agi, lvl, exp, gold;
    String name;


    public Being(String name, int hp, int maxHp, int str, int agi, int lvl, int exp, int gold) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
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

    public void decreaseHp(int delta){
        hp -= delta;
        if (hp < 0) {
            hp = 0;
        }
    }

    public int getExp() {
        return exp;
    }

    public int getGold() {
        return gold;
    }
}
