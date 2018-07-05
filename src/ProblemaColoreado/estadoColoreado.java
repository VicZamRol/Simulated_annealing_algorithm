package ProblemaColoreado;

import grafos.grafo;

import java.util.ArrayList;

import Optimizacion.estados;

/*Creacion del estado para el problema de coloreado de mapas. Implementa la
 interfaz estados.
 Atributos:
 actual= es una lista con el nombre de los nodos que forman un estado.
 grafo= es el grafo original del problema.
 algoritmo1= es el algoritmo que nos da el menor numero necesario de colores
 numColor= numero menor d ecolores necesarion.*/

public class estadoColoreado implements estados {
	
	//Inicializacion variables
	public static ArrayList<String> actual;
	grafo f;
	algoritmoColor a;
	int numColor; 
	
	//Constructores
	public estadoColoreado(grafo g,ArrayList<String> s){
		this.f=g;
		this.actual= s;
		algoritmoColor a = new algoritmoColor(g,s);
		this.numColor= a.numMinColor();
	}
	public estadoColoreado(grafo g){
		this.f=g;
		this.actual= g.getNombres();
		algoritmoColor a = new algoritmoColor(g);
		this.numColor= a.numMinColor();
	}
	
	//Devuelve una lista de los nodos del estado
	public ArrayList<String> getActual() {
		return actual;
	}
	
	//Devuelve el numero minimo de colores necesarios para colorear el grafo (no siempre es minimo)
	public int getNumColor() {
		return numColor;
	}
	
	//Devuelve el grafo del problema
	public grafo getF() {
		return f;
	}
	

}
