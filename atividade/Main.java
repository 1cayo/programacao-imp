import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static class Pessoa {
        String nome;
        int idade;
        double peso;
        double altura;
    }

    public static int buscarNome(Pessoa[] v, int qtd, String nome) {
        for (int i = 0; i < qtd; i++) {
            if (v[i].nome.equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return -1;
    }

    // Questão 1
    public static int cadastrarPessoa(Pessoa[] v, int qtd) {

        if (qtd == v.length) {
            return qtd;
        }

        Pessoa p = new Pessoa();

        System.out.print("Nome: ");
        p.nome = sc.nextLine();

        while (buscarNome(v, qtd, p.nome) != -1) {
            System.out.println("Nome já existe.");
            System.out.print("Digite outro nome: ");
            p.nome = sc.nextLine();
        }

        System.out.print("Idade: ");
        p.idade = sc.nextInt();

        System.out.print("Peso: ");
        p.peso = sc.nextDouble();

        System.out.print("Altura: ");
        p.altura = sc.nextDouble();
        sc.nextLine();

        v[qtd] = p;

        return qtd + 1;
    }

    public static double calcularIMC(Pessoa p) {
        return p.peso / (p.altura * p.altura);
    }

    // Questão 2
    public static void imprimirPessoas(Pessoa[] v, int qtd) {

        for (int i = 0; i < qtd; i++) {

            System.out.println("Nome: " + v[i].nome);
            System.out.println("Idade: " + v[i].idade);
            System.out.println("Peso: " + v[i].peso);
            System.out.println("Altura: " + v[i].altura);
            System.out.println("IMC: " + calcularIMC(v[i]));
            System.out.println();
        }
    }

    // Questão 3
    public static int maisVelhaIMCMagreza(Pessoa[] v, int qtd) {

        int indice = -1;

        for (int i = 0; i < qtd; i++) {

            if (calcularIMC(v[i]) < 18.5) {

                if (indice == -1 || v[i].idade > v[indice].idade) {
                    indice = i;
                }
            }
        }

        return indice;
    }

    // Questão 4
    public static void insertionSortPorNome(Pessoa[] v, int qtd) {

        for (int i = 1; i < qtd; i++) {

            Pessoa aux = v[i];
            int j = i - 1;

            while (j >= 0 &&
                   v[j].nome.compareToIgnoreCase(aux.nome) > 0) {

                v[j + 1] = v[j];
                j--;
            }

            v[j + 1] = aux;
        }
    }

    // Questão 5
    // Calcula a média das idades.
    // Se não houver retorna 0

    public static double mediaIdades(Pessoa[] v, int qtd) {

        if (qtd == 0) {
            return 0;
        }

        int soma = 0;

        for (int i = 0; i < qtd; i++) {
            soma += v[i].idade;
        }

        return (double) soma / qtd;
    }

    public static void main(String[] args) {

        Pessoa[] pessoas = new Pessoa[50];
        int qtd = 0;

        qtd = cadastrarPessoa(pessoas, qtd);
        qtd = cadastrarPessoa(pessoas, qtd);

        imprimirPessoas(pessoas, qtd);

        System.out.println("Indice da mais velha com magreza: "
                + maisVelhaIMCMagreza(pessoas, qtd));

        insertionSortPorNome(pessoas, qtd);

        System.out.println("Media das idades: "
                + mediaIdades(pessoas, qtd));
    }
}