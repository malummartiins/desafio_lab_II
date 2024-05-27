package etapa_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Labirinto {

    public char[][] labirinto;

    public Labirinto(){

    }

    public void criaLabirinto(String filename) throws IOException{
         String path = MessageFormat.format("src/etapa_1/{0}.txt", filename);
        List<char[]> linhas = new ArrayList<>();
        int maxLength = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.length() > maxLength) {
                    maxLength = linha.length();
                }
                linhas.add(linha.toCharArray());
            }
    }

    this.labirinto = new char[linhas.size()][maxLength];

        for (int i = 0; i < linhas.size(); i++) {
            char[] linha = linhas.get(i);
            for (int j = 0; j < maxLength; j++) {
                if (j < linha.length) {
                    labirinto[i][j] = linha[j];
                } else {
                    labirinto[i][j] = ' ';
                }
            }
        }
}

public boolean percorreLabirinto() {
    if (labirinto == null) throw new IllegalArgumentException();
    return percorreLabirinto(0, 0);
}

private boolean percorreLabirinto(int x, int y) {
    boolean alemLimites = x < 0 || y < 0 || x >= labirinto.length;
    if (alemLimites) return false;

    boolean umaParede = y >= labirinto[0].length || labirinto[x][y] == 'X';
    if (umaParede) return false;

    boolean chegouSaida = labirinto[x][y] == 'D';
    if (chegouSaida) return true;

    boolean mesmoCaminho = labirinto[x][y] == 'V';
    if (mesmoCaminho) return false;

    
    labirinto[x][y] = 'V';

    boolean caminhoCerto = percorreLabirinto(x + 1, y) ||  // baixo
            percorreLabirinto(x - 1, y) ||  // sobe
            percorreLabirinto(x, y + 1) ||  // direita
            percorreLabirinto(x, y - 1);    // esquerda

    
    labirinto[x][y] = ' ';

    return caminhoCerto;
}


}