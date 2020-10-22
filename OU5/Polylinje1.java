package OU5;

public class Polylinje1 {

	//Instansierade variabler
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;
	
	public Polylinje1 () {	//Skapar polylinjen
		this.horn = new Punkt[0];
	}
	
	public Polylinje1 (Punkt[] horn) {
		this.horn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
			this.horn[i] = new Punkt (horn[i]);
	}
	
	//Ersätter toString metoden för att visa punktens innehåll
	public String toString () {
		StringBuilder res = new StringBuilder("{[");
		for ( Punkt h : horn)
			res.append(h+",");
		res.delete(res.length()-1, res.length());
		String ret = res.append("], "+farg+", "+bredd+"}").toString();
		return ret;
	}
	
	public Punkt[] getHorn () {
		Punkt[] nyHorn = new Punkt[horn.length];
		for (int i = 0; i<horn.length; i++)
			nyHorn[i] = new Punkt(horn[i]);
		return nyHorn;
	}

	public String getFarg () {			return farg;		}
	public int getBredd () {			return bredd;		}
	public void setFarg (String farg) {	this.farg = farg;	}
	public void setBredd (int bredd) {	this.bredd = bredd;	}
	
	public double langd () {
		double totLang = 0;
		for (int i =1; i < horn.length; i++){
			double xDist = Math.abs( horn[i-1].getX() - horn[i].getX());
			double yDist = Math.abs( horn[i-1].getY() - horn[i].getY());
			totLang += Math.sqrt( xDist*xDist + yDist*yDist);
		}
		return totLang;
	}
	
	public void laggTill (Punkt horn) {
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		for (i = 0; i < this.horn.length; i++)
		h[i] = this.horn[i];
		h[i] = new Punkt (horn);
		this.horn = h;
	}
	
	//Metod för att lägga till ett hörn längst fram i polylinjen.
	public void laggTillFramfor (Punkt horn, String hornNamn) {
		Punkt[] h = new Punkt[this.horn.length + 1];
		h[0] = new Punkt (horn);
		for (int i = 1; i <= this.horn.length; i++)
			h[i] = this.horn[i-1];
		this.horn = h;
	}
		
	//Metod för att ta bort ett hörn i polylinjen.
	public void taBort (String hornNamn) {
		Punkt[] newHorn = new Punkt[horn.length -1];
		int n = 0;
		for ( Punkt h : horn)
		{
			if (!h.getNamn().equals(hornNamn)) {
				newHorn[n] = horn[n];
				n++;
			}
		}
		this.horn = newHorn;
	}
}
