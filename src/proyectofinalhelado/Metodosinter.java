/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectofinalhelado;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author domif
 */
public interface Metodosinter {
    
    
    //--------------------metodos implementados en newframe------------------------------
    
    //este metodo es para limpiar los campos de seleccion
   private void limpiarCampos() {
   
}
   //---------------------------------------------------------------------------------
   
   //este metodo es para que al darle a un articulo agregado te pregunte si deseas eliminarlo
    private void agregarEventoEliminarArticulo(){
        
    }
   //------------------------------------------------------------------------------------
    
    
    //este es para que traiga los precios directamente de la bdd
   
  private int obtenerPrecioDesdeDB(Connection con, String nombreProducto) throws SQLException{
      
       return 0;
      
  }
  
  //---------------------------------------------------------------------------------------

}
