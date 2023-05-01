/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajo_01;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author sebas
 */
public class Trabajo_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu();

    }

    public static void Menu() {
        Scanner input = new Scanner(System.in);
        int opcion;
        do {

            System.out.print("\n\nPresione la tecla INTRO: ");
            try {
                System.in.read();

            } catch (IOException e) {
                System.out.println("Ocurrio un error de :" + e);
            }

            System.out.println("\nIngrese la opcion que deses ejecutar:"
                    + "\n0.- Salir."
                    + "\n1.- Cantidad de numeros primos."
                    + "\n2.- Determinar elementos de un arreglo A en B."
                    + "\n3.- Busqueda secuencial y binaria."
                    + "\n4.- Reemplazo de datos en un arreglo."
                    + "\n5.- Generación secuencial de una matriz (nxn,diagonal)."
                    + "\n6.- Generación secuencial de un matriz (nxm,caracol)."
                    + "\n7.- Multiplicación de matrices (nxn)."
                    + "\n8.- Determinante de una matriz (nxn)."
                    + "\n9.- Ordenamiento de columnas por seleccion una matriz. (nxm)."
                    + "\n10.- Matriz para notas.");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    Ejercicio_01();
                    break;
                case 2:
                    Ejercicio_02();
                    break;
                case 3:
                    Ejercicio_03();
                    break;
                case 4:
                    Ejercicio_04();
                    break;
                case 5:
                    Ejercicio_05();
                    break;
                case 6:
                    Ejercicio_06();
                    break;
                case 7:
                    Ejercicio_07();
                    break;
                case 8:
                    Ejercicio_08();
                    break;
                case 9:
                    Ejercicio_09();
                    break;
                case 10:
                    Ejercicio_10();
                    break;
                default:
                    break;

            }

        } while (opcion != 0);

    }

    public static void Ejercicio_01() {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de numeros a generar.");
        int cantidad_numeros = input.nextInt();
        int[] arreglo_nuemros = Generar_arreglo_numeros_random(cantidad_numeros);
        Imprimir_arreglo_int(arreglo_nuemros);
        long inicio = System.nanoTime();
        int cantidad_numeros_encontrados = Buscar_cantidad_numeros_primos(arreglo_nuemros);
        long fin = System.nanoTime();
        long tiempo_total = fin - inicio;
        System.out.println("\nHay " + cantidad_numeros_encontrados + " numeros primos.");
        System.out.printf("El tiempo de ejecución en buscar numeros primos es de %.9f microsegundos.%n", (tiempo_total / 1e9) * 1000000.0);

    }

    public static int[] Generar_arreglo_numeros_random(int cantidad_numeros) {
        Random numero_random = new Random();
        int[] arreglo_numeros = new int[cantidad_numeros];
        for (int i = 0; i < cantidad_numeros; i++) {
            arreglo_numeros[i] = numero_random.nextInt(100) + 1;
        }

        return arreglo_numeros;

    }

    public static int Buscar_cantidad_numeros_primos(int[] arreglo) {
        int cantidad_primos = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (Verificar_numero_primo(arreglo[i], (int) arreglo[i] / 2)) {
                cantidad_primos++;
            }
        }
        return cantidad_primos;
    }

    public static boolean Verificar_numero_primo(int numero, int max_divisible) {
        if (numero == 1 || numero == 2) {
            return true;
        } else {
            for (int j = 2; j <= max_divisible; j++) {
                if (numero % j == 0) {
                    return false;
                }
            }
            return true;
        }

    }

    public static void Ejercicio_02() {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de numeros a generar.");
        int tamanio_arreglo = input.nextInt();
        int[] arreglo_a = Generar_arreglo_numeros_random(tamanio_arreglo);
        int[] arreglo_b = Generar_arreglo_numeros_random(tamanio_arreglo);
        System.out.println("Arreglo A: ");
        Imprimir_arreglo_int(arreglo_a);
        System.out.println("");
        System.out.println("Arreglo B:");
        Imprimir_arreglo_int(arreglo_b);
        System.out.println("");
        long startTime = System.nanoTime();
        System.out.println(Elementos_a_en_b(arreglo_a, arreglo_b));
        System.out.println(Elementos_b_en_a(arreglo_b, arreglo_a));
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("\nTiempo en nanosegundos: " + timeElapsed);
    }

    public static String Elementos_a_en_b(int[] arreglo_a, int[] arreglo_b) {
        String cadena = "";
        for (int i = 0; i < arreglo_a.length; i++) {
            for (int j = 0; j < arreglo_b.length; j++) {
                if (arreglo_a[i] == arreglo_b[j]) {
                    cadena += "[" + arreglo_a[i] + "]";
                }
            }
        }

        return "Los elementos de A en B son: " + cadena;

    }

    public static String Elementos_b_en_a(int[] arreglo_a, int[] arreglo_b) {
        String cadena = "";
        for (int i = 0; i < arreglo_b.length; i++) {
            for (int j = 0; j < arreglo_a.length; j++) {
                if (arreglo_b[i] == arreglo_a[j]) {
                    cadena += "[" + arreglo_b[i] + "]";
                }
            }
        }

        return "Los elementos de B en A son: " + cadena;

    }

    public static void Ejercicio_03() {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de numeros a generar.");
        int cantidad_numeros = input.nextInt();

        int[] arreglo = Generar_arreglo_numeros_random(cantidad_numeros);
        Ordenamiento_burbuja(arreglo);

        Imprimir_arreglo_int(arreglo);

        System.out.print("\nIngrese el numero a buscar: ");
        int numero_buscando = input.nextInt();

        long inicio = System.nanoTime();
        int posicion = Busqueda_secuencial(arreglo, numero_buscando);
        long fin = System.nanoTime();
        long tiempo_total = fin - inicio;
        System.out.println("\nEncontrado en la posicion (busqueda secuencial): " + (posicion >= 0 ? "" + posicion : "El numero no se encontró."));
        System.out.printf("\nEl tiempo de ejecución por busqueda secuencial es de %.9f microsegundos.%n", (tiempo_total / 1e9) * 1000000.0);

        inicio = System.nanoTime();
        posicion = Busqueda_binaria(arreglo, numero_buscando, 0, arreglo.length - 1);
        fin = System.nanoTime();
        tiempo_total = fin - inicio;
        System.out.println("\nEncontrado en la posicion (busqueda binaria): " + (posicion >= 0 ? "" + posicion : "El numero no se encontró."));
        System.out.printf("\nEl tiempo de ejecución por busqueda binaria es de %.9f microsegundos.%n", (tiempo_total / 1e9) * 1000000.0);

    }

    public static void Imprimir_arreglo_int(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(" " + arreglo[i]);
        }

    }

    public static int Busqueda_secuencial(int[] arreglo, int numero) {

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == numero) {
                return i;
            }
        }
        return -1;
    }

    public static int Busqueda_binaria(int[] arreglo, int numero, int indice_izquierda, int indice_derecha) {

        if (indice_izquierda > indice_derecha) {
            return -1;
        }
        int indice_medio = (int) ((indice_izquierda + indice_derecha) / 2);
        if (arreglo[indice_medio] == numero) {
            return indice_medio;
        }

        if (numero < arreglo[indice_medio]) {
            indice_derecha = indice_medio - 1;
        } else {
            indice_izquierda = indice_medio + 1;
        }

        return Busqueda_binaria(arreglo, numero, indice_izquierda, indice_derecha);
    }

    public static int[] Ordenamiento_burbuja(int[] arreglo) {
        int tamanio_arreglo = arreglo.length;
        for (int i = 0; i < tamanio_arreglo; i++) {
            for (int j = 1; j < tamanio_arreglo - i; j++) {
                if (arreglo[j - 1] > arreglo[j]) {
                    arreglo[j - 1] = arreglo[j - 1] + arreglo[j];
                    arreglo[j] = Math.abs(arreglo[j - 1] - arreglo[j]);
                    arreglo[j - 1] = Math.abs(arreglo[j] - arreglo[j - 1]);
                }
            }

        }

        return arreglo;
    }

    public static void Ejercicio_04() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nIngrese la cantidad de numeros a generar.");
        int cantidad_numeros = input.nextInt();

        System.out.println("\nIngrese cuantos valores va reemplazar");
        int cantidad_valores_reemplzar = input.nextInt();

        int[] arreglo_numeros = Generar_arreglo_numeros_random(cantidad_numeros);
        int[] arreglo_original = arreglo_numeros.clone();

        long inicio = System.nanoTime();
        Remplazar_n_valores(cantidad_valores_reemplzar, arreglo_numeros);
        long fin = System.nanoTime();
        long tiempo_total = fin - inicio;

        System.out.println("\nArreglo original:");
        Imprimir_arreglo_int(arreglo_original);
        System.out.println("\nArreglo modificado: ");
        Imprimir_arreglo_int(arreglo_numeros);
        System.out.printf("\nEl tiempo de ejecución en reemplazar los valores es de %.9f microsegundos.%n", (tiempo_total / 1e9) * 1000000.0);

    }

    public static int[] Remplazar_n_valores(int numero_elementos, int[] arreglo) {
        Scanner input = new Scanner(System.in);
        //Random numero_random = new Random();
        int posicion = 0, valor = 0;

        for (int i = 0; i < numero_elementos; i++) {
            System.out.println("\n" + (i + 1) + "° elemento");
            System.out.print("\nIngrese la posicion a reemplazar [0.." + (arreglo.length - 1) + "]: ");

            posicion = input.nextInt();

            System.out.print("\nIngrese valor: ");

            valor = input.nextInt();

            arreglo[posicion] = valor;

        }
        return arreglo;
    }

    public static void Ejercicio_05() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamanio de la matriz: ");
        String tamanio_string = sc.nextLine();
        int tamanio_matriz = Integer.parseInt(tamanio_string);
        int[][] matriz = Generar_matriz(tamanio_matriz, tamanio_matriz);
        long startTime = System.nanoTime();
        Llenar_Matriz__Diagonal_Secundaria(matriz);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Matriz Generada");
        Imprimir_matriz(matriz);
        System.out.println("\nTiempo en nanosegundos: " + timeElapsed);
    }

    public static int[][] Generar_matriz(int n, int m) {
        int[][] matriz = new int[n][m];
        return matriz;
    }

    public static int[][] Llenar_Matriz__Diagonal_Secundaria(int[][] matriz) {
        int valor = 0;
        int filas = matriz.length - 1;
        for (int columnas = 0; columnas < matriz.length; columnas++) {
            matriz[filas--][columnas] = ++valor;
        }
        int columnas = matriz.length - 1;

        filas = 0;
        columnas = 1;
        while (columnas != matriz.length) {
            filas = matriz.length - 1;

            for (int i = columnas; i < matriz.length; i++) {
                matriz[filas--][i] = ++valor;

            }
            columnas++;

        }

        filas = matriz.length - 1;
        columnas = 1;
        int auxiliar;
        while (columnas != 0 && columnas != matriz.length) {
            columnas = 0;
            filas--;
            auxiliar = filas;
            for (int i = filas; i >= 0; i--) {
                matriz[filas--][columnas++] = ++valor;

            }
            filas = auxiliar;
        }

        return matriz;
    }

    public static void Ejercicio_06() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el numero de filas: ");
        String filas_string = sc.nextLine();
        int numero_filas = Integer.parseInt(filas_string);
        System.out.print("Ingrese el numero de columnas: ");
        String columnas_string = sc.nextLine();
        int numero_columnas = Integer.parseInt(columnas_string);
        int[][] matriz_caracol = Generar_matriz(numero_filas, numero_columnas);
        long startTime = System.nanoTime();
        Generar_matriz_caracol(matriz_caracol);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Matriz Ordenada");
        Imprimir_matriz(matriz_caracol);
        System.out.println("\nTiempo en nanosegundos: " + timeElapsed);
    }

    public static int[][] Generar_matriz_caracol(int[][] matriz) {
        int fila = matriz.length - 1;
        int columna = matriz[fila].length - 1;

        int direccion = 1;
        for (int num = 1; num <= matriz.length * matriz[0].length;
                num++) {
            matriz[fila][columna] = num;

            if (direccion == 1) {
                if (columna == 0 || matriz[fila][columna - 1] != 0) {
                    direccion = 2;
                } else {
                    columna--;
                }
            }
            if (direccion == 2) {
                if (fila == 0 || matriz[fila - 1][columna] != 0) {
                    direccion = 3;
                } else {
                    fila--;
                }
            }
            if (direccion == 3) {
                if ((columna == matriz[fila].length - 1) || (matriz[fila][columna + 1] != 0)) {
                    direccion = 4;
                } else {
                    columna++;
                }
            }
            if (direccion == 4) {
                if ((fila == matriz.length - 1) || (matriz[fila + 1][columna] != 0)) {
                    direccion = 1;
                    columna--;

                } else {
                    fila++;
                }
            }
        }
        return matriz;

    }

    public static void Ejercicio_07() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamanio de la matriz: ");
        String tamanio_string = sc.nextLine();
        int tamanio_matriz = Integer.parseInt(tamanio_string);
        int[][] matriz_a = Generar_matriz_numeros_random(tamanio_matriz);
        int[][] matriz_b = Generar_matriz_numeros_random(tamanio_matriz);

        long startTime = System.nanoTime();
        int[][] matriz_multiplicada = Multiplicar_matrices(matriz_a, matriz_b);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("\nTiempo en nanosegundos: " + timeElapsed);
        System.out.println("Matriz A: ");
        Imprimir_matriz(matriz_a);
        System.out.println("Matriz B: ");
        Imprimir_matriz(matriz_b);
        System.out.println("Matriz Multiplicada: ");
        Imprimir_matriz(matriz_multiplicada);
    }

    public static int[][] Multiplicar_matrices(int[][] matriz_a, int[][] matriz_b) {
        int tamanio_fila_matriz_a = matriz_a.length;
        int tamanio_columna_matriz_a = matriz_a[0].length;
        int tamanio_fila_matriz_b = matriz_b.length;
        int tamanio_columna_matriz_b = matriz_b[0].length;

        if (tamanio_columna_matriz_a != tamanio_fila_matriz_b) {
            System.out.println("No se puede realizar la multiplicación");
        }

        int[][] respuesta = new int[tamanio_fila_matriz_a][tamanio_columna_matriz_b];
        for (int i = 0; i < tamanio_fila_matriz_a; i++) {
            for (int j = 0; j < tamanio_columna_matriz_b; j++) {
                int suma = 0;
                for (int k = 0; k < tamanio_columna_matriz_a; k++) {
                    suma += matriz_a[i][k] * matriz_b[k][j];
                }
                respuesta[i][j] = suma;
            }
        }
        return respuesta;
    }

    public static void Ejercicio_08() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese tamanio de la matriz ");
        int tamanio_matriz = input.nextInt();
        
        int[][] matriz_numeros = Generar_matriz_numeros_random(tamanio_matriz);
        Imprimir_matriz(matriz_numeros);

        long inicio = System.nanoTime();
        
        Eliminacion_gausiana_matriz(matriz_numeros);
        double determinante = Determinate_matriz(matriz_numeros);
        long fin = System.nanoTime();
        long tiempo_total = fin - inicio;

        System.out.println("--");
        Imprimir_matriz(matriz_numeros);
        System.out.println("El determinante es: " + determinante);
        System.out.printf("\nEl tiempo de ejecución en encontrar el determinante de un matriz nxn es de %.9f microsegundos.%n", (tiempo_total / 1e9) * 1000000.0);

    }

    public static int[][] Generar_matriz_numeros_random(int tamanio) {
        Random numero_random = new Random();
        int[][] matriz_numeros = new int[tamanio][tamanio];
        for (int i = 0; i < matriz_numeros.length; i++) {
            for (int j = 0; j < matriz_numeros[0].length; j++) {
                matriz_numeros[i][j] = numero_random.nextInt(50);
            }
        }
        return matriz_numeros;
    }

    public static void Imprimir_matriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public static int[][] Eliminacion_gausiana_matriz(int[][] matriz) {
        int longitud = matriz.length;
        double factor;

        for (int k = 0; k < longitud - 1; k++) {
            for (int i = k + 1; i < longitud; i++) {
                factor = (int) (matriz[i][k] / matriz[k][k]);
                for (int j = k + 1; j < longitud; j++) {
                    matriz[i][j] = matriz[i][j] - (int) factor * matriz[k][j];
                }
                matriz[i][k] = 0;
            }
        }
        return matriz;
    }

    public static double Determinate_matriz(int[][] matriz_triangular_superior) {
        double resultado = 1;
        for (int i = 0; i < matriz_triangular_superior.length; i++) {
            resultado *= matriz_triangular_superior[i][i];
        }
        return resultado;
    }

    public static void Ejercicio_09() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese las filas: ");
        int filas = input.nextInt();
        System.out.println("Ingrese las columnas: ");
        int columnas = input.nextInt();

        int[][] matriz = Generar_matriz(filas, columnas);
        Llenar_matriz_random(matriz);

        System.out.println("Matriz Inicial:");
        Imprimir_matriz(matriz);

        long startTime = System.nanoTime();
        Ordenar_columnas(matriz);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("\nMatriz ordenada:");
        Imprimir_matriz(matriz);

        System.out.println("\nTiempo en nanosegundos: " + timeElapsed);
    }

    public static int[][] Llenar_matriz_random(int[][] matriz) {
        Random random = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(100) + 1;
            }
        }

        return matriz;
    }

    public static void Ordenar_columnas(int[][] matriz) {
        int filas = matriz.length;
        int columas = matriz[0].length;

        int[] arreglo_columa = new int[filas];

        for (int j = 0; j < columas; j++) {
            for (int i = 0; i < filas; i++) {
                arreglo_columa[i] = matriz[i][j];
            }
            Ordenamiento_seleccion(arreglo_columa);
            for (int i = 0; i < filas; i++) {
                matriz[i][j] = arreglo_columa[i];
            }
        }
    }

    public static int[] Ordenamiento_seleccion(int[] arreglo) {
        int tamanio_arreglo = arreglo.length;
        int menor, aux;
        for (int i = 0; i < tamanio_arreglo - 1; i++) {
            menor = i;
            for (int j = i + 1; j < tamanio_arreglo; j++) {
                if (arreglo[menor] > arreglo[j]) {
                    menor = j;
                }

            }
            if (menor != i) {
                aux = arreglo[i];
                arreglo[i] = arreglo[menor];
                arreglo[menor] = aux;
            }

        }
        return arreglo;
    }

    public static void Ejercicio_10() {
        Scanner input = new Scanner(System.in);
        System.out.print("Numero de estudiantes: ");
        int numero_estudiantes = input.nextInt();
        String[][] matriz_mostrar = new String[numero_estudiantes + 1][6];
        double[][] matriz_notas_estudiantes = new double[numero_estudiantes][4];
        long startTime = System.nanoTime();
        Llenar_matriz_notas_random(matriz_notas_estudiantes);
        Llenar_matriz_estudiantil(matriz_mostrar, matriz_notas_estudiantes);
        int[] cantidades = Cantidad_aprobados_reprobados(matriz_mostrar);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("\nTiempo en nanosegundos: " + timeElapsed);
        Imprimir_matriz(matriz_mostrar);

        System.out.println("Hay " + cantidades[0] + " aprobados, " + cantidades[1] + " en supletorios y " + cantidades[2] + " reprobados");

    }

    public static double[][] Llenar_matriz_notas_random(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = Math.round(Math.random() * 1000) / 100.0;

            }

        }

        return matriz;

    }

    public static String[][] Llenar_matriz_estudiantil(String[][] matriz, double[][] matriz_notas) {

        matriz[0][0] = "Estudiante";
        matriz[0][1] = "Nota 01";
        matriz[0][2] = "Nota 02";
        matriz[0][3] = "Nota 03";
        matriz[0][4] = "Promedio";
        matriz[0][5] = "Estado";
        double suma = 0;

        for (int i = 1; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (j == 0) {
                    matriz[i][j] = "Estudiante " + i;
                }
                if (j == 1) {

                    for (int k = 1; k <= 3; k++) {
                        matriz[i][k] = "" + matriz_notas[i - 1][k];
                    }

                }
                if (j == 4) {
                    for (int k = 0; k < matriz_notas[0].length; k++) {
                        suma += matriz_notas[i - 1][k];
                    }
                    matriz[i][4] = ((Math.round((suma / 3) * 100) / 100.0) > 10) ? "10" : "" + (Math.round((suma / 3) * 100) / 100.0);

                    suma = 0;
                }

                if (j == 5) {
                    double promedio = Double.parseDouble(matriz[i][4]);
                    if (promedio >= 7) {
                        matriz[i][j] = "Aprobado";

                    } else if (promedio < 5) {
                        matriz[i][j] = "Reprobado";

                    } else {
                        matriz[i][j] = "Supletorio";

                    }
                }

            }
        }

        return matriz;

    }

    public static int[] Cantidad_aprobados_reprobados(String[][] matriz) {
        int[] cantidades = new int[3];
        cantidades[0] = 0;
        cantidades[1] = 0;
        cantidades[2] = 0;

        for (int i = 1; i < matriz.length; i++) {
            if ("Aprobado".compareTo(matriz[i][5]) == 0) {
                cantidades[0]++;
            }
            if ("Supletorio".compareTo(matriz[i][5]) == 0) {
                cantidades[1]++;
            }
            if ("Reprobado".compareTo(matriz[i][5]) == 0) {
                cantidades[2]++;
            }
        }
        return cantidades;

    }

    public static void Imprimir_matriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
    }

}
