package OU5;

public class Polylinje
{
	//Instansierade variabler
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;
	
	public Polylinje ()	//Skapar polylinjen
	{
		this.horn = new Punkt[0];
	}
	
	public Polylinje (Punkt[] horn)
	{
		this.horn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
		this.horn[i] = new Punkt (horn[i]);
	}
	
	//ersätter toString metoden för att visa punktens innehåll
	public String toString () {
		StringBuilder res = new StringBuilder("{[");
		for ( Punkt h : horn) {
			res.append(h+",");
		}
		res.delete(res.length()-1, res.length());
		res.append("], "+farg+", "+bredd+"}");
		String ret = res.toString();
		return ret;
	}
	
	//Metoder för att returnera och ändra instansierade lokala värden av polylinjen
	public Punkt[] getHorn () {			return horn;		}
	public String getFarg () {			return farg;		}
	public int getBredd () {			return bredd;		}
	public void setFarg (String farg) {	this.farg = farg;	}
	public void setBredd (int bredd) {	this.bredd = bredd;	}
	
	//Metod för att räkna ut längden på polylinjen
	public double langd ()
	{
		double totLang = 0;
		for (int i =1; i < horn.length; i++){
			double xDist = Math.abs( horn[i-1].getX() - horn[i].getX());
			double yDist = Math.abs( horn[i-1].getY() - horn[i].getY());
			totLang += Math.sqrt( xDist*xDist + yDist*yDist);
		}
		return totLang;
	}
	
	//Metod för att lägga till ett hörn i polylinjen
	public void laggTill (Punkt horn) {
		Punkt[] newHorn = new Punkt[this.horn.length + 1];
		int i = 0;
		for (i = 0; i < this.horn.length; i++)
			newHorn[i] = this.horn[i];
		newHorn[i] = new Punkt (horn);
		this.horn = newHorn;
	}
	
	//Metod för att lägga till ett hörn längst fram i polylinjen
	public void laggTillFramfor (Punkt horn, String hornNamn) {
		Punkt[] newHorn = new Punkt[this.horn.length + 1];
		int i = 0;
		for ( Punkt h : this.horn ) {
			if (h.getNamn().equals(hornNamn)) {
				newHorn[i] = new Punkt (horn);
				i++;
			}
			newHorn[i] = h;
			i++;
		}
			
		this.horn = newHorn;
	}
	
	//Metod för att ta bort ett hörn i polylinjen
	public void taBort (String hornNamn) {
		Punkt[] newHorn = new Punkt[horn.length -1];
		int n = 0;
		for ( Punkt h : horn) {
			if (!h.getNamn().equals(hornNamn)) {
				newHorn[n] = h;
				n++;
			}
		}
		this.horn = newHorn;
	}
	
	public class PolylinjeIterator {

		private int aktuell = -1;
		
		public PolylinjeIterator () {
			if (Polylinje.this.horn.length > 0)
				aktuell = 0;
		}
		
		public boolean finnsHorn ()
		{
			return aktuell != -1;
		}
		
		public Punkt horn () throws java.util.NoSuchElementException {

			if (!this.finnsHorn ())
				throw new java.util.NoSuchElementException ("slut av iterationen");
			
			Punkt horn = Polylinje.this.horn[aktuell];
			return horn;
		}
		
		public void gaFram () {

			if (aktuell >= 0 && aktuell < Polylinje.this.horn.length - 1)
				aktuell++;
			else
				aktuell = -1;
		}
	}
}
