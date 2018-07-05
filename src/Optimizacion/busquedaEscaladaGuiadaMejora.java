package Optimizacion;

import grafos.grafo;

import java.util.Calendar;

/*Esta clase es exactamente igual que la Busqueda Escala Guida, pero con la diferencia que 
  al principio del bucle incorporamos una condicion, la cual si se cumple comenzamos a iterar
  desde un estado mejor que el que se nos da como inicial*/

public class busquedaEscaladaGuiadaMejora {
	problemaOptimizado probl;

	//Constructor	
		public busquedaEscaladaGuiadaMejora(grafo g, problemaOptimizado p){
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
/*Esta condicion nos evita el bucle en la mayoria de las ejecuciones, ya que
  si se cumple hace que empecemos con un estado mejor que el inicial*/
			if(iteracciones==0 && valorSuc > valorAct){
				estadoAct= estadoSuc;
				valorAct=  valorSuc;
			}
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
	        System.out.println("---Escalada Guiada con mejora---");
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
