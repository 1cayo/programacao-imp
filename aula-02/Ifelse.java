import java.util.Scanner;

public class Ifelse{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Exercício 1:
        
        System.out.println("======BANCA DE VOTACAO======");
        System.out.println("Digite sua idade: ");
        int idade = sc.nextInt();


        if (idade < 16) {
            System.out.println("VOTO N PERMITIDO");
        } else if (idade >= 70) {
            System.out.println("VOTO FACULTATIVO");
        } else if (idade >= 18) {
            System.out.println("VOTO OBRIGATORIO");
        } else {
            System.out.println("IDADE MINIMA P/ FACULTATIVO");
        }

        // Exercício 2:

        System.out.println("======CLASSIFICACAO DE NOTAS======");
        int nota = sc.nextInt();

        if (nota > 10 || nota < 0) {
            System.out.println("INVALIDO");
        } else if (nota >= 9) {
            System.out.println("EXCELENTEMENTE APROVADO");
        } else if (nota >= 7) {
            System.out.println("APROVADO");
        } else if (nota >= 5){
            System.out.println("RECUPERACAO");
        } else if (nota < 5){
            System.out.println("REPROVACAO");
        } 

    }

}
