package webservice;

import java.util.HashMap;
import java.util.List;

import service.ServicePays;
import meserreurs.MonException;
import metier.Pays;

public class WebServicePays
{
	public String getListePays()
	{
		try
		{
			String response = "<countries>";
			for (Pays pays : ServicePays.recherchePays())
			{
				response += "<country>" + pays.getNom() + "</country>";
			}
			response += "</countries>";
			return response;
		} catch (MonException e)
		{
			e.printStackTrace();
		}
		return "<error>Impossible d'afficher les pays</error>";
	}

	public String donneInfoPays(String pays)
	{
		try
		{
			String response = "<country><name>" + pays + "</name>";
			Pays unPays = ServicePays.recherchePays(pays);
			response += "<capital>" + unPays.getCapital() + "</capital>";
			response += "<nbinhab>" + unPays.getNbHabitants() + "</nbinhab>";
			response += "</country>";
			return response;
		} catch (MonException e)
		{
			e.printStackTrace();
		}
		return "<error>Impossible d'afficher les données de ce pays</error>";
	}
}
