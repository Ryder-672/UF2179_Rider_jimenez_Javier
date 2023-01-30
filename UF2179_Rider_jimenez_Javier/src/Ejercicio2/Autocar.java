package Ejercicio2;
import java.util.Objects;

public class Autocar {
	
		private String matricula;
		private String marca;
		private String modelo;
		private int kilometros;
		private int num_plazas;


		public String getMatricula() {
			return matricula;
		}

		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}

		public String getmarca() {
			return marca;
		}

		public void setTipo(String marca) {
			this.marca = marca;
		}

		public int getKilometros() {
			return kilometros;
		}

		public void setKilometros(int kilometros) {
			this.kilometros = kilometros;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public int getNum_plazas() {
			return num_plazas;
		}

		public void setNum_plazas(int num_plazas) {
			this.num_plazas = num_plazas;
		}
		
		public Autocar(String matricula, String tipo, String modelo, int kilometros, int num_plazas) {
			super();
			this.setMatricula(matricula);
			this.marca = tipo;
			this.modelo = modelo;
			this.kilometros = kilometros;
			this.num_plazas = num_plazas;
		}

		@Override
		public String toString() {
			return "Autocar [matricula=" + matricula + ", tipo=" + marca + ", modelo=" + modelo + ", kilometros="
					+ kilometros + ", num_plazas=" + num_plazas + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(kilometros, matricula, modelo, num_plazas, marca);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Autocar other = (Autocar) obj;
			return kilometros == other.kilometros && Objects.equals(matricula, other.matricula)
					&& Objects.equals(modelo, other.modelo) && num_plazas == other.num_plazas
					&& Objects.equals(marca, other.marca);
		}
		
		
		
		
	}
