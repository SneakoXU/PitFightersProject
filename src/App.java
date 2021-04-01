import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class App {


//    private Fighter player1;
//    private Fighter player2;


    private static final String[] WEAPON_OPTIONS = {
            "Crossbow",
            "Spear",
            "Sword and Shield",
            "Warhammer",
            "Dagger"
    };

    public static void main(String[] args) {
        List<Fighter> player1Team = new ArrayList<>();
        List<Fighter> player2Team = new ArrayList<>();
        boolean createFighters = true;
        //int fighterCount = 0;
        Scanner userInput = new Scanner(System.in);
        int playerCount = 1;
        boolean gameOn = true;
        System.out.println("PLAYER " + playerCount + " - Create your fighters.");

//        while(fighterCount<=4){
//
//
//            fighterMenu();
//            String name = userInput.nextLine();
//            weaponMenu(WEAPON_OPTIONS);
//            String weapon = userInput.nextLine();
//
//        //assigns the user inputs to a new fighter object and adds fighter to fighter array
//            Fighter player1Fighter = new Fighter(name, weaponSelection(weapon));
//            player1Team.add(player1Fighter);
//            fighterCount++;
//
//
//
//
//        }


            player1Team = teamCreation(userInput);


            playerCount++;
            printFighters(player1Team);


            System.out.println("-------------------------------------");


            System.out.println("PLAYER " + playerCount + " - Create your fighters.");

            player2Team = teamCreation(userInput);

            printFighters(player2Team);

        while(gameOn){
            System.out.println("-------------------------------------\n");
            System.out.println("-------------------------------------\n");
            System.out.println("Press enter to battle. . . ");

            userInput.nextLine();

            battle(player1Team, player2Team);
            if(player1Team.isEmpty() || player2Team.isEmpty()){
                System.out.println("-----------GAME OVER.");
                gameOn = false;

            }

        }


//        fighterCount = 0;
//
//        while(fighterCount<=4){
//
//            fighterMenu();
//            String name = userInput.nextLine();
//            weaponMenu(WEAPON_OPTIONS);
//            String weapon = userInput.nextLine();
//
//
//            Fighter player2Fighter = new Fighter(name, weaponSelection(weapon));
//            player2Team.add(player2Fighter);
//            fighterCount++;
//        }




    }

    public static void fighterMenu(){
        System.out.println("Please enter fighter name: ");

    }

    public static void weaponMenu(String[] options){
        System.out.println("Please select a weapon to battle with: ");
        int count = 1;
        for(int i=0; i<options.length;i++){

            System.out.println(count + ". " + options[i]);
            count++;
        }

    }

    public static String weaponSelection(String weapon){
        switch(weapon){
            case "1":
                weapon = WEAPON_OPTIONS[0];
                break;
            case "2":
                weapon = WEAPON_OPTIONS[1];
                break;
            case "3":
                weapon = WEAPON_OPTIONS[2];
                break;
            case "4":
                weapon = WEAPON_OPTIONS[3];
                break;
            case "5":
                weapon = WEAPON_OPTIONS[4];
                break;
        }
        return weapon;
    }

    public static void printFighters(List<Fighter> fighters){
        for(Fighter fighter : fighters){
            System.out.println(fighter.getName());
            System.out.println(fighter.getWeapon());
        }
    }


    public static Fighter randomFighter(List<Fighter> team){
        int bound = team.size();
        int randNum = new Random().nextInt(bound);
        Fighter fighter = team.get(randNum);

        return fighter;
    }

    public static List<Fighter> teamCreation (Scanner input) {
        int fighterCount = 0;
        List<Fighter> team = new ArrayList<>();
        while (fighterCount <= 4) {


            fighterMenu();
            String name = input.nextLine();
            weaponMenu(WEAPON_OPTIONS);
            String weapon = input.nextLine();

            //assigns the user inputs to a new fighter object and adds fighter to fighter array
            Fighter playerFighter = new Fighter(name, weaponSelection(weapon));
            team.add(playerFighter);
            fighterCount++;

        }
        return team;
    }

    public static void battle (List<Fighter> player1, List<Fighter> player2){

        Fighter randFight1 = randomFighter(player1);
        Fighter randFight2 = randomFighter(player2);

        //player 1 weapon is crossbow logic
        if(randFight1.getWeapon().equals("Crossbow")){
            if(randFight2.getWeapon().equals("Crossbow")){
                System.out.println("Both fighters are dead.");
                player1.remove(randFight1);
                player2.remove(randFight2);
            }else if(randFight2.getWeapon().equals("Spear")){
                System.out.println(randFight2.getName() + " wins! " + randFight1.getName() + " has been killed by a " + randFight2.getWeapon().toLowerCase());
                player1.remove(randFight1);
            }else if(randFight2.getWeapon().equals("Sword Shield")){
                System.out.println(randFight2.getName() + " wins! " + randFight1.getName() + " has been killed by a " + randFight2.getWeapon().toLowerCase());
                player1.remove(randFight1);
            }else if(randFight2.getWeapon().equals("Warhammer")){
                System.out.println(randFight1.getName() + " wins! " + randFight2.getName() + " has been killed by a " + randFight1.getWeapon().toLowerCase());
                player2.remove(randFight1);
            }else if(randFight2.getWeapon().equals("Dagger")){
                System.out.println(randFight1.getName() + " wins! " + randFight2.getName() + " has been killed by a " + randFight1.getWeapon().toLowerCase());
                player2.remove(randFight1);
            }
        }

        //player 1 weapon is spear
        if(randFight1.getWeapon().equals("Spear")){
            if(randFight2.getWeapon().equals("Crossbow")){
                System.out.println(randFight1.getName() + " wins! " + randFight2.getName() + " has been killed by a " + randFight1.getWeapon().toLowerCase());
                player2.remove(randFight1);
            }else if(randFight2.getWeapon().equals("Spear")){
                System.out.println("Both fighters are dead.");
                player1.remove(randFight1);
                player2.remove(randFight2);
            }else if(randFight2.getWeapon().equals("Sword and Shield")){
                System.out.println(randFight2.getName() + " wins! " + randFight1.getName() + " has been killed by a " + randFight2.getWeapon().toLowerCase());
                player1.remove(randFight1);
            }else if(randFight2.getWeapon().equals("Warhammer")){
                System.out.println(randFight1.getName() + " wins! " + randFight2.getName() + " has been killed by a " + randFight1.getWeapon().toLowerCase());
                player2.remove(randFight1);
            }else if(randFight2.getWeapon().equals("Dagger")){
                System.out.println(randFight2.getName() + " wins! " + randFight1.getName() + " has been killed by a " + randFight2.getWeapon().toLowerCase());
                player1.remove(randFight1);
            }
        }

        //player 1 weapon is sword & shield
        if(randFight1.getWeapon().equals("Sword and Shield")){
            if(randFight2.getWeapon().equals("Crossbow")){
                System.out.println(randFight1.getName() + " wins! " + randFight2.getName() + " has been killed by a " + randFight1.getWeapon().toLowerCase());
                player2.remove(randFight1);
            }else if(randFight2.getWeapon().equals("Spear")){
                System.out.println(randFight1.getName() + " wins! " + randFight2.getName() + " has been killed by a " + randFight1.getWeapon().toLowerCase());
                player2.remove(randFight1);
            }else if(randFight2.getWeapon().equals("Sword Shield")){
                System.out.println("Both fighters are dead.");
                player1.remove(randFight1);
                player2.remove(randFight2);
            }else if(randFight2.getWeapon().equals("Warhammer")){
                System.out.println(randFight2.getName() + " wins! " + randFight1.getName() + " has been killed by a " + randFight2.getWeapon().toLowerCase());
                player1.remove(randFight1);
            }else if(randFight2.getWeapon().equals("Dagger")){
                System.out.println(randFight2.getName() + " wins! " + randFight1.getName() + " has been killed by a " + randFight2.getWeapon().toLowerCase());
                player1.remove(randFight1);
            }
        }

        //player 1 weapon is warhammer
        if(randFight1.getWeapon().equals("Warhammer")){
            if(randFight2.getWeapon().equals("Crossbow")){
                System.out.println(randFight2.getName() + " wins! " + randFight1.getName() + " has been killed by a " + randFight2.getWeapon().toLowerCase());
                player1.remove(randFight1);
            }else if(randFight2.getWeapon().equals("Spear")){
                System.out.println(randFight1.getName() + " wins! " + randFight2.getName() + " has been killed by a " + randFight1.getWeapon().toLowerCase());
                player2.remove(randFight1);
            }else if(randFight2.getWeapon().equals("Sword Shield")){
                System.out.println(randFight1.getName() + " wins! " + randFight2.getName() + " has been killed by a " + randFight1.getWeapon().toLowerCase());
                player2.remove(randFight1);
            }else if(randFight2.getWeapon().equals("Warhammer")){
                System.out.println("Both fighters are dead.");
                player1.remove(randFight1);
                player2.remove(randFight2);
            }else if(randFight2.getWeapon().equals("Dagger")){
                System.out.println(randFight2.getName() + " wins! " + randFight1.getName() + " has been killed by a " + randFight2.getWeapon().toLowerCase());
                player1.remove(randFight1);
            }
        }

        //player 1 weapon is dagger
        if(randFight1.getWeapon().equals("Dagger")){
            if(randFight2.getWeapon().equals("Crossbow")){
                System.out.println(randFight2.getName() + " wins! " + randFight1.getName() + " has been killed by a " + randFight2.getWeapon().toLowerCase());
                player1.remove(randFight1);
            }else if(randFight2.getWeapon().equals("Spear")){
                System.out.println(randFight1.getName() + " wins! " + randFight2.getName() + " has been killed by a " + randFight1.getWeapon().toLowerCase());
                player2.remove(randFight1);
            }else if(randFight2.getWeapon().equals("Sword Shield")){
                System.out.println(randFight1.getName() + " wins! " + randFight2.getName() + " has been killed by a " + randFight1.getWeapon().toLowerCase());
                player2.remove(randFight1);
            }else if(randFight2.getWeapon().equals("Warhammer")){
                System.out.println(randFight2.getName() + " wins! " + randFight1.getName() + " has been killed by a " + randFight2.getWeapon().toLowerCase());
                player1.remove(randFight1);
            }else if(randFight2.getWeapon().equals("Dagger")){
                System.out.println("Both fighters are dead.");
                player1.remove(randFight1);
                player2.remove(randFight2);
            }
        }

//        printFighters(player1);
//        printFighters(player2);

    }
}
