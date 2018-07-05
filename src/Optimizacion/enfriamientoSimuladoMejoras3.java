package Optimizacion;

import grafos.grafo;

import java.util.Calendar;
import java.util.Random;

/*El algoritmo de Enfriamiento Simulado esta inspirado en el enfriamiento Fisico-quimico  de metales,
la idea principal es ir aceptando estados peores, dependiendo de la probabilidad en funcion del 
incremneto producido en la funcion objetivo, nos permite asi salir de optimos locales pero no 
de optimos globales.
Este algoritmo de Enfriamiento Simulado incluye una supuesta mejora que consiste que tras un numero iteraciones del bucle
exterior, el bucle interior comenzara a iterar con el mejor estado encontrado hasta el momento, este numero de 
iteracciones del bucle exterior se calculara como un tercio del nuemro total de enfriamientos, ademas incluye 
otra mejora  que consiste que tras x iteraciones del bucle interior sin mejoras, el bucle para automaticamente,
este numero de iteracciones maximas se introducira como parametro de entrada */

public class enfriamientoSimuladoMejoras3 {
	
	//Declaracion de atributos
	problemaOptimizado probl;
	grafo g;
	
	//Constructor
	public enfriamientoSimuladoMejoras3(grafo g, problemaOptimizado p){
		this.g= g;
		this.probl=p;
	}
	
	

	/*Algoritmo principal de Enfriamiento Simulado. Los parametros de entrada son los siguentes:
   (1) Temperatura: es la temperatura inicial en la que comienza el algoritmo
   (2) Factor: es el factor de enfriamiento en el cual ira decrementando la temperatuta paulativamente
   (3) nEnfriamientos:numero de enfriamientos que se llevara a cabo en la ejecucion
   (4) nIteracciones: nuemro de iteraccipnes maximas para cada valor de Temperatura
   (5) numMaxIteraccionesSinMejora: es el numero maximo de interacciones del bucle interior sin mejoras*/
	
	public estados algoritmoEnfriamientoSimuladoMejoras3(int temperatura, int factor, int nEnfriamientos, int nIteracciones, int numMaxIteracSinMejora){
		
		
		//Contador de tiempo
		long t1, t2, dif;
		Calendar ahora1 = Calendar.getInstance();
        t1 = ahora1.getTimeInMillis();
        
        //Inicializacion de variables
		int temperaturaAct= temperatura;
		estados estadoAct= probl.getEstadoAct();
		int valorAct = probl.fObjetivo(estadoAct);
		estados mejorEstado= estadoAct;
		int mejorValor= valorAct;
		int enfriamientos= nEnfriamientos;
		int iteracciones= nIteracciones;
		int factorDesc= factor;
		int numMaxIterSinMejoras= numMaxIteracSinMejora;
		int optEnfriamientos= enfriamientos/3;
		
		//Condicion que nos controla que la temperatura nunca alcance valores negativos	
		if(temperaturaAct< factorDesc * enfriamientos){
			System.out.print("Error argumentos de entrada");
		}else{
			
			int numEnfriamientos=0;
			
			/*Bucle externo del algoritmo, el cual se repetira un numero nEnfriamientos y cada x enfriamientos
			el bucle interior empezara a iterar desde el mejor estado encontrado hasta el momento*/
			for(int i=0; i<= enfriamientos;i++){
				int numIterSinMejoras=0;
				int j=0;
				
				//Condicion para que cada x enfriamientos se empiece a iterar desde el mejor estado
				if(numEnfriamientos== optEnfriamientos){
					estadoAct= mejorEstado;
					valorAct= mejorValor;
					numEnfriamientos=0;
				}else{
					numEnfriamientos++;
				}
				/*Bucle interno del algoritmo que se repetira nIteracciones o numMaxIterSinMejoras en caso de no haber mejoras en ese numero de
	  			iteracciones. En este bucle calculamos el estado candidato y lo comparamos con el actual, a continuacion calculamos el 
	  			incremento de las funciones objetivo y vemos si lo aceptamos o no llamando a la funcion aceptarCandidato.*/
				while(j<= iteracciones && numIterSinMejoras<= numMaxIterSinMejoras){
					estados candidato= probl.generaSucesor(estadoAct);
					int valorCandidato= probl.fObjetivo(candidato);
					int incremento= valorCandidato - valorAct;
					if(aceptarCandidato(incremento, temperaturaAct)){
						estadoAct = candidato;
						valorAct= valorCandidato;
					}
					//Esta condicion hace que siempre guardemos el mejor estado encontrado hasta el momento
					if(mejorValor< valorAct){
						mejorValor= valorAct;
						mejorEstado= estadoAct;
					}else{
						numIterSinMejoras ++;
					}
					j++;
				
				}
				//Decrementamos la temperatura
				temperaturaAct = temperaturaAct- factorDesc;
			}
			//Contador de tiempo
			Calendar ahora2 = Calendar.getInstance();
			t2 = ahora2.getTimeInMillis();
			dif = t2 - t1;
			//Imprimimos por pantalla los resultados obtenidos
			System.out.println("---Enfriamiento Simulado Mejora III---");
			System.out.println("Tiempo consumido: " + dif + " milisegundos");
			System.out.println("Valor funcion objetivo: "+mejorValor);
			System.out.print("Estado final: ");
			for(int i=0; i<mejorEstado.getActual().size();i++){
				System.out.print(mejorEstado.getActual().get(i));
			}
			System.out.println();
		}	
		//Devolvemos mejor estado
		return mejorEstado;
		
	}

	/*Esta funcion es la encargada de decidir si un estado es aceptado o no. Tiene como argumentos de entrada
	  el incremento y la temperatura actual*/	

		private boolean aceptarCandidato(int incremento, int temperaturaAct) {
			//Inicializacion de variables
			boolean seAcepta= false;
			 Random rnd = new Random();
			 //Esta variable contiene la probabilidad de un estado candidato
			double probabilidad= Math.exp(incremento/temperaturaAct);
			
			//Si el incremento es menor que 0, el candidato es mejor que el estado actual y se acepta automaticamente		
			if(incremento<0){
				seAcepta= true;
			}else{
				/*Si el incremento no es menor que 0, comparamos que la probabilidad del estado sea mayor igual
	  			que un numero obtenido al azar entre 0 y 1, en el caso que se cumpla se aceptara ese estado candidato
	  			aunque sea peor que el actual*/			
				if(probabilidad >= rnd.nextDouble() ){
					seAcepta=true;
				}
			}
			//Devolvemos la resolucion de la funcion		
			return seAcepta;
		}

}
