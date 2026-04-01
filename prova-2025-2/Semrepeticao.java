public class Semrepeticao{
    public static int gerarVetorSemRepeticao(int[] v, int tamV, int[] vsr) {
        int tam = 0;
        for (int i = 0; i < tamV; i++) {
            boolean rep = false;
            for (int j = 0; j < tam; j++) {
                if (v[i] == vsr[j]) { rep = true; break; }
            }
            if (!rep) vsr[tam++] = v[i];
        }
        return tam;
}