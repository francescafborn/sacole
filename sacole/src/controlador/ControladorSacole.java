/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoSacole;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.Sacole;
import tela.manutencao.ManutencaoSacole;

/**
 *
 * @author Administrador
 */
public class ControladorSacole {

    public static void inserir(ManutencaoSacole man){
        Sacole objeto = new Sacole();
        objeto.setSabor(man.jtfSabor.getText());
        objeto.setData_de_validade(LocalDate.parse(man.jtfData_de_validade.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setPreco(Double.parseDouble(man.jtfPreco.getText()));
        objeto.setN_de_serie(Integer.parseInt(man.jtfN_de_serie.getText()));
        
        boolean resultado = DaoSacole.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

   public static void alterar(ManutencaoSacole man){
        Sacole objeto = new Sacole();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setSabor(man.jtfSabor.getText());
        objeto.setData_de_validade(LocalDate.parse(man.jtfData_de_validade.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setPreco(Double.parseDouble(man.jtfPreco.getText()));
        objeto.setN_de_serie(Integer.parseInt(man.jtfN_de_serie.getText()));
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        
        boolean resultado = DaoSacole.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
   }
}
