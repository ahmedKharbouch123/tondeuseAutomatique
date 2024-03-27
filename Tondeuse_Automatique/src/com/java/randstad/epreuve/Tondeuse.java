package com.java.randstad.epreuve;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.java.randstad.epreuve.service.TondeuseService;

public class Tondeuse {
	
	 
	
    public static void main(String[] args) {
    	
        try { 
        	TondeuseService tondeuseService = new TondeuseService();
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);

            //Dimensions de la pelouse, dans l'exemple (5 5)
            int sizeX = scanner.nextInt();
            int sizeY = scanner.nextInt();

            // Lecture des consignes pour chaque tondeuse
            while (scanner.hasNext()) {
                // Position initiale de la tondeuse
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if(x <= sizeX && y <= sizeY) {
                	char orientation = scanner.next().charAt(0);
                    //passer à la ligne suivante
                    scanner.nextLine(); 

                    // Instructions de déplacement
                    String instructions = scanner.nextLine();
                    // Execution des instruction 
                    tondeuseService.deplacerTondeuse(x, y, orientation, instructions, sizeX, sizeY);
                }
                else {
                	System.out.println("\u001B[31m Les coordonnées de la posisition initiale de la tendeuse doivent etre inférieur à la taille Max de la pelouse");
                	return;
                }
                
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier input.txt introuvable !!!");
            e.printStackTrace();
        }
    }

    
}