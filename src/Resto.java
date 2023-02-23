import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Resto {

	public static void main(String[] args) {

		// variables
		Scanner sc = new Scanner(System.in);
		ArrayList<String> order = new ArrayList<>();

		// TODO utiliser des tableau de constantes pour presenter le menu
		final String[] ENTREE = { "entrée", "SALADE", "SOUPE", "QUICHE", "AUCUNE" };
		final String[] PLATS = { "plat", "POULET", "BOEUF", "POISSON", "VEGAN", "AUCUN" };
		final String[] ACCOMPAGNEMENTS = { "accompagnement", "RIZ", "PATES", "FRITES", "LEGUMES", "AUCUN" };
		final String[] BOISSONS = { "boisson", "EAU PLATE", "EAU GAZEUZE", "SODA", "AUCUNE" };
		final String[] DESSERTS = { "dessert", "TARTE MAISON", "MOUSSE AU CHOCOLAT", "TIRAMISU", "AUCUN" };

		// demander combien de menu (la répétition de la boucle)
		System.out.println("Bonjour, combien de menu souhaitez vous commander ?");
		int nbMenu = sc.nextInt();
		BufferedWriter file = null;
		// Résumer chaque commande avant de passer a la suivante
		try {
			file = new BufferedWriter(new FileWriter("menu.txt"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 1; i <= nbMenu; i++) {
			System.out.println("Commande numéro " + i);
			System.out.println();

			try {
				file.write("****************Résumé de la commande N° " + i + "*************");
				file.newLine();
				// entree
				displayChoice(ENTREE);
				addChoice(ENTREE, order, file);

				// plat
				displayChoice(PLATS);
				addChoice(PLATS, order, file);

				// accompagnements
				displayChoice(ACCOMPAGNEMENTS);
				addChoice(ACCOMPAGNEMENTS, order, file);

				// boissons
				displayChoice(BOISSONS);
				addChoice(BOISSONS, order, file);

				// DESSERTS
				displayChoice(DESSERTS);
				addChoice(DESSERTS, order, file);
				file.newLine();
				file.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// resumer la commande
			System.out.println("Résumé de la commande " + i);
			System.out.println(order);
			System.out.println("-------------Bon App----------------");
			order.clear();
		}
		sc.close();

	}

	private static void addChoice(final String[] ENTREE, ArrayList<String> order, BufferedWriter file)
			throws IOException {
		Scanner scan = new Scanner(System.in);
		int choice;
		while (!scan.hasNextInt())
			scan.next();
		choice = scan.nextInt();
		while (choice > ENTREE.length - 1) {
			System.out.println("on a pas ce choix dans la liste !");
			choice = scan.nextInt();
		}
		if (choice == (ENTREE.length) - 1) {
			System.out.println();
		} else {
			System.out.println("Good choice !");
			System.out.println();
			order.add(ENTREE[choice].toLowerCase());

			// ecrire dans un fichier
			file.write(ENTREE[choice].toLowerCase());
			file.newLine();
			file.flush();
		}

	}

	private static void displayChoice(final String[] ENTREE) {
		String menuSelected = ENTREE[0];
		System.out.println("choix " + menuSelected + " :");
		display(ENTREE);
		System.out.println();
		System.out.println("Que souhaitez vous comme " + menuSelected + " ? " + "[Saisir le chiffre correspondant]");
	}

	private static void display(final String[] tab) {
		for (int i = 1; i < tab.length; i++) {
			System.out.print("[" + i + " - " + tab[i] + "]" + " ");

		}
	}

}
