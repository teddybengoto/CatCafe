package test;


import java.util.Scanner;

import model.Client;

public class App {

	public static String saisieString(String msg) {
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		return monScanner.nextLine();
		// return var;
	}

	public static int saisieInt(String msg) {
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		int var = monScanner.nextInt();
		return var;
	}

	public static double saisieDouble(String msg) {
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		double var = monScanner.nextDouble();
		return var;
	}

	public static boolean saisieBoolean(String msg) {
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		boolean var = monScanner.nextBoolean();
		return var;
	}

	// ---------------------------------Menu---------------------------------------
	// Principal---------------------------------------------
	public static void menuPrincipal() {
		System.out.println("Bienvenue au Java Cat Cafe");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Inscription");
		System.out.println("3 - Stop");

		int choix = saisieInt("Choisir un menu :");
		switch (choix) {
			case 1:
				connection();
				break;
			case 2:
				inscription();
				break;
			case 3:
				System.exit(0);
		}

		menuPrincipal();
	}

	public static void connection() {

		String login = saisieString("Login :");
		String password = saisieString("Mot de passe :");

		// modifier ces lignes après ajout de la base
		int choix = saisieInt("Choisir un Compte : 1 Client 2 Admin");
		System.out.println("Vous êtes connecté");
		// Affiche le bon menu menuAdmin(); / menuClient();
		if (choix == 1) {
			menuClient();
		} else if (choix == 2) {
			menuAdmin();
		}

	}

	public static void inscription() {

		String nom = saisieString("Entrez votre nom : ");
		String prenom = saisieString("Entrez votre prenom : ");
		// Pour quoi le login c'est pas le nom ?
		String login = saisieString("Entrez votre login : ");
		String password = saisieString("Entrez votre mot de passe : ");

		Client c = new Client(login, password, nom, prenom, null, "0");

		// Enregistre le clien dans la data base

		System.out.println("Vous êtes inscrit ! ");

		menuPrincipal();
	}

	// --------------------------------- Admin
	// -----------------------------------------------
	public static void menuAdmin() {
		System.out.println("Gestion du Java Cat Cafe");
		System.out.println("1 - Gestion des chats");
		System.out.println("2 - Gestion des adoptions");
		System.out.println("3 - Gestion des reservations");
		System.out.println("4 - Gestion des comptes");
		System.out.println("5 - Se deconnecter");

		int choix = saisieInt("Choisir un menu :");
		switch (choix) {
			case 1:
				//gestionChat();
				break;
			case 2:
				//gestionAdoption();
				break;
			case 3:
				//gestionReservation();
				break;
			case 4:
				//gestionCompte();
				break;
			case 5:
				menuPrincipal();
				break;
		}

		menuAdmin();
	}

	// ---------------------------------- Client
	// -------------------------------------------------
	public static void menuClient() {
		System.out.println("Bienvenue au Java Cat Cafe");
		System.out.println("1 - Regarder les chats du Java Cat Cafe");
		System.out.println("2 - Adopter un chat");
		System.out.println("3 - Menu garderie - pour faire garder son chat");
		System.out.println("4 - Gestion du compte");
		System.out.println("5 - Se deconnecter");

		int choix = saisieInt("Choisir un menu :");
		switch (choix) {
			case 1:
				regarderChatPresent(); // liste des chats présent au cafe
				break;
			case 2:
				adopterChat();
				break;
			case 3:
				menuGarderie();
				break;
			case 4:
				gestionCompteClient();
				break;
			case 5:
				menuPrincipal();
				break;
		}
		menuClient();
	}

	public static void regarderChatPresent() {
		//afficher tous les chats qui sont dans le cat café
		System.out.println("Voici les chats : ");
		System.out.println("Chat 1 🐱");
		System.out.println("Chat 2 🐈");
	}

	public static void adopterChat(){
		System.out.println("Bienvenue dans le menu d'adoption");
		System.out.println("1 - Liste des chats à adopter");
		System.out.println("2 - Se renseigner sur les conditions d'adoptions");
		System.out.println("3 - Retour");
		
		int choix = saisieInt("Choisir un menu :");
		switch (choix) {
			case 1:
				regarderChatAdoptable();
				break;
			case 2:
				System.out.println("Pour pouvoir adopter un chat, il vous faut remplir plusieurs conditions : \n -70m² entierement dédiées à l'animal.\n -...");
				break;
			case 3:
				menuClient();
				break;
		}
		adopterChat();
	}

	public static void regarderChatAdoptable() {
		//afficher seulement les chats adoptables
		System.out.println("Voici les chats : ");
		System.out.println("Chat 1 🐅");
		System.out.println("Chat 2 🦝");

		System.out.println("1 - Faire une demande d'adoption pour un chat");
		System.out.println("2 - Retour");

		int choix = saisieInt("Choix :");
		switch (choix) {
			case 1:
				int choix2 = saisieInt("Quelle chat voulez vous adopter ?");
				//ca crée une classe demande d'adoption à partir d'ici je suppose
				break;
			case 2:
				adopterChat();
				break;
			
		}
		
	}

	public static void menuGarderie(){
		System.out.println("Bienvenue dans le menu garderie pour chat");
		System.out.println("1 - Déposer son chat à la garderie");
		System.out.println("2 - Retirer son chat de la garderie");
		System.out.println("3 - Retour");

		int choix = saisieInt("Choisir un menu : ");
		switch (choix){
			case 1: // ;
				break;
			case 2: //;
				break;
			case 3: menuClient();
				break;
		}
		menuGarderie();
	}
	
	public static void enregistrezAdresse() {
		
	}
	public static void modifierNomPrenomLogin() {
		
	}
	public static void modifierpassword() {
		
	}
	public static void gestionCompteClient() {
	
		System.out.println("1- Modifier votre adresse");
		System.out.println("2- Modifier votre Nom prenom ou login");
		System.out.println("3- Modifier votre mot de passe");
		
		int choix = saisieInt("Choisir un menu");
		
		switch (choix) {
			case 1: enregistrezAdresse() ;
			break;
			case 2: modifierNomPrenomLogin() ;
			break;
			case 3: modifierpassword() ;
			break;
	
			default:
				break;
		}

	}


	public static void main(String[] args) {
		 menuPrincipal();

	}
}