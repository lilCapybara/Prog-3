import java.lang.reflect.Array;
import java.util.ArrayList;

public class OrenadorDeArreglos {
    private int[] arreglo;

    public OrenadorDeArreglos(int[] arreglo) {
        this.arreglo = arreglo;
    }

    public void verificarOrdenado(int i){
        boolean ordenado=true;

        if (ordenado && i+1<this.arreglo.length && this.arreglo[i]<=this.arreglo[i+1]){ //Verifica si dos items contiguos estan ordenados y si se llego al final del array
            //Siempre verificar que no se haya ecedido el tamaño antes de comparar los valores
            verificarOrdenado(i+1);
        } else if (i+1>=this.arreglo.length && i-1<=i) { //Verifico si los dos elementos del final estan ordenados
            System.out.println("El array esta ordenado");
        } else{
            ordenado=false;
            System.out.println("El array esta desordenado");
        }

    }
}
