package Optimizacion;

import java.util.Calendar;

import grafos.grafo;

/*Este algoritmo de busqueda en escala esta modificado de tal forma que los estados sucesores
 *  generados a partir de un estado inicial, tambien generado estrategicamente, sus nodos 
 *  estan ordenados de forma ascendente por el numero de vecinos.
 *  El funcionamiento es el mismo que en el algoritmo de la busqueda en escalada aleatoria, solo
 *  con la diferencia del ordenamiento de los elementos dentro de un estado*/

public class busquedaEscaladaGuiada {
problemaOptimizado probl;

//Constructor	
	public busquedaEscaladaGuiada(grafo g, problemaOptimizado p){
		this.probl=p;
		
	}
	
	public estados algoritmoBusquedaEscalada(){

//Contador de tiempo		
		long t1, t2, dif;
		Calendar ahora1 = Calendar.getInstance();
        t1 = ahora1.getTimeInMillis();
//Inicializacion de variables
		estados estadoAct= probl.getEstadoAct();
		int valorAct= probl.fObjetivo(estadoAct);
		estados estadoSuc= probl.generaSucesorGuiado(estadoAct);
		int valorSuc= probl.fObjetivo(estadoSuc);
		int iteracciones = 0;
		
/*Bucle principal en el que buscamos la mejor solucion. La diferencia con la
  Busqueda Escalada Aleatoria es que los sucesores no los creamos aleatoriamente,
  sino que se obtienen ordenando ascendentemente los nodos por vecinos*/
		while (valorSuc > valorAct){
			estadoAct= estadoSuc;
			valorAct= valorSuc;
			estadoSuc= probl.generaSucesorGuiado(estadoAct);
			valorSuc= probl.fObjetivo(estadoSuc);
			iteracciones ++;
		}
//Contador de tiempo		
		Calendar ahora2 = Calendar.getInstance();
        t2 = ahora2.getTimeInMillis();
        dif = t2 - t1;
//Imprimimos por pantalla los resultados obtenidos
        System.out.println("---Escalada Guiada---");
        System.out.println("Tiempo consumido: " + dif + " milisegundos");
        System.out.println("Valor funcion objetivo: "+valorAct);
        System.out.println("Numero iteracciones: "+iteracciones);
        
		System.out.print("Estado final: ");
		for(int i=0; i<estadoAct.getActual().size();i++){
			System.out.print(estadoAct.getActual().get(i));
		}
		System.out.println();
//Devolvemos el estado final		
		return estadoAct;
	}

}
