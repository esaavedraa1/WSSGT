
package wssgt;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Date;


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
            System.out.println("|  0   |               EXIT                 |");
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
                            System.out.println("+--------------------------------------------+");
                            System.out.println("|  OP  |  30000 :MENÚ GESTIÓN DE VIAJES      |");
                            System.out.println("+--------------------------------------------+");
                            System.out.println("| 30101|    PLANIFICACIÓN  HISTÓRICA         |");
                            System.out.println("+--------------------------------------------+");
                            System.out.println("| 30102|    PLANIFICACIÓN PREDICTIVA         |");
                            System.out.println("+--------------------------------------------+");
                            System.out.print("Select a number >> ");
                            int op31 = 0;
                            try
                            {
                                op31 = Integer.parseInt (br.readLine());
                            }
                            catch(Exception e)
                            {
                              System.out.println("Failed to make connection!");  
                            }
                            switch(op31){
                                case 30101:
                                    try{
                                    System.out.print("\nIngrese Mes (Mayusculas) >>");
                                    String V_MON = sc.nextLine();
                                    System.out.print("\nIngrese Año (4 Digitos)>>");
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
                                    break;
                                default:
                                    System.out.println("+------------------------------------------------------+");
                                    System.out.println("| ERROR : SGT-0001 NO OPTION FOUND- PRESS ENTER TO EXIT|");
                                    System.out.println("+------------------------------------------------------+");
                                    cadena = sc.nextLine();
                                    break;     
                            }  
                            System.out.println("PRESS ENTER TO EXIT");
                            cadena = sc.nextLine();
                            break;
                        case 302:
                            int despt_id = 0;
                            int flotc_id = 0;
                            int soli_m3 = 0;
                            int loca_origen = 0;
                            int loca_destino = 0;
                            int prov_id = 0;
                            int flott_id = 0;
                            String soli_fecha = "";
                            System.out.println("+--------------------------------------------+");
                            System.out.println("|  OP  |  30000 :MENÚ GESTIÓN DE VIAJES      |");
                            System.out.println("+--------------------------------------------+");
                            System.out.println("| 30201|       SOLICITUD PROGRAMADA          |");
                            System.out.println("+--------------------------------------------+");
                            System.out.println("| 30202|       SOLICITUD EXPRESS             |");
                            System.out.println("+--------------------------------------------+");
                            System.out.println("| 30203|       SOLICITUD PUBLICAR            |");
                            System.out.println("+--------------------------------------------+");
                            System.out.print("Select a number >> ");
                            int op32 = 0;
                            try
                            {
                                op32 = Integer.parseInt (br.readLine());
                            }
                            catch(Exception e)
                            {
                              System.out.println("Failed to make connection!");  
                            }
                            switch(op32)
                            {
                                case 30201:
                                    System.out.println("Seleccione Tipo de Viaje");
                                    try{
                                        Statement stmt= connection.createStatement();
                                        //step4 execute query  
                                        ResultSet rs=stmt.executeQuery("SELECT DESPT_ID AS \"ID\" ,CONCAT(CONCAT(CONCAT(CONCAT(DESPT_ID,' - '),DESPT_TIPO),' - '),DESPT_DESCRIPCION) AS \"TIPO_VIAJE\"  FROM SGT_DESPACHO_TIPO");  

                                        String leftAlignFormat = "| %-3s| %-40s |%n";

                                        System.out.format("+----+------------------------------------------+%n");
                                        System.out.format("| ID |                 DESCRIPCION              |%n");
                                        System.out.format("+----+------------------------------------------+%n");
                                           while(rs.next()) {

                                            System.out.format(leftAlignFormat, rs.getString(1) ,rs.getString(2));  
                                           }

                                        System.out.format("+----+------------------------------------------+%n");
                                    }
                                     catch (SQLException e) {

                                        System.out.println("Connection Failed! Check output console");
                                        e.printStackTrace();
                                        return;     

                                    }
                                    System.out.print("Select a number >> ");
                                    try
                                    {
                                        despt_id = Integer.parseInt (br.readLine());
                                    }
                                    catch(Exception e)
                                    {
                                      System.out.println("Failed to make connection!");  
                                    }
                                    System.out.println("Seleccione Tipo de cobro");
                                    int flotc_total = 0;
                                    try{
                                        Statement stmt= connection.createStatement();
                                        //step4 execute query  
                                        ResultSet rs=stmt.executeQuery("SELECT FLOTC_ID AS \"ID\",CONCAT(CONCAT(FLOTC_ID,' - '),FLOTC_TIPO) AS \"TIPO_COBRO\" FROM SGT_FLOTA_COBRO");  
                                        flotc_total = rs.getRow();
                                        String leftAlignFormat = "| %-3s| %-40s |%n";

                                        System.out.format("+----+------------------------------------------+%n");
                                        System.out.format("| ID |                 DESCRIPCION              |%n");
                                        System.out.format("+----+------------------------------------------+%n");
                                           while(rs.next()) {

                                            System.out.format(leftAlignFormat, rs.getString(1) ,rs.getString(2));  
                                           }
                                        
                                        System.out.format("+----+------------------------------------------+%n");
                                    }
                                    catch (SQLException e) {

                                        System.out.println("Connection Failed! Check output console");
                                        e.printStackTrace();
                                        return;     

                                    }
                                    System.out.print("Select a number >> ");
                                    do{
                                        try
                                        {
                                            flotc_id = Integer.parseInt (br.readLine());
                                        }
                                        catch(Exception e)
                                        {
                                          System.out.println("Failed to make connection!");  
                                        }
                                    }while((flotc_id>flotc_total)&&(flotc_id<0));
                                    if(flotc_id == 2)
                                    {
                                        System.out.print("Ingrese la Cantidad de Metros Cubicos >>");
                                        try
                                        {
                                            soli_m3 = Integer.parseInt (br.readLine());
                                        }
                                        catch(Exception e)
                                        {
                                          System.out.println("Failed to make connection!");  
                                        }
                                    }
                                    System.out.println("Seleccione Destino");
                                    int loca_total = 0;
                                    int prov_total = 0;
                                    int flott_total = 0;
                                    if(despt_id == 1)//TRONCAL
                                    {
                                        try{
                                            Statement stmt= connection.createStatement();
                                            //step4 execute query  
                                            ResultSet rs=stmt.executeQuery("SELECT LO.LOCA_ID AS \"ID\",CONCAT(CONCAT(CONCAT(CONCAT(LO.LOCA_DESCRIPCION,' - '),LT.LOCAT_TIPO),' - '),LO.LOCA_NOMBRE) AS \"DESTINO\" FROM SGT_LOCALIDAD LO ,SGT_LOCALIDAD_TIPO LT WHERE LO.LOCAT_ID = LT.LOCAT_ID AND LO.LOCAT_ID = 3");  
                                            flotc_total = rs.getRow();
                                            String leftAlignFormat = "| %-3s| %-40s |%n";

                                            System.out.format("+----+------------------------------------------+%n");
                                            System.out.format("| ID |                 DESCRIPCION              |%n");
                                            System.out.format("+----+------------------------------------------+%n");
                                               while(rs.next()) {

                                                System.out.format(leftAlignFormat, rs.getString(1) ,rs.getString(2));  
                                               }

                                            System.out.format("+----+------------------------------------------+%n");
                                        }
                                        catch (SQLException e) {

                                            System.out.println("Connection Failed! Check output console");
                                            e.printStackTrace();
                                            return;     

                                        }
                                        System.out.print("Select a number >> ");
                                        do{
                                            try
                                            {
                                                loca_destino = Integer.parseInt (br.readLine());
                                            }
                                            catch(Exception e)
                                            {
                                              System.out.println("Failed to make connection!");  
                                            }
                                        }while((loca_destino>loca_total)&&(loca_destino<0));
                                    }  
                                    System.out.println("Seleccione Transportista");
                                    
                                    try{
                                        Statement stmt= connection.createStatement();
                                        //step4 execute query  
                                        ResultSet rs=stmt.executeQuery("SELECT PROV_ID AS \"ID\", CONCAT(CONCAT(PROV_ID,' - '),PROV_NOMBRE) AS \"TRANSPORTISTA\" FROM SGT_PROVEEDOR");  
                                        prov_total = rs.getRow();
                                        String leftAlignFormat = "| %-3s| %-40s |%n";

                                        System.out.format("+----+------------------------------------------+%n");
                                        System.out.format("| ID |                 DESCRIPCION              |%n");
                                        System.out.format("+----+------------------------------------------+%n");
                                           while(rs.next()) {

                                            System.out.format(leftAlignFormat, rs.getString(1) ,rs.getString(2));  
                                           }

                                        System.out.format("+----+------------------------------------------+%n");
                                    }
                                    catch (SQLException e) {

                                        System.out.println("Connection Failed! Check output console");
                                        e.printStackTrace();
                                        return;     

                                    }
                                    System.out.print("Select a number >> ");
                                    do{
                                        try
                                        {
                                            prov_id = Integer.parseInt (br.readLine());
                                        }
                                        catch(Exception e)
                                        {
                                          System.out.println("Failed to make connection!");  
                                        }
                                    }while((prov_id>prov_total)&&(prov_id<0));
                                           System.out.println("Seleccione Tipo de Vahiculo");
                                    
                                    try{
                                        Statement stmt= connection.createStatement();
                                        //step4 execute query  
                                        ResultSet rs=stmt.executeQuery("SELECT FLOTT_ID AS \"ID\", CONCAT(CONCAT(FLOTT_ID,' - '),FLOTT_TIPO) FROM SGT_FLOTA_TIPO");  
                                        flott_total = rs.getRow();
                                        String leftAlignFormat = "| %-3s| %-40s |%n";

                                        System.out.format("+----+------------------------------------------+%n");
                                        System.out.format("| ID |                 DESCRIPCION              |%n");
                                        System.out.format("+----+------------------------------------------+%n");
                                           while(rs.next()) {

                                            System.out.format(leftAlignFormat, rs.getString(1) ,rs.getString(2));  
                                           }

                                        System.out.format("+----+------------------------------------------+%n");
                                    }
                                    catch (SQLException e) {

                                        System.out.println("Connection Failed! Check output console");
                                        e.printStackTrace();
                                        return;     

                                    }
                                    System.out.print("Select a number >> ");
                                    do{
                                        try
                                        {
                                            flott_id = Integer.parseInt (br.readLine());
                                        }
                                        catch(Exception e)
                                        {
                                          System.out.println("Failed to make connection!");  
                                        }
                                    }while((flott_id>flott_total)&&(flott_id<0));  
                                    System.out.print("Ingrese la Fecha de Presentacion >>");
                                    try
                                    {
                                        soli_fecha = (br.readLine());
                                    }
                                    catch(Exception e)
                                    {
                                      System.out.println("Failed to make connection!");  
                                    }
                                    try
                                    {                       
                                        Statement stmt= connection.createStatement();
                                        //step4 execute query 
                                        String sql = "INSERT INTO \"SGT\".\"SGT_SOLICITUD\" (SOLIT_ID, DESPT_ID, FLOTC_ID, LOCA_ORIGEN, LOCA_DESTINO, PROV_ID, FLOTT_ID, SOLI_FECHA_PRESENTACION, SOLI_ESTADO, SOLI_FECHA_ESTADO) "
                                                + "VALUES ('2', '"+despt_id+"', '"+flotc_id+"', '1', '"+loca_destino+"', '"+prov_id+"', '"+flott_id+"', TO_DATE('"+soli_fecha+"', 'DD/MM/YYYY HH24:MI:SS'), 'CREADO', SYSDATE)";
                                        stmt.executeUpdate(sql);  
                                        
                                        System.out.println(sql);
                                        stmt.executeUpdate("COMMIT");  
                                    }                
                                    catch (SQLException e) {

                                        System.out.println("Connection Failed! Check output console");
                                        e.printStackTrace();
                                        return;     

                                    } 
                                    finally
                                    {
                                        System.out.println("Ingreso Correcto");
                                    }
                                    System.out.println("PRESS ENTER TO EXIT");
                     
                                    cadena = sc.nextLine();
                                    break;                                
                            }
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
