package etapa_2;

import java.util.Random;

public class PrincipalCandidatos {
    
public static void main(String[] args) {
    
        Candidato[] candidatos = criarCandidatos(6);


         // Ordenação por nome usando Seleção Direta
         ordenaCandidatosPorNome(candidatos);
         System.out.println("Candidatos ordenados por nome:");
         for (Candidato c : candidatos) {
             System.out.println(c);
         }


        //Ordenação por votos usando Inserção Direta
        ordenaCandidatosPorVotos(candidatos);
        System.out.println("\nCandidatos ordenados por votos:");
        for (Candidato c : candidatos) {
            System.out.println(c);
        }

        // Ordenação por partido usando Inserção Direta
         ordenaCandidatosPorPartido(candidatos);
        System.out.println("\nCandidatos ordenados por partido:");
        for (Candidato c : candidatos) {
            System.out.println(c);
        }  

        
}

    private static final String[] nomes = {"Ross", "Monica", "Chandler", "Rachel", "Phoebe", "Joey"};
    private static final int[] intencoesVoto = {170, 200, 100, 400, 100};
    private static final String[] partidos = {"CP", "LV", "FRIENDS"};


public static Candidato[] criarCandidatos(int numCandidatos) {
        Candidato[] candidatos = new Candidato[numCandidatos];

        for (int i = 0; i < numCandidatos; i++) {
            int randomNome = new Random().nextInt(nomes.length);
            int randomVotos = new Random().nextInt(intencoesVoto.length);
            int randomPartido = new Random().nextInt(partidos.length);

            candidatos[i] = new Candidato(
                nomes[randomNome],
                partidos[randomPartido],
                intencoesVoto[randomVotos]
            );
        }
        return candidatos;
    }


   //SELEÇÃO DIRETA

   public static void ordenaCandidatosPorNome(Candidato[] candidatos) {
    for (int i = 0; i < candidatos.length - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < candidatos.length; j++) {
            if (candidatos[j].getNome().compareTo(candidatos[minIndex].getNome()) < 0) {
                minIndex = j;
            }
        }
        Candidato temp = candidatos[minIndex];
        candidatos[minIndex] = candidatos[i];
        candidatos[i] = temp;
    }
}


    //ULTIMOS MÉTODOS COM INSERÇÃO DIRETA

    public static void ordenaCandidatosPorVotos(Candidato[] candidatos) {
        for (int i = 1; i < candidatos.length; i++) {
            Candidato key = candidatos[i];
            int j = i - 1;
            while (j >= 0 && candidatos[j].getIntencoesVotos() > key.getIntencoesVotos()) {
                candidatos[j + 1] = candidatos[j];
                j = j - 1;
            }
            candidatos[j + 1] = key;
        }
    }



   public static void ordenaCandidatosPorPartido(Candidato[] candidatos) {
    for (int i = 1; i < candidatos.length; i++) {
        Candidato key = candidatos[i];
        int j = i - 1;
        while (j >= 0 && candidatos[j].getPartido().compareTo(key.getPartido()) > 0) {
            candidatos[j + 1] = candidatos[j];
            j = j - 1;
        }
        candidatos[j + 1] = key;
    }
}

    //  PESQUISA BINÁRIA


   public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome) {
    int inicio = 0;
    int fim = candidatos.length - 1;
    
    while (inicio <= fim) {
        int meio = (inicio + fim) / 2;
        int comparacao = candidatos[meio].getNome().compareTo(nome);
        
        if (comparacao == 0) {
            
            while (meio > 0 && candidatos[meio - 1].getNome().compareTo(nome) == 0) {
                meio--;
            }
            return meio;
        } else if (comparacao < 0) {
            inicio = meio + 1;
        } else {
            fim = meio - 1;
        }
    }
    
    return -1; 
}
}
