package UF2179_RomeraMata_AndresAlejandro_Ej1;

import java.util.Objects;

public class Formulario {
	String origen;
	String nacOrig;
	String destino;
	String nacDes;
	String envio;
	double peso;
	
	public Formulario(String origen, boolean nacOrig, String destino, boolean nacDes, String envio, double peso) {
		this.origen = origen;
		this.nacOrig = nacOrig?"Nacional":"Extranjero";
		this.destino = destino;
		this.nacDes = nacDes?"Nacional":"Extranjero";
		this.envio = envio;
		this.peso = peso;
	}

	public Formulario() {
	
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String isNacOrig() {
		return nacOrig;
	}

	public void setNacOrig(String nacOrig) {
		this.nacOrig = nacOrig;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String isNacDes() {
		return nacDes;
	}

	public void setNacDes(String nacDes) {
		this.nacDes = nacDes;
	}

	public String getEnvio() {
		return envio;
	}

	public void setEnvio(String envio) {
		this.envio = envio;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Origen: " + origen + "\n\t " + nacOrig + "\nDestino: " + destino + "\n\t" + nacDes
				+ "\nEnvio: " + envio + "\nPeso: " + peso + "\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(destino, envio, nacDes, nacOrig, origen, peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formulario other = (Formulario) obj;
		return Objects.equals(destino, other.destino) && Objects.equals(envio, other.envio) && nacDes == other.nacDes
				&& nacOrig == other.nacOrig && Objects.equals(origen, other.origen)
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso);
	}
	
	
	


}
