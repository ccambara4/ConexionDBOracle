/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexiondboracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author PREDATOR
 */
public class ConexionDB {
    /*
    Controlador
    Direccion ip o nombre del servidor 
    puerto de comunicacion
    base de datos
    */
    
    private String DB_URL;
    private String DB_USER;
    private String DB_PWD;
    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    public ConexionDB() {
        try {
        this.DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
        this.DB_USER = "SYSTEM";
        this.DB_PWD = "12345";
        
        conexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
        conexion.setAutoCommit(false);
        System.out.println("Conexion establecida correctamente\n");
        
        }catch (SQLException e){
            System.out.println("Error de conexion: " + e.getMessage());
        }
    }
    
    public void ejectaQuery(String p_sql, int p_tipoSql){
        
        try {
            
            this.st = this.conexion.createStatement();
            this.rs = this.st.executeQuery(p_sql);
            
            ResultSetMetaData metadata = rs.getMetaData();
            int numeroColumnasTB = metadata.getColumnCount();
            
            if (p_tipoSql > 1){
                conexion.commit();
            }else {
                while(rs.next()){
                for(int i = 1; i <= numeroColumnasTB; i++){
                    System.out.printf("%-8s\t", metadata.getColumnName(i) + 
                            ": " + rs.getObject(i));
                    System.out.println("");
                }
                System.out.println("");
            }
                
            }
          
            
            this.rs.close();
            this.st.close();
            this.conexion.close();
            
        }catch(SQLException e) {
            System.out.println("Error al ejecutar la consulta " + e.getMessage());
        }
    }
    
    
    
}
