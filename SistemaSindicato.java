import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaSindicato {

    static class Professor {
        private String nome;
        private String cpf;
        private String titulacao; // Doutor, Mestre, Especialista
        private double salario;

        public Professor(String nome, String cpf, String titulacao, double salario) {
            this.nome = nome;
            this.cpf = cpf;
            this.titulacao = titulacao;
            this.salario = salario;
        }

        public double calcularContribuicao() {
            switch (titulacao) {
                case "Especialista":
                    return salario * 0.012;
                case "Mestre":
                    return salario * 0.014;
                case "Doutor":
                    return salario * 0.016;
                default:
                    return 0;
            }
        }

        public String getTitulacao() {
            return titulacao;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Professor> professores = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Digite o nome do professor:");
            String nome = scanner.nextLine();

            System.out.println("Digite o CPF do professor:");
            String cpf = scanner.nextLine();

            System.out.println("Digite a titulação do professor (Doutor, Mestre, Especialista):");
            String titulacao = scanner.nextLine();

            System.out.println("Digite o salário do professor:");
            double salario = scanner.nextDouble();
            scanner.nextLine();

            professores.add(new Professor(nome, cpf, titulacao, salario));

            System.out.println("Deseja adicionar outro professor? (s/n)");
            String resposta = scanner.nextLine();
            continuar = resposta.equalsIgnoreCase("s");
        }

        double totalArrecadado = 0;
        int quantidadeMestres = 0;

        for (Professor professor : professores) {
            totalArrecadado += professor.calcularContribuicao();
            if (professor.getTitulacao().equalsIgnoreCase("Mestre")) {
                quantidadeMestres++;
            }
        }

        System.out.printf("Total arrecadado pelo sindicato: R$ %.2f%n", totalArrecadado);
        System.out.println("Quantidade de professores Mestre: " + quantidadeMestres);
    }
}
