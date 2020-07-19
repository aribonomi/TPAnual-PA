package dao.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Archivos {
	
	public void archivoProvincias() {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("Provincias.txt"))){
			String texto = "Buenos Aires,Catamarca,Chaco,Chubut,Córdoba,Corrientes,Entre Ríos,Formosa,Jujuy,La Pampa,La Rioja,Mendoza,Misiones,Neuquén,Río Negro,Salta,San Juan,San Luis,Santa Cruz,Santa Fe,Santiago del Estero,Tierra del Fuego,Tucuman";
			bw.write(texto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
