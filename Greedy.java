package TPE.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Greedy {
    private Solucion solucion;



    public Solucion greedy(LinkedList<Procesador>procesadores, LinkedList<Tarea>tareas){

        while (!tareas.isEmpty()){  //Si tareas esta vacia, significa que las asigne todas

            int coeficienteMenor=Integer.MAX_VALUE; //Criterio de seleccion, se calcula como tiempo/prioridad
            Tarea mejorTarea=new Tarea(" "," ",0,0,false);

            for(Tarea t: tareas){
                if(t.getTiempo()/t.getPrioridad()<coeficienteMenor){
                    coeficienteMenor=t.getTiempo()/t.getPrioridad();
                    mejorTarea=t;
                }
            }   //Al salir del for, deberia tener el mejor candidato

            //Debo asignar la tarea al mejor procesador posible
            //Uso el menor tiempo acumulado del procesador como criterio para elegir al mejor candidato
            if(mejorTarea.esCritica()){ //Asigno a un procesador refrigerado

            }else{  //Asigno a un procesador normal

            }
            //Debo desasignar t de la lista de candidatos

        }//Al salir del while, deberia tener la solucion armada

        //return solucion
    }



}
