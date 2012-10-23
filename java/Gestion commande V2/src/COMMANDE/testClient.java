package COMMANDE;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class testClient {

	/**Class main*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Client serialClient =new Client();
		ArrayList<Client> listeClient=null;
		
		
		 try{
			 FileInputStream fichier = new FileInputStream("client.txt");
			 ObjectInputStream ois = new ObjectInputStream(fichier);
		     listeClient=(ArrayList<Client>)ois.readObject();
		     
			 
		 }
		 catch(Exception e){
				e.printStackTrace();
				listeClient = new ArrayList<Client>();
			}
		
		int choix = 0;
		String nom = " ";
		String adresse=" ";
		String supNom=" ";
		Scanner scan = new Scanner(System.in);		 
		
		
		do{
			System.out.println("Menu:");
			System.out.println("Ajouter client:1 , Supprimer client:2 , Modifier adresse client:3 , Rechercher client:4 , Afficher la liste des clients: 5");
		
			choix=scan.nextInt();
		if(choix==1){
			ajout(listeClient);
		
		}
		if(choix==2){
			System.out.println("Saisir nom � supprimer");
			supNom=scan.nextLine();
			suppression(listeClient,supNom);
		}
		if(choix==3){
		       System.out.println("Saisir adresse � modifier");
		       adresse=scan.nextLine();
			   modificationAdresse(serialClient, adresse);
			
		}
	
		if(choix==4){
			System.out.println("Saisir nom � supprimer");
			nom=scan.nextLine();
			rechercheClient(listeClient,nom);
		}
			
		if(choix==5)
			
			afficherListeClient(listeClient);
		/*if(choix==6){
			
		}*/
			
		}
		while(choix!=-1);
		
		
	try{
		    FileOutputStream fichier =new FileOutputStream("client.txt");
			ObjectOutputStream oos =new ObjectOutputStream(fichier);
			oos.writeObject(listeClient);
			oos.flush();
			oos.close();
		 
	 }
		catch(Exception e){
			System.out.println(e.toString());
		}
	
	}
	/** PROCEDURE ajout*/
	public static void ajout(ArrayList<Client> col){
		Client c = new Client();
		c.saisirClient();
	    col.add(c);
				
	}
	/** Procedure suppression*/
	public static void suppression(ArrayList<Client> col,String n){
		boolean trouve = false;
		int i = 0,position=-1;
		while(trouve==false && i<col.size())
		{  
			if(col.get(i).getNom().compareTo(n)==0)
			{
				trouve = true;
				position =i;
				
		        i++;
			
		}
		}
		if(position==-1)
			System.out.println("Client in�xistant");
		else 
		    col.remove(position);
	
	}
	/** Procedure modification*/
	public static void modificationAdresse(Client unClient,String adresse){
					
		unClient.setAdresse(adresse);
	}
	/**Castaing q2**/
	public static void modification(Client cli,String unMail){
		cli.setMail(unMail);
	}
	
	
	public static Client rechercheClient(ArrayList<Client> listClient,String unNom){
	boolean trouve = false;	
	int i =0;
	int position =0;
	Client c = null ;
	while(trouve==false && i<listClient.size())
	{
	 if(listClient.get(i).getNom().compareTo(unNom)==0){
		trouve=true; 
		position =i;
		c=listClient.get(position);
	 }
	 
	 i++;
	}
	return c;
	     		
		
	}
	
	
	public static void afficherListeClient(ArrayList<Client> listClient){
		Collections.sort(listClient);
		for(int i=0;i<listClient.size();i++){
			
			listClient.get(i).afficherClient();
		}
	}
			
	}

  
	


