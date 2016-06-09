import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SimpleCalc {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 * Wird von Eclipse zusammengebaut.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalc window = new SimpleCalc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * Der Konstruktor unserer Klasse, erzeugen wir mit new (in der main) ein Objekt der Klasse wird
	 * diese Methode als erstes aufgerufen.
	 * initialize (in NetBeans initComponents()) ertellt alle GUI Componenten (Label, TextField, Button,...
	 */
	public SimpleCalc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * Hier werden die Componenten erzeugt - in NetBeans nicht veränderbar, hier aber schon 
	 * Bei NetBeans werden die Methoden die man dann verändern darf, einfach außerhalb erstellt
	 * wie private void Button1 actionPerformed(...){...}
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Zahl 1");
		lblNewLabel.setBounds(22, 41, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(110, 38, 255, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Zahl 2");
		lblNewLabel_1.setBounds(22, 93, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 90, 255, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ergebnis");
		lblNewLabel_2.setBounds(22, 118, 344, 132);
		frame.getContentPane().add(lblNewLabel_2);
		
		// Hier können wir in der action Performed einfach das Programmieren was wir "brauchen"
		// Button, ActionListener werden erzeugt, müssen wir nicht machen (könnten aber wenn wir wollten)
		JButton btnRechne = new JButton("Rechne!");
		btnRechne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Eingabe - hier gehts los
				// Variablen um den text der TextFelder zu speichenr anlegen und sich den Text geben lassen
				String eingabe1 = textField.getText();
				String eingabe2 = textField_1.getText();
				
				String ausgabe = "<html>Ergebnis: <br>";
				
				// Verarbeitung - jetze wird geprüft und gerechnet
				 
				if( eingabe1.length() > 0 && eingabe2.length() > 0 ){
					
					// Eine Zahl erstellen lassen aus dem Text
					double z1 =  Double.parseDouble( eingabe1 );
					double z2 =  Double.parseDouble( eingabe2 );

					// Rechnen
					double e1 = z1 + z2;
					double e2 = z1 * z2;
					double e3 = z1 - z2;
					double e4;
					// Für die Division prüfen ob z2 keine 0 ist
					if( z2 != 0){
						e4 = z1 / z2;
						ausgabe += " Division " + e4 +"<br>";
					}else{ // ist es null, wird nix gerechnet
						ausgabe += " Division durch 0 nicht möglich! "+"<br>";
					}
					// weiteren Ausgabe Text erstellen
					ausgabe += " Addition " + e1+"<br>";
					ausgabe += " Multiplikation " + e2+"<br>";
					ausgabe += " Subtraktion " + e3+"<br>";
					
					
				}else { // Eingabefelder leer? Keine Rechnung - nut Text!
					ausgabe = ausgabe + " Keine Gültigen Werte bei der Eingabe!"+"<br>";
				}
				
				// Ausgabe - Unseren zusammengebauten Text auf den Label "setzen"  - Fertig!
				lblNewLabel_2.setText(ausgabe);
				
				
			}
		});
		
		btnRechne.setBounds(375, 89, 89, 23);
		frame.getContentPane().add(btnRechne);
		
		
	}
}
