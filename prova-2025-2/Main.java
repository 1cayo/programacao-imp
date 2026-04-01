public class Main{
    public static void rotacionar(int[] v, int tam, int k) {
        k = k % tam;
        if (k < 0) k += tam;
    
    
        for (int i = 0, j = tam-1; i < j; i++, j--) {
            int tmp = v[i]; v[i] = v[j]; v[j] = tmp;
        }
    
        for (int i = 0, j = k-1; i < j; i++, j--) {
            int tmp = v[i]; v[i] = v[j]; v[j] = tmp;
        }
    
        for (int i = k, j = tam-1; i < j; i++, j--) {
            int tmp = v[i]; v[i] = v[j]; v[j] = tmp;
        }
    }
}