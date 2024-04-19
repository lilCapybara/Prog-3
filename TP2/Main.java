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
        if(n==1){
            return 0;
        }else if(n==2){
            return 1;
        }else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    public static void fibonacciHelper(int n){ //Realiza el recorrido para la sucesion de fibonacci
        for (int i=1; i<=n; i++){
            System.out.println(fibonacci(i));
        }
    }

    public static int valorIgualIndice(int[]a,int i){
        if(a[i]==i){
            return i;
        }
        if(i<a.length-1) {  //Si lo hay, pasa al siguiente valor del arreglo
            return valorIgualIndice(a,i+1);
        }
        return -1;
    }

    public static void main(String[] args) {
        /*int[]arreglo={1,2,3,4,5};
        OrenadorDeArreglos ordenador=new OrenadorDeArreglos(arreglo);
        ordenador.verificarOrdenado(0);*/

        //System.out.println(convertirABinario(1));

        //fibonacciHelper(6);
        //System.out.println(fibonacci(6));

        int[]a={6,3,1,1,1,1};
        System.out.println(valorIgualIndice(a,0));

    }
}