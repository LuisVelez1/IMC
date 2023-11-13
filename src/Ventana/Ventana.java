package Ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import clases.Logica;
import clases.PersonaVO;

public class Ventana extends JFrame implements ActionListener{
    private JLabel lblTitulo;
    private JLabel lblDocumento;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblPeso;
    private JLabel lblTalla;
    private JLabel lblResultado;
    private JTextArea textAreaResultado;
    private JTextField txtDocumento;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtPeso;
    private JTextField txtTalla;
    JButton btnCalcularIMC, btnRegistrar, btnCalcularPromedio, btnListaPersonas;
    private JScrollPane scrollPane;
    
    Logica miLogica;

    public Ventana() {
        setTitle("HOME");
        setSize(730, 540);
        setLocationRelativeTo(null);
        miLogica = new Logica();
        initialize();
        
    }

    private void initialize() {
        getContentPane().setBackground(new Color(204, 255, 153));
        setLayout(null);

        lblTitulo = new JLabel("CALCULAR IMC");
        lblTitulo.setFont(new Font("Dialog", Font.BOLD, 16));
        lblTitulo.setBounds(300, 12, 140, 17);
        getContentPane().add(lblTitulo);

        lblDocumento = new JLabel("Documento:");
        lblDocumento.setBounds(12, 83, 81, 17);
        getContentPane().add(lblDocumento);

        txtDocumento = new JTextField();
        txtDocumento.setBounds(99, 81, 140, 17);
        getContentPane().add(txtDocumento);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(247, 83, 110, 17);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(312, 83, 213, 17);
        getContentPane().add(txtNombre);

        lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(546, 83, 110, 17);
        getContentPane().add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(597, 83, 48, 17);
        getContentPane().add(txtEdad);

        lblPeso = new JLabel("Peso:");
        lblPeso.setBounds(12, 162, 48, 17);
        getContentPane().add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(59, 162, 119, 17);
        getContentPane().add(txtPeso);

        lblTalla = new JLabel("Talla:");
        lblTalla.setBounds(247, 162, 110, 17);
        getContentPane().add(lblTalla);

        txtTalla = new JTextField();
        txtTalla.setBounds(300, 162, 71, 17);
        getContentPane().add(txtTalla);

        lblResultado = new JLabel("Resultado");
        lblResultado.setFont(new Font("Dialog", Font.BOLD, 14));
        lblResultado.setBounds(12, 206, 110, 17);
        getContentPane().add(lblResultado);

        textAreaResultado = new JTextArea();
        textAreaResultado.setBounds(12, 235, 696, 183);
        getContentPane().add(textAreaResultado);
        
        scrollPane = new JScrollPane(textAreaResultado);
        scrollPane.setBounds(12, 235, 696, 183);
        getContentPane().add(scrollPane);

        btnCalcularIMC = new JButton("Calcular IMC");
        btnCalcularIMC.setBounds(198, 471, 147, 27);
        btnCalcularIMC.addActionListener(this);
        getContentPane().add(btnCalcularIMC);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(357, 471, 147, 27);
        btnRegistrar.addActionListener(this);
        getContentPane().add(btnRegistrar);
        
        btnListaPersonas = new JButton("Consultar Lista");
        btnListaPersonas.setBounds(516, 471, 192, 27);
        btnListaPersonas.addActionListener(this);
        getContentPane().add(btnListaPersonas);

        btnCalcularPromedio = new JButton("Calcular Promedio IMC");
        btnCalcularPromedio.setBounds(516, 471, 192, 27);
        btnCalcularPromedio.addActionListener(this);
        getContentPane().add(btnCalcularPromedio);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(btnRegistrar == e.getSource()) {
			PersonaVO miPersona = new PersonaVO();
			miPersona.setDocumento(txtDocumento.getText());
			miPersona.setNombre(txtNombre.getText());
			miPersona.setEdad(Integer.parseInt(txtEdad.getText()));
			miPersona.setTalla(Double.parseDouble(txtTalla.getText()));
			miPersona.setPeso(Double.parseDouble(txtPeso.getText()));
			
			
			String res = miLogica.registrarPersona(miPersona);
			textAreaResultado.setText(res);
			
		}
		
		if(btnListaPersonas==e.getSource()) {
			String res = miLogica.consultarListaPersonas();
			textAreaResultado.setText(res);
		}
		
		if(btnCalcularIMC==e.getSource()) {
			String res=miLogica.consultarPromedio();
			textAreaResultado.setText(res);
		}
		
	}
}

