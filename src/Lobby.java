import java.util.Scanner;

public class Lobby {
    static String location = "Lobby";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username:");

        Player player = new Player(sc.nextLine());
        new GUI(player, 0).start();
        Dragon dragon = new Dragon("Dragon");

        while (player.isAlive() && dragon.isAlive()) {
            switch (location) {
                case ("Lobby") -> {
                    System.out.println("Where you wanna go?");
                    System.out.println("1. Darkwood");
                    System.out.println("2. Merchant");
                    System.out.println("3. Show status");
                    if (player.haveKey) {
                        System.out.println("4. Dragon's factory");
                    }
                    switch (sc.nextLine()) {
                        case ("1") -> {
                            location = "Darkwood";
                            new DarkWood(player).fight();
                        }
                        case ("2") -> {
                            location = "Merchant";
                            System.out.println("Hello, " + player.name + " come again for potions?");
                        }
                        case ("3") -> player.status();
                        case ("4") -> {
                            if (player.haveKey) {
                                System.out.println("Dragon woke up. Prepare to battle");
                                new Factory(player, dragon).fight();
                            }
                        }
                    }
                }
                case ("Darkwood") -> {
                    System.out.println("What will you do?");
                    System.out.println("1. Stay in Darkwood");
                    System.out.println("2. Back to the Lobby");
                    System.out.println("3. Show status");
                    switch (sc.nextLine()) {
                        case ("1") -> new DarkWood(player).fight();
                        case ("2") -> location = "Lobby";
                        case ("3") -> player.status();
                    }
                }
                case ("Merchant") -> {
                    Merchant merchant = new Merchant(player);

                    System.out.println("1. Buy a hp potion (5 gold)");
                    System.out.println("2. Buy a Dragon's factory key (100 gold)");
                    System.out.println("3. Back to the Lobby");
                    System.out.println("4. Show status");

                    switch (sc.nextLine()) {
                        case ("1") -> {
                            if (!merchant.buyHpPotion(5)) {
                                location = "Merchant's yard";

                                System.out.println("You seem to be missing gold. Help me chop wood and I'll give you a potion");
                            }
                        }
                        case ("2") -> {
                            if(merchant.buyKey(100)){
                                System.out.println("Now you can go to the dragon's factory");
                            } else {
                                System.out.println("You seem to be missing gold.");
                            }
                        }
                        case ("3") -> location = "Lobby";
                        case ("4") -> player.status();
                    }
                }
                case ("Merchant's yard") -> {
                    System.out.println("1. Accept the offer");
                    System.out.println("2. Back to the Lobby");
                    System.out.println("3. Show status");
                    switch (sc.nextLine()) {
                        case ("1") -> {
                            new MerchantsYard(player).choppingWood();
                            location = "Merchant";
                        }
                        case ("2") -> location = "Lobby";
                        case ("3") -> player.status();
                    }
                }
            }
        }
        if (player.isAlive()){
            System.out.println("Congratulations! You rid the world of the dragon");
        } else{
            System.out.println("Player " + player.name + " died ^x^ Good luck next time!");
        }
        System.out.println("Game over");
    }
}
