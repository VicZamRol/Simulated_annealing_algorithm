package Optimizacion;

import grafos.grafo;

import java.util.ArrayList;
/*Esta es la interfaz principal de los estados de un problema, en ella podemos 
  podemos encontrar los metodos que tienen que tener todos los estados de un 
  problema de optimizacion*/
public interface estados {


	public ArrayList<String> getActual();
	public grafo getF();

}
