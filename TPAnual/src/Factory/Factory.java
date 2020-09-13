package Factory;
import dao.implDB.*;
import dao.Interfaces.*;

public class Factory {



	public static ClienteDAO getClienteDaoImplMysql() {

		return new ImplDAOClientes();
	}

	public static AeropuertoDAO getAeropuertoDaoImplMysql() {

		return new AeropuertoDaoImplMysql();

	}

	public static DireccionDAO getDireccionDaoImplMysql() {

		return new DireccionDaoImplMysql();

	}

//	public static LineaAereaDAO getLineaAereaDaoImplMysql() {
//
//		return new LineaAereaDaoImplMysql();
//	}
//
//
//	public static PaisDAO getPaisDao() {
//
//		return new PaisDaoImplMysql();
//	}
//
//	public static PasajeroFrecuenteDAO getPasajeroFrecuenteDaoImplMysql() {
//
//
//		return new PasajeroFrecuenteDaoImplMysql();
//
//	}
//
//	public static PasaporteDAO getPasaporteDaoImplMysql() {
//
//
//		return new PasaporteDaoImplMysql();
//	}
//
//
//
//	public static ProvinciaDAO getProvinciaDaoImplMysql() {
//
//		return new ProvinciaDaoImplMysql();
//	}
//
//
//	public static TelefonoDAO getTelefonoDaoImplMysql() {
//
//		return new TelefonoDaoImplMysql();
//	}
//
//
//    public static VentasDAO getVentasDaoImplMysql() {
//   
//    	return new VentasDaoImplMysql();
//    }
//
//    public static VuelosDAO getVuelosDaoImplMysql() {
//
//    	return new VuelosDaoImplMysql();
//    }

}