package OU5;

import java.util.Random;

class ValjPolylinje {
	
	public static final Random rand = new Random ();
	public static final int ANTAL_POLYLINJER = 10;
	
	public static void main (String[] args) {

		//Skapa ett antal slumpmässiga polylinjer
		Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
		
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
			polylinjer[i] = slumpPolylinje ();
		
		//Visa polylinjerna
		for ( Polylinje poly : polylinjer )
			System.out.println("Polylinje: "+poly+"\n langd: "+poly.langd());
		
		//Bestäm den kortaste av de polylinjer som är gula
		Polylinje kortast = polylinjer[0];
		for ( Polylinje poly : polylinjer )
			if ( poly.getFarg() == "gul" && ( poly.langd() < kortast.langd() || kortast.getFarg() != "gul" ) )
				kortast = poly;
		
		//Visa den valda polylinjen
		if (kortast.getFarg() != "gul")
			System.out.println("Kortaste gula polylinje: \n Saknas gula polylinjer!");
		else
			System.out.println("Kortaste gula polylinje: \n "+kortast+"\n langd: "+kortast.langd());
	}

	/*
	slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en
	stor bokstav i det engelska alfabetet, och slumpmässiga koordinater
	*/
	public static Punkt slumpPunkt () {
		String n = "" + (char) (65 + rand.nextInt (26));
		int x = rand.nextInt (11);
		int y = rand.nextInt (11);
		return new Punkt (n, x, y);
	}

	/*
	slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen
	blå, röd eller gul. Namn på polylinjens hörn är stora bokstäver i det
	engelska alfabetet. Två hörn kan inte ha samma namn
	*/
	public static Polylinje slumpPolylinje () {

		// skapa en tom polylinje, och lägg till hörn till den
		Polylinje polylinje = new Polylinje ();
		int antalHorn = 2 + rand.nextInt (7);
		
		// ett och samma namn kan inte förekomma flera gånger
		char valtNamn[] = new char[antalHorn];
		
		for (int i = 0; i < antalHorn; i++) {
			boolean ledig = !true;
			Punkt p = new Punkt(slumpPunkt());
			
			NameCheck:
			while (!ledig) {
				ledig = true;
				for ( char n : valtNamn )
					if (p.getNamn().toCharArray()[0] == n) {
						ledig = false;
						break;
					} else if (n == valtNamn[antalHorn-1] || !ledig)
						break NameCheck;
				
				if (!ledig) //generate new name and retry
					p = new Punkt(slumpPunkt());
			}
			
			valtNamn[i] = p.getNamn().toCharArray()[0];
			polylinje.laggTill(p);
		}
		
		// sätt färg
		String farger[] = {"gul","rod","bla"};
		polylinje.setFarg(farger[rand.nextInt(3)]);
		
		return polylinje;
	}
}
