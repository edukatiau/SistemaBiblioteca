package br.com.projetobiblioteca.apresentacao.telamenu.obras;

import java.util.Scanner;

import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.model.Obra;
import br.com.projetobiblioteca.persistencia.ObraDAO;

public class TelaRemoverObra {

    public static void TelaRemoverObra(Funcionário funcionario) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----REMOVER OBRA-----");
        System.out.println("Id da obra: ");
        long idObra = sc.nextLong();

        ObraDAO obraDAO = new ObraDAO();
        Obra obra = obraDAO.buscarPorId(idObra);

        if (obra == null) {
            System.out.println("Obra não encontrada!");
        } else {
            System.out.println(obra.toString());
            System.out.println("Confirma a remoção? (S/N)");
            String confirmacao = sc.next().toUpperCase();

            if (confirmacao.equals("N")) {
                System.out.println("Remoção cancelada!");
            } else if (!confirmacao.equals("S")) {
                System.out.println("Opção inválida!");
            } else {
                obraDAO.deletar(obra);
                System.out.println("Obra removida com sucesso!");
            }
        }
    }

}
