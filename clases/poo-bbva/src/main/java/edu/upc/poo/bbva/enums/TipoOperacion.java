package edu.upc.poo.bbva.enums;

/**
 *
 * @author gian.corzo
 */
public enum TipoOperacion {
    RETIRO (1, "retiro"),
    DEPOSITO (2, "deposito"),
    APERTURA_CUENTA (3, "apertura"),
    CANCELACION_CUENTA (4, "cancelacion"),
    PRESTAMO (5, "prestamo");
    
    Integer id;
    String label;   
    
    TipoOperacion(Integer id, String label) {
        this.id = id;
        this.label = label;        
    }
    
    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }    
    
    public static TipoOperacion getTipoOperacionPorLabel(String label){
        if (!label.isEmpty()){
            for(TipoOperacion item:TipoOperacion.values()){
                if (item.getLabel().equals(label)){
                    return item;
                }
            }
        }
        return null;
    }    
}
