package Etapa04;

import java.time.LocalDate;

public class ProdutoNovo {
    private String nome;   // Nome do produto
    private double precoCusto; // Preço de custo
    private double precoVenda;   // Preço de venda
    private LocalDate dataFabricacao; // Data de fabricação
    private LocalDate dataValidade;   // Data de validade

    // Construtor principal 
    public ProdutoNovo(String nome, double precoCusto, double precoVenda, LocalDate dataFabricacao, LocalDate dataValidade) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = LocalDate.now().plusMonths(1); // Validade de 1 mês
    }

    // Construtor que assume validade de 1 mês 
    public ProdutoNovo(String nome, double precoCusto, double precoVenda, LocalDate dataFabricacao) {
        this(nome, precoCusto, precoVenda, dataFabricacao, dataFabricacao.plusMonths(1));
    }

    // Construtor simplificado com preço de venda baseado no preço de custo
    public ProdutoNovo(String nome, double precoCusto) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoCusto * 1.10; // Margem de 10% sobre o custo
        this.dataFabricacao = LocalDate.now(); // Data atual como fabricação
        this.dataValidade = dataFabricacao.plusMonths(1); // Validade de 1 mês
    }

    // Métodos getters para acessar os atributos
    public String getNome() {
        return nome;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    // Método para formatar as informações do produto em uma string
    public String descricao() {
        return "Produto: " + nome +
               "\nPreço de Custo: R$ " + precoCusto +
               "\nPreço de Venda: R$ " + precoVenda +
               "\nData de Fabricação: " + dataFabricacao +
               "\nValidade: " + dataValidade;
    }

    public static void main(String[] args) {
        // Exibindo informações sobre produtos específicos
        ProdutoNovo arroz = new ProdutoNovo("Arroz", 20, 30, LocalDate.now(), LocalDate.now());
        System.out.println(arroz.descricao());

        System.out.println();

        ProdutoNovo feijao = new ProdutoNovo("Feijão", 10, 15, LocalDate.now());
        System.out.println(feijao.descricao());

        System.out.println();

        ProdutoNovo macarrao = new ProdutoNovo("Macarrão", 5);
        System.out.println(macarrao.descricao());
    }
}
