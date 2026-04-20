import java.util.Scanner;
import java.util.Stack;

public class MetodosNavegador {

    public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("por favor digite un numero valido.");
            sc.next(); 
        }
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }

    public Stack<PaginaWeb> VisitarPagina(Stack<PaginaWeb> pila, Scanner sc) {
        System.out.println("ingrese la URL de la pagina:");
        String url = sc.nextLine();
        
        System.out.println("ingrese el titulo de la pagina:");
        String titulo = sc.nextLine();
        
        System.out.println("ingrese la fecha de acceso:");
        String fecha = sc.nextLine(); 

        PaginaWeb nuevaPagina = new PaginaWeb(url, titulo, fecha);
        pila.push(nuevaPagina); 
        System.out.println("¡pagina visitada con exito!");
        
        return pila; 
    }

    public Stack<PaginaWeb> Retroceder(Stack<PaginaWeb> pila) {
        if (pila.isEmpty()) {
            System.out.println("no hay paginas en el historial para retroceder.");
        } else {
            PaginaWeb paginaEliminada = pila.pop(); 
            System.out.println("retrocediendo... saliste de: " + paginaEliminada.getTitulo());

            if (!pila.isEmpty()) {
                System.out.println("ahora estas en: " + pila.peek().getTitulo() + " (" + pila.peek().getUrl() + ")");
            } else {
                System.out.println("has llegado a la pagina de inicio (historial vacio).");
            }
        }
        return pila; 
    }

    public String ObtenerHistorial(Stack<PaginaWeb> pila) {
        if (pila.isEmpty()) {
            return "el historial esta vacio.";
        }

        StringBuilder textoHistorial = new StringBuilder();
        textoHistorial.append("\n--- historial Actual ---\n");

        for (int i = pila.size() - 1; i >= 0; i--) {
            PaginaWeb p = pila.get(i);
            textoHistorial.append("Titulo: ").append(p.getTitulo())
                          .append(" | URL: ").append(p.getUrl())
                          .append(" | Fecha: ").append(p.getFechaAcceso()).append("\n");
        }
        return textoHistorial.toString(); 
    }
}