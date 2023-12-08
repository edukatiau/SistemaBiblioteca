package br.com.projetobiblioteca.apresentacao.telamenu.campus;

import java.util.List;

import br.com.projetobiblioteca.model.Campus;
import br.com.projetobiblioteca.persistencia.CampusDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaListarCampus {

    public static void listarCampus() {
        System.out.println(Colors.ANSI_BLUE + "-----LISTAR CAMPUS-----" + Colors.ANSI_RESET);
        CampusDAO campusDAO = new CampusDAO();
        List<Campus> listaCampus = campusDAO.buscarTodos();

        if (listaCampus.isEmpty()) {
            System.out.println(Colors.ANSI_RED + "Não há campus cadastrados!" + Colors.ANSI_RESET);
            return;
        } else{
            int i = 1;
            for (Campus campus : listaCampus) {
                System.out.println("Campus " + i++ + ": ");
                System.out.println(campus.toString() + "\n");
            }
        }
    }

}
