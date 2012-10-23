package COMMANDE;
import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import java.util.Iterator;
import java.util.Scanner;

import CLIENT.Client;

public class testArticle {

	/**S
	 * @param args
	 */
	public static void main2(String[] args) {
		Hashtable<String,Article> colArticles = new Hashtable<String,Article>();
		
		 try{
			 FileInputStream fichier = new FileInputStream("article.txt");
			 ObjectInputStream ois = new ObjectInputStream(fichier);
			 colArticles=(Hashtable<String,Article>)ois.readObject();
				 
		 }
		 catch(Exception e){
				e.printStackTrace();
				colArticles = new Hashtable<String,Article>();
			}
		
		
		Scanner scan = new Scanner(System.in);
		int choix=0;
		
		do{
			System.out.println("Menu:");
			System.out.println("Ajouter client:1 , Supprimer client:2 , Modifier adresse client:3 Rechercher client:4  Afficher la liste des articles:5");
		
			
		     choix=scan.nextInt();
		if(choix==1){
			ajoutArt(colArticles);
		
		}
		if(choix==2){
			
			suppression(colArticles);
		}
		if(choix==3){
		     
			modifPrix(colArticles);
			
		}
	
		if(choix==4)
			rechercheArt(colArticles);
		
		
		if(choix==5)
			 afficherArt(colArticles);
		}	
		while(choix!=-1);
		
		try{
			    FileOutputStream fichier =new FileOutputStream("article.txt");
				ObjectOutputStream oos =new ObjectOutputStream(fichier);
				oos.writeObject(colArticles);
				oos.flush();
				oos.close();
		  }
		
		catch(Exception e){
				System.out.println(e.toString());
			}
	}
        
		
	public static void ajoutArt(Hashtable<String,Article> colArt){
	int choix =0;
	Scanner scan = new Scanner(System.in);
	System.out.println("Quel type d'article souhaiter vous ajouter ? 1:Article acheté,2:Article fabriqué");
	choix=scan.nextInt();
		
	switch(choix){
	case 1:
		   Article art = new Article();
	       art.saisirArticle();
	       colArt.put(art.getNomArt(), art);
	       break;
	case 2:ArticleProduit artP = new ArticleProduit();
		   artP.saisirArticle();
		   colArt.put(artP.getNomArt(), artP);
		   break;
		  
	}
			
	}
	public static void rechercheArt(Hashtable<String,Article> colArt){
		Scanner scan = new Scanner(System.in);
		String unNom="";
		System.out.println("Saisir article à rechercher ");
		unNom=scan.nextLine();
		if(colArt.containsKey(unNom)){
			Article art = colArt.get(unNom);
			art.afficherArticle();
		}
	}
	public static void suppression(Hashtable<String,Article> colArt){
		Scanner scan = new Scanner(System.in);
		String unNom="";
		System.out.println("Saisir article à supprimer ");
		unNom=scan.nextLine();
		try{
			colArt.remove(unNom);
			
		}
		catch(Exception e){
			
			System.out.println("l'article n'éxiste pas");
			
		}
	}
			
	
	public static void modifPrix(Hashtable<String,Article> colArt){
		Scanner scan = new Scanner(System.in);
		String unNom="";
		double d;
		System.out.println("Saisir article à modifier ");
		unNom=scan.nextLine();
		
		if(colArt.containsKey(unNom)){
			System.out.println("Saisir nouveau prix ");
		    d=scan.nextDouble();
			colArt.get(unNom).setPrix(d);
		}
			
	   else 
			System.out.println("Article non éxistant");
		
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
	
	public static void afficherRupture(Hashtable<String,Article> colArt){
		
	    Set s = colArt.keySet();
        Iterator it = s.iterator();
        String cle = (String)it.next();
        
     

        while (it.hasNext()&&colArt.get(cle).estEnRupture()) {
        	
        	
        	colArt.get(cle).afficherArticle();  	
        }
	}

	}
			
		
	