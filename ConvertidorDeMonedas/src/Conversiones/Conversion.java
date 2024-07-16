package Conversiones;

public class Conversion {
    private String monedaPrincipal;
    private String monedaCambio;
    private float valorUnitario;
    private float resultado;

    public String getMonedaPrincipal() {
        return monedaPrincipal;
    }

    public String getMonedaCambio() {
        return monedaCambio;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public float getResultado() {
        return resultado;
    }

    public Conversion(ApiConversion conversionApi) {
        this.monedaPrincipal = conversionApi.base_code();
        this.monedaCambio = conversionApi.target_code();
        this.valorUnitario = conversionApi.conversion_rate();
        this.resultado = conversionApi.conversion_result();
    }

    @Override
    public String toString() {
        return "===== Convertidor de Monedas ======" + '\n' +
                "Moneda Principal" + monedaPrincipal + '\n' +
                "Moneda a Cambiar=" + monedaCambio + '\n' +
                "Valor de la Moneda=" + valorUnitario  + '\n'+
                "Cambio=" + resultado + '\n'+
                "==================================";
    }
}
