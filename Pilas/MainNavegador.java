import java.util.Scanner;
import java.util.Stack;

public class MainNavegador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<PaginaWeb> historial = new Stack<>();
        MetodosNavegador metodos = new MetodosNavegador();

        boolean continuar = true;
        int opcion = 0;

        while (continuar) {
            System.out.println("\n===== NAVEGADOR WEB =====");
            System.out.println("1) visitar una nueva pagina");
            System.out.println("2) retroceder (Atras)");
            System.out.println("3) ver historial actual");
            System.out.println("4) salir");
            System.out.print("elija una opcion: ");

            opcion = metodos.ValidarEntero(sc);

            switch (opcion) {
                case 1:
                    historial = metodos.VisitarPagina(historial, sc);
                    break;
                case 2:
                    historial = metodos.Retroceder(historial);
                    break;
                case 3:
                    String texto = metodos.ObtenerHistorial(historial);
                    System.out.println(texto);
                    break;
                case 4:
                    System.out.println("cerrando navegador...");
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