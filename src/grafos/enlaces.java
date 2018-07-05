package grafos;

public class enlaces { 
	 
	 	private String destino;
	 	private double peso;
	 
	 	

		public enlaces(String desti, double peso1)
	 	{
	 		destino = desti;
	 		peso = peso1;
	 	}
	 
	 	public enlaces(String desti)
	 	{
	 		destino = desti;
	 		peso = -1;
	 	}
	 
	 	public void modificar(double peso1)
	 	{
	 		peso = peso1;
	 	}
	 
	 	public String getDestino()
	 	{
	 		return destino;
	 	}
	 
	 	public double getPeso()
	 	{
	 		return peso;
	 	}
	 }


