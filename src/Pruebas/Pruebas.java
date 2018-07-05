package Pruebas;

import grafos.grafo;




import Optimizacion.busquedaEscaladaAleatoria;
import Optimizacion.busquedaEscaladaGuiada;
import Optimizacion.busquedaEscaladaGuiadaMejora;
import Optimizacion.enfriamientoSimulado;
import Optimizacion.enfriamientoSimuladoMejoras1;
import Optimizacion.enfriamientoSimuladoMejoras2;
import Optimizacion.enfriamientoSimuladoMejoras3;
import Optimizacion.problemaOptimizado;
import ProblemaColoreado.algoritmoColor;
import ProblemaColoreado.problemaOptimizacionColoreado;

public class Pruebas {

	public static void main(String[] args) {
		
    //Creacion del grafo para problema del coloreado
		grafo g = new grafo();
		
		g.ingresarNodo("C");
		g.ingresarNodo("D");
		g.ingresarNodo("A");
		g.ingresarNodo("B");
		
	g.ingresarNodo("E");
		g.ingresarNodo("F");
		g.ingresarNodo("G");
		g.ingresarNodo("H");
		g.ingresarNodo("I");
		g.ingresarNodo("J");
		g.ingresarNodo("K");
		g.ingresarNodo("L");
		g.ingresarNodo("M");
		g.ingresarNodo("N");
		g.ingresarNodo("O");
		g.ingresarNodo("P");
		g.ingresarNodo("Q");
		g.ingresarNodo("R");
		g.ingresarNodo("S");
		g.ingresarNodo("T");

//Creamos enlaces del grafo
		
	g.adicionarEnlace("A","F",0);
		g.adicionarEnlace("A","B",0);
		g.adicionarEnlace("A","G",0);
		g.adicionarEnlace("A","R",0);
		g.adicionarEnlace("B","G",0);
		g.adicionarEnlace("C","G",0);
		g.adicionarEnlace("C","K",0);
		g.adicionarEnlace("C","H",0);
		g.adicionarEnlace("C","D",0);
		g.adicionarEnlace("D","E",0);
		g.adicionarEnlace("D","G",0);
		g.adicionarEnlace("E","I",0);
		g.adicionarEnlace("E","H",0);
		g.adicionarEnlace("F","K",0);
		g.adicionarEnlace("F","G",0);
		g.adicionarEnlace("G","L",0);
		g.adicionarEnlace("G","N",0);
		g.adicionarEnlace("G","R",0);
		g.adicionarEnlace("H","L",0);
		g.adicionarEnlace("H","K",0);
		g.adicionarEnlace("H","M",0);
		g.adicionarEnlace("H","Q",0);
		g.adicionarEnlace("I","L",0);
		g.adicionarEnlace("J","Q",0);
		g.adicionarEnlace("J","K",0);
		g.adicionarEnlace("J","I",0);
		g.adicionarEnlace("K","N",0);
		g.adicionarEnlace("K","Q",0);
		g.adicionarEnlace("K","O",0);
		g.adicionarEnlace("K","L",0);
		g.adicionarEnlace("L","O",0);
		g.adicionarEnlace("L","P",0);
		g.adicionarEnlace("L","M",0);
		g.adicionarEnlace("M","T",0);
		g.adicionarEnlace("M","S",0);
		g.adicionarEnlace("N","R",0);
		g.adicionarEnlace("Q","R",0);
		g.adicionarEnlace("Q","S",0);
		g.adicionarEnlace("Q","T",0);
		g.adicionarEnlace("O","S",0);
		g.adicionarEnlace("P","T",0);
		g.adicionarEnlace("P","R",0);
		g.adicionarEnlace("R","S",0);
		g.adicionarEnlace("S","T",0);

//Algoritmo que nos da el supuesto numero minimo de colores (no siempre acierta)
		algoritmoColor test1 = new algoritmoColor(g);		
		System.out.println(test1.numMinColor());
		
/* Creamos problema optimizado, es decir, creamos todos los elementos necesarios
   de un problema de optimizacion a partir de un grafo de entrada */				
		problemaOptimizado pO= new problemaOptimizacionColoreado(g);
/*NOTA: Todos los constructores de busqueda tienen como parametros de entrada:
		(a) grafo
  		(b) problema optimizado*/
		
// Busqueda con Escalada Aleatoria
//		busquedaEscaladaAleatoria be = new busquedaEscaladaAleatoria(g,pO);
//		be.algoritmoBusquedaEscalada();

//Busqueda con Escalada Guiada.
		
		busquedaEscaladaGuiada beg= new busquedaEscaladaGuiada(g,pO);
		beg.algoritmoBusquedaEscalada();
		
//Busqueda con Escalada Guiada con mejora.
		busquedaEscaladaGuiadaMejora begm= new busquedaEscaladaGuiadaMejora(g,pO);
		begm.algoritmoBusquedaEscalada();

//Busqueda con Enfriamiento Simulado Original. 
		enfriamientoSimulado es= new enfriamientoSimulado(g,pO);
		es.algoritmoEnfriamientoSimulado(71, 10, 7, 5);
		
/*Busqueda con Enfriamiento Simulado con mejoras en las iteracciones del
  bucle interno*/
		enfriamientoSimuladoMejoras1 esm1= new enfriamientoSimuladoMejoras1(g,pO);
		esm1.algoritmoEnfriamientoSimuladoMejoras1(71, 10, 7, 5,3);
		
/*Busqueda con Enfriamiento Simulado con mejoras en las iteracciones del
  bucle externo*/		
		enfriamientoSimuladoMejoras2 esm2= new enfriamientoSimuladoMejoras2(g,pO);
		esm2.algoritmoEnfriamientoSimuladoMejoras2(71, 10, 7, 5);
		
/*Busqueda con Enfriamiento Simulado con mejoras en las iteracciones del
  bucle interno y externo*/		
		enfriamientoSimuladoMejoras3 esm3= new enfriamientoSimuladoMejoras3(g,pO);
		esm3.algoritmoEnfriamientoSimuladoMejoras3(71, 10, 7, 5,3);
		
		
	}
	

	}


