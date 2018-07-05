package grafos;

import java.util.Hashtable;
import java.util.ArrayList;

public class grafo
{
	ArrayList <String>nombres;
	ArrayList <arco>aristas;
	Hashtable <String,nodo> nodos;

	public grafo()
	{
		nombres=new ArrayList<String>();
		nodos=new Hashtable <String,nodo>();
		aristas=new ArrayList <arco>();
	}

	public void ingresarNodo(String nombre)
	{
		nombres.add(nombre);
		nodos.put(nombre,new nodo(nombre));
	}
	public void adicionarEnlace(String nodoInicial,String nodoTerminal,float peso)
	{
		arco nuevo=new arco(nodoInicial,nodoTerminal,peso);
		int i=buscarIndice(nuevo.getPeso());

		if(i==-1)
			aristas.add(nuevo);
		else
			aristas.add(i,nuevo);

		nodos.get(nodoInicial).agregarEnlace(nodoTerminal,peso);
		nodos.get(nodoTerminal).agregarEnlace(nodoInicial,peso);
	}
	public boolean busarArista(arco arco)
	{
		for(int i=0;i<aristas.size();i++)
		{
			arco otro=aristas.get(i);
			if(arco.getInicial().equals(otro.getInicial())&&arco.getTerminal().equals(otro.getTerminal())&&arco.getPeso()==otro.getPeso())
			{
				aristas.remove(otro);
				return true;
			}
		}
		return false;
	}
	public int buscarIndice(float peso)
	{
		for(int i=0;i<aristas.size();i++)
		{
 			if(peso<aristas.get(i).getPeso())
				return i;
		}
		return -1;
	}
	public Hashtable getNodos()
	{
		return nodos;
	}
	public void setNodos(Hashtable<String,nodo > muchos)
	{
		nodos=muchos;
	}
	public ArrayList<String> getNombres()
	{
		return nombres;
	}
	public nodo getNodo(String nombre)
	{
		return (nodo)nodos.get(nombre);
	}

	public ArrayList<arco> getAristas() {
		return aristas;
	}

	public void setAristas(ArrayList<arco> aristas) {
		this.aristas = aristas;
	}

	public void setNombres(ArrayList<String> nombres) {
		this.nombres = nombres;
	}

}
