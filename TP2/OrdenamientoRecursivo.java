public class OrdenamientoRecursivo {

    public static void burbujeoRecursivo(int[]a, int pos,int i){
        if(i>=a.length-1){
            return;
        }else{

        if (pos>=a.length-1){
            return;
        }

        //Lo de abajo lo debo hacer a.length iteraciones, ya que representa una sola iteracion
        if ((a[pos]>a[pos+1])){ //Si el primer elem es mayor que el siguiente, los ordeno
            int aux=a[pos+1];
            a[pos+1]=a[pos];
            a[pos]=aux;
            burbujeoRecursivo(a,pos+1,i+1);
        }else{
            burbujeoRecursivo(a,pos+1,i+1);
        }
        }
    }

    public static void main(String[] args){
        int[]a={2,3,5,2,3,5,7,3,2};
        burbujeoRecursivo(a,0);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }
}
