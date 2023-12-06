package br.com.projetobiblioteca.apresentacao.telamenu.obras;

import java.util.Scanner;

import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.model.Obra;
import br.com.projetobiblioteca.persistencia.ObraDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaRemoverObra {
    static Scanner sc = new Scanner(System.in);

    public TelaRemoverObra() {
    }

    public static void removerObra(Funcionário funcionario) {
        System.out.println(Colors.ANSI_BLUE + "-----REMOVER OBRA-----" + Colors.ANSI_RESET);
        System.out.print("Id da obra: ");
        long idObra = sc.nextLong();

        ObraDAO obraDAO = new ObraDAO();
        Obra obra = obraDAO.buscarPorId(idObra);

        if (obra == null) {
            System.out.println(Colors.ANSI_RED + "Obra não encontrada!" + Colors.ANSI_RESET);
            return;
        } else {
            System.out.println(obra.toString());
            System.out.println("Confirma a remoção? (S/N)");
            String confirmacao = sc.next().toUpperCase();

            if (!confirmacao.equals("S")) {
                System.out.println(Colors.ANSI_RED + "Remoção cancelada!" + Colors.ANSI_RESET);
            } else {
                obraDAO.deletar(obra);
                System.out.println(Colors.ANSI_GREEN + "Obra removida com sucesso!" + Colors.ANSI_RESET);
            }
            System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
        }
    }

}
