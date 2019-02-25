package teoria.serializacion;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class Persona implements Serializable{
	
	private String apellidosPersona; //nombre, fecha nac(localDate), apellidos, metodo para calcular la edad
	private String nombrePersona; 
	private LocalDate fechaNac;
	
	public Persona(String apellidosPersona, String nombrePersona, LocalDate fechaNac) {
		this.apellidosPersona = apellidosPersona;
		this.nombrePersona = nombrePersona;
		this.fechaNac = fechaNac;
	}

	public String getNombre() {
		return nombrePersona;
	}

	public String getApellidos() {
		return apellidosPersona;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}
	
	@Override
	public String toString() {
		return apellidosPersona + ", " + nombrePersona + " con " + calcularEdad() + " años";
	}

	//método que nos devuelve los años transcurridos desde una fecha pasada como argumento
	public int calcularEdad() {
		Period period = Period.between(LocalDate.now(), fechaNac);
		return period.getYears();
	}
	
	public static void main(String[] args) {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
//		LocalDate date = LocalDate.parse("25/02/2019", formatter);
//		System.out.printf("%s%n", date);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse("25/02/2019", formatter);
		Persona persona = new Persona("Rodríguez Acosta", "Agapito", date);
		System.out.println(persona);
		
	}

}
