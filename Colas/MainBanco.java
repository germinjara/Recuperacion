import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainBanco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
       
        Queue<Cliente> filaPendientes = new LinkedList<>();
        Queue<Cliente> clientesAtendidos = new LinkedList<>(); // Nueva cola para el historial
        MetodosBanco metodos = new MetodosBanco();
        
        boolean continuar = true;
        int opcion = 0;
        int turnoActual = 1; 

        while (continuar) {
            System.out.println("\n===== SISTEMA DE TURNOS BANCO =====");
            System.out.println("1) llegada de un cliente");
            System.out.println("2) atender cliente");
            System.out.println("3) ver siguiente cliente");
            System.out.println("4) ver fila actual (solo pendientes)");
            System.out.println("5) mostrar todos los turnos (atendidos y pendientes)");
            System.out.println("6) salir");
            System.out.print("elija una opcion: ");

            opcion = metodos.ValidarEntero(sc);

            switch (opcion) {
                case 1:
                    filaPendientes = metodos.EncolarCliente(filaPendientes, sc, turnoActual);
                    turnoActual++; 
                    break;
                case 2:
                    
                    filaPendientes = metodos.DesencolarCliente(filaPendientes, clientesAtendidos);
                    break;
                case 3:
                    String proximo = metodos.VerSiguiente(filaPendientes);
                    System.out.println(proximo);
                    break;
                case 4:
                    String listadoPendientes = metodos.ObtenerColaActual(filaPendientes);
                    System.out.println(listadoPendientes);
                    break;
                case 5:
                    
                    String reporteCompleto = metodos.MostrarTodosLosTurnos(filaPendientes, clientesAtendidos);
                    System.out.println(reporteCompleto);
                    break;
                case 6:
                    System.out.println("cerrando sistema del banco...");
                    continuar = false;
                    break;
                default:
                    System.out.println("opcion invalida, intente de nuevo.");
                    break;
            }
        }
        sc.close();
    }
}