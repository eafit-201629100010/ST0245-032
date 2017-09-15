import java.util.*;

//Ejercicio con juez en línea
//autor: Jacobo Henao Henao

public class nReinascMalos{
    
    public static int[] tablero;
    public static int soluciones;
    public static char[][]malos;
    
    public static void main(String[] args) {
            System.out.println("Ingrese el numero de reinas: ");

            Scanner sc = new Scanner(System.in);
            int nr = sc.nextInt();
            tablero = new int [nr];
            malos = new char[nr][nr];
            Scanner sc2 = new Scanner(System.in);
            for(int i = 0; i <nr; i++){
                System.out.println("Ingrese la línea de cuadros buenos-malos");
                String x = sc2.nextLine();
             for(int j = 0; j < nr; j++){
                 malos[i][j] = x.charAt(j);
             }   
            }
            
            int soluciones = ubicarReina(0, nr);
            System.out.println("numero de posibilidades para "+nr+" son "+soluciones);
    }

    public static boolean esMalo(int a, int b){
	return(malos[a][b] != '.');
    }
    
    
    public static boolean sePuedeUbicar(int x2,int y2){
        for (int i = 0; i < x2 ; i++) {
            if((tablero[i] == y2 || Math.abs(i - x2) == Math.abs(y2 - tablero[i])) || esMalo(i,y2)){
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
