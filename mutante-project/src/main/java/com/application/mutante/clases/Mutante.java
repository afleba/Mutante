package com.application.mutante.clases;

public class Mutante {
	
	public static boolean isMutant(String[] dna) {
		int n = dna.length;
		char[][] matriz = new char[n][n];
		viewMatriz (dna);
		// transformo el arreglo en matriz de caracteres
		for (int i = 0; i < n; i++) {
			matriz[i] = dna[i].toCharArray();
		}

		// Verifico todas las posibilidades horizontal y vertical
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (checkSequence(matriz, i, j, 1, 0) || // horizontal
						checkSequence(matriz, i, j, 0, 1) || // vertical
						checkSequence(matriz, i, j, 1, 1) || // diagonal derecha
						checkSequence(matriz, i, j, 1, -1)) { // diagonal izquierda
					return true;
				}
			}
		}

		return false;
	}

	// Verifica si hay una secuencia de cuatro letras iguales
	private static boolean checkSequence(char[][] matriz, int x, int y, int dx, int dy) {
		int n = matriz.length; //tamaño de la matriz
		char caracter = matriz[x][y]; //

		for (int i = 0; i < 4; i++) {
			int nx = x + i * dx;
			int ny = y + i * dy;

			if (nx < 0 || nx >= n || ny < 0 || ny >= n || matriz[nx][ny] != caracter) {
				return false;
			}
		}

		return true;
	}

	private static void viewMatriz (String[] dna) {
			System.out.println("MATRIZ: ");
			for(int i=0; i < dna.length ; i++) {
				System.out.println(dna[i]);
			}
	}

}
