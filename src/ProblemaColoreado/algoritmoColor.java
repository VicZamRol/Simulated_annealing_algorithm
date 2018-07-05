package ProblemaColoreado;

/*Este algotimo calcula el numero minimo de colores necesarios para
 colorear un grafo*/

import java.util.ArrayList;
import java.util.Hashtable;
import grafos.enlaces;
import grafos.grafo;
import grafos.nodo;

//Constructores y creacion de variables
public class algoritmoColor {
	grafo g;
	private Hashtable<String,Integer> map = new Hashtable<String,Integer>();
	ArrayList<String> n;
	
	public algoritmoColor(grafo r){
		this.g=r;
		this.n=r.getNombres();
		
	}
	public algoritmoColor(grafo r, ArrayList<String> p){
		this.g=r;
		this.n=p;
	}

	//Algoritmo principal de la coloracion de grafos
	public int numMinColor(){
		int cnt =1;
		int color;
			
		//Bucle en el cual se recorre lo nodos del grafo y se estudian sus vecinos		
		for(int i=0; i<n.size();i++){
			color=1;
			String nodoActual=n.get(i);
			nodo nodoAct=g.getNodo(nodoActual);
			ArrayList<enlaces> aristas=nodoAct.getEnlaces();
			
			//Mientras existan aristas sin estudiar, se recorreran cada una de ellas y se estudiara el color
			int j = 0;
			while( j<aristas.size()){
				String nodoVecino=aristas.get(j).getDestino();
				if(map.containsKey(nodoVecino) && map.get(nodoVecino).equals(color)){
					color++;
					j= -1;
				}
				j++;
			}
			// Cuando hayamos encontrado el color correcto, lo almacenamos en un map y finalmente obtenemos el menor
			// numero de colores nacesarios
			map.put(nodoActual, color);
			if(cnt < color)
			cnt = color;
	
		}
		
		
	return cnt;
	
	}
}
