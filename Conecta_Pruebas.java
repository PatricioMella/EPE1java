package ConectandoBaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conecta_Pruebas {


   private Statement createStatement;

    public static void main(String[] args) {
        try {
            //crear conecion.
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/centro_medico","root","");
            System.out.println("Conectado con exito");
            /* Crear objeto statement */
            Statement miConexion = con.createStatement();

            //ejecutar sentencia SQL
            ResultSet miResulset = miConexion.executeQuery("select * from paciente");
            System.out.println("********** Lista de Pacientes **********");
            System.out.println(" ");
            //Recorrer el resulset
            while (miResulset.next()) {
                System.out.println( miResulset.getString("nombre")+ " " + miResulset.getString("apellidos")+" "+ miResulset.getString("rut_pac"));
            }
            System.out.println(" ");
            System.out.println(" ");
            ResultSet Resul = miConexion.executeQuery("select * from medico");
            System.out.printf("");
            System.out.println("******** Lista de Medicos **********");
            System.out.printf(" ");

            while ( Resul.next ()){
                System.out.println(Resul.getString("nombre")+" "+ Resul.getString("apellidos") +" "+ Resul.getString("rut_medico")+" "+ Resul.getString("especialidad"));
            }

        }catch (Exception e) {
            System.out.println("mal conectado");
            e.printStackTrace();

        }
    }
}
