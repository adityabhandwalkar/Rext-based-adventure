package main;



import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in  = new Scanner(System.in);
		Random rand = new Random();

		String[] enemies = {"skeleton", "zombie", "warrior", "Assasin"};
		// enemy variables
		int maxEnemyHealth = 75;
		int enemyAttackdamage = 25;
		// player variable
		int health = 100;
		int attackdamage = 50;
		int numHealthPotions = 3;
		int healthPotionHealAmount = 30;
		int healthPotionFDropChance = 50;

		boolean running  = true;

		System.out.println("Welcome to dungeon");

		GAME:
			while (running) {
				System.out.println("---------------------------------------------------------");
				int enemyHealth = rand.nextInt(maxEnemyHealth);
				String enemy = enemies[rand.nextInt(enemies.length)];
				System.out.println("\t# " + " " + enemy + "appeared");

				while (enemyHealth > 0) {
					System.out.println("\tYour HP: " + health);
					System.out.println("\t " + enemy + "s HP " + enemyHealth);
					System.out.println("\n\tWhat would you like to do?");
					System.out.println("\t1. Attack");
					System.out.println("\t2. Drink health potion");
					System.out.println("\t3. Run");


					String input = in.nextLine();
					if(input.equals("1")) {
						int damageDealt= rand.nextInt(attackdamage);
						int damageTaken = rand.nextInt(enemyAttackdamage);

						enemyHealth -= damageDealt;
						health -= damageTaken;

						System.out.println("\tr> you striked the enemey" + " " + enemy + " for " + damageDealt + " damage");
						System.out.println("\t>  you received " + damageTaken + "in retaliation");

						if(health < 1 ) {
							System.out.println("\t> you've taken too much damage , you are too weak to go ahead");
							break;

						}

					}
					else if(input.equals("2")) {
						if(numHealthPotions>0) {
							health+= healthPotionHealAmount;
							numHealthPotions--;
							System.out.println("\t> you drank health potion for healing  " + healthPotionHealAmount 

									+  "\n\t you now have " + health + "HP"
									+ "health potion left \n" + numHealthPotions);
						}
						else {
							System.out.println("you have no potion left ! , ");
						}

					}
					else if(input.equals("3")) {
						System.out.println("\t you run away from the " + enemy+ " !");
						continue GAME;

					}
					else {
						System.out.println("\t invalid command!  ");
					}
				}
				if(health < 1) {
					System.out.println("u limp out of dungeon ");
					break;

				}

				System.out.println("--------------------------------------------------------------");
				System.out.println(" you defeated   " + enemy + " ;-)");



			}
		System.out.println("--------------------------------");
		System.out.println("what would u like to do?");
		System.out.println("1. continue figthing");
		System.out.println("2. exit dungeon");
		String input= in.nextLine();

		while(!input.equals("1") && !input.equals("2") ) {
			System.out.println("invalid command");
			input = in.nextLine();
		}
		if(input.equals("1")) {
			System.out.println("you chose to continue");
		}
		else  {

			System.out.println("you are exiting from the dungeon");
			
		}
		System.out.println("----------------Thank you for playing------------");


	}

}
