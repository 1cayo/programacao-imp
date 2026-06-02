import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Produto {
    String nome;
    int qtdEstoque;
    double precoUnitario;
    String categoria;
    int qtdMinima;

    public Produto(String nome, int qtdEstoque, double precoUnitario,
                   String categoria, int qtdMinima) {
        this.nome = nome;
        this.qtdEstoque = qtdEstoque;
        this.precoUnitario = precoUnitario;
        this.categoria = categoria;
        this.qtdMinima = qtdMinima;
    }
}

public class controleEstoque {

    static ArrayList<Produto> produtos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n===== CONTROLE DE ESTOQUE =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Filtrar por categoria");
            System.out.println("4 - Ordenar por categoria");
            System.out.println("5 - Remover produto");
            System.out.println("6 - Atualizar preco");
            System.out.println("7 - Listagem com subtotal por categoria");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    filtrarCategoria();
                    break;
                case 4:
                    ordenarProdutos();
                    break;
                case 5:
                    removerProduto();
                    break;
                case 6:
                    atualizarPreco();
                    break;
                case 7:
                    listarSubtotalCategoria();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);
    }

    public static void cadastrarProduto() {

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Quantidade em estoque: ");
        int qtd = sc.nextInt();

        System.out.print("Preco unitario: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        System.out.print("Categoria: ");
        String categoria = sc.nextLine();

        System.out.print("Quantidade minima: ");
        int qtdMin = sc.nextInt();
        sc.nextLine();

        produtos.add(
            new Produto(nome, qtd, preco, categoria, qtdMin)
        );

        System.out.println("Produto cadastrado.");
    }

    public static void listarProdutos() {

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println("--------------------");
            System.out.println("Nome: " + p.nome);
            System.out.println("Estoque: " + p.qtdEstoque);
            System.out.println("Preco: R$ " + p.precoUnitario);
            System.out.println("Categoria: " + p.categoria);
            System.out.println("Qtd minima: " + p.qtdMinima);
        }
    }

    public static void filtrarCategoria() {

        System.out.print("Categoria: ");
        String categoria = sc.nextLine();

        for (Produto p : produtos) {
            if (p.categoria.equalsIgnoreCase(categoria)) {
                System.out.println(p.nome);
            }
        }
    }

    public static void ordenarProdutos() {

        Collections.sort(produtos,
                Comparator.comparing(p -> p.categoria));

        System.out.println("Produtos ordenados por categoria.");
    }

    public static void removerProduto() {

        System.out.print("Nome do produto: ");
        String nome = sc.nextLine();

        boolean removido = false;

        for (int i = 0; i < produtos.size(); i++) {

            if (produtos.get(i).nome.equalsIgnoreCase(nome)) {
                produtos.remove(i);
                removido = true;
                break;
            }
        }

        if (removido)
            System.out.println("Produto removido.");
        else
            System.out.println("Produto nao encontrado.");
    }

    public static void atualizarPreco() {

        System.out.print("Nome do produto: ");
        String nome = sc.nextLine();

        for (Produto p : produtos) {

            if (p.nome.equalsIgnoreCase(nome)) {

                System.out.print("Novo preco: ");
                p.precoUnitario = sc.nextDouble();
                sc.nextLine();

                System.out.println("Preco atualizado.");
                return;
            }
        }

        System.out.println("Produto nao encontrado.");
    }

    public static void listarSubtotalCategoria() {

        ordenarProdutos();

        String categoriaAtual = "";
        double subtotal = 0;
        double totalGeral = 0;

        for (Produto p : produtos) {

            if (!p.categoria.equals(categoriaAtual)) {

                if (!categoriaAtual.equals("")) {
                    System.out.printf("Subtotal: R$ %.2f%n%n",
                            subtotal);
                }

                categoriaAtual = p.categoria;
                subtotal = 0;

                System.out.println("\nCategoria: "
                        + categoriaAtual);
            }

            double valor =
                    p.qtdEstoque * p.precoUnitario;

            System.out.printf(
                    "%s %d x %.2f = %.2f%n",
                    p.nome,
                    p.qtdEstoque,
                    p.precoUnitario,
                    valor
            );

            subtotal += valor;
            totalGeral += valor;
        }

        if (!produtos.isEmpty()) {
            System.out.printf("Subtotal: R$ %.2f%n",
                    subtotal);
        }

        System.out.printf(
                "%nTOTAL GERAL: R$ %.2f%n",
                totalGeral
        );
    }
}