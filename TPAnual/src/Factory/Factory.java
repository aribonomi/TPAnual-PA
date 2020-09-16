package Factory;
import dao.implDB.*;
import dao.Interfaces.*;

public class Factory {



	public static ClienteDAO getClienteDaoImplMysql() {

		return new ClienteDAOImplMySQL();
	}

	public static AeropuertoDAO getAeropuertoDaoImplMysql() {

		return new AeropuertoDaoImplMysql();

	}

	public static DireccionDAO getDireccionDaoImplMysql() {

		return new DireccionDaoImplMysql();

	}

	public static LineaAereaDAO getLineaAereaDaoImplMysql() {

		return new LineaAereaDAOImplMySQL();
	}


	public static PaisDAO getPaisDao() {

		return new PaisDAOImplMySQL();
	}

	public static PasajeroFrecuenteDAO getPasajeroFrecuenteDaoImplMysql() {


		return new PasajeroFrecuenteDAOImplMySQL();

	}

	public static PasaporteDAO getPasaporteDaoImplMysql() {


		return new PasaporteDAOImplMySQL();
	}



	public static ProvinciaDAO getProvinciaDaoImplMysql() {

		return new ProvinciaDAOImplMySQL();
	}


	public static TelefonoDAO getTelefonoDaoImplMysql() {

		return new TelefonoDAOImplMySQL();
	}


    public static VentasDAO getVentasDaoImplMysql() {
   
    	return new VentasDAOImplMySQL();
    }

    public static VuelosDAO getVuelosDaoImplMysql() {

    	return new VuelosDAOImplMySQL();
    }
}