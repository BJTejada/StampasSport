/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.Statement;

public class Conexion {
 
    static Connection cn=null;
 
    
    static Statement st;
    static ResultSet rs;
    int cantidadColumnas;
    int cantidadFilas;
    
    //conexion para procedimientos almacenados
    public Connection conectar()
    {
        try
        {
        cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","VentasSport","123teamo");
           st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           
        }
        catch(SQLException e)
        {
           JOptionPane.showMessageDialog(null,"no ha sido conectada " + e);
        }
        return cn;
    }
    
    /* ESTOS METODOS LOS UTILIZO YO(byron) PARA LOS FORMS QUE E HECHO ANTES DE QUE SE CREARA OTRA CLASE CONEXION LAS AGREGUE 
        POR QUE ME DABA ALGUNOS ERRORES PERO POR CUESTIONES DE TIEMPO NO LOS CORREGI Y ESTO FUE LO PRIMERO QUE SE ME 
        OCURRIO MAS RAPIDO HACER*/
    public static Connection conectar(Connection cn)throws SQLException  {
        try
        {
        cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","VentasSport","123teamo");
           st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           
        }
        catch(SQLException e)
        {
           JOptionPane.showMessageDialog(null,"no ha sido conectada " + e);
        }
        return cn;
    }
        /*Establecer la conexion a la base de datos*/
     public static Statement sta(Statement st)throws SQLException    {
        cn=conectar(cn);
        st=cn.createStatement();
        return st;
    }
     /*Hacer una consulta a la tabla*/
    public static ResultSet Consulta(ResultSet rs,String Sql)throws SQLException    {
       st=sta(st);
       rs=st.executeQuery(Sql);
        return rs;
    }
}
