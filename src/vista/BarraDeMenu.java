package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import vista.Eventos.OpcionInformacionEventHandler;
import vista.Eventos.OpcionSalirEventHandler;

public class BarraDeMenu extends MenuBar {

	public BarraDeMenu() {
		
		Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        
       
        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionInformacion = new MenuItem("Informacion del juego");
        
        OpcionSalirEventHandler salirEventHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(salirEventHandler);
        
        OpcionInformacionEventHandler informacionEventHandler = new OpcionInformacionEventHandler();
        opcionInformacion.setOnAction(informacionEventHandler);
        
        menuArchivo.getItems().add(opcionSalir);
        menuVer.getItems().add(opcionInformacion);
        
        this.getMenus().addAll(menuArchivo, menuVer);
	}
}
