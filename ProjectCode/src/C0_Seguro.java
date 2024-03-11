public class C0_Seguro {
    //ATRIBUTOS
    private tipoSeguro tipoSeguro;
    private float precioSeguro;

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
    public C0_Seguro(tipoSeguro tipoSeguro, float precioSeguro) {
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
    public void setPrecioSeguro(float precioSeguro){
        this.precioSeguro = precioSeguro;
    }
    /**
     * 
     * @return float
     */
    public float getPrecioSeguro(){
        return precioSeguro;
    }
}