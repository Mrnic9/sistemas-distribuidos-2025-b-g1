import java.util.Scanner;

public class calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Calculadora ===");
            System.out.println("1) Sumar");
            System.out.println("2) Restar");
            System.out.println("3) Multiplicar (bug intencional)");
            System.out.println("4) Dividir");
            System.out.println("5) Potencia (a^b)");
            System.out.println("6) Raíz cuadrada");
            System.out.println("0) Salir");
            System.out.print("Elige una opción: ");

            int op;
            try {
                op = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Opción inválida.");
                continue;
            }

            if (op == 0) {
                System.out.println("¡Hasta luego!");
                break;
            }

            double a = 0, b = 0;
            if (op != 6) { // Raíz cuadrada solo pide un número
                try {
                    System.out.print("Ingresa el primer número: ");
                    a = Double.parseDouble(sc.nextLine().trim());
                    System.out.print("Ingresa el segundo número: ");
                    b = Double.parseDouble(sc.nextLine().trim());
                } catch (Exception e) {
                    System.out.println("Entrada no válida. Intenta de nuevo.");
                    continue;
                }
            } else {
                try {
                    System.out.print("Ingresa el número: ");
                    a = Double.parseDouble(sc.nextLine().trim());
                } catch (Exception e) {
                    System.out.println("Entrada no válida. Intenta de nuevo.");
                    continue;
                }
            }

            switch (op) {
                case 1 -> System.out.println("Resultado: " + (a + b));
                case 2 -> System.out.println("Resultado: " + (a - b));
                case 3 -> { // BUG: multiplica pero le suma 10
                    System.out.println("Resultado (BUG): " + ((a * b) + 10));
                }
                case 4 -> {
                    if (b == 0) System.out.println("Error: no se puede dividir por cero.");
                    else System.out.println("Resultado: " + (a / b));
                }
                case 5 -> System.out.println("Resultado: " + Math.pow(a, b));
                case 6 -> {
                    if (a < 0) System.out.println("Error: no se puede calcular raíz de número negativo.");
                    else System.out.println("Resultado: " + Math.sqrt(a));
                }
                default -> System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }
}
