package vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionInformacionEventHandler implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		
		alert.setTitle("Informacion del juego AlgoPoly");
		alert.setHeaderText("REGLAS DEL JUEGO");
		alert.setContentText( 
				"JUGABILIDAD\n" + 
						"Es un juego por turnos. Hay 3 jugadores. En cada turno cada jugador debe lanzar un par de dados (números del 1 al 6 cada dado). El número obtenido será la suma de ambos resultados. \n" + 
						"Si un jugador al tirar los dados obtiene un doble numero (o sea 1 y 1 , o 3 y 3 , etc) entonces tira nuevamente. Si vuelve a sacar otro doble, no tira otra vez, sino que le toca el turno al jugador siguiente.\n" + 
						"El jugador debe mover en el sentido que indica la flecha del casillero de salida. \n" + 
						"Los efectos ocurren al caer en un casillero y no al pasar por ellos.\n" + 
						"Para poder edificar tanto en Córdoba como en Bs.As como en Salta es necesario que el jugador compre ambas zonas (norte y sur) para recién poder edificar. \n" + 
						"No se puede edificar en ningún terreno en el mismo turno en que se lo compra\n" + 
						"Antes de lanzar los dados, cada jugador tiene la posibilidad de edificar si se encuentra en condiciones de hacerlo: Ya sea tanto contar con el dinero que sale +  el terreno.\n" + 
						"Patenerra poder edificar un hotel, debe estar lleno de casas en su capacidad máxima. Es decir que si un jugador tiene 2 casas en Bs. As. sur y sólo 1 casa en Bs. As Norte NO puede construir hotel. Recién al contar con 2 casas en Bs. As sur y 2 casas en Bs. norte puede empezar a construir los hoteles (máximo 1 por cada terreno).\n" + 
						"Los hoteles reemplazan a las casas, es decir que cuando se edifica un hotel las 2 casas desaparecen.\n" + 
						"Los terrenos que no son dobles (es decir que no tiene un Norte y Sur) no pueden construir hoteles.\n" + 
						"Un jugador puede decidir vender tanto sus terrenos (con las casas u hoteles que tenga edificados) o las compañías antes de lanzar los dados. En ese caso el jugador perderá la titularidad de los mismos, los cuales pasan a estar disponibles para la compra para el resto de los jugadores. El jugador que vende cobra un 15% menos de la suma de todo lo que vende. Al venderse un terreno que tenía edificaciones las mismas desaparecen del mapa. Es decir que cuando un nuevo jugador compre ese terreno, estará vacío y deberá volver a construir las casas y luego los hoteles.\n" + 
						"\n" + 
						"Fin del juego\n" + 
						"Cuando un jugador se quede sin dinero y sin propiedades quedará eliminado.\n" + 
						"Si un jugador no tiene dinero, pero sí propiedades y debe afrontar un gasto, está obligado a vender (con la quita del 15% ya explicada) para afrontar esos gastos. Si aún vendiendo todo, no puede afrontar el gasto, el jugador quedará eliminado también.\n" + 
						"Ganará el último jugador restante.\n" + 
				"");
		alert.showAndWait();
		alert.show();
		
	}
}
