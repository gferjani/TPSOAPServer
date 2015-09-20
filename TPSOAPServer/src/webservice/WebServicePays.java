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
			String response = "";
			for (Pays pays : ServicePays.recherchePays())
			{
				response += "<country>"+pays.getNom() + "</country>\n";
			}
			return response;
		} catch (MonException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Impossible d'afficher les pays";
	}

	public String donneInfoPays(String pays)
	{
		try
		{
			String response = "<country>\n<name>" + pays+"</name>\n";
			Pays unPays = ServicePays.recherchePays(pays);
			response += "<capital>" + unPays.getCapital()+"</capital>\n";
			response += "<nbinhab>" + unPays.getNbHabitants()+"</nbinhab>\n";
			response +="</country>";
			return response;
		} catch (MonException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Impossible d'afficher les données de ce pays";
	}
}
