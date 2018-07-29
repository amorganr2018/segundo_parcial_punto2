package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

import encrypt.Asymmetric;
import encrypt.EncryptManager;
import encrypt.Symmetric;
import encrypt.TwoFish;

public class MainUI {
	
	static Scanner in = new Scanner(System.in);
	static PrintStream out = System.out;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static EncryptManager encryptManager;	

	public static void main(String[] args) throws Exception {
			boolean noExitMenu;
			int option;			
			String[] menu = {	" 1. Symmetric encription method",
								" 2. Asymmetric encription method",
								" 3. Twofish encription method",
								" 4. Exit",
								};
			
			do{				
				showMenu(menu);
				option = getOption();
				noExitMenu = processOption(option);
			}while(noExitMenu);
			
			out.println("\nThanks for using this program!");
	    	
    }
		
	static void showMenu(String[] pmenu){
		out.println("\n");
		for(int i=0;i<pmenu.length;i++){	
			out.println(pmenu[i]);
		}
	}
		
	static int getOption() throws IOException{
		int option;
		out.print("\nChoose an option: ");
		option = in.nextInt();
		return option;
	}
		
	static boolean processOption(int pOption) throws Exception{
		
		boolean noExitMenu = true;
		boolean noExitSubMenu = true;
		int optionSubMenu = 0;
		
		String[] subMenu = {	" 1. Create key.",
								" 2. Encript message.",
								" 3. Decript message.",
								" 4. Exit",
							};
		
		switch (pOption) {		
			case 1:				
				encryptManager = new Symmetric();				
				do {
					showMenu(subMenu);
					optionSubMenu = getOption();
					noExitSubMenu = executeAction(optionSubMenu);
				} while (noExitSubMenu);
				
				break;
				
			case 2:				
				encryptManager = new Asymmetric();
				do {
					showMenu(subMenu);
					optionSubMenu = getOption();
					noExitSubMenu = executeAction(optionSubMenu);
				} while (noExitSubMenu);
				break;
				
			case 3:
				encryptManager = new TwoFish();
				do {
					showMenu(subMenu);
					optionSubMenu = getOption();
					noExitSubMenu = executeAction(optionSubMenu);
				} while (noExitSubMenu);
				break;
				
			case 4:
				noExitMenu = false;
				break;
				
			default:
				out.println("\n--->ERROR: Choose a different option");
				break;
		}
		
		return noExitMenu;
	}		

	private static Boolean executeAction(int option) throws Exception {
		
		boolean noExitSubMenu = true;
		String name, messageName, message;
		
		switch(option) {
			case 1: 
				System.out.println("Key name: ");
				name = br.readLine();
				encryptManager.createKey(name);
				break;
			case 2:
				System.out.println("Key name: ");
				name = br.readLine();
				System.out.println("Message name: ");
				messageName = br.readLine();
				System.out.println("Message: ");
				message = br.readLine();
				encryptManager.encryptMessage(messageName,message,name);
				break;
			case 3:
				System.out.println("Key name: ");
				String keyName = br.readLine();
				System.out.println("Message name: ");
				messageName = br.readLine();
				encryptManager.decryptMessage(messageName, keyName);
				break;
			case 4:
				noExitSubMenu = false;
				break;
				
			default:
				out.println("\n--->ERROR: Choose a different option");
				break;
		}
		
		return noExitSubMenu;
	}
	
}


