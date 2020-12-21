package it.omicron.esercizio.controller;



import it.omicron.esercizio.MenuContent;
import it.omicron.esercizio.MenuNode;
import it.omicron.esercizio.read.FoglioExcel;
import it.omicron.esercizio.read.LettoreFile;

public class Controllore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//C:\Users\mmoll
		
		LettoreFile l1 = new LettoreFile("//properties.txt");
		String[] arr = new String[2];
		arr = l1.lettoreInput().split(",");
		
		String input = arr[0];
		String output = arr[1];
		
		LettoreFile l = new LettoreFile(input);
		String jsonString = l.leggi();
		
		MenuContent menuc = l.traduci(jsonString);
		MenuNode m = new MenuNode();
		
		m.calcoloProfonditaMax(menuc.getNodes(), 0);
		
		FoglioExcel foglio = new FoglioExcel(output, m.getMaxProfondita());
		
		foglio.createFoglio(menuc.getNodes(), menuc.getVersion());
		
		
		
	}

} 
