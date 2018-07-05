package Optimizacion;

/*Esta es la interfaz principal de los problemas de optimizacion, en la cual
  definimos las funciones elementales que debe tener cualquier problema
  de optimizacion para poder ser utilizado en los algoritmos de busquedas.*/

public interface problemaOptimizado {

//Funcion Objetivo, es la funcion cuyo valor se trata de optimizar
	public int fObjetivo(estados e);
//generaSucesor, es la funcion encargada de proporcionar el sucesor de un estado
	public estados generaSucesor(estados actual);
//getEstadoAct, funcion que nos proporciona el estado actual
	public estados getEstadoAct();
//generaSucesorGuiado, es la funcion que proporciona un sucesor no aleatorio	
	public estados generaSucesorGuiado(estados actual);
	

}
