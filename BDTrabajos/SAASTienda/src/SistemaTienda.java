import java.util.Scanner;

public class SistemaTienda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalAcumuladoDia = 0;
        int opcion;

        do {
            System.out.println("\n SISTEMA DE CONTROL DE VENTAS ");
            System.out.println("1. Registrar venta");
            System.out.println("2. Ver total acumulado del dia");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Tipo de pago (Efectivo / Tarjeta / Transferencia): ");
                    String pago = sc.nextLine();

                    Venta nuevaVenta = new Venta(nombre, precio, cantidad, pago);

                    double subtotal = nuevaVenta.calcularSubtotal();
                    double desc = nuevaVenta.obtenerDescuentoTotal();
                    double total = nuevaVenta.obtenerTotalFinal();

                    System.out.println("\n TICKET DE VENTA ");
                    System.out.printf("Subtotal: $%.2f\n", subtotal);
                    System.out.printf("Descuento aplicado: $%.2f\n", desc);
                    System.out.printf("Total a pagar: $%.2f\n", total);

                    totalAcumuladoDia += total;
                    break;

                case 2:
                    System.out.printf("\nTotal acumulado en caja: $%.2f\n", totalAcumuladoDia);
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 3);

        sc.close();
    }
}