package laboratoriodos;
import java.util.Scanner;
import java.util.Random;

public class Cano_Daniel_Prueba1 {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        int opcion;
        int contadorVotaciones = 0;
        int contadorPerfecto = 0;
        int contadorPrimos = 0;
        int contadorPalabras = 0;

        do {
            System.out.println("-----------------------------");
            System.out.println("            Menu:");
            System.out.println(" ");
            System.out.println("1| Invertir Palabra");
            System.out.println("2| Numeros perfectos");
            System.out.println("3| Numeros primos");
            System.out.println("4| Votaciones");
            System.out.println("5| Salir");
            System.out.println("-----------------------------");
            opcion = lea.nextInt();
            
            if (opcion == 1) {
                contadorPalabras++;
                System.out.print("Ingrese una palabra: ");
                String palabra = lea.next();
                
                String palabraAlreves = "";
                
                for(int indice = palabra.length() - 1; indice >= 0; indice--){
                    palabraAlreves += palabra.charAt(indice);
                }
                
                System.out.println("La palabra al revés es: " + palabraAlreves);

            } else if (opcion == 2) {
                contadorPerfecto++;
                System.out.print("Ingrese un número: ");
                int numero = lea.nextInt();
                int suma = 0;

                for (int divisor = 1; divisor <= numero / 2; divisor++) {
                    if (numero % divisor == 0) {
                        suma += divisor;
                    }
                }

                if (suma == numero) {
                    System.out.println("El número " + numero + " es perfecto.");
                } else {
                    System.out.println("El número " + numero + " no es perfecto.");
                }

            } else if (opcion == 3) {
                contadorPrimos++;
                Random random = new Random();
                int numero = random.nextInt(100) + 1;
                int divisores = 0;

                System.out.println("Número generado: " + numero);
                System.out.print("Divisores: ");

                for (int divisor = 1; divisor <= numero; divisor++) {
                    if (numero % divisor == 0) {
                        divisores++;
                        System.out.print(divisor + " ");
                    }
                }

                if (divisores == 2) {
                    System.out.print("\nEl número " + numero + " es primo.");
                } else {
                    System.out.print("\nEl número " + numero + " no es primo.");
                }

            } else if (opcion == 4) {
                contadorVotaciones++;
                System.out.print("Ingrese el número de votantes: ");
                int numeroVotantes = lea.nextInt();
                lea.nextLine();
                int votosAzul = 0, votosRojo = 0, votosNegro = 0, votosAmarillo = 0, votosNulos = 0;

                for (int votanteActual = 0; votanteActual < numeroVotantes; votanteActual++) {
                    boolean votoValido = false;
                    while (!votoValido) {
                        System.out.print("Votante " + (votanteActual + 1) + ", ingrese su voto (Azul, Rojo, Negro, Amarillo): ");
                        String voto = lea.nextLine();
                        if (voto.equalsIgnoreCase("Azul")) {
                            votosAzul++;
                            votoValido = true;
                        } else if (voto.equalsIgnoreCase("Rojo")) {
                            votosRojo++;
                            votoValido = true;
                        } else if (voto.equalsIgnoreCase("Negro")) {
                            votosNegro++;
                            votoValido = true;
                        } else if (voto.equalsIgnoreCase("Amarillo")) {
                            votosAmarillo++;
                            votoValido = true;
                        } else {
                            votosNulos++;
                            System.out.println("Error: Voto no válido. Por favor, ingrese un voto válido.");
                        }
                    }
                }

                int votosValidos = votosAzul + votosRojo + votosNegro + votosAmarillo;
                double porcentajeValido = (double) votosValidos / (numeroVotantes + votosNulos) * 100;

                if (porcentajeValido >= 60) {
                    if (votosAzul > votosRojo && votosAzul > votosNegro && votosAzul > votosAmarillo) {
                        System.out.println("La planilla ganadora es: AZUL");
                    } else if (votosRojo > votosAzul && votosRojo > votosNegro && votosRojo > votosAmarillo) {
                        System.out.println("La planilla ganadora es: ROJO");
                    } else if (votosNegro > votosAzul && votosNegro > votosRojo && votosNegro > votosAmarillo) {
                        System.out.println("La planilla ganadora es: NEGRO");
                    } else {
                        System.out.println("La planilla ganadora es: AMARILLO");
                    }
                } else {
                    System.out.println("VOTACIÓN FALLIDA");
                }
                System.out.println("Total de votos válidos: " + votosValidos);
                System.out.println("Total de votos nulos: " + votosNulos);

            }

        } while (opcion != 5);

        System.out.println("-----------------------------------------------");
        System.out.println("                    Info");
        System.out.println("Palabras Invertidas: " + contadorPalabras);
        System.out.println("Perfectos: " + contadorPerfecto);
        System.out.println("Primos: " + contadorPrimos);
        System.out.println("Votaciones: " + contadorVotaciones);
        System.out.println("-----------------------------------------------");
    }
}
