package br.com.projetobiblioteca.apresentacao.telamenu.campus;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Campus;
import br.com.projetobiblioteca.persistencia.AlunoDAO;
import br.com.projetobiblioteca.persistencia.BibliotecaDAO;
import br.com.projetobiblioteca.persistencia.CampusDAO;
import br.com.projetobiblioteca.persistencia.ObraDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaRemoverCampus {
    static Scanner sc = new Scanner(System.in);

    public static void removerCampus() throws SQLException {
        System.out.println(Colors.ANSI_BLUE + "-----REMOVER CAMPUS-----" + Colors.ANSI_RESET);
        System.out.print("Nome do Campus: ");
        String nome = sc.nextLine();

        CampusDAO campusDAO = new CampusDAO();
        Campus campus = campusDAO.buscarPorNome(nome);

        if (campus == null) {
            System.out.println(Colors.ANSI_RED + "Campus não encontrado!" + Colors.ANSI_RESET);
        } else {
            System.out.println(campus.toString());
            System.out.println("Confirma a remoção? (S/N)");
            String confirmacao = sc.next().toUpperCase();

            if (!confirmacao.equals("S")) {
                System.out.println(Colors.ANSI_RED + "Remoção cancelada!" + Colors.ANSI_RESET);
            } else {

                if(verificaTUDO(campus.getId_campus(), campus.getId_campus())){
                    return;
                }

                campusDAO.deletar(campus.getId_campus());
                BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                bibliotecaDAO.deletar(campus.getId_campus());
                System.out.println(Colors.ANSI_GREEN + "Campus removido com sucesso!" + Colors.ANSI_RESET);
            }
            System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
        }
    }

    public static boolean verificaTUDO(long id_biblioteca, long id_campus){
        ObraDAO obraDAO = new ObraDAO();
        AlunoDAO alunoDAO = new AlunoDAO();

        if(alunoDAO.buscarPorCampus(id_campus).size() > 0){
            System.out.println("Há alunos ainda cadastrados no campus.");
        }
        
        if(obraDAO.buscarPorBiblioteca(id_biblioteca).size() > 0){
            System.out.println("Há obras ainda cadastradas na biblioteca.");
        }



        System.out.println("Deseja remover as obras/alunos/empréstimos? (S/N)");
        String confirmacao = sc.next().toUpperCase();
        return confirmacao.equals("S") ? false : true;

    }


}
