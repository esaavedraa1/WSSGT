
package wssgt;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;



public class WSSGT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         System.out.println("+-------- Oracle SGT TESTER APLICATION --------+");
         System.out.println("| APP VER 02 |");
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }
        System.out.println("Oracle SERVER     ... OK!");
        System.out.println("Oracle JDBC Driver... OK!");
        Scanner sc = new Scanner(System.in);

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@192.168.111.250:1521:xe", "SGT", "abc123");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("Conexion Establesida... OK!");
        } else {
            System.out.println("Failed to make connection!");
        }
        int op = 0;
        int i;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
       
        String cadena;
        do
        {
    
            System.out.println("+--------------------------------------------+");
            System.out.println("|  OP  |              DESCRIPCIÓN            |");
            System.out.println("+--------------------------------------------+");
            System.out.println("|  1   |             CONSULTAS               |");
            System.out.println("+--------------------------------------------+");
            System.out.println("|  2   |            FACTURACIÓN              |");
            System.out.println("+--------------------------------------------+");
            System.out.println("|  3   |        GESTIÓN TRANSPORTES          |");
            System.out.println("+--------------------------------------------+");
            System.out.println("|  4   |            MANTENEDORES             |");
            System.out.println("+--------------------------------------------+");
            System.out.println("|  9   |        BUSSINES TO BUSINNES         |");
            System.out.println("+--------------------------------------------+");
            System.out.println("|  10   |               EXIT                 |");
            System.out.println("+--------------------------------------------+");
            System.out.print("Select a number >> ");
            try
            {
                op = Integer.parseInt (br.readLine());
            }
            catch(Exception e)
            {
              System.out.println("Failed to make connection!");  
            }
            switch(op)
            {
                case 1:
                    System.out.println("+--------------------------------------------+");
                    System.out.println("|  OP  |              DESCRIPCIÓN            |");
                    System.out.println("+--------------------------------------------+");
                    System.out.println("|  1   |             CONSULTAS               |");
                    System.out.println("+--------------------------------------------+");
                    System.out.println("|  2   |            FACTURACIÓN              |");
                    System.out.println("+--------------------------------------------+");
                    System.out.println("|  3   |        GESTIÓN TRANSPORTES          |");
                    System.out.println("+--------------------------------------------+");
                    System.out.println("|  4   |            MANTENEDORES             |");
                    System.out.println("+--------------------------------------------+");
                    System.out.println("|  9   |        BUSSINES TO BUSINNES         |");
                    System.out.println("+--------------------------------------------+");
                    System.out.println("|  0   |               EXIT                 |");
                    System.out.println("+--------------------------------------------+");
                    System.out.print("Select a number >> ");
                    break;
                case 3:
                    System.out.println("+--------------------------------------------+");
                    System.out.println("|  OP  |  30000 :MENÚ GESTIÓN DE VIAJES      |");
                    System.out.println("+--------------------------------------------+");
                    System.out.println("| 301  |          PLANIFICACIÓN              |");
                    System.out.println("+--------------------------------------------+");
                    System.out.println("| 302  |           SOLICITUDES               |");
                    System.out.println("+--------------------------------------------+");
                    System.out.println("| 303  |             CONTROL                 |");
                    System.out.println("+--------------------------------------------+");
                    System.out.println("| 304  |             SELLOS                  |");
                    System.out.println("+--------------------------------------------+");
                    System.out.println("| 305  |          VALIDACIONES               |");
                    System.out.println("+--------------------------------------------+");
                    System.out.println("| 306   |      MANIFIESTOS DE CARGA          |");
                    System.out.println("+--------------------------------------------+");
                    System.out.println("| 307   |           SERVICIOS                |");
                    System.out.println("+--------------------------------------------+");
                    System.out.println("| 308   |            VIAJES                  |");
                    System.out.println("+--------------------------------------------+");
                    System.out.println("| 309   |           DOCUMENTOS               |");
                    System.out.println("+--------------------------------------------+");
                    System.out.print("Select a number >> ");
                    int op3 = 0;
                    try
                    {
                        op3 = Integer.parseInt (br.readLine());
                    }
                    catch(Exception e)
                    {
                      System.out.println("Failed to make connection!");  
                    }
                    switch(op3)
                    {
                        case 301:
                            try{
                                System.out.print("\nIngrese Mes >>");
                                String V_MON = sc.nextLine();
                                System.out.print("\nIngrese Año >>");
                                String V_YEAR = sc.nextLine();
                                Statement stmt= connection.createStatement();
                                String sql="SELECT LOCA_NOMBRE,HISTORICO(LOCA_NOMBRE, 1,'"+V_MON+"','"+V_YEAR+"') AS \"LUNES\",HISTORICO(LOCA_NOMBRE, 2,'"+V_MON+"','"+V_YEAR+"') AS \"MARTES\",  \n" +
"HISTORICO(LOCA_NOMBRE, 3,'"+V_MON+"','"+V_YEAR+"') AS \"MIERCOLES\" ,HISTORICO(LOCA_NOMBRE, 4,'"+V_MON+"','"+V_YEAR+"') AS \"JUEVES\",HISTORICO(LOCA_NOMBRE, 5,'"+V_MON+"','"+V_YEAR+"') AS \"VIERNES\" \n" +
",HISTORICO(LOCA_NOMBRE, 6,'"+V_MON+"','"+V_YEAR+"') AS \"SABADO\" ,HISTORICO(LOCA_NOMBRE, 7,'"+V_MON+"','"+V_YEAR+"') AS \"DOMINGO\" ,HISTORICO_TOTAL(LOCA_NOMBRE,'"+V_MON+"','"+V_YEAR+"') AS \"TOTAL\"\n" +
"FROM SGT_LOCALIDAD WHERE LOCAT_ID = 4 GROUP BY  LOCA_NOMBRE ORDER BY LOCA_NOMBRE ASC";
                               
                                ResultSet rs=stmt.executeQuery(sql);  

                                String leftAlignFormat = "| %-20s| %-8s | %-8s | %-9s | %-7s |%-9s | %-8s |%-8s | %-8s |%n";

                                System.out.format("+---------------------+----------+----------+-----------+---------+----------+----------+---------+----------+%n");
                                System.out.format("|       DESTINO       |   LUNES  |  MARTES  | MIERCOLES | JUEVES  | VIERNES  |  SABADO  | DOMINGO |   TOTAL  |%n");
                                System.out.format("+---------------------+----------+----------+-----------+---------+----------+----------+---------+----------+%n");
                                   while(rs.next()) {

                                    System.out.format(leftAlignFormat, rs.getString(1) ,rs.getString(2),rs.getString(3), rs.getString(4) ,rs.getString(5),rs.getString(6), rs.getString(7) ,rs.getString(8),rs.getString(9));  
              
                                   }

                                  System.out.format("+---------------------+----------+----------+-----------+---------+----------+----------+---------+-----------+%n");
                            }
                            catch (SQLException e) {

                                System.out.println("Connection Failed! Check output console");
                                e.printStackTrace();
                                return;     

                            }
                            System.out.println("PRESS ENTER TO EXIT");
                            cadena = sc.nextLine();
                            break;
                        default:
                            System.out.println("+------------------------------------------------------+");
                            System.out.println("| ERROR : SGT-0001 NO OPTION FOUND- PRESS ENTER TO EXIT|");
                            System.out.println("+------------------------------------------------------+");
                            cadena = sc.nextLine();
                            break;    
                    }
                    break;
                case 0:
                    System.out.println("+--------------------------------------------+");
                    System.out.println("|  SGT-MSG-1001 GOODBYE-PRESS ENTER TO EXIT  |");
                    System.out.println("+--------------------------------------------+");
                    cadena = sc.nextLine();
                    break;
                default:
                    System.out.println("+------------------------------------------------------+");
                    System.out.println("| ERROR : SGT-0001 NO OPTION FOUND- PRESS ENTER TO EXIT|");
                    System.out.println("+------------------------------------------------------+");
                    cadena = sc.nextLine();
                    break;
            }
            
        }while(op != 0);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        try{
            Statement stmt= connection.createStatement();
            //step4 execute query  
            ResultSet rs=stmt.executeQuery("select * from SGT_DESPACHO_TIPO");  
            
            String leftAlignFormat = "| %-3s| %-5s | %-40s |%n";
            
            System.out.format("+----+-------+------------------------------------------+%n");
            System.out.format("| ID | TIPO  |                DESCRIPCION               |%n");
            System.out.format("+----+-------+------------------------------------------+%n");
               while(rs.next()) {
              
                System.out.format(leftAlignFormat, rs.getString(1) ,rs.getString(2),rs.getString(3));  
               }
              
            System.out.format("+----+-------+------------------------------------------+%n");
        }
        catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;     

        }
        
  

//step5 close the connection object  
try{
connection.close();  }
    
 catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;     

        }
    
    }
}
