package lt.eimantas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Main object = new Main();
        object.atidarytiFaila();
        object.skaitymasIsFailo2x();
    }

    private FileReader _in;
    private String _failoVardas = "skaiciai.txt";
    private BufferedReader _bufferis;

    public void atidarytiFaila() {
        try {
            _in = new FileReader(_failoVardas);
            _bufferis = new BufferedReader(_in);
        } catch (Exception e) {
        }
    }

    public void skaitymasIsFailo2x() {
        try {
            Integer eiluciuSk = 0;
            String eilute = _bufferis.readLine();
            while (eilute != null) {
                eiluciuSk++;
                System.out.println(eilute);
                eilute = _bufferis.readLine();
            }
            System.out.println("Eiluciu skaicius: " + eiluciuSk);
            _bufferis.close();
            _in.close();

            atidarytiFaila();                // metodo iskvietimas kito metodo viduje

            int[] array = new int[eiluciuSk];
            eilute = _bufferis.readLine();
            while (eilute != null) {
                for (int i = 0; i < eiluciuSk; i++) {
                    array[i] = Integer.parseInt(eilute);
                    eilute = _bufferis.readLine();
                }
            }
            Integer temp = 0;
            for (int i = 0; i < eiluciuSk - 1; i++) {
                for (int j = i + 1; j < eiluciuSk; j++) {
                    if (array[i] > array[j]) {
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(array));
            _bufferis.close();
            _in.close();

        } catch (Exception e) {
            System.out.println("Kazkas negerai");
            e.printStackTrace();
        }
    }
}