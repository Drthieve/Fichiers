package Fichier;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FirstFile {
	
	public static void EcrireDansUnFichier(String text, String CheminFichier, boolean ajout )
	{
		
		try {
		File f= new File(CheminFichier); //Ouverture d'un Fichier a laide de son chemin

FileWriter EcritureFichier= new FileWriter(f,ajout);  // si on mets creation dun fichier comme nom premier parametre de la fonction sinon ouverture du fichier avec ajout a la fin du fihier 
	
	PrintWriter PrintFichier= new PrintWriter(EcritureFichier);
	PrintFichier.println(text);
	PrintFichier.close(); 
	EcritureFichier.close(); }
	catch (IOException e)
	{
		System.out.println(e);
	}
}
	
/*********************************************************************************/
	
public static String LectureTouteLeContenuDuFichier (String CheminDuFichier)
{
	String ContenueFichier="";
	try {		
	File fichier= new File(CheminDuFichier);
	Scanner scannerFichier =  new Scanner (fichier); 
// Affichage du contenue d un fichier 
while (scannerFichier.hasNextLine())
{
	String Ligne =  scannerFichier.nextLine(); 
	ContenueFichier= ContenueFichier+Ligne+"\n"; 
}
System.out.println("le contenue du fichier passé en parametre est   : \n"+ContenueFichier);
scannerFichier.close();
}
catch (Exception e )
{
	e.printStackTrace();
}

//		Affichage d'un fichier qui contient que des entiers 
//		while (scannerFichier.hasNextLine())
//		{
//			int Entier= scannerFichier.nextInt();
//			System.out.println(Entier);
//		}
	return ContenueFichier;

}

/*********************************************************************************/

public static void LectureLigneFichier(String CheminDuFichier)
{
	try  {
	File Fichier = new File (CheminDuFichier); 
	Scanner LectureFichier = new Scanner (Fichier);
	String Mot = LectureFichier.next(); // Lecture d un mot d un  fichier
	String Ligne = LectureFichier.nextLine();  // Lecture d'une ligne d'un fichier 
	System.out.println(Mot);
	System.out.println(Ligne);
	LectureFichier.close();
	}
	catch (Exception e )
	{
		e.printStackTrace();
	}
	
	
}
public static void CopierFichierEnEntreéFichierSortie(String FichierEntree, String FichierSortie)
{
	try {
	File FichierSortieOuvert= new File(FichierSortie);
	FileWriter FichierSoriteEcrire= new FileWriter(FichierSortieOuvert); 
	PrintWriter FichierSortiePret = new PrintWriter (FichierSoriteEcrire);
	String ContenueFichierEntree = LectureTouteLeContenuDuFichier(FichierEntree);
	FichierSortiePret.println(ContenueFichierEntree);
	FichierSortiePret.close();
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
}

public static void main (String  args []) {

//		EcrireDansUnFichier("Souissi","src/Fichier/Youssef.txt",true);
//		EcrireDansUnFichier("Java", "src/Fichier/Youssef.txt", true); 
//		EcrireDansUnFichier("YAA", "src/Fichier/Youssef.txt", true);
	
/*********************************************************************************/

LectureTouteLeContenuDuFichier("src/Fichier/Youssef.txt");

/*********************************************************************************/

CopierFichierEnEntreéFichierSortie("src/Fichier/Youssef.txt", "src/Fichier/AAA.txt");
		
		
		
	} 
	
}


