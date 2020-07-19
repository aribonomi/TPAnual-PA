package dao.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Archivos {
	
	public void archivoProvincias() {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("Provincias.txt"))){
			String texto = "Buenos Aires,Catamarca,Chaco,Chubut,C�rdoba,Corrientes,Entre R�os,Formosa,Jujuy,La Pampa,La Rioja,Mendoza,Misiones,Neuqu�n,R�o Negro,Salta,San Juan,San Luis,Santa Cruz,Santa Fe,Santiago del Estero,Tierra del Fuego,Tucuman";
			bw.write(texto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
