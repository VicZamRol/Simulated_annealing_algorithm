package Optimizacion;
import java.util.Calendar;

import grafos.grafo;


/*Nuestro objetivo es maximizar la funcion objetivo y dar el estado resultante
de esa busqueda*/

public class busquedaEscaladaAleatoria {
	
	problemaOptimizado probl;
	
	public busquedaEscaladaAleatoria(grafo g, problemaOptimizado p){
		this.probl= p;
		
	}
/* Algoritmo original de la busqueda en escalada*/	
	
	public estados algoritmoBusquedaEscalada(){

//Contador de tiempo
		long t1, t2, dif;
		Calendar ahora1 = Calendar.getInstance();
        t1 = ahora1.getTimeInMillis();
//Inicializacion de variables        
		estados estadoAct= probl.getEstadoAct();
		int valorAct= probl.fObjetivo(estadoAct);
		estados estadoSuc= probl.generaSucesor(estadoAct);
		int valorSuc= probl.fObjetivo(estadoSuc);
		int iteracciones = 1;
		
		
//Bucle principal, donde buscamos el estado cuya funcion objetivo sea maxima		
		while (valorSuc >= valorAct){
			estadoAct= estadoSuc;
			valorAct= valorSuc;
			estadoSuc= probl.generaSucesor(estadoAct);
			valorSuc= probl.fObjetivo(estadoSuc);
			iteracciones ++;
		}
//Contador de tiempo				
		Calendar ahora2 = Calendar.getInstance();
        t2 = ahora2.getTimeInMillis();
        dif = t2 - t1;
  // Imprimimos por pantalla los resultados      
        System.out.println("---Escalada Aleatoria---");
        System.out.println("Tiempo consumido: " + dif + " milisegundos");
        System.out.println("Valor funcion objetivo: "+valorAct);
        System.out.println("Numero iteracciones: "+iteracciones);
        
		System.out.print("Estado final: ");
		for(int i=0; i<estadoAct.getActual().size();i++){
			System.out.print(estadoAct.getActual().get(i));
		}
		System.out.println();
//Devolvemos el mejor estado		
		return estadoAct;
	}

	
	
	
	
	
	
	

}
