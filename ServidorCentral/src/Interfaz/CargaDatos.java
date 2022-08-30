package Interfaz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Logica.Usuario.*;
import Logica.Paquete.ControladorPaquete;
import Logica.Paquete.IControladorPaquete;
import Logica.Turistico.*;



public class CargaDatos {
	
	public  Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("dd/MM/yyyy").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	
	public  Date parseDateH(String date) {
	     try {
	         return new SimpleDateFormat("dd/MM/yyyy HH").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	 

	public void cargarDatos() {		
		
		
		IControladorPaquete CP = ControladorPaquete.getInstance();
		IControladorUsuario CU = ControladorUsuario.getInstance();
		IControladorTuristico CT = ControladorTuristico.getInstance();
				
		
		//ingreso usuarios
				CU.ingresoTurista("lachiqui", "Rosa María", "Martínez", "mirtha.legrand.ok@hotmail.com.ar",parseDate("23/02/1927"),"argentina");
				CU.ingresoTurista("isabelita", "Elizabeth", "Windsor", "isabelita@thecrown.co.uk", parseDate("21/04/1926"),"inglesa");
				CU.ingresoTurista("anibal", "Aníbal", "Lecter", "anibal@fing.edu.uy", parseDate("31/12/1937"),"lituana");
				CU.ingresoTurista("waston", "Emma", "Waston", "e.waston@gmail.com", parseDate("15/04/1990"),"inglesa");
				CU.ingresoTurista("elelvis", "Elvis", "Lacio", "suavemente@hotmail.com", parseDate("30/07/1971"),"estadounidense");
				CU.ingresoTurista("eleven11", "Eleven", "Once", "eleven11@gmail.com", parseDate("19/02/2004"),"española");
				CU.ingresoTurista("bobesponja", "Bob", "Esponja", "bobesponja@nickelodeon.com", parseDate("01/05/1999"),"japonesa");
				CU.ingresoTurista("tony", "Antonio", "Pacheco", "eltony@manya.org.uy", parseDate("11/04/1976"),"uruguaya");
				CU.ingresoTurista("chino", "Álvaro", "Recoba", "chino@trico.org.uy", parseDate("17/03/1976"),"uruguaya");
				CU.ingresoTurista("mastropiero", "Johann Sebastian", "Mastropiero", "johann.sebastian@gmail.com", parseDate("07/02/1922"),"austríaca");		
				CU.ingresoProveedor("washington", "Washington", "Rocha", "washington@turismorocha.gub.uy", parseDate("14/09/1970"), "Hola! me llamo Washington y soy el encargado del portal de turismo del departamento de Rocha - Uruguay", "http://turismorocha.gub.uy/");      
				CU.ingresoProveedor("eldiez", "Pablo", "Bengoechea", "eldiez@socfomturriv.org.uy", parseDate("27/06/1965"),"Pablo es el presidente de la Sociedad de Fomento Turístico de Rivera (conocida como Socfomturriv)", "http://wwww.socfomturriv.org.uy");
				CU.ingresoProveedor("meche", "Mercedes", "Venn", "meche@colonia.gub.uy", parseDate("31/12/1990"), "Departamento de Turismo del Departamento de Colonia", "https://colonia.gub.uy/turismo/");
								//Set<DTUsuario> u = ICU.listaUsuario();
				//for(DTUsuario usu: u) {
				//	System.out.println( usu.getNombre());
				//	System.out.println( usu.getEmail());
				//	System.out.println( usu.getNacimiento());
				//}
				
				//ingreso departamento
				CT.ingresarDatosDepto("Canelones", "División Turismo de la Intendencia ", "https://www.imcanelones.gub.uy/es");
				CT.ingresarDatosDepto("Maldonado", "División Turismo de la Intendencia ", "https://www.maldonado.gub.uy/");
				CT.ingresarDatosDepto("Rocha", "La Organización de Gestión del Destino (OGD) Rocha es un ámbito de articulación público – privada en el sector turístico que integran la Corporación Rochense de Turismo y la Intendencia de Rocha a través de su Dirección de Turismo. ", "www.turismorocha.gub.uy");
				CT.ingresarDatosDepto("Treinta y Tres", "División Turismo de la Intendencia ", "https://treintaytres.gub.uy/");
				CT.ingresarDatosDepto("Cerro Largo", "División Turismo de la Intendencia ", "https://www.gub.uy/intendencia-cerro-largo/");
				CT.ingresarDatosDepto("Rivera", "Promociona e implementa proyectos e iniciativas sostenibles de interés turístico con la participación institucional pública – privada en bien del desarrollo socioeconómico de la comunidad.  ", "www.rivera.gub.uy/social/turismo/");
				CT.ingresarDatosDepto("Artigas", "División Turismo de la Intendencia ", "http://www.artigas.gub.uy");
				CT.ingresarDatosDepto("Salto", "División Turismo de la Intendencia ", "https://www.salto.gub.uy");
				CT.ingresarDatosDepto("Paysandú", "División Turismo de la Intendencia ", "https://www.paysandu.gub.uy");
				CT.ingresarDatosDepto("Río Negro", "División Turismo de la Intendencia ", "https://www.rionegro.gub.uy");
				CT.ingresarDatosDepto("Soriano", "División Turismo de la Intendencia ", "https://www.soriano.gub.uy");
				CT.ingresarDatosDepto("Colonia", "La propuesta del Departamento de Colonia divide en cuatro actos su espectáculo anual. Cada acto tiene su magia. Desde su naturaleza y playas hasta sus tradiciones y el patrimonio mundial. Todo el año se disfruta. ", "https://colonia.gub.uy/turismo/");
				CT.ingresarDatosDepto("San José", "División Turismo de la Intendencia ", "https://sanjose.gub.uy");
				CT.ingresarDatosDepto("Flores", "División Turismo de la Intendencia ", "https://flores.gub.uy");
				CT.ingresarDatosDepto("Florida", "División Turismo de la Intendencia ", "http://www.florida.gub.uy");
				CT.ingresarDatosDepto("Lavalleja", "División Turismo de la Intendencia ", "http://www.lavalleja.gub.uy");
				CT.ingresarDatosDepto("Durazno", "División Turismo de la Intendencia ", "https://durazno.uy");
				CT.ingresarDatosDepto("Tacuarembó", "División Turismo de la Intendencia ", "https://tacuarembo.gub.uy");
				CT.ingresarDatosDepto("Montevideo", "División Turismo de la Intendencia ", "https://montevideo.gub.uy/areas-tematicas/turismo");

				//ingreso actividades	
				CT.ingresarDatosBasicos("washington", "Rocha", "Degusta", "Festival gastronómico de productos locales en Rocha", 3, 800, "Rocha", parseDate("20/07/2022"));
				CT.ingresarDatosBasicos("washington", "Rocha", "Teatro con Sabores", "En el mes aniversario del Club Deportivo Unión de Rocha te invitamos a una merienda deliciosa.", 3, 500, "Rocha", parseDate("21/07/2022") );
				CT.ingresarDatosBasicos("meche", "Colonia","Tour por Colonia del Sacramento", "Con guía especializado y en varios idiomas. Varios circuitos posibles.", 2, 400, "Colonia del Sacramento",parseDate("01/08/2022") );
				CT.ingresarDatosBasicos("meche", "Colonia", "Almuerzo en el Real de San Carlos", "Restaurante en la renovada Plaza de Toros con menú internacional", 2, 800,"Colonia del Sacramento",parseDate("01/08/2022"));
				CT.ingresarDatosBasicos("eldiez", "Rivera", "Almuerzo en Valle del Lunarejo", "Almuerzo en la Posada con ticket fijo. Menú que incluye bebida y postre casero.",2, 300, "Tranqueras" ,parseDate("01/08/2022"));
				CT.ingresarDatosBasicos("eldiez","Rivera", "Cabalgata en Valle del Lunarejo","Cabalgata por el área protegida. Varios recorridos para elegir.", 2, 150 ,"Tranqueras" ,parseDate("01/08/2022"));
				//ingresar salidas
				CT.ingresarSalidaTuristica("Degusta Agosto", parseDateH("20/08/2022 17"), "Sociedad Agropecuaria de Rocha",20, parseDate("21/07/2022"), "Degusta", "Rocha");		
				CT.ingresarSalidaTuristica("Degusta Setiembre", parseDateH("03/09/2022 17"), "Sociedad Agropecuaria de Rocha",20, parseDate("22/07/2022"), "Degusta", "Rocha");
				CT.ingresarSalidaTuristica("Teatro con Sabores 1", parseDateH("04/09/2022 18"),  "Club Deportivo Unión",30, parseDate("23/07/2022"), "Teatro con Sabores", "Rocha");
				CT.ingresarSalidaTuristica("Teatro con Sabores 2", parseDateH("11/09/2022 18"),  "Club Deportivo Unión",30, parseDate("23/07/2022"), "Teatro con Sabores", "Rocha");
				CT.ingresarSalidaTuristica("Tour Colonia del Sacramento 11-09", parseDateH("11/09/2022 10"), "Encuentro en la base del Faro",5, parseDate("05/08/2022"), "Tour por Colonia del Sacramento", "Colonia");
				CT.ingresarSalidaTuristica("Tour Colonia del Sacramento 18-09", parseDateH("18/09/2022 10"), "Encuentro en la base del Faro",5, parseDate("05/08/2022"), "Tour por Colonia del Sacramento", "Colonia");
				CT.ingresarSalidaTuristica("Almuerzo 1", parseDateH("18/09/2022 12"),  "Restaurante de la Plaza de Toros", 5,parseDate("04/08/2022"), "Almuerzo en el Real de San Carlos", "Colonia");
				CT.ingresarSalidaTuristica("Almuerzo 2", parseDateH("25/09/2022 12"),  "Restaurante de la Plaza de Toros", 5,parseDate("04/08/2022"), "Almuerzo en el Real de San Carlos", "Colonia");
				CT.ingresarSalidaTuristica("Almuerzo 3", parseDateH("10/09/2022 12"),  "Posada Del Lunarejo", 4,parseDate("15/08/2022"), "Almuerzo en Valle del Lunarejo", "Rivera");
				CT.ingresarSalidaTuristica("Almuerzo 4", parseDateH("11/09/2022 12"),  "Posada Del Lunarejo",4, parseDate("15/08/2022"), "Almuerzo en Valle del Lunarejo", "Rivera");
				CT.ingresarSalidaTuristica("Cabalgata 1", parseDateH("10/09/2022 16"), "Posada del Lunarejo", 4,parseDate("15/08/2022"), "Cabalgata en Valle del Lunarejo", "Rivera");
				CT.ingresarSalidaTuristica("Cabalgata 2", parseDateH("11/09/2022 16"),  "Posada del Lunarejo",4, parseDate("15/08/2022"), "Cabalgata en Valle del Lunarejo", "Rivera");

				
				// registrar paquete
				CP.registrarPaquete("Disfrutar Rocha" ,"Actividades para hacer en familia y disfrutar arte y gastronomía",60,20, parseDate("10/08/2022")); 
				CP.registrarPaquete("Un día en Colonia","Paseos por el casco histórico y se puede terminar con Almuerzo en la Plaza de Toros",45,15,parseDate("01/08/2022")); 
				
				// agregar a paquete actividad

				 
				 CP.seleccionarActividadTuristicaParaAgregarAPaquete("Degusta", "Disfrutar Rocha");
				 CP.seleccionarActividadTuristicaParaAgregarAPaquete("Teatro con Sabores", "Disfrutar Rocha");
				 CP.seleccionarActividadTuristicaParaAgregarAPaquete("Tour por Colonia del Sacramento", "Un día en Colonia");
				 CP.seleccionarActividadTuristicaParaAgregarAPaquete("Almuerzo en el Real de San Carlos", "Un día en Colonia");
				
				
				
			
				// Registrar inscripciones
				CU.inscripcion("lachiqui", "Degusta Agosto", 3, parseDate("15/8/2022"));
				CU.inscripcion("elelvis", "Degusta Agosto", 5, parseDate("16/8/2022"));
				CU.inscripcion("lachiqui", "Tour Colonia del Sacramento 18-09", 3, parseDate("18/8/2022"));
				CU.inscripcion("isabelita", "Tour Colonia del Sacramento 18-09", 1,parseDate("19/8/2022"));
				CU.inscripcion("mastropiero", "Almuerzo 2", 2, parseDate("19/8/2022"));
				CU.inscripcion("chino", "Teatro con Sabores 1", 1, parseDate("19/8/2022"));
				CU.inscripcion("chino", "Teatro con Sabores 2", 10, parseDate("20/8/2022"));
				CU.inscripcion("bobesponja", "Teatro con Sabores 2", 2, parseDate("20/8/2022"));
				CU.inscripcion("anibal", "Teatro con Sabores 2", 1, parseDate("21/8/2022"));
				CU.inscripcion("tony", "Degusta Setiembre", 11, parseDate("21/8/2022"));
				

			}
}

