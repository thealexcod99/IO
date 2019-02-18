package teoria.flujoSalida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo1 {

	public static void main(String[] args) {

		File file = new File("datos/fichero1");
		String cadenaAGuardar = "\ncuarta cadena";
		
		if (file.exists())
			System.out.printf("fichero %s existe%n", file.getName());
		else {
			System.out.println("No existe el fichero, creando el fichero.....");
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("No puedo manipular el fichero");
			}
		}

		//FORMA CLASICA
//		FileOutputStream out = null;
//		try {
//			out = new FileOutputStream(file);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//				try {
//					if (out != null)
//					out.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		}
		
		//FORMA JAVA 7
		try (FileOutputStream out = new FileOutputStream(file, true)) { //si se le añade el true no borra la anterior cadena y añade la nueva
			out.write(cadenaAGuardar.getBytes());
			out.write(155);
			out.flush();
			System.out.printf("Escrito fichero %s, con un tamaño %d bytes%n", file.getName(), file.length());
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
