package OU5;

public class Punkt {
	
	private String pNamn;
	private int pX;
	private int pY;

	@Override
	public String toString() {
		return "("+pNamn+" "+pX+" "+pY+")";
	}
	
	public boolean equals(Punkt p) {
		boolean equality = (pNamn.equals(p.getNamn()) && pX == p.getX() && pY ==p.getY());
		return equality;
	}
	
	public Punkt(String punktnamn, int x, int y) {
		pNamn = punktnamn;
		pX = x;
		pY = y;
	}

	public Punkt(Punkt p) {
		pNamn = p.getNamn();
		pX = p.getX();
		pY = p.getY();
	}

	public String getNamn() {
		return pNamn;
	}

	public int getX() {
		return pX;
	}

	public int getY() {
		return pY;
	}

	public double avstand(Punkt p) {
		double xDist = Math.abs( pX - p.getX());
		double yDist = Math.abs( pY - p.getY());
		double dist = Math.sqrt( xDist*xDist + yDist*yDist);
		
		return dist;
	}

	public void setX(int x) {
		pX = x;
	}

	public void setY(int y) {
		pY = y;
	}
}
