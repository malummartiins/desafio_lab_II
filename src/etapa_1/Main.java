package etapa_1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Labirinto labirintoFinal = new Labirinto();
        labirintoFinal.criaLabirinto("lab");
        boolean result = labirintoFinal.percorreLabirinto();

        System.out.println(result);
    }
    
}
