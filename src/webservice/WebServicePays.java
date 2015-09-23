package webservice;

import service.ServicePays;

import java.util.Collection;

import exceptions.PaysServiceException;
import metier.Pays;

public class WebServicePays
{
	public Collection<Pays> getListePays()
	{
		try
		{
			return ServicePays.recherchePays();
		}
		catch(PaysServiceException e)
		{
			return null;
		}
	}

	public Pays donneInfoPays(String pays)
	{
		try
		{
			return ServicePays.recherchePays(pays);
		}
		catch(PaysServiceException e)
		{
			return null;
		}
	}
}
