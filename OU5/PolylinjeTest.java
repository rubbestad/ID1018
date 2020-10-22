package OU5;

import java.io.PrintWriter;

public class PolylinjeTest {

	public static void main (String[] args) {

		PrintWriter out = new PrintWriter (System.out, true);
		
		//Testar skapa 4 hörn objekt att mata in i polylinjerna
		Punkt 	p1 = new Punkt ("A", 3, 4),
				p2 = new Punkt ("B", 4, 6),
				p3 = new Punkt ("C", 2, 2),
				p4 = new Punkt ("D", 1, 1);
		
		out.println (	"Oanvända punkter: \n "+p1+" "+p2+" "+p3+" "+p4+"\n");
		
		//Skapar lista för hörn objekt att initialisera polylinjerna med
		Punkt[] pGrupp = {	new Punkt ("E", 3, 2),
							new Punkt ("F", 4, 1)};
		
		//Testar skapa polylinje objekt
		Polylinje poly1 = new Polylinje (pGrupp);
		Polylinje poly2 = new Polylinje (pGrupp);
		
		out.println (	"PolyLinjer:\n "+poly1+"\n   langd: "+poly1.langd()+
						"\n "+poly2+"\n   langd: "+poly2.langd()+"\n\n"+
						"Testar laggTill: \n "+poly1+"\n   langd: "
						+poly2.langd()+"\n läggTill "+p1+" ger:");
		
		//Testar laggTill
		poly1.laggTill(p1);
		out.println (	" "+poly1+"\n   langd: "+poly1.langd()
						+"\n\nTestar setBredd(5):");
		
		//Testar setBredd:
		poly1.setBredd(5);
		out.println (	" "+poly1+"\n   langd: "+poly1.langd()+"\n");
		
		//Testar setFarg
		poly1.setFarg("gul");
		out.println (	"Testar setFarg(\"vit\"):\n "+poly1+"\n   langd: "+
						poly1.langd()+"\n\nTestar laggTillFramfor("+p2+
						",\"F\"):\n "+poly1+"\n   langd: "+poly1.langd()+p2);
		
		//Testar laggTillFramfor
		poly1.laggTillFramfor(p2, "F");
		out.println (	" lägg till "+p2+" framför F ger:\n "+poly1+
						"\n   langd: "+poly1.langd()+"\n\nTestar taBort(\"E\"):");
		
		//Testar ta bort
		poly1.taBort("E");
		out.println (	" "+poly1+"\n   langd: "+poly1.langd()+
						"\n\nTestar getHorn:");
		
		//Testar getHorn
		Punkt[] hornImport = poly1.getHorn();
		for (int i = 0; i < hornImport.length; i++) {
			out.print(" "+hornImport[i]);
		}
		
		//Testar getFarg och getBredd
		out.println (	"\n\nTestar getFarg:\n "+poly1.getFarg()+
						"\n\nTestar getBredd:\n "+poly1.getBredd()+
						"\n\nTestar PolylinjeIterator:");
		
		Polylinje.PolylinjeIterator iter = poly1.new PolylinjeIterator();
		
		while (iter.finnsHorn()) {
			System.out.println(" " + iter.horn());
			iter.gaFram();
		}
	}
}
