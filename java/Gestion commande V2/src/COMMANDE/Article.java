
package COMMANDE;
import java.io.Serializable;
import java.util.Scanner;
public class Article implements Serializable {
	private String nomArticle;
	private double prixUnitaire;
	private int qteStock;

	public Article(){}
	public void saisirArticle(){
		Scanner scan =new Scanner(System.in);
		
		System.out.println("Saisir nom article");
		this.nomArticle=scan.nextLine();
		System.out.println("Saisir prix article");
		this.prixUnitaire=scan.nextFloat();
		System.out.println("Saisir quantite article");
		this.qteStock=scan.nextInt();
		
	}
	public void afficherArticle(){
		
	      System.out.println("Nom: "+ this.nomArticle +" "+ "Prix unitaire: " +this.prixUnitaire +" Quantite stock "+ this.qteStock);
	    }
    public String getNomArt(){
    	return this.nomArticle;
    }
    public void setNomArt(String unNom){
    	this.nomArticle=unNom;
    }
    public double getPrix(){
    	return this.prixUnitaire;
    }
    public void setPrix(double unPrix){
    	this.prixUnitaire=unPrix;
    }
    public int getQte(){
    	return this.qteStock;
    }
    public void setQte(int uneQte){
    	this.qteStock=uneQte;
    	
    }
   
    
    public boolean estEnRupture(){
    	boolean rup =false;
    	if(this.getQte()==0){
    	 rup=true;	
    	}
    	return rup;
    	
    }
    

}

class ArticleProduit extends Article implements Serializable{
	
	private float coutFabrication;
	
	public void	afficherArticle(){
		super.afficherArticle();
		System.out.println("Coût de fabrication: "+ this.coutFabrication);
		
	}
	public void saisirArticle(){
		Scanner scan =new Scanner(System.in);
		super.saisirArticle();
		System.out.println("Saisir coût de fabrication:");
		this.coutFabrication=scan.nextFloat();
		
	}
	public float getCout(){
		return coutFabrication;
	}
	public void setCout(float unCout){
		this.coutFabrication=unCout;
	}
	public boolean estEnRupture(){
		return super.estEnRupture();
	}
	
	
	
    
}
	

