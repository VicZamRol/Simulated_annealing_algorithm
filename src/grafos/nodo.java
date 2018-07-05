package grafos;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class nodo {
	
	 
	 	private String nombre;
	 	private ArrayList<enlaces> enlaces;
	 	private int enlacesExistentes;
	 
	 	public ArrayList<grafos.enlaces> getEnlaces()
	 	{
	 		return enlaces;
	 	}
	 
	 	public nodo(String newName)
	 	{
	 		nombre = newName;
	 		enlacesExistentes = -1;
	 		enlaces = new ArrayList<enlaces>();
	 	}
	 
	 	public int getEnlacesExistentes()
	 	{
	 		return enlacesExistentes;
	 	}
	 
	 	public String getNombre()
	 	{
	 		return nombre;
	 	}
	 
	 	public void agregarEnlace(String enlazar,double peso)
	 	{
	 		if (enlacesExistentes == -1)
	 		{
	 			enlaces.add(new enlaces(enlazar,peso));
	 			enlacesExistentes++;
	 		}
	 		else
	 		{
	 			int posicion;
	 			posicion = existeEnlace(enlazar);
	 			if (posicion == -1)
	 			{
	 				enlaces.add(new enlaces(enlazar,peso));
	 				enlacesExistentes++;
	 			}
	 		}
	 	}
	 
	 	public int existeEnlace(String enlazar)
	 	{
	 		for (int i = 0; i < enlaces.size(); i++)
	 		{
	 			enlaces miEnlace;
	 			miEnlace = enlaces.get(i);
	 			if (miEnlace.getDestino().equals(enlazar))
	 				return i;
	 		}
	 		return -1;
	 	}
	 
	 	public double enlacePosicion(int posi)
	 	{
	 		enlaces miEnlace;
	 		miEnlace = enlaces.get(posi);
	 		return miEnlace.getPeso();
	 	}
	 
	 	public String NodoPosicion(int posi)
	 	{
	 		enlaces miEnlace;
	 		miEnlace = enlaces.get(posi);
	 		return miEnlace.getDestino();
	 	}
	 
	 	boolean eliminarEnlace(int posicion)
	 	{
	 		if (posicion >= 0 && posicion <= enlaces.size())
	 		{
	 			enlaces.remove(posicion);
	 			enlacesExistentes--;
	 			return true;
	 		}
	 		else
	 			JOptionPane.showMessageDialog(null, "No hay enlace en la posicion " + posicion); 
	 	 	return false;
	 	}
	 }

