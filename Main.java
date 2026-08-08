import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Personaje> personajes = new ArrayList<>();
        int opcion = 0;

        do {
            System.out.println("\n========== MENÚ ==========");
            System.out.println("1. Registrar personaje");
            System.out.println("2. Mostrar personajes");
            System.out.println("3. Buscar personaje por id");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Elija el tipo (1 = Guerrero, 2 = Mago): ");
                        int tipo = Integer.parseInt(scanner.nextLine());

                        System.out.print("Ingrese ID: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.print("Ingrese Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Ingrese Nivel (1-100): ");
                        int nivel = Integer.parseInt(scanner.nextLine());

                        // Validaciones solicitadas
                        if (id > 0 && !nombre.trim().isEmpty() && nivel >= 1 && nivel <= 100) {
                            if (tipo == 1) {
                                personajes.add(new Guerrero(id, nombre, nivel));
                                System.out.println("¡Guerrero registrado con éxito!");
                            } else if (tipo == 2) {
                                personajes.add(new Mago(id, nombre, nivel));
                                System.out.println("¡Mago registrado con éxito!");
                            } else {
                                System.out.println("Error: Tipo de personaje no válido.");
                            }
                        } else {
                            System.out.println("Error: Datos inválidos. Verifique que ID > 0, nombre no esté vacío y nivel esté entre 1 y 100.");
                        }
                        break;

                    case 2:
                        if (personajes.isEmpty()) {
                            System.out.println("La lista está vacía. No hay personajes registrados.");
                        } else {
                            System.out.println("\n--- LISTA DE PERSONAJES ---");
                            for (Personaje p : personajes) {
                                p.mostrarInfo();
                                System.out.println("Acción: " + p.realizarAccion());
                                System.out.println("---------------------------");
                            }
                        }
                        break;

                    case 3:
                        if (personajes.isEmpty()) {
                            System.out.println("La lista está vacía. No hay personajes para buscar.");
                        } else {
                            System.out.print("Ingrese el ID a buscar: ");
                            int idBusqueda = Integer.parseInt(scanner.nextLine());
                            Personaje encontrado = null;

                            // Búsqueda secuencial
                            for (Personaje p : personajes) {
                                if (p.getId() == idBusqueda) {
                                    encontrado = p;
                                    break; // Detenerse al encontrar la primera coincidencia
                                }
                            }

                            if (encontrado != null) {
                                System.out.println("\n¡Personaje encontrado!");
                                encontrado.mostrarInfo();
                                System.out.println("Acción: " + encontrado.realizarAccion());
                            } else {
                                System.out.println("Personaje no encontrado.");
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }

            } catch (NumberFormatException e) {
                // Manejo básico de errores para entradas no numéricas
                System.out.println("Error: Debe ingresar un valor numérico válido en las opciones o campos numéricos.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}