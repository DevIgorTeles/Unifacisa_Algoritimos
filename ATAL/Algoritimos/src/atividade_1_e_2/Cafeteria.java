package atividade_1_e_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Cafeteria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Clientes> cliente = new LinkedList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Registrar novo pedido");
            System.out.println("2. Visualizar pedidos em espera");
            System.out.println("3. Cancelar pedido e remover da fila de espera");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    registrarPedido(cliente, sc);
                    break;
                case 2:
                    visualizarPedidos(cliente);
                    break;
                case 3:
                    cancelarPedido(cliente, sc);
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saindo... Obrigado por usar a cafeteria!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        sc.close();
    }

    public static void registrarPedido(Queue<Clientes> cliente, Scanner sc) {
        System.out.println("Digite o nome do cliente: ");
        String nome = sc.nextLine();

        System.out.println("Cliente é VIP? (S/N)");
        String resposta = sc.nextLine();
        boolean vip = resposta.equalsIgnoreCase("s");

        Clientes novoCliente = new Clientes(nome, vip);

        if (vip) {
            // Insere VIP no início da fila
            LinkedList<Clientes> listaTemporaria = new LinkedList<>(cliente);
            listaTemporaria.addFirst(novoCliente);
            cliente.clear();
            cliente.addAll(listaTemporaria);
        } else {
            // Insere cliente normal no final da fila
            cliente.add(novoCliente);
        }

        System.out.println("Cliente adicionado com sucesso!");
    }

    public static void visualizarPedidos(Queue<Clientes> cliente) {
        if (cliente.isEmpty()) {
            System.out.println("Nenhum pedido na fila de espera.");
        } else {
            System.out.println("Pedidos em espera:");
            for (Clientes c : cliente) {
                System.out.println(c);
            }
        }
    }

    public static void cancelarPedido(Queue<Clientes> cliente, Scanner sc) {
        if (cliente.isEmpty()) {
            System.out.println("Nenhum pedido na fila para cancelar.");
            return;
        }

        System.out.println("Digite o nome do cliente a ser removido: ");
        String nome = sc.nextLine();

        boolean encontrado = false;
        LinkedList<Clientes> listaTemporaria = new LinkedList<>(cliente);

        for (Clientes c : listaTemporaria) {
            if (c.nome.equalsIgnoreCase(nome)) {
                cliente.remove(c);
                System.out.println("Pedido do cliente " + nome + " removido com sucesso!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente não encontrado na fila.");
        }
    }
}