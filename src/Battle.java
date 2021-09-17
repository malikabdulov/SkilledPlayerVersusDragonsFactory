import java.util.Random;

public class Battle extends Thread {
    Player player;
    Being monster;
    private boolean isPlayerTurn = true;

    public Battle(Player player, Being monster) {
        this.player = player;
        this.monster = monster;
    }

    @Override
    public void run() {
        while (player.isAlive() && monster.isAlive()) {
            if (isPlayerTurn) {
                attack(player, monster);
            } else {
                attack(monster, player);
            }
            isPlayerTurn = !isPlayerTurn;

            try {
                sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (player.isAlive()){
            int exp = monster.getExp();
            int maxLoot = monster.getGold();
            int loot = new Random().nextInt(maxLoot) + 5;

            player.increaseGold(loot);
            System.out.println("The " + monster.name + " is defeated. (+ " + exp + " experience, +" + loot + " gold)");
            player.increaseExp(exp);
        }
        System.out.println();
    }

    private boolean attack(Being attacker, Being target) {
        int attackerAgi = attacker.getAgi();
        int attackerStr = attacker.getStr();
        int targetAgi = target.getAgi();


        if (isDodge(attackerAgi, targetAgi)) {
            System.out.println(attacker.name + " missed. " + target.name + " dodged the attack");
            return false;
        }

        if (isCriticalStrike(attackerStr, attackerAgi)) {
            System.out.println(attacker.name + " made a critical strike and deals " + attackerStr * 2 + " damage");
            target.decreaseHp(attackerStr * 2);
        } else {
            System.out.println(attacker.name + " deals " + attackerStr + " damage");
            target.decreaseHp(attackerStr);
        }
        return true;
    }


    private boolean isDodge(int attackerAgi, int targetAgi) {
        if (targetAgi <= attackerAgi) {
            return false;
        } else return (targetAgi - attackerAgi) * 5 > new Random().nextInt(100);
    }

    private boolean isCriticalStrike(int attackerStr, int attackerAgi) {
        return (attackerStr + attackerAgi) > new Random().nextInt(120);
    }


}
