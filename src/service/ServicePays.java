package service;

import java.util.ArrayList;
import java.util.List;

import exceptions.PaysServiceException;
import metier.Pays;
import persistance.DialogueBd;

public class ServicePays
{
	public static List<Pays> recherchePays() throws PaysServiceException
	{
		ArrayList<Pays> listPays = new ArrayList<Pays>();
		List<Object> listeObj;
		int index = 0;

		String mysql = "SELECT * FROM pays ";
		listeObj = DialogueBd.lecture(mysql);
		while(listeObj.size() > index)
		{
			Pays pays = new Pays();
			pays.setNom(listeObj.get(0 + index).toString());
			pays.setCapital(listeObj.get(1 + index).toString());
			pays.setNbHabitants(Integer.valueOf(listeObj.get(2 + index).toString()));
			listPays.add(pays);
			index = index + 3;
		}
		return listPays;
	}

	public static Pays recherchePays(String unPays) throws PaysServiceException
	{
		String mysql = "SELECT * FROM pays where nom_pays='" + unPays + "'";
		List<Object> objectpays = DialogueBd.lecture(mysql);
		
		if(objectpays.isEmpty())
			throw new PaysServiceException();
		
		Pays pays = new Pays();
		pays.setNom(objectpays.get(0).toString());
		pays.setCapital(objectpays.get(1).toString());
		pays.setNbHabitants(Integer.valueOf(objectpays.get(2).toString()));
		return pays;
	}
}
