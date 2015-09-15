package Webservice;

import java.util.HashMap;
import java.util.List;

import service.ServicePays;
import meserreurs.MonException;
import metier.Pays;

public class WebServicePays
{
	public String getListePays(){
		try
		{
			String response="";
			for(Pays pays:ServicePays.recherchePays())
			{
				response+=pays.getNom()+"\n";
			}
			return response;
		} catch (MonException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Impossible d'afficher les pays";
	}
	public String donneInfoPays(String pays){
		try
		{
			String response="Pour le pays "+pays;
			Pays unPays=ServicePays.recherchePays(pays);
			response+="\n Capital:"+unPays.getCapital();
			response+="\n Nombre d'habitants:"+unPays.getNbHabitants();
			return response;
		} catch (MonException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Impossible d'afficher les données de ce pays";
	}
}
