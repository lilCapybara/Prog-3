// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    /*public int buscarElementoRecursivamente(int[]arreglo, int numBuscado, int inicio, int fin){

    }*/

    public static String convertirABinario(int num){


        if(num<0){
            return "-1";

        }else if(num==1){
            return "1";

        }else{
            return convertirABinario(num / 2) + String.valueOf(num % 2);
        }
    }

    public static int fibonacci (int n){    //Obtiene el termino n de la sucesion de fibonacci
        if(n==0 || n==1){
            return n;
        }else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    public static void fibonacciHelper(int n){ //Realiza el recorrido para la sucesion de fibonacci
        for (int i=0; i<n; i++){
            System.out.println(fibonacci(i));
        }
    }

    public static void valorIgualIndice(int[]a,int i){
        if(a[i]==i){
            System.out.println("El indice y su valor son iguales para i="+i);
        }
        if(i<a.length-1) {
            valorIgualIndice(a,i+1);
        }
    }


    public static void main(String[] args) {
        /*int[]arreglo={1,2,3,4,5};
        OrenadorDeArreglos ordenador=new OrenadorDeArreglos(arreglo);
        ordenador.verificarOrdenado(0);*/

        //System.out.println(convertirABinario(1));

        //fibonacciHelper(6);

        /*int[]a={0,1,5,3,4,5};
        valorIgualIndice(a,0);*/
    }
}