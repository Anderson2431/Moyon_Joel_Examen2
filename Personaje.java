public class Personaje {
    private int id;
    private String nombre;
    private int nivel;

    // Constructor que inicializa los tres atributos
    public Personaje(int id, String nombre, int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    // Getters necesarios para mostrar y buscar información
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    // Método para mostrar id, nombre y nivel
    public void mostrarInfo() {
        System.out.println("ID: " + id + " | Nombre: " + nombre + " | Nivel: " + nivel);
    }

    // Método con mensaje general en la clase padre
    public String realizarAccion() {
        return "El personaje realiza una acción genérica.";
    }
}