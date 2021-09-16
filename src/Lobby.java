import java.util.Scanner;

public class Lobby {
    static String location = "Lobby";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username:");

        Player player = new Player(sc.nextLine());
        while (player.isAlive()) {
            switch (location) {
                case ("Lobby") -> {
                    System.out.println("Where you wanna go?");
                    System.out.println("1. Darkwood");
                    System.out.println("2. Merchant");
                    System.out.println("3. Show status");
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
                    System.out.println("2. Back to the Lobby");
                    System.out.println("3. Show status");
                    switch (sc.nextLine()) {
                        case ("1") -> {
                            if (merchant.buyHpPotion(5)) {
                                System.out.println("Pleasure doing business with you");
                            } else {
                                System.out.println("You seem to be missing gold. If you can help me chop wood, then I will give this potion.");
                                location = "Merchant's yard";
                            }
                        }
                        case ("2") -> location = "Lobby";
                        case ("3") -> player.status();
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

        System.out.println("Player " + player.name + " died ^x^ Good luck next time!");

    }
}
