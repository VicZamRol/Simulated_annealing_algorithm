package Optimizacion;

import java.util.Calendar;
import java.util.Random;

import grafos.grafo;

/*El algoritmo de Enfriamiento Simulado esta inspirado en el enfriamiento Fisico-quimico  de metales,
  la idea principal es ir aceptando estados peores, dependiendo de la probabilidad en funcion del 
  incremneto producido en la funcion objetivo, nos permite asi salir de optimos locales pero no 
  de optimos globales */

public class enfriamientoSimulado {

	//Declaracion de atributos	
	problemaOptimizado probl;
	grafo g;

	//Constructor
	public enfriamientoSimulado(grafo g, problemaOptimizado p){
		this.g= g;
		this.probl=p;
	}
	/*Algoritmo principal de Enfriamiento Simulado. Los parametros de entrada son los siguentes:
  	(1) Temperatura: es la temperatura inicial en la que comienza el algoritmo
  	(2) Factor: es el factor de enfriamiento en el cual ira decrementando la temperatuta paulativamente
  	(3) nEnfriamientos:numero de enfriamientos que se llevara a cabo en la ejecucion
  	(4) nIteracciones: nuemro de iteraccipnes maximas para cada valor de Temperatura*/	
	public estados algoritmoEnfriamientoSimulado(int temperatura, int factor, int nEnfriamientos, int nIteracciones){

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
		
		//Condicion que nos controla que la temperatura nunca alcance valores negativos		
		if(temperaturaAct< factorDesc * enfriamientos){
			System.out.print("Error argumentos de entrada");
		}else{
	
			//Bucle externo del algoritmo, el cual se repetira un numero nEnfriamientos 			
			for(int i=0; i<= enfriamientos;i++){
				
				/*Bucle interno del algoritmo que se repetira nIteracciones. En este bucle calculamos el estado candidato
  				y lo comparamos con el actual, a continuacion calculamos el incremento de las funciones objetivo y vemos 
  				si lo aceptamos o no llamando a la funcion aceptarCandidato.*/				
				for(int j=0; j<= iteracciones;j++){
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
					}
				}
				//Decrementamos la temperatura
				temperaturaAct = temperaturaAct- factorDesc;
			}
			//Contador de tiempo		
			Calendar ahora2 = Calendar.getInstance();
			t2 = ahora2.getTimeInMillis();
			dif = t2 - t1;
			//Imprimimos los resultados obtenidos			
			System.out.println("---Enfriamiento Simulado Original---");
			System.out.println("Tiempo consumido: " + dif + " milisegundos");
		
			System.out.println("Valor funcion objetivo: "+mejorValor);
			System.out.print("Estado final: ");
			for(int i=0; i<mejorEstado.getActual().size();i++){
				System.out.print(mejorEstado.getActual().get(i));
			}
			System.out.println();
		}
			//Devolvemos el mejor estado		
			return mejorEstado;
		
	}
	
/*Esta funcion es la encargada de decidir si un estado es aceptado o no. Tiene 
  como argumentos de entrada el incremento y la temperatura actual*/	

	private boolean aceptarCandidato(int incremento, int temperaturaAct) {
		//Inicializacion de variables
		boolean seAcepta= false;
		 Random rnd = new Random();
		 //Esta variable contiene la probabilidad de un estado candidato
		double probabilidad= Math.exp(incremento/temperaturaAct);
		
		/*Si el incremento es menor que 0, el candidato es mejor que el estado
		actual y se acepta automaticamente*/	
		if(incremento<0){
			seAcepta= true;
		}else{
			/*Si el incremento no es menor que 0, comparamos que la probabilidad 
			del estado sea mayor igual que un numero obtenido al azar entre 0 y 1,
		    en el caso que se cumpla se aceptara ese estado candidato aunque sea peor
		     que el actual*/			
			if(probabilidad >= rnd.nextDouble() ){
				seAcepta=true;
			}
		}
		//Devolvemos la resolucion de la funcion		
		return seAcepta;
	}

}
