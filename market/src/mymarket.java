// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

public class MeuMercado {
   public static int escolha;
   public static int indice = 0;
   public static double saldo = 0.0;
   public static int menu;
   public static String[] idProduto = new String[5];
   public static String[] nomeProduto = new String[5];
   public static double[] valorProduto = new double[5];
   public static int[] estoqueProduto = new int[5];
   public static String[] nomeCliente = new String[10];
   public static String[] idCliente = new String[10];

   public MeuMercado() {
   }

   public static void sairouMenu() {
      Scanner scan = new Scanner(System.in);
      System.out.println("Pressione 1 para sair do programa");
      System.out.println("Pressione 0 para voltar pro menu");
      System.out.println("Escolha:");
      escolha = scan.nextInt();
      if (escolha == 1) {
         sair();
      } else {
         menu();
      }

   }

   public static void inicializar() {
      idProduto[0] = "1";
      idProduto[1] = "2";
      idProduto[2] = "3";
      idProduto[3] = "4";
      idProduto[4] = "5";
      nomeProduto[0] = "Arroz";
      nomeProduto[1] = "Feijao";
      nomeProduto[2] = "Bolacha";
      nomeProduto[3] = "Macarrao";
      nomeProduto[4] = "Tapioca";
      valorProduto[0] = 2.25;
      valorProduto[1] = 1.75;
      valorProduto[2] = 2.35;
      valorProduto[3] = 2.15;
      valorProduto[4] = 2.45;
      estoqueProduto[0] = 40;
      estoqueProduto[1] = 45;
      estoqueProduto[2] = 60;
      estoqueProduto[3] = 48;
      estoqueProduto[4] = 50;
      idCliente[0] = "1";
      idCliente[1] = "2";
      idCliente[2] = "3";
      idCliente[3] = "4";
      idCliente[4] = "5";
      idCliente[5] = "6";
      idCliente[6] = "7";
      idCliente[7] = "8";
      idCliente[8] = "9";
      idCliente[9] = "10";
   }

   public static void login() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("########## Login ##########");
      System.out.println("login: ");
      String logNome = scanner.nextLine();
      System.out.println("senha: ");
      String logSenha = scanner.nextLine();
      if (logNome.equals("admin") && logSenha.equals("123")) {
         inicializar();
         menu();
      } else {
         limparTela();
         System.out.println("(Dados Incorretos !!!)");
         login();
      }

   }

   public static void menu() {
      Scanner scanner = new Scanner(System.in);
      limparTela();
      System.out.println("--------------MENU--------------\n1 - Mostrar produtos em estoque\n2 - Mostrar clientes\n3 - Cadastrar novo cliente\n4 - Mostrar dinheiro em caixa\n5 - Vender Produtos\n6 - Sair\n--------------------------------\n");
      System.out.println("Escolha o que deseja fazer:");
      menu = scanner.nextInt();
      if (menu == 1) {
         printProdutos();
      } else if (menu == 2) {
         mostrarCliente();
      } else if (menu == 3) {
         cadastrarCliente();
      } else if (menu == 4) {
         valorEmCaixa();
      } else if (menu == 5) {
         realizarCompra();
      } else {
         sair();
      }

   }

   public static void printProdutos() {
      new Scanner(System.in);
      System.out.println("\n\n-----------------------------PRODUTOS------------------------------");

      for(int i = 0; i < idProduto.length; ++i) {
         String var10001 = idProduto[i];
         System.out.println("ID:" + var10001 + " - Produto:" + nomeProduto[i] + " - Pre\u00e7o R$" + valorProduto[i] + " - Quantidade em estoque: " + estoqueProduto[i]);
      }

      System.out.println("------------------------------------------------------------------");
      sairouMenu();
   }

   public static void sair() {
      System.out.println("Fim do Programa");
      System.exit(0);
   }

   public static void mostrarCliente() {
      new Scanner(System.in);
      System.out.println("\n\n-----------------------------CLIENTES------------------------------");

      for(int i = 0; i < nomeCliente.length; ++i) {
         String var10001 = idCliente[i];
         System.out.println("ID:" + var10001 + "  Cliente: " + nomeCliente[i]);
      }

      System.out.println("------------------------------------------------------------------");
      sairouMenu();
   }

   public static void cadastrarCliente() {
      System.out.println("CADASTRANDO...");
      System.out.println("Digite o nome:");
      Scanner scan = new Scanner(System.in);
      nomeCliente[indice] = scan.nextLine();
      ++indice;
      menu();
   }

   public static void valorEmCaixa() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("\n\nValor em Caixa: R$ " + saldo);
      System.out.println("(Qualquer tecla + Enter para voltar !)");
      scanner.nextLine();
      menu();
   }

   public static void realizarCompra() {
      Scanner scan = new Scanner(System.in);
      System.out.println("Qual ID do produto que deseja comprar ?");
      int id = scan.nextInt();
      System.out.println("Qual quantidade deseja comprar ?");

      int quantidade;
      for(quantidade = scan.nextInt(); quantidade > estoqueProduto[id - 1]; quantidade = scan.nextInt()) {
         System.out.println("(QUANTIDADE PEDIDA EXCEDE O ESTOQUE)");
         System.out.println("Qual quantidade deseja comprar ?");
      }

      System.out.println("\n\n\n-----------RECIBO-----------");
      String var10001 = nomeProduto[id - 1];
      System.out.println("Produto: " + var10001);
      double var4 = valorProduto[id - 1];
      System.out.println("Pre\u00e7o da Unidade: R$ " + var4);
      System.out.println("Quantidade sendo comprada: " + quantidade);
      System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
      System.out.println("Valor a pagar " + valorProduto[id - 1] * (double)quantidade);
      System.out.println("\nConfirmar a compra ? 0- Sim 1- N\u00e3o(Cancelar compra):");
      escolha = scan.nextInt();
      if (escolha == 1) {
         menu();
      }

      if (indice == 0) {
         limparTela();
         System.out.println("N\u00e3o existe cliente cadastrado!!!");
         System.out.println("Cadastre um cliente !!!");
         cadastrarCliente();
      }

      System.out.println("Informe o ID do cliente: ");

      for(int id2 = scan.nextInt(); id2 > indice || id2 < 1; id2 = scan.nextInt()) {
         System.out.println("Informe um ID v\u00e1lido do cliente: ");
      }

      System.out.println("(COMPRA CONFIRMADA !!!)");
      saldo += (double)quantidade * valorProduto[id - 1];
      estoqueProduto[id - 1] -= quantidade;
      System.out.println("Deseja realizar outra compra ?");
      System.out.println("Pressione 1 para realizar outra compra");
      System.out.println("Pressione 0 para voltar pro menu");
      System.out.println("Escolha:");
      escolha = scan.nextInt();
      if (escolha == 1) {
         realizarCompra();
      } else {
         menu();
      }

   }

   public static void limparTela() {
      for(int i = 0; i < 100; ++i) {
         System.out.println(" ");
      }

   }

   public static void main(String[] args) {
      login();
   }
}
