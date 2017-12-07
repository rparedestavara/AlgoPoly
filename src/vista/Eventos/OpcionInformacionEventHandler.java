package vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class OpcionInformacionEventHandler implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		
		alert.setTitle("Informacion del juego AlgoPoly");
		alert.setHeaderText("REGLAS DEL JUEGO");
		
		TextArea informacion = new TextArea("JUGABILIDAD\n" + 
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
						"FIN DEL JUEGO\n" + 
						"Cuando un jugador se quede sin dinero y sin propiedades quedará eliminado.\n" + 
						"Si un jugador no tiene dinero, pero sí propiedades y debe afrontar un gasto, está obligado a vender (con la quita del 15% ya explicada) para afrontar esos gastos. Si aún vendiendo todo, no puede afrontar el gasto, el jugador quedará eliminado también.\n" + 
						"Ganará el último jugador restante.\n" + 
				"\n" + 
				"CASILLEROS\n" + 
				"SALIDA: Los 3 jugadores comienzan el juego en el mismo lugar. Se elige aleatoriamente quién tira primero, segundo y tercero.\n" + 
				"QUINI 6: El jugador que caiga en esta casilla recibe un premio de $50000 (cincuenta mil pesos). Si ese jugador ya ganó una vez el Quini 6, la segunda vez que caiga en esa casilla recibe un premio de $30000 (treinta mil pesos). Las sucesivas veces que el mismo jugador caiga en este casillero no cobrará ningún dinero.\n" + 
				"BUENOS AIRES SUR:\n" + 
				"Precio terreno: $20000 (veinte mil pesos)\n" + 
				"Alquiler: $2000\n" + 
				"Alquiler con 1 casa: $3000\n" + 
				"Alquiler con 2 casas: $3500\n" + 
				"Alquiler con Hotel: $5000\n" + 
				"Construir casas cuestan $5000 y hotel $8000\n" + 
				"EDESUR: \n" + 
				"Comprar la compañía: $35000\n" + 
				"Cobra  500 veces lo que dice los dados. O sea que si un jugador no dueño de la empresa cae en esa casilla tras haber sacado 12 en los dados => deberá pagar: 12 x 500 = $6000\n" + 
				"Si también tiene la compañía AYSA cobrará 1000 veces  lo sacado en los dados.\n" + 
				"BUENOS AIRES NORTE:\n" + 
				"Precio terreno: $25000 (veinte mil pesos)\n" + 
				"Alquiler: $2500\n" + 
				"Alquiler con 1 casa: $3500\n" + 
				"Alquiler con 2 casas: $4000\n" + 
				"Alquiler con Hotel: $6000\n" + 
				"Construir casas cuestan $5500 y hotel $9000\n" + 
				"CARCEL: un jugador al caer en este casillero debe esperar 3 turnos para salir. Es decir, recién cuando le toque por 4ta vez podrá moverse. Salvo que cuando cuando ya haya pasado 1 turno de la cárcel (o sea en el turno 2 y 3 de espera) pague una fianza de $45000.\n" + 
				"CORDOBA SUR:\n" + 
				"Precio terreno: $18000\n" + 
				"Alquiler: $1000\n" + 
				"Alquiler con 1 casa: $1500\n" + 
				"Alquiler con 2 casas: $2500\n" + 
				"Alquiler con Hotel: $3000\n" + 
				"Construir casas cuestan $2000 y hotel $3000\n" + 
				"AVANCE DINAMICO: El jugador avanzará tantos casilleros como lo indica la siguiente lógica:\n" + 
				"Si sacó 2,3,4,5 o 6 => entonces avanza el número sacado menos 2 unidades\n" + 
				"Si sacó 7,8,9 o 10 => entonces avanza #cantidad de efectivo del jugador % numero sacado \n" + 
				"si sacó 11 o 12 => avanza el numero sacado menos la sumatoria de propiedades del jugador. Tanto los terrenos como las casas como los hoteles suman como propiedad.\n" + 
				"SUBTE: \n" + 
				"Comprar la compañía: $40000\n" + 
				"Cobra  600 veces lo que dice los dados. O sea que si un jugador no dueño de la empresa cae en esa casilla tras haber sacado 12 en los dados => deberá pagar: 12 x 600 = $7200\n" + 
				"Si también tiene la compañía TRENES cobrará 1100 veces  lo sacado en los dados.\n" + 
				"CORDOBA NORTE:\n" + 
				"Precio terreno: $20000\n" + 
				"Alquiler: $1300\n" + 
				"Alquiler con 1 casa: $1800\n" + 
				"Alquiler con 2 casas: $2900\n" + 
				"Alquiler con Hotel: $3500\n" + 
				"Construir casas cuestan $2200 y hotel $3500\n" + 
				"IMPUESTO AL LUJO: El jugador que caiga en esta casilla debe pagar el 10 % de todo su efectivo\n" + 
				"SANTA FE:\n" + 
				"Precio terreno: $15000\n" + 
				"Alquiler: $1500\n" + 
				"Alquiler con 1 casa: $3500\n" + 
				"Construir la única casa posible cuesta $4000\n" + 
				"AYSA: \n" + 
				"Comprar la compañía: $30000\n" + 
				"Cobra  300 veces lo que dice los dados. O sea que si un jugador no dueño de la empresa cae en esa casilla tras haber sacado 12 en los dados => deberá pagar: 12 x 300 = $3600\n" + 
				"Si también tiene la compañía EDESUR cobrará 500 veces  lo sacado en los dados.\n" + 
				"SALTA NORTE:\n" + 
				"Precio terreno: $23000\n" + 
				"Alquiler: $2000\n" + 
				"Alquiler con 1 casa: $3250\n" + 
				"Alquiler con 2 casas: $3850\n" + 
				"Alquiler con Hotel: $5500\n" + 
				"Construir casas cuestan $4500 y hotel $7500\n" + 
				"SALTA SUR:\n" + 
				"Precio terreno: $23000\n" + 
				"Alquiler: $2000\n" + 
				"Alquiler con 1 casa: $3250\n" + 
				"Alquiler con 2 casas: $3850\n" + 
				"Alquiler con Hotel: $5500\n" + 
				"Construir casas cuestan $4500 y hotel $7500\n" + 
				"POLICIA: Al caer en este casillero el jugador va a la cárcel.\n" + 
				"TRENES: \n" + 
				"comprar la compañía: $38000\n" + 
				"Cobra  450 veces lo que dice los dados. O sea que si un jugador no dueño de la empresa cae en esa casilla tras haber sacado 12 en los dados => deberá pagar: 12 x 450 = $5400\n" + 
				"Si también tiene la compañía SUBTES cobrará 800 veces  lo sacado en los dados.\n" + 
				"NEUQUEN:\n" + 
				"Precio terreno: $17000\n" + 
				"Alquiler: $1800\n" + 
				"Alquiler con 1 casa: $3800\n" + 
				"Construir la única casa posible cuesta $4800\n" + 
				"RETROCESO DINAMICO: El jugador avanzará tantos casilleros como lo indica la siguiente lógica:\n" + 
				"Si sacó 2,3,4,5 o 6 =>  retrocede el número sacado menos la sumatoria de propiedades del jugador. Tanto los terrenos como las casas como los hoteles suman como propiedad. \n" + 
				"Si sacó 7,8,9 o 10 => retrocede #cantidad de efectivo del jugador % numero sacado \n" + 
				"si sacó 11 o 12 => retrocede el número sacado menos 2 unidades\n" + 
				"TUCUMAN:\n" + 
				"Precio terreno: $25000\n" + 
				"Alquiler: $2500\n" + 
				"Alquiler con 1 edificio histórico: $4500\n" + 
				"Construir la casita de tucumpán (única construcción posible) cuesta $7000\n" + 
				"");

		informacion.setEditable(false);

		GridPane.setVgrow(informacion, Priority.ALWAYS);
		GridPane.setHgrow(informacion, Priority.ALWAYS);
		GridPane expContent = new GridPane();
		expContent.add(informacion, 0, 1);
		
		alert.getDialogPane().setExpandableContent(expContent);
		alert.show();
		
	}
}
