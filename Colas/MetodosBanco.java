import java.util.Queue;
import java.util.Scanner;

public class MetodosBanco {

    public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("por favor digite un numero valido.");
            sc.next();
        }
        int num = sc.nextInt();
        sc.nextLine(); 
        return num;
    }

    public Queue<Cliente> EncolarCliente(Queue<Cliente> cola, Scanner sc, int turnoId) {
        System.out.println("ingrese el nombre del cliente:");
        String nombre = sc.nextLine();

        System.out.println("ingrese el tipo de servicio (ej: retiro, consignacion, asesoria):");
        String servicio = sc.nextLine();

        System.out.println("ingrese la hora de llegada (ej: 14:30):");
        String hora = sc.nextLine();

        Cliente nuevoCliente = new Cliente(turnoId, nombre, servicio, hora);
        cola.offer(nuevoCliente); 
        System.out.println("¡cliente " + nombre + " agregado con el turno #" + turnoId + "!");

        return cola;
    }

    
    public Queue<Cliente> DesencolarCliente(Queue<Cliente> colaPendientes, Queue<Cliente> colaAtendidos) {
        if (colaPendientes.isEmpty()) {
            System.out.println("no hay clientes en espera para atender.");
        } else {
            Cliente clienteAtendido = colaPendientes.poll(); 
            clienteAtendido.setAtendido(true); 
            
            colaAtendidos.offer(clienteAtendido); 

            System.out.println("atendiendo a: " + clienteAtendido.getNombre() + 
                               " (turno #" + clienteAtendido.getId() + ") para " + 
                               clienteAtendido.getTipoServicio());
        }
        return colaPendientes;
    }

    public String VerSiguiente(Queue<Cliente> cola) {
        if (cola.isEmpty()) {
            return "la fila esta vacia.";
        }
        Cliente siguiente = cola.peek(); 
        return "el proximo a ser atendido es: " + siguiente.getNombre() + 
               " (turno #" + siguiente.getId() + ")";
    }

    public String ObtenerColaActual(Queue<Cliente> cola) {
        if (cola.isEmpty()) {
            return "no hay nadie en la fila en este momento.";
        }

        StringBuilder textoFila = new StringBuilder();
        textoFila.append("\n--- fila actual (pendientes) ---\n");

        for (Cliente c : cola) {
            textoFila.append("turno #").append(c.getId())
                     .append(" | nombre: ").append(c.getNombre())
                     .append(" | servicio: ").append(c.getTipoServicio()).append("\n");
        }
        return textoFila.toString();
    }

  
    public String MostrarTodosLosTurnos(Queue<Cliente> colaPendientes, Queue<Cliente> colaAtendidos) {
        StringBuilder texto = new StringBuilder();
        texto.append("\n========== REPORTE DE TURNOS ==========\n");

        texto.append("\n>>> TURNOS ATENDIDOS <<<\n");
        if (colaAtendidos.isEmpty()) {
            texto.append("aun no se ha atendido a ningun cliente.\n");
        } else {
            for (Cliente c : colaAtendidos) {
                texto.append("[ATENDIDO] turno #").append(c.getId())
                     .append(" | nombre: ").append(c.getNombre()).append("\n");
            }
        }

        texto.append("\n>>> TURNOS PENDIENTES <<<\n");
        if (colaPendientes.isEmpty()) {
            texto.append("no hay clientes en espera.\n");
        } else {
            for (Cliente c : colaPendientes) {
                texto.append("[PENDIENTE] turno #").append(c.getId())
                     .append(" | nombre: ").append(c.getNombre()).append("\n");
            }
        }
        texto.append("=======================================\n");

        return texto.toString();
    }
}