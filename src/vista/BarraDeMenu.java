package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import vista.Eventos.OpcionAcercaDeEventHandler;
import vista.Eventos.OpcionInformacionEventHandler;
import vista.Eventos.OpcionPantallaCompletaEventHandler;
import vista.Eventos.OpcionSalirEventHandler;

public class BarraDeMenu extends MenuBar {

	public BarraDeMenu(Stage stage) {
		
		Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Informacion");
        
       
        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionInformacion = new MenuItem("Reglas del juego");
        MenuItem opcionAcercaDe = new MenuItem("Acera de...");
        MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");
        
        OpcionSalirEventHandler salirEventHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(salirEventHandler);
        
        OpcionInformacionEventHandler informacionEventHandler = new OpcionInformacionEventHandler();
        opcionInformacion.setOnAction(informacionEventHandler);
        
        OpcionAcercaDeEventHandler acercaDeEventHandler = new OpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(acercaDeEventHandler);
        
        OpcionPantallaCompletaEventHandler pantallaCompletaEventHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta) ;
        opcionPantallaCompleta.setOnAction(pantallaCompletaEventHandler);
        
        menuArchivo.getItems().addAll(opcionPantallaCompleta, opcionSalir);
        menuVer.getItems().addAll(opcionInformacion, opcionAcercaDe);
        
        this.getMenus().addAll(menuArchivo, menuVer);
	}
}
