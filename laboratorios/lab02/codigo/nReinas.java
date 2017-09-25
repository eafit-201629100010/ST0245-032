import java.util.*;

public class nReinas{
	
	public static int[] tablero;
	public static int soluciones;

	public static void main(String[] args) {
			System.out.println("Ingrese el numero de reinas: ");

			Scanner sc = new Scanner(System.in);
			int nr = sc.nextInt();

			tablero = new int [nr];
			int soluciones = ubicarReina(0, nr);
			System.out.println("numero de posibilidades para "+nr+" son "+soluciones);
	}

	public static boolean sePuedeUbicar(int x2,int y2){
		for (int i =0; i < x2 ; i++) {
			if(tablero[i] == y2 || Math.abs(i - x2) == Math.abs(y2 - tablero[i])){
				return false;
			}
		}

		return true;
	}

	public static int ubicarReina(int x1, int n){
		for(int i = 0 ; i < n ; i++){
			if(sePuedeUbicar(x1, i)){
				tablero[x1] = i;
				if(x1==n-1){
					soluciones++;
					System.out.println(Arrays.toString(tablero));
				}else{
					ubicarReina(x1+1,n);
				}
			}
		}

		return soluciones;
	}

}
