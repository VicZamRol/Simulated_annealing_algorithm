package ProblemaColoreado;

import grafos.grafo;
import grafos.nodo;

import java.util.ArrayList;

import Optimizacion.estados;
import Optimizacion.problemaOptimizado;

/*Esta clase transforma un problema cualquiera de coloreado en un problema optimizado, el cual podremos
  utilizar en los algoritmos de busquedas. Esta clase implementa la interfaz problemaOptimizado*/

public class problemaOptimizacionColoreado implements problemaOptimizado {
	
	//Inicializacion variables
	private estados estadoAct;
	grafo g;

	//Contructor
	public problemaOptimizacionColoreado(grafo f){
		this.g= f;
		this.setEstadoAct(new estadoColoreado(f));
		
	}
	
	//Funcion la cual queremos optimizar en los algoritmos de busqueda	
	public int fObjetivo(estados e){
		return ((estadoColoreado) e).getActual().size() - ((estadoColoreado) e).getNumColor();
		
	}
	//Genera aleatoriamente los estados sucesores de un estado actual
	public estados generaSucesor(estados actual){
		ArrayList<String> act = ((estadoColoreado) actual).getActual();
		int aleatorio1 = (int) Math.floor(Math.random()* (act.size()));
		int aleatorio2 = (int) Math.floor(Math.random()* (act.size()));

		
		String aux1= act.get(aleatorio1);
		String aux2= act.get(aleatorio2); 
		act.set(aleatorio1, aux2);
		act.set(aleatorio2, aux1);
	   estados sucesor = new estadoColoreado(g,act);
	   return sucesor;
	}
	
	//Genera heuristicamente (ordenacion ascendente por numero de vecinos) los estados sucesores de un estado actual
	public estados generaSucesorGuiado(estados actual){
		ArrayList<String> act= ((estadoColoreado) actual).getActual();
		ArrayList<String> auxA= new ArrayList<String>();
		auxA.addAll(act);
		ArrayList<String> suc= new ArrayList<String>();
		
		while(auxA.size()>0){
		
			int numVecMejor = 0;
			String nodoMejor= auxA.get(0);
			for(int i=0; i< auxA.size();i++){
				String nodoActual=auxA.get(i);
				nodo nodoAct=g.getNodo(nodoActual);
				int numVecAct= nodoAct.getEnlacesExistentes();
			
				if(numVecMejor <= numVecAct){
					numVecMejor= numVecAct;
					nodoMejor= nodoActual;
				}
			}
			auxA.remove(nodoMejor);
			suc.add(nodoMejor);
			
		}

		
		estados sucesor= new estadoColoreado(g,suc);
		return sucesor;
		
		
	}

	//Devuelve estado actual
	public estados getEstadoAct() {
		return  estadoAct;
	}

	//Modifica estado actual
	public void setEstadoAct(estadoColoreado estadoAct) {
		this.estadoAct = estadoAct;
	}
}
