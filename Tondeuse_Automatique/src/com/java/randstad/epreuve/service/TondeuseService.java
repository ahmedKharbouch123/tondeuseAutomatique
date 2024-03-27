package com.java.randstad.epreuve.service;

public class TondeuseService {

	public TondeuseService() {
		// TODO Auto-generated constructor stub
	}
	
	public void deplacerTondeuse(int x, int y, char orientation, String instructions, int sizeX, int sizeY) {
        // Parcourir chaque instruction ex: GAGAGAGAA
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'G':
                    orientation = tournerAGauche(orientation);
                    break;
                case 'D':
                    orientation = tournerADroite(orientation);
                    break;
                case 'A':
                    // Calculer la nouvelle position après avancement
                    int[] newPosition = avancer(x, y, orientation, sizeX, sizeY);
                    x = newPosition[0];
                    y = newPosition[1];
                    break;
                default:
                    System.out.println("\u001B[31m Instruction non reconnue : " + instruction);
            }
        }
        // Position finale de la tondeuse
        System.out.println("\u001B[0m " + x + " " + y + " " + orientation);
    }

    public char tournerAGauche(char orientation) {
        switch (orientation) {
            case 'N':
                return 'W';
            case 'E':
                return 'N';
            case 'S':
                return 'E';
            case 'W':
                return 'S';
            default:
            	System.out.println("\u001B[31m Orientation non reconnue : " + orientation);
            	return orientation ;
        }
    }

    public char tournerADroite(char orientation) {
        switch (orientation) {
            case 'N':
                return 'E';
            case 'E':
                return 'S';
            case 'S':
                return 'W';
            case 'W':
                return 'N';
            default:
                return orientation;
        }
    }

    public int[] avancer(int x, int y, char orientation, int maxX, int maxY) {
        // Calculer les nouvelles coordonnées en fonction de l'orientation
        switch (orientation) {
            case 'N':
                y = Math.min(y + 1, maxY);
                break;
            case 'E':
                x = Math.min(x + 1, maxX);
                break;
            case 'S':
                y = Math.max(y - 1, 0);
                break;
            case 'W':
                x = Math.max(x - 1, 0);
                break;
        }
        return new int[]{x, y};
    }
}
