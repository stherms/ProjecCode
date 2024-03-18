package ProjectCode.modelo;

public class C0_Seguro {
    //ATRIBUTOS
    private tipoSeguro tipoSeguro;
    private double precioSeguro;

    //ENUM Tipo de seguro
    public enum tipoSeguro{
        BASICO, COMPLETO
    }

    //CONSTRUCTOR
    /**
     * 
     * @param tipoSeguro
     * @param precioSeguro
     */
    public C0_Seguro(tipoSeguro tipoSeguro, double precioSeguro) {
        this.tipoSeguro = tipoSeguro;
        this.precioSeguro = precioSeguro;
    }
    
    //METODO_TipoSeguro
    /**
     * 
     * @param tipoSeguro 
     */
    public void setTipoSeguro(tipoSeguro tipoSeguro){
        this.tipoSeguro = tipoSeguro;
    }

    /**
     * 
     * @return tipoSeguro
     */
    public tipoSeguro getTipoSeguro(){
        return tipoSeguro;
    }

    //METODO_PrecioSeguro
    /**
     * 
     * @param precioSeguro
     */
    public void setPrecioSeguro(double precioSeguro){
        this.precioSeguro = precioSeguro;
    }
    /**
     * 
     * @return double
     */
    public double getPrecioSeguro(){
        return precioSeguro;
    }
}