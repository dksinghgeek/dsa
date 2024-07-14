package com.ggn.probs.algo.backtracking;

import java.util.Arrays;

public class nQueen {
	static int SIZE = 4;

	private static void printBoard(char[][] chessBoard) {
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				System.out.print(chessBoard[r][c] + " ");
			}
			System.out.println();
		}
	}

	public static void nQueenSolution(char[][] chessBoard, int R) {
		if (R == SIZE) {
			System.out.println();
			printBoard(chessBoard);
		} else {
			for (int C = 0; C < SIZE; C++) {
				if (isSafe(chessBoard, R, C)) {
					chessBoard[R][C] = 'Q';
					nQueenSolution(chessBoard, R + 1);
					chessBoard[R][C] = '-';
				}
			}
		}
	}

	private static boolean isSafe(char[][] chessBoard, int r, int c) {
		for(int i = 0 ; i < SIZE ; i++) {
			if(chessBoard[i][c] == 'Q') {
				return false;
			}
		}
		
		for(int i = 0 ; i < SIZE ; i++) {
			if(chessBoard[r][i] == 'Q') {
				return false;
			}
		}
		
		for(int i = r , j = c; i >=0 && j >= 0; i--,j--) {
			if(chessBoard[i][j] == 'Q') {
				return false;
			}
		}
		
		for(int i = r , j = c; i >= 0 && j < SIZE; i--,j++) {
			if(chessBoard[i][j] == 'Q') {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		char[][] chessBoard = new char[SIZE][SIZE];

		for (int r = 0; r < SIZE; r++) {
			Arrays.fill(chessBoard[r], '-');
		}

		printBoard(chessBoard);
		
		nQueenSolution(chessBoard, 0);
	}
}
