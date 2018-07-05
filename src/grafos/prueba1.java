package grafos;

import java.util.ArrayList;

import ProblemaColoreado.algoritmoColor;

public class prueba1 {

	public static void main(String[] args) {
		grafo g = new grafo();
		g.ingresarNodo("Gr");
		g.ingresarNodo("Ma");
		g.ingresarNodo("Ca");
		g.ingresarNodo("Co");
		g.ingresarNodo("Ja");
		g.ingresarNodo("Al");
		g.ingresarNodo("Se");
		g.ingresarNodo("Hu");
		
		
		
		g.adicionarEnlace("Se","Hu",0);
		g.adicionarEnlace("Se","Ca",0);
		g.adicionarEnlace("Se","Co",0);
		g.adicionarEnlace("Co","Ca",0);
		g.adicionarEnlace("Co","Ja",0);
		g.adicionarEnlace("Ca","Ma",0);
		g.adicionarEnlace("Ja","Ma",0);
		g.adicionarEnlace("Ja","Gr",0);
		g.adicionarEnlace("Ja","Al",0);
		g.adicionarEnlace("Gr","Ma",0);
		g.adicionarEnlace("Gr","Al",0);
		
		
		ArrayList<String> v = g.getNombres();
		for(int i=0; i< v.size();i++)
		System.out.println(g.getNodo(v.get(i)).getNombre());
		algoritmoColor test1 = new algoritmoColor(g);
		
		System.out.println(test1.numMinColor());
	}

}
