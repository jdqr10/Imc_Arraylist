package imc_Arraylist;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Procesos_ImcArraylist {
	
	String nombre="";
	int telefono = 0;
	Double peso, talla, imc;
	
	ArrayList<String> nombres = new ArrayList<>();
	ArrayList<String> resultado = new ArrayList<>();
	
	public void menu() {
		
		int opcion;
		do {
			
		opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opcion\n" +
		"1 - Agregar pacientes\n" +
		"2 - Consultar paciente\n" + 
		"3 - Eliminacion de registros\n" +
		"4 - Actualizar registros\n" +
		"5 - Imprimir resultados\n"));
		
		switch (opcion) {
		case 1:
			registros();
			break;
			
		case 2:
			consultarNombre();
			break;
			
		case 3: 
			eliminacion();
			break;
			
		case 4:
			actualizacion();
			break;
			
		case 5: 
			imprimirResultados();
		default:
			break;
		}
		
		} while (opcion != 6);
		
	}
	
	



	public void registros() {
		
		String proceso ="";
		
		do {
			
			nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente");
			nombres.add(nombre);
			peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese peso del paciente"));
			talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese estatura del paciente"));
			calculosIMC();
			
			proceso = JOptionPane.showInputDialog("¿Desea agregar un nuevo paciente?\n " + "Ingrese si para seguir\n");
			
		} while (proceso.equalsIgnoreCase("si"));
		
		System.out.println();		
		System.out.println(nombres);
		System.out.println(resultado+ "\n");
	}
	
	
	public void consultarNombre() {
		
		System.out.println("Usuarios en sistema: " + nombres);
		String consulta = JOptionPane.showInputDialog("Ingrese el nombre del paciente a consultar");
		
		if(nombres.contains(consulta)) {
			
		for (int i = 0; i < nombres.size(); i++) {
			
			if(nombres.get(i).equalsIgnoreCase(consulta)) {
				
				System.out.println(consulta + " si existe en el sistema");
				System.out.println("Y tiene como resultado = "+resultado.get(i));
				
				}
			}
		}else {
			System.out.println("El paciente no existe");
		}
	}
	
	public void eliminacion(){
		
		System.out.println("Usuarios en sistema: " + nombres);
		String consulta = JOptionPane.showInputDialog("Ingrese el nombre del paciente a elimianr");
		
		if(nombres.contains(consulta)) {
			for (int i = 0; i < nombres.size(); i++) {
				if(nombres.get(i).equalsIgnoreCase(consulta)) {
					nombres.remove(consulta);
					System.out.println("El paciente ha sido eliminado del sistema" + nombres);
				}
				
			}
		}else {
			
			System.out.println("El paciente no existe");
			
		}
	}
	
	public  void actualizacion() {
		
		int consulta =0;
		
		do {
			
		
		consulta = Integer.parseInt(JOptionPane.showInputDialog("Que desea actualizar\n" +
		"1 - Nombre del paciente\n" +
		"2 - Salir al menú principal"));
		
		switch (consulta) {
		case 1:
			actualizarNombre();		
			break;
		case 2:
			menu();
			/*actualizacionPesoYEstatura(imc, imc);*/
			break;

		default:
			System.out.println("Ingrese un numero correcto");
			break;
		}
	} while (consulta != 3);	
}
	
	
	
	public void calculosIMC() {
		imc= 0.0;
		imc=peso/(talla*talla);
		
		String result="";
		
		if (imc<18) {
			result=("Anorexia");
		}else if (imc>=18 && imc <20) {
			result=("Delgadez");
		}else if (imc>=20 && imc <27) {
			result=("Normalidad");
		}else if (imc>=27 && imc <30) {
			result=("Obesidad 1");
		}else if (imc>=30 && imc <35) {
			result=("Obesidad 2");
		}else if (imc>=35 && imc <40) {
			result=("Obesidad 3");
		}else if (imc>=40) {
			result=("Obesidad Morbida");
		}
		
		resultado.add(result);
		System.out.println("El Resultado es: "+result);
		}
	
	
	private void imprimirResultados() {
		System.out.println("********RESULTADOS**********\n");
		
		for (int i = 0; i < nombres.size(); i++) {
			System.out.println(nombres.get(i)+", resultado: "+resultado.get(i));
		}
		
		System.out.println();
		System.out.println("*****************************");
	}
		
	public void actualizarNombre() {
		
		System.out.println("Usuarios en sistema: " + nombres);
		
		String paciente = JOptionPane.showInputDialog("Ingrese el nombre del paciente que desea actualizar");
			
		
		
		if (nombres.contains(paciente)) {
			for (int i = 0; i < nombres.size(); i++) {
				if (nombres.get(i).equalsIgnoreCase(paciente)) {
					nombres.remove(paciente);
					
					nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente actualizado");
					nombres.add(nombre);
					System.out.println("El paciente ha sido actualizado correctamente");
				}
				
			}
		}else {
			System.out.println("El paciente no existe en el sistema");
		}
	}
	
}
