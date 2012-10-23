package COMMANDE;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import ARTICLE.*;
import ARTICLE.Article;
import CLIENT.*;
import CLIENT.Client;

public class testCommande {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choix=0;
		Scanner scan=new Scanner(System.in);
		ArrayList<Commande> listeCommande = new ArrayList<Commande>();
		ArrayList<Client> listeClient =null;
		try{
			 FileInputStream fichier = new FileInputStream("client.txt");
			 ObjectInputStream ois = new ObjectInputStream(fichier);
		     listeClient=(ArrayList<Client>)ois.readObject();
		  		 
		 }
		 catch(Exception e){
				e.printStackTrace();
				listeClient = new ArrayList<Client>();
			}
		Hashtable<String,Article> colArticles = null;
		try{
			 FileInputStream fichier = new FileInputStream("article.txt");
			 ObjectInputStream ois = new ObjectInputStream(fichier);
			 colArticles=(Hashtable<String,Article>)ois.readObject();
				 
		 }
		 catch(Exception e){
				e.printStackTrace();
				colArticles = new Hashtable<String,Article>();
			}
		try{
			 FileInputStream fichier = new FileInputStream("commande.txt");
			 ObjectInputStream ois = new ObjectInputStream(fichier);
			 listeCommande=(ArrayList<Commande>)ois.readObject();
		     
			 
		 }
		 catch(Exception e){
				e.printStackTrace();
				listeCommande = new ArrayList<Commande>();
			}
		
		
		do{
		  System.out.println("Menu:");
			System.out.println("Ajouter commande:1 , Supprimer commande:2 , Modifier commande :3 Rechercher commande:4  Afficher la liste des commandes_:5");
			choix=scan.nextInt();
			 if(choix==1)
				 ajoutCommande(listeCommande,listeClient,colArticles); 
			 
			 if(choix==2)
			 	 suppression(listeCommande); 
			 
			 if(choix==5)
				 afficherListeCommande(listeCommande);
			 
			 
		 }while(choix!=-1);
		
		
		
		/**Serialisation**/
		try{
		    FileOutputStream fichier =new FileOutputStream("commande.txt");
			ObjectOutputStream oos =new ObjectOutputStream(fichier);
			oos.writeObject(listeCommande);
			oos.flush();
			oos.close();
		 
	 }
		catch(Exception e){
			System.out.println(e.toString());
		}
		
	}
	public static void ajoutCommande(ArrayList<Commande> listeCommande,ArrayList<Client> listeClient,Hashtable<String,Article>colArticles){
		Scanner scan = new Scanner(System.in);
		Article art=null;
		Client  cli=null;
		String unNom="";
		String nomArt="";
		System.out.println("Liste des client:");
		int num=listeCommande.size();
		afficherListeClient(listeClient);
		System.out.println("Selectionner nom client:");
		unNom=scan.nextLine();
		
		cli=rechercheClient(listeClient,unNom);
		if(cli!=null){
			System.out.println("Liste des articles:");
			afficherArt(colArticles);
			art=rechercheArt(colArticles);
			
			System.out.println(art.toString());
			Commande com =new Commande(num,cli,art);
			
			listeCommande.add(com);
			
		}
		
	}
	
	public static void afficherArt(Hashtable<String,Article> colArt){
        Set s = colArt.keySet();
        Iterator it = s.iterator();
        
        Article unArticle;
     

        while (it.hasNext()) {
        	
        	String cle = (String)it.next();
        	colArt.get(cle).afficherArticle();  	
        }
}
	/** Procedure suppression*/
	public static void suppression(ArrayList<Commande> col){
		int num=0;
		boolean trouve = false;
		int i = 0,position=-1;
		Scanner scan = new Scanner(System.in);
		System.out.println("Saisir numero de commande � supprimer:");
		num=scan.nextInt();
		while(trouve==false && i<col.size())
		{  
			if(col.get(i).getNum()==num)
			{
				trouve = true;
				position =i;
				System.out.println(position);
		        i++;
			
		}
		}
		if(position==-1)
			System.out.println("commande inexistante");
		else 
		    col.remove(position);
	
	}
	public static void afficherListeClient(ArrayList<Client> listClient){
		
		for(int i=0;i<listClient.size();i++){
			
			listClient.get(i).afficherClient();
		}
	}
public static void afficherListeCommande(ArrayList<Commande> listeCommande){
		
		for(int i=0;i<listeCommande.size();i++){
			
			listeCommande.get(i).afficherCommande();
			
	}

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
		
	public static Article rechercheArt(Hashtable<String,Article> colArt){
		Scanner scan = new Scanner(System.in);
		String unNom="";
		Article art=null;
		System.out.println("Selectionner article");
		unNom=scan.nextLine();
		
		
		if(colArt.containsKey(unNom)){
			    art=colArt.get(unNom);
		    	art.getNomArt();
		    	//System.out.println(art.getNomArt());
		}
		return art;
	}

}
