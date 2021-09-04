package edu.uspg;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FabricaConexionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabricaConexionApplication.class, args);
		
		FabricaConexiones fabricaConexiones = new FabricaConexiones();
		
		Connection cnPostgres = fabricaConexiones.getConexion("POSTGRES");
		
		//Menú para registrar
		//1. Alumnos
		//2. Lista Alumnos
		//3. Actualizar Alumno
		//4. Salir
		
		//Ingrese nombres:
		//Ingrese apellidos:
		//Ingrese telefono:
		
		//id	nombres 	apellidos	telefono
		//1		Juan		Carrasco	12948575
		//2		Juan		Carrasco	12948575
		//3		Juan		Carrasco	12948575
		
		//ingrese id a actualizar
		//3
		//Carlos
		//Carrasco
		//7889-2323
		
		if(cnPostgres != null) {
			System.out.println("Conectado a postgres");
			try {
				PreparedStatement st = cnPostgres.prepareStatement("insert into alumno(apellidos,nombres,correo) values(?,?,?)");
				st.setString(1, "Mota");
				st.setString(2, "Laura");
				st.setString(3, "lmota@catedratico.uspg.edu.gt");
				st.execute();
				st.close();
			} catch(Exception e) {
				e.getMessage();
			}
		}
		
	}
	
	public void registrar() {
		
	}

}
