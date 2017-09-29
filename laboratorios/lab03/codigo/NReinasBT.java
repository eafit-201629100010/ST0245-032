package nreinasbt;
import java.util.*;
/*
 * @author Jacobo
 * Código solución al problema de las n reinas usando backtracking
 * En este caso se usó una matriz como tablero, la cual tendrá "Q" en sus celdas si hay
 * una reina, y "." en caso contrario.
 */
public class NReinasBT{
	
	public static String[][] tablero;
        
        /*
         * Método principal
         */
	public static void main(String[] args) {
			System.out.println("Ingrese el numero de reinas: ");
			Scanner sc = new Scanner(System.in);
			int nr = sc.nextInt();
			tablero = new String [nr][nr];
                        for(int i = 0; i < nr ; i++){
                            for(int j = 0; j < nr; j++)
                            {
                                tablero[i][j]=".";
                            }
                        }
                        resolver(nr);
	}

        /*
         * Ubica las reinas, recursión y backtracking
         */
        public static boolean ubicarReinas(int reina, int n){
            if(reina==n){return true;}
            
            for(int i = 0; i < n; i++){
                if(sePuedeUbicar(tablero,i,reina)){
                    tablero[i][reina] = "Q";
                    if(ubicarReinas(reina+1,n))
                            {
                                return true;
                            }
                    
                    //No funcionó, volvemos.
                    tablero[i][reina] = ".";
                }
            }
            return false;
        }
        
        /*
         * Chequea la línea, diagonal, y si no hay alguna reina en la celda visitada
         */
        public static boolean sePuedeUbicar(String[][] tab, int fila, int columna){
        
            for(int i = 0; i < columna; i++){
                if(tab[fila][i].equals("Q"))
                    return false;
            }
            for (int i = fila, j = columna; i >= 0 && j >= 0; i--, j--) {
			if (tab[i][j].equals("Q")) {
				return false;
			}
		}

		
		for (int i = fila, j = columna; i < tab.length && j >= 0; i++, j--) {
			if (tab[i][j].equals("Q")) {
				return false;
			}
		}

        return true;
        }
    
        /*
         * Imprime el resultado
         */
        public static void resolver(int N) {
		if(ubicarReinas(0, N)){
			//print the result
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(" " + tablero[i][j]);
				}
				System.out.println();
			}
		}else{
			System.out.println("NO SOLUTION EXISTS");
		}
	}
}
            
            
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
