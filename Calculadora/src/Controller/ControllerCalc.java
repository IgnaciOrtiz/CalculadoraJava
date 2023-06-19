package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ControllerCalc implements Initializable  {

	
	@FXML
	private Label lab_Visor;
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	@FXML
	private void button_Cero(ActionEvent event) {
		numeroPantalla("0");
	}
	@FXML
	private void button_Uno(ActionEvent event) {
		numeroPantalla("1");
	}
	@FXML
	private void button_Dos(ActionEvent event) {
		numeroPantalla("2");
	}
	@FXML
	private void button_Tres(ActionEvent event) {
		numeroPantalla("3");
	}
	@FXML
	private void button_Cuatro(ActionEvent event) {
		numeroPantalla("4");
	}
	@FXML
	private void button_Cinco(ActionEvent event) {
		numeroPantalla("5");
	}
	@FXML
	private void button_Seis(ActionEvent event) {
		numeroPantalla("6");
	}
	@FXML
	private void button_Siete(ActionEvent event) {
		numeroPantalla("7");
	}
	@FXML
	private void button_Ocho(ActionEvent event) {
		numeroPantalla("8");
	}
	@FXML
	private void button_Nueve(ActionEvent event) {
		numeroPantalla("9");
	}
	@FXML
	private void button_Punto(ActionEvent event) {
		if(!Punto && !Digito) {
			lab_Visor.setText("0.");
			Digito = true;
		}
		else if(!Punto) {
			String valorActual = lab_Visor.getText();
			lab_Visor.setText(valorActual + ".");
		}
		
		Punto = true;
	}
	
	@FXML
	private void button_Sum(ActionEvent event) {
		evalOperador("+");
	}
	@FXML
	private void button_Rest(ActionEvent event) {
		evalOperador("-");
	}
	@FXML
	private void button_Mult(ActionEvent event) {
		evalOperador("*");
	}
	@FXML
	private void button_Div(ActionEvent event) {
		evalOperador("/");
	}
	@FXML
	private void button_Clean(ActionEvent event) {
		Digito = false;
		Punto = false;
		numOperandos = 0;
		Operando1 = 0;
		Operando2 = 0;
		Operador = ' ';
		lab_Visor.setText("0");
	}
	@FXML
	private void button_Igual(ActionEvent event) {
		evalOperador("=");
	}
	

	
	private boolean Digito = false;
	private boolean Punto = false;
	private int numOperandos = 0;
	private double Operando1;
	private double Operando2;
	private char Operador = ' ';
	
	private void numeroPantalla(String numero) {
		if(!Digito && numero.equals("0"))
			return;
		
		if(!Digito) {
			lab_Visor.setText("");
			Punto = false;
		}
		
		String valorActual = lab_Visor.getText();
		lab_Visor.setText(valorActual + numero);
		Digito = true;
	}
	
	private void evalOperador(String Operador) {
		
		if(Digito)
			numOperandos ++;
		
		if(numOperandos == 1)
			Operando1 = Double.parseDouble(lab_Visor.getText());
		
		if(numOperandos == 2) {
			
			Operando2 = Double.parseDouble(lab_Visor.getText());
			
			switch(this.Operador) {
			case '+':
				Operando1 = Operando1 + Operando2;
				break;
			case '-':
				Operando1 = Operando1 - Operando2;
				break;
			case '*':
				Operando1 = Operando1 * Operando2;
				break;
			case '/':
				Operando1 = Operando1 / Operando2;
				break;
			case '=':
				Operando1 = Operando2;
				break;
			}
			lab_Visor.setText(String.valueOf(Operando1));
			numOperandos = 1;
			Punto = false;	
		}
		Digito = false;
		this.Operador = Operador.charAt(0);
		
	}
	
	
}