/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.Sacole;
/**
 *
 * @author Administrador
 */
public class DaoSacole {
   
     public static boolean inserir(Sacole objeto) {
        String sql = "INSERT INTO sacole (sabor, data_de_validade, preco, n_de_serie) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getSabor());
            ps.setDate(2, Date.valueOf(objeto.getData_de_validade()));
            ps.setDouble(3, objeto.getPreco());
            ps.setInt(4, objeto.getN_de_serie());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
      public static void main(String[] args) {
        Sacole objeto = new Sacole();
        
        objeto.setSabor("BR");
        objeto.setData_de_validade(LocalDate.parse("11/01/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setPreco(1.50);
        objeto.setN_de_serie(15);
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
      
      public static boolean alterar(Sacole objeto) {
        String sql = "UPDATE sacole SET sabor = ?, data_de_validade = ?, preco = ?, n_de_serie = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getSabor());
            ps.setDate(2, Date.valueOf(objeto.getData_de_validade()));
            ps.setDouble(3, objeto.getPreco());
            ps.setInt(4, objeto.getN_de_serie());
            ps.setInt(5, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
