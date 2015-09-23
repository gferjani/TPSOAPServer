package persistance;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import exceptions.PaysServiceException;

import java.sql.Connection;
import java.sql.SQLException;

public class Connexion
{

	private static Connexion instance = null;

	// On utilise un singleton
	public static Connexion getInstance()
	{
		if(instance == null)
			instance = new Connexion();

		return instance;

	}

	// on rend le constructeur priv�
	// pour emp�cher toute cr�ation d'instance
	private Connexion()
	{
	}

	public Connection getConnexion() throws PaysServiceException
	{
		try
		{
			Context ctxt = new InitialContext();
			// On r�cup�re l'environnement
			Context envCtx = (Context) ctxt.lookup("java:comp/env");
			// On recherche la data source
			DataSource ds = (DataSource) envCtx.lookup("jdbc/DSMesPays");
			
			return ds.getConnection();

		}
		catch(Exception e)
		{
			throw new PaysServiceException(e.getMessage());
		}
	}

}
