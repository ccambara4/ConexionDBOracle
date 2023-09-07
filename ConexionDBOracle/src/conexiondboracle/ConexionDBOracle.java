/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexiondboracle;

/**
 *
 * @author PREDATOR
 */
public class ConexionDBOracle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ConexionDB conexionDb = new ConexionDB();
       final String SELECT_PAIS_TB = "SELECT * FROM SYSTEM.PAIS ORDER BY FECHA_GRABACION DESC";
            
       final String SELECT_FABRICANTE = "SELECT FA.ID_FABRICANTE, FA.NOMBRE, FA.ABREVIATURA, FA.ESTADO, PA.ID_PAIS, PA.NOMBRE PAIS, PA.ABREVIATURA ABRE_PAIS FROM SYSTEM.FABRICANTE FA\n" +
            "INNER JOIN PAIS PA ON PA.ID_PAIS = FA.ID_PAIS\n" +
            "WHERE PA.NOMBRE = 'JAPON'";
       
            final String SELECT_FABRICANTE2 = "SELECT FA.ID_FABRICANTE, FA.NOMBRE, FA.ABREVIATURA, FA.ESTADO, PA.ID_PAIS, PA.NOMBRE PAIS, PA.ABREVIATURA ABRE_PAIS FROM SYSTEM.FABRICANTE FA\n" +
            "INNER JOIN PAIS PA ON PA.ID_PAIS = FA.ID_PAIS\n" +
            "WHERE PA.NOMBRE <> 'JAPON'";
            
            final String INSERT_PAIS = "INSERT INTO SYSTEM.PAIS (ID_PAIS, NOMBRE, ABREVIATURA) VALUES\n" +
"    (SYSTEM.SQ_PAIS.NEXTVAL, 'PANAMA', 'PAN')";
            
            final String INSERT_FABRICANTE = "INSERT INTO SYSTEM.FABRICANTE (ID_FABRICANTE, NOMBRE, ABREVIATURA, ID_PAIS) VALUES\n" +
"    (SYSTEM.SQ_FABRICANTE.NEXTVAL, UPPER('PRUEBA'), 'PR',46)";
            
            final String INSERT_TIPO = "INSERT INTO SYSTEM.TIPO_VEHICULO (ID_TIPO, NOMBRE) VALUES\n" +
"    (SYSTEM.SQ_TIPO_VEHICULO.NEXTVAL, 'MOTOCICLETA')";
            
            final String SELECT_TIPO = "SELECT * FROM SYSTEM.TIPO_VEHICULO";
            
            
            
            final String INSERT_VEHICULO = "INSERT INTO SYSTEM.VEHICULO (ID_VEHICULO,ID_TIPO,ID_COMBUSTIBLE,ID_TRANSMISION,ID_FABRICANTE,\n" +
"            PLACA, ANIO, MODELO, COLOR, CILINDRADA, COSTO, ESTADO, RENDIMIENTO, VELOCIDAD_MAXIMA)  \n" +
"            VALUES\n" +
"            (SYSTEM.SQ_VEHICULO.NEXTVAL,22,2,1,30,\n" +
"            '000254', 2022, 'PRUEBA','BLANCA','1250 CC', 100000, 'A', 60, 210)";
            
            final String SELECT_VEHICULO = "SELECT VH.MODELO VEHICULO1, TI.NOMBRE TIPO_VEHICULO, TR.NOMBRE TRANSMISION, FA.NOMBRE FABRICANTE, PA.NOMBRE PAIS FROM SYSTEM.VEHICULO VH\n" +
"INNER JOIN TIPO_VEHICULO TI ON TI.ID_TIPO = VH.ID_TIPO\n" +
"INNER JOIN TRANSMISION TR ON TR.ID_TRANSMISION = VH.ID_TRANSMISION\n" +
"INNER JOIN FABRICANTE FA ON FA.ID_FABRICANTE = VH.ID_FABRICANTE\n" +
"INNER JOIN PAIS PA ON PA.ID_PAIS = FA.ID_PAIS\n" +
"ORDER BY VH.MODELO ASC";
            
            final String SELECT_VEHICULO2 = "SELECT PA.ID_PAIS PAIS_FABRICANTE, PA.NOMBRE NOMBRE_PAIS, PA.ABREVIATURA ABRE_PAIS, FA.NOMBRE FABRICANTE, FA.ABREVIATURA ABRE_FABRICANTE,\n" +
"CO.NOMBRE COMBUSTIBLE, TI.NOMBRE TIPO_VEHICULO, TR.NOMBRE TRANSMISION, VH.PLACA, VH.MODELO, VH.ANIO, VH.COLOR, VH.CILINDRADA, VH.RENDIMIENTO, VH.FECHA_GRABACION  \n" +
"FROM SYSTEM.VEHICULO VH\n" +
"INNER JOIN FABRICANTE FA ON FA.ID_FABRICANTE = VH.ID_FABRICANTE\n" +
"INNER JOIN PAIS PA ON PA.ID_PAIS = FA.ID_PAIS\n" +
"INNER JOIN COMBUSTIBLE CO ON CO.ID_COMBUSTIBLE = VH.ID_COMBUSTIBLE\n" +
"INNER JOIN TIPO_VEHICULO TI ON TI.ID_TIPO = VH.ID_TIPO\n" +
"INNER JOIN TRANSMISION TR ON TR.ID_TRANSMISION = VH.ID_TRANSMISION ORDER BY TI.NOMBRE ASC";
            
            final String UPDATE_TR = "UPDATE SYSTEM.TRANSMISION TR SET TR.NOMBRE = LOWER(TR.NOMBRE), TR.USUARIO_MODIFICACION = USER, TR.FECHA_MODIFICACION = SYSDATE WHERE TR.ID_TRANSMISION = 1";
            
            final String SELECT_TR = "SELECT * FROM SYSTEM.TRANSMISION";
            
            final String COUNT_FA = "SELECT COUNT (*) CANTIDAD_FAB FROM SYSTEM.FABRICANTE";
            
            final String DELETE_FA = "DELETE * FROM FABRICANTE WHERE ID_FABRICANTE = 1";
            
            final String SELECT_FABRICANTE3 = "SELECT FA.ID_FABRICANTE, FA.NOMBRE, FA.ABREVIATURA, FA.ESTADO, PA.ID_PAIS, PA.NOMBRE PAIS, PA.ABREVIATURA ABRE_PAIS FROM SYSTEM.FABRICANTE FA\n" +
            "INNER JOIN PAIS PA ON PA.ID_PAIS = FA.ID_PAIS\n" +
            "WHERE PA.NOMBRE <> 'JAPON' AND PA.NOMBRE <> 'INGLATERRA'";
            
            final String COUNT_FABRICANTE = "SELECT COUNT(*) AS Cantidad, PA.ID_PAIS, PA.NOMBRE FROM FABRICANTE FA\n" +
                    "INNER JOIN PAIS PA ON PA.ID_PAIS = FA.ID_PAIS\n" +
                    "GROUP BY PA.ID_PAIS, PA.NOMBRE\n" + 
                    "ORDER BY PA.NOMBRE ASC";
            
            final String COUNT_VEHICULO = "SELECT COUNT(*) AS Cantidad, PA.ID_PAIS, PA.NOMBRE FROM VEHICULO VH\n" +
                    "INNER JOIN FABRICANTE FA ON FA.ID_FABRICANTE = VH.ID_FABRICANTE\n" +
                    "INNER JOIN PAIS PA ON PA.ID_PAIS = FA.ID_PAIS\n" +
                    "GROUP BY PA.ID_PAIS, PA.NOMBRE\n" +
                    "ORDER BY PA.NOMBRE ASC";
            
            final String COUNT_VEHICULO2 = "SELECT COUNT(*) AS Cantidad, FA.ID_FABRICANTE, FA.NOMBRE FROM VEHICULO VH\n" +
                    "INNER JOIN FABRICANTE FA ON FA.ID_FABRICANTE = VH.ID_FABRICANTE\n" +
                    "GROUP BY FA.ID_FABRICANTE, FA.NOMBRE\n" +
                    "ORDER BY FA.NOMBRE ASC";
            
            final String COUNT_VEHICULO3 = "SELECT COUNT(*) AS Cantidad, TR.ID_TRANSMISION, TR.NOMBRE FROM VEHICULO VH\n" +
                    "INNER JOIN TRANSMISION TR ON TR.ID_TRANSMISION = VH.ID_TRANSMISION\n" +
                    "GROUP BY TR.ID_TRANSMISION, TR.NOMBRE\n" +
                    "ORDER BY TR.NOMBRE ASC";
            
            
            
            //final String INSERT_TR = "INSERT";
            //conexionDb.ejectaQuery(SELECT_PAIS_TB, 1);
            //conexionDb.ejectaQuery(SELECT_FABRICANTE, 1);
            //conexionDb.ejectaQuery(SELECT_FABRICANTE2, 1);
            //conexionDb.ejectaQuery(INSERT_PAIS, 8);
            //conexionDb.ejectaQuery(INSERT_FABRICANTE, 3);
            //conexionDb.ejectaQuery(INSERT_TIPO, 2);
            //conexionDb.ejectaQuery(INSERT_VEHICULO, 2);
            //conexionDb.ejectaQuery(SELECT_VEHICULO, 1);
            //conexionDb.ejectaQuery(SELECT_VEHICULO2, 1);
            //conexionDb.ejectaQuery(UPDATE_TR, 2);
            //conexionDb.ejectaQuery(SELECT_TR, 0);
            //conexionDb.ejectaQuery(COUNT_FA, 0);
            //conexionDb.ejectaQuery(SELECT_FABRICANTE3, 0);
            //conexionDb.ejectaQuery(SELECT_TIPO, 0);
            
            //COUNT
            //conexionDb.ejectaQuery(COUNT_FABRICANTE, 1);
            //conexionDb.ejectaQuery(COUNT_VEHICULO, 1);
            //conexionDb.ejectaQuery(COUNT_VEHICULO2, 1);
            //conexionDb.ejectaQuery(COUNT_VEHICULO3, 1);
            
       
       
    }
    
}
