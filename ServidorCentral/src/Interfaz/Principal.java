package Interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Logica.Fabrica.*;
import Logica.Paquete.*;
import Logica.Turistico.*;
import Logica.Usuario.*;
import Interfaz.*;

import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase principal (Frame) con el mÃ©todo Main.
 * @author TProg2017
 *
 */
public class Principal {

    private JFrame frmGestionDeUsuarios;
    private IControladorUsuario ICU;
    private IControladorTuristico ICT;
    private IControladorPaquete ICP;
    private AltaUsuario creUsrInternalFrame;
    private ConsultaUsuario consUsrInternalFrame;
    private ModificarUsuario modUsrInternalFrame;
    private AltaActividadTuristica altaActInternalFrame;
    private ConsultaActividadTuristica consActTurInternalFrame; 
    private AltaSalidaTuristica altaSalTurInternalFrame;
    private ConsultaSalidaTuristica consSalTurInternalFrame;
    private InscripcionASalidaTuristica inscSalTurInternalFrame;
    private CrearPaqueteActTuristicas crearPaqActTurInternalFrame;
    private AgregarActTuristicaAPaq addActTurAPaqInternalFrame;
    private ConsultaPaqueteActTur consPaqActTurInternalFrame;
    //alta departamento
    private static CargaDatos cargar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    Principal window = new Principal();
                    window.frmGestionDeUsuarios.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Principal() {
        initialize();
        cargarDatos();
        
        // Inicializacion
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
        ICT = fabrica.getIControladorTuristico();
        ICP = fabrica.getIControladorPaquete();

        
        // Se crean los InternalFrame y se incluyen al Frame principal ocultos.
        // De esta forma, no es necesario crear y destruir objetos lo que enlentece la ejecuciÃ³n.
        // Cada InternalFrame usa un layout diferente, simplemente para mostrar distintas opciones.
        
        creUsrInternalFrame = new AltaUsuario(ICU);
        creUsrInternalFrame.setVisible(false);
        
        consUsrInternalFrame = new ConsultaUsuario(ICU,ICT,frmGestionDeUsuarios);
        consUsrInternalFrame.setVisible(false);
        
        modUsrInternalFrame = new ModificarUsuario(ICU);
        modUsrInternalFrame.setVisible(false);
        
        altaActInternalFrame = new AltaActividadTuristica(ICT, ICU);
        altaActInternalFrame.setVisible(false);
        
        consActTurInternalFrame = new ConsultaActividadTuristica(ICT,null);
        consActTurInternalFrame.setVisible(false);
        
        altaSalTurInternalFrame = new AltaSalidaTuristica(ICT);
        altaSalTurInternalFrame.setVisible(false);
        
        consSalTurInternalFrame = new ConsultaSalidaTuristica(ICT,null);
        consSalTurInternalFrame.setVisible(false);
        
        inscSalTurInternalFrame = new InscripcionASalidaTuristica(ICT);
        inscSalTurInternalFrame.setVisible(false);
        
        crearPaqActTurInternalFrame = new CrearPaqueteActTuristicas(ICP);
        crearPaqActTurInternalFrame.setVisible(false);
        
        addActTurAPaqInternalFrame = new AgregarActTuristicaAPaq(ICP);
        addActTurAPaqInternalFrame.setVisible(false);

        consPaqActTurInternalFrame = new ConsultaPaqueteActTur(ICP);
        consPaqActTurInternalFrame.setVisible(false);

        
        frmGestionDeUsuarios.getContentPane().setLayout(null);
        
        frmGestionDeUsuarios.getContentPane().add(creUsrInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(consUsrInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(modUsrInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(altaActInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(consActTurInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(altaSalTurInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(consSalTurInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(inscSalTurInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(crearPaqActTurInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(addActTurAPaqInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(consPaqActTurInternalFrame);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        
        // Se crea el Frame con las dimensiones indicadas.
        frmGestionDeUsuarios = new JFrame();
        frmGestionDeUsuarios.setTitle("turismo.com");
        frmGestionDeUsuarios.setBounds(100, 100, 450, 400);
        frmGestionDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Se crea una barra de menÃº (JMenuBar) con dos menÃº (JMenu) desplegables.
        // Cada menÃº contiene diferentes opciones (JMenuItem), los cuales tienen un 
        // evento asociado que permite realizar una acciÃ³n una vez se seleccionan. 
        JMenuBar menuBar = new JMenuBar();
        frmGestionDeUsuarios.setJMenuBar(menuBar);

        JMenu menuSistema = new JMenu("Sistema");
        menuBar.add(menuSistema);

        JMenuItem menuSalir = new JMenuItem("Salir");
        menuSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Salgo de la aplicaciÃ³n
                frmGestionDeUsuarios.setVisible(false);
                frmGestionDeUsuarios.dispose();
            }
        });
        menuSistema.add(menuSalir);

        JMenu menuUsuarios = new JMenu("Usuarios");
        menuBar.add(menuUsuarios);

        JMenuItem menuItemRegistrar = new JMenuItem("Registrar Usuario");
        menuItemRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                creUsrInternalFrame.setVisible(true);
                
            }
        });
        menuUsuarios.add(menuItemRegistrar);

        JMenuItem menuItemVerInfo = new JMenuItem("Consulta Usuario");
        menuItemVerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	consUsrInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemVerInfo);

        JMenuItem mntmListaUsuarios = new JMenuItem("Modificar Usuario");
        mntmListaUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modUsrInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(mntmListaUsuarios);
        
        //actividad turistica
        JMenu menuActividad = new JMenu("Actividades");
        menuBar.add(menuActividad);

        JMenuItem menuItemAltaActividad = new JMenuItem("Alta Actividad");
        menuItemAltaActividad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	altaActInternalFrame.setVisible(true);
            }
        });
        menuActividad.add(menuItemAltaActividad);

        JMenuItem menuItemConsActividad = new JMenuItem("Consulta Actividad");
        menuItemConsActividad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	consActTurInternalFrame.setVisible(true);
            }
        });
        menuActividad.add(menuItemConsActividad);
        
        //salida turistica 
        JMenu menuSalida = new JMenu("Salidas");
        menuBar.add(menuSalida);

        JMenuItem menuItemAltaSalida = new JMenuItem("Alta salida");
        menuItemAltaSalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	altaSalTurInternalFrame.setVisible(true);
            }
        });
        menuSalida.add(menuItemAltaSalida);
        
        JMenuItem menuItemConsSalida = new JMenuItem("Consulta salida");
        menuItemConsSalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	consSalTurInternalFrame.setVisible(true);
            }
        });
        menuSalida.add(menuItemConsSalida);
        
        JMenuItem menuItemInscSalida = new JMenuItem("Inscripcion a salida");
        menuItemInscSalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	inscSalTurInternalFrame.setVisible(true);
            }
        });
        menuSalida.add(menuItemInscSalida);
        
        //paquetes
        JMenu menuPaquetes = new JMenu("Paquetes");
        menuBar.add(menuPaquetes);

        JMenuItem menuItemCrearPaq = new JMenuItem("Crear paquete");
        menuItemCrearPaq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	crearPaqActTurInternalFrame.setVisible(true);
            }
        });
        menuPaquetes.add(menuItemCrearPaq);
        
        JMenuItem menuItemAddActPaq = new JMenuItem("Agregar Actividad");
        menuItemAddActPaq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	addActTurAPaqInternalFrame.setVisible(true);
            }
        });
        menuPaquetes.add(menuItemAddActPaq);
        
        JMenuItem menuItemConsPaq = new JMenuItem("Consulta paquete");
        menuItemConsPaq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	consPaqActTurInternalFrame.setVisible(true);
            }
        });
        menuPaquetes.add(menuItemConsPaq);
    }
    
    
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
				CU.ingresoTurista("lachiqui", "Rosa Maria", "Martinez", "mirtha.legrand.ok@hotmail.com.ar",parseDate("23/02/1927"),"argentina");
				CU.ingresoTurista("isabelita", "Elizabeth", "Windsor", "isabelita@thecrown.co.uk", parseDate("21/04/1926"),"inglesa");
				CU.ingresoTurista("anibal", "AnÃ­bal", "Lecter", "anibal@fing.edu.uy", parseDate("31/12/1937"),"lituana");
				CU.ingresoTurista("waston", "Emma", "Waston", "e.waston@gmail.com", parseDate("15/04/1990"),"inglesa");
				CU.ingresoTurista("elelvis", "Elvis", "Lacio", "suavemente@hotmail.com", parseDate("30/07/1971"),"estadounidense");
				CU.ingresoTurista("eleven11", "Eleven", "Once", "eleven11@gmail.com", parseDate("19/02/2004"),"espaÃ±ola");
				CU.ingresoTurista("bobesponja", "Bob", "Esponja", "bobesponja@nickelodeon.com", parseDate("01/05/1999"),"japonesa");
				CU.ingresoTurista("tony", "Antonio", "Pacheco", "eltony@manya.org.uy", parseDate("11/04/1976"),"uruguaya");
				CU.ingresoTurista("chino", "Ã�lvaro", "Recoba", "chino@trico.org.uy", parseDate("17/03/1976"),"uruguaya");
				CU.ingresoTurista("mastropiero", "Johann Sebastian", "Mastropiero", "johann.sebastian@gmail.com", parseDate("07/02/1922"),"austrÃ­aca");		
				CU.ingresoProveedor("washington", "Washington", "Rocha", "washington@turismorocha.gub.uy", parseDate("14/09/1970"), "Hola! me llamo Washington y soy el encargado del portal de turismo del departamento de Rocha - Uruguay", "http://turismorocha.gub.uy/");      
				CU.ingresoProveedor("eldiez", "Pablo", "Bengoechea", "eldiez@socfomturriv.org.uy", parseDate("27/06/1965"),"Pablo es el presidente de la Sociedad de Fomento TurÃ­stico de Rivera (conocida como Socfomturriv)", "http://wwww.socfomturriv.org.uy");
				CU.ingresoProveedor("meche", "Mercedes", "Venn", "meche@colonia.gub.uy", parseDate("31/12/1990"), "Departamento de Turismo del Departamento de Colonia", "https://colonia.gub.uy/turismo/");
								//Set<DTUsuario> u = ICU.listaUsuario();
				//for(DTUsuario usu: u) {
				//	System.out.println( usu.getNombre());
				//	System.out.println( usu.getEmail());
				//	System.out.println( usu.getNacimiento());
				//}
				
				//ingreso departamento
				CT.ingresarDatosDepto("Canelones", "DivisiÃ³n Turismo de la Intendencia ", "https://www.imcanelones.gub.uy/es");
				CT.ingresarDatosDepto("Maldonado", "DivisiÃ³n Turismo de la Intendencia ", "https://www.maldonado.gub.uy/");
				CT.ingresarDatosDepto("Rocha", "La OrganizaciÃ³n de GestiÃ³n del Destino (OGD) Rocha es un Ã¡mbito de articulaciÃ³n pÃºblico â€“ privada en el sector turÃ­stico que integran la CorporaciÃ³n Rochense de Turismo y la Intendencia de Rocha a travÃ©s de su DirecciÃ³n de Turismo. ", "www.turismorocha.gub.uy");
				CT.ingresarDatosDepto("Treinta y Tres", "DivisiÃ³n Turismo de la Intendencia ", "https://treintaytres.gub.uy/");
				CT.ingresarDatosDepto("Cerro Largo", "DivisiÃ³n Turismo de la Intendencia ", "https://www.gub.uy/intendencia-cerro-largo/");
				CT.ingresarDatosDepto("Rivera", "Promociona e implementa proyectos e iniciativas sostenibles de interÃ©s turÃ­stico con la participaciÃ³n institucional pÃºblica â€“ privada en bien del desarrollo socioeconÃ³mico de la comunidad.  ", "www.rivera.gub.uy/social/turismo/");
				CT.ingresarDatosDepto("Artigas", "DivisiÃ³n Turismo de la Intendencia ", "http://www.artigas.gub.uy");
				CT.ingresarDatosDepto("Salto", "DivisiÃ³n Turismo de la Intendencia ", "https://www.salto.gub.uy");
				CT.ingresarDatosDepto("PaysandÃº", "DivisiÃ³n Turismo de la Intendencia ", "https://www.paysandu.gub.uy");
				CT.ingresarDatosDepto("RÃ­o Negro", "DivisiÃ³n Turismo de la Intendencia ", "https://www.rionegro.gub.uy");
				CT.ingresarDatosDepto("Soriano", "DivisiÃ³n Turismo de la Intendencia ", "https://www.soriano.gub.uy");
				CT.ingresarDatosDepto("Colonia", "La propuesta del Departamento de Colonia divide en cuatro actos su espectÃ¡culo anual. Cada acto tiene su magia. Desde su naturaleza y playas hasta sus tradiciones y el patrimonio mundial. Todo el aÃ±o se disfruta. ", "https://colonia.gub.uy/turismo/");
				CT.ingresarDatosDepto("San JosÃ©", "DivisiÃ³n Turismo de la Intendencia ", "https://sanjose.gub.uy");
				CT.ingresarDatosDepto("Flores", "DivisiÃ³n Turismo de la Intendencia ", "https://flores.gub.uy");
				CT.ingresarDatosDepto("Florida", "DivisiÃ³n Turismo de la Intendencia ", "http://www.florida.gub.uy");
				CT.ingresarDatosDepto("Lavalleja", "DivisiÃ³n Turismo de la Intendencia ", "http://www.lavalleja.gub.uy");
				CT.ingresarDatosDepto("Durazno", "DivisiÃ³n Turismo de la Intendencia ", "https://durazno.uy");
				CT.ingresarDatosDepto("TacuarembÃ³", "DivisiÃ³n Turismo de la Intendencia ", "https://tacuarembo.gub.uy");
				CT.ingresarDatosDepto("Montevideo", "DivisiÃ³n Turismo de la Intendencia ", "https://montevideo.gub.uy/areas-tematicas/turismo");

				//ingreso actividades	
				CT.ingresarDatosBasicos("washington", "Rocha", "Degusta", "Festival gastronÃ³mico de productos locales en Rocha", 3, 800, "Rocha", parseDate("20/07/2022"));
				CT.ingresarDatosBasicos("washington", "Rocha", "Teatro con Sabores", "En el mes aniversario del Club Deportivo UniÃ³n de Rocha te invitamos a una merienda deliciosa.", 3, 500, "Rocha", parseDate("21/07/2022") );
				CT.ingresarDatosBasicos("meche", "Colonia","Tour por Colonia del Sacramento", "Con guÃ­a especializado y en varios idiomas. Varios circuitos posibles.", 2, 400, "Colonia del Sacramento",parseDate("01/08/2022") );
				CT.ingresarDatosBasicos("meche", "Colonia", "Almuerzo en el Real de San Carlos", "Restaurante en la renovada Plaza de Toros con menÃº internacional", 2, 800,"Colonia del Sacramento",parseDate("01/08/2022"));
				CT.ingresarDatosBasicos("eldiez", "Rivera", "Almuerzo en Valle del Lunarejo", "Almuerzo en la Posada con ticket fijo. MenÃº que incluye bebida y postre casero.",2, 300, "Tranqueras" ,parseDate("01/08/2022"));
				CT.ingresarDatosBasicos("eldiez","Rivera", "Cabalgata en Valle del Lunarejo","Cabalgata por el Ã¡rea protegida. Varios recorridos para elegir.", 2, 150 ,"Tranqueras" ,parseDate("01/08/2022"));
				//ingresar salidas
				CT.ingresarSalidaTuristica("Degusta Agosto", parseDateH("20/08/2022 17"), "Sociedad Agropecuaria de Rocha",20, parseDate("21/07/2022"), "Degusta", "Rocha");		
				CT.ingresarSalidaTuristica("Degusta Setiembre", parseDateH("03/09/2022 17"), "Sociedad Agropecuaria de Rocha",20, parseDate("22/07/2022"), "Degusta", "Rocha");
				CT.ingresarSalidaTuristica("Teatro con Sabores 1", parseDateH("04/09/2022 18"),  "Club Deportivo UniÃ³n",30, parseDate("23/07/2022"), "Teatro con Sabores", "Rocha");
				CT.ingresarSalidaTuristica("Teatro con Sabores 2", parseDateH("11/09/2022 18"),  "Club Deportivo UniÃ³n",30, parseDate("23/07/2022"), "Teatro con Sabores", "Rocha");
				CT.ingresarSalidaTuristica("Tour Colonia del Sacramento 11-09", parseDateH("11/09/2022 10"), "Encuentro en la base del Faro",5, parseDate("05/08/2022"), "Tour por Colonia del Sacramento", "Colonia");
				CT.ingresarSalidaTuristica("Tour Colonia del Sacramento 18-09", parseDateH("18/09/2022 10"), "Encuentro en la base del Faro",5, parseDate("05/08/2022"), "Tour por Colonia del Sacramento", "Colonia");
				CT.ingresarSalidaTuristica("Almuerzo 1", parseDateH("18/09/2022 12"),  "Restaurante de la Plaza de Toros", 5,parseDate("04/08/2022"), "Almuerzo en el Real de San Carlos", "Colonia");
				CT.ingresarSalidaTuristica("Almuerzo 2", parseDateH("25/09/2022 12"),  "Restaurante de la Plaza de Toros", 5,parseDate("04/08/2022"), "Almuerzo en el Real de San Carlos", "Colonia");
				CT.ingresarSalidaTuristica("Almuerzo 3", parseDateH("10/09/2022 12"),  "Posada Del Lunarejo", 4,parseDate("15/08/2022"), "Almuerzo en Valle del Lunarejo", "Rivera");
				CT.ingresarSalidaTuristica("Almuerzo 4", parseDateH("11/09/2022 12"),  "Posada Del Lunarejo",4, parseDate("15/08/2022"), "Almuerzo en Valle del Lunarejo", "Rivera");
				CT.ingresarSalidaTuristica("Cabalgata 1", parseDateH("10/09/2022 16"), "Posada del Lunarejo", 4,parseDate("15/08/2022"), "Cabalgata en Valle del Lunarejo", "Rivera");
				CT.ingresarSalidaTuristica("Cabalgata 2", parseDateH("11/09/2022 16"),  "Posada del Lunarejo",4, parseDate("15/08/2022"), "Cabalgata en Valle del Lunarejo", "Rivera");

				
				// registrar paquete
				CP.registrarPaquete("Disfrutar Rocha" ,"Actividades para hacer en familia y disfrutar arte y gastronomÃ­a",60,20, parseDate("10/08/2022")); 
				CP.registrarPaquete("Un dÃ­a en Colonia","Paseos por el casco histÃ³rico y se puede terminar con Almuerzo en la Plaza de Toros",45,15,parseDate("01/08/2022")); 
				
				// agregar a paquete actividad
				 
				 CP.seleccionarActividadTuristicaParaAgregarAPaquete("Degusta", "Disfrutar Rocha");
				 CP.seleccionarActividadTuristicaParaAgregarAPaquete("Teatro con Sabores", "Disfrutar Rocha");
				 CP.seleccionarActividadTuristicaParaAgregarAPaquete("Tour por Colonia del Sacramento", "Un dÃ­a en Colonia");
				 CP.seleccionarActividadTuristicaParaAgregarAPaquete("Almuerzo en el Real de San Carlos", "Un dÃ­a en Colonia");
				

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
    
    

