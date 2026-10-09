import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static boolean verificador(String texto) {
        int s = 0;

        for (char c : texto.toCharArray()) {
            switch (s) {
                case 0:
                    s = (c == 'v') ? 1 : 0;
                    break;
                case 1:
                    s = (c == 'o') ? 2 : 1;
                    break;
                case 2:
                    s = (c == 'i') ? 3 : 2;
                    break;
                case 3:
                    s = (c == 'd') ? 4 : 3;
                    break;
                case 4:
                    s = (c == ' ') ? 5 : 4;
                    break;
                case 5:
                    s = (c == '(') ? 6 : 5;
                    break;
                case 6:
                    s = (c == ')') ? 7 : 6;
                    break;
                case 7:
                    s = (c == '{') ? 8 : 7;
                    break;
                case 8:
                    s = (c == '}') ? 9 : 8;
                    break;
            }
        }
        return s == 9;
    }

    static public void leerYProcesarArchivo(String nombre) {
        File myObj = new File(nombre + ".txt");
        int ac = 0;
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (verificador(data)) {
                    ac+=1;
                }
            }
            System.out.println(ac);
        } catch (FileNotFoundException e) {
            System.out.println("An error had occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Nombre del archivo demo disponible es «Cuento»");
        System.out.println("Ingrese el nombre del archivo (sin extension .txt): ");
        String nombreArchivo = in.nextLine();
        leerYProcesarArchivo(nombreArchivo);
    }
}