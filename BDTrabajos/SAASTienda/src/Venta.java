public class Venta {
    private String nombreProducto;
    private double precio;
    private int cantidad;
    private String tipoPago;

    public Venta(String nombreProducto, double precio, int cantidad, String tipoPago) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipoPago = tipoPago;
    }

    public double calcularSubtotal() {
        return precio * cantidad;
    }

    public double calcularDescuentoPorMonto() {
        double subtotal = calcularSubtotal();
        return (subtotal >= 1000) ? subtotal * 0.10 : 0;
    }

    public double calcularDescuentoPorMetodoPago(double subtotalConPrimerDescuento) {
        switch (tipoPago.toLowerCase()) {
            case "efectivo":
                return subtotalConPrimerDescuento * 0.05;
            case "transferencia":
                return subtotalConPrimerDescuento * 0.02;
            default:
                return 0;
        }
    }

    public double obtenerTotalFinal() {
        double subtotal = calcularSubtotal();
        double desc1 = calcularDescuentoPorMonto();
        double subtotalIntermedio = subtotal - desc1;
        double desc2 = calcularDescuentoPorMetodoPago(subtotalIntermedio);
        
        return subtotalIntermedio - desc2;
    }

    public double obtenerDescuentoTotal() {
        return calcularSubtotal() - obtenerTotalFinal();
    }
}