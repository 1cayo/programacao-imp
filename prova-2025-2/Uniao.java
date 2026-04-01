public class Uniao{
    public static int uniao(int[] a, int tamA, int[] b, int tamB, int[] u) {
     int tamU = 0;
    
      for (int i = 0; i < tamA; i++) {
         u[tamU++] = a[i];
     }
    
      for (int i = 0; i < tamB; i++) {
         boolean achou = false;
         for (int j = 0; j < tamU; j++) {
              if (b[i] == u[j]) {
                 achou = true;
                 break;
             }
         }
            if (!achou) u[tamU++] = b[i];
        }
        return tamU;
    }
}