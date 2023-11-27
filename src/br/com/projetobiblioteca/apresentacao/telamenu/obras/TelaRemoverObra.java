package br.com.projetobiblioteca.apresentacao.telamenu.obras;

import java.util.Scanner;

import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.model.Obra;
import br.com.projetobiblioteca.persistencia.ObraDAO;

public class TelaRemoverObra {
    static Scanner sc = new Scanner(System.in);

    public TelaRemoverObra() {
    }

    public static void removerObra(Funcionário funcionario) {
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

            if (!confirmacao.equals("S")) {
                System.out.println("Remoção cancelada!");
            } else {
                obraDAO.deletar(obra);
                System.out.println("Obra removida com sucesso!");
            }
        }
    }

}
