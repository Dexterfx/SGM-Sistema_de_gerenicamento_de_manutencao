/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author acg
 */
public class cadastra {
    //EQUIPAMENTO
    public String codigo;
    public String equipamento;
    public String proprietario;
    public String status;
    
    //MANUTENÇÃO
    public String data;
    public String materiais;
    public String servico;
    public int total;
    
    //Ultimo codigo

    
    
    public void incluir() throws SQLException {
        String sql = "Insert into cadastro (cod, equipamento, proprietario, data_manutencao, materiais, servico, total_man, status) values (" +
                "'" + codigo + "', " +
                "'" + equipamento + "', " +
                "'" + proprietario + "', " +
                "'" + data + "', " +
                "'" + materiais + "'" +
                ", " +
                "'" + servico + "'" +
                ", " +
                "" + total + "" +
                ", " +
                "'" + status + "'" +
                ")";
        System.out.println(sql);
        Banco.executarAtualizacao(sql);
        
    }

    public void alterar() throws SQLException {
        String sql = "Update cadastro set " +
                " equipamento = '" + equipamento + "', " +
                " proprietario = '" + proprietario + "', " +
                " data = '" + data + "', " +
                " materiais = '" + materiais + "' " +
                " servico = '" + servico + "' " +
                " total = '" + total + "' " +
                " status = '" + status + "' " +
                " where cod = '" + codigo + "'";
                
        System.out.println(sql);
        Banco.executarAtualizacao(sql);
        
    }

    public void excluir() throws SQLException {
        String sql = "Delete from cadastro where cod = '" + codigo + "'";
                
        System.out.println(sql);
        Banco.executarAtualizacao(sql);
        
    }
    

    public void buscarTodos() throws SQLException{
        //List<cadastra> l = new ArrayList();
        
        String sql = "Select * from cadastro order by cod";
        ResultSet rs = Banco.executaConsulta(sql);
        
        while (rs.next()) {
            cadastra c = new cadastra();
            c.equipamento = rs.getString("equipamento");
            c.proprietario = rs.getString("proprietario");
            c.data= rs.getString("data_manutencao");
            c.materiais = rs.getString("materiais");
            c.servico = rs.getString("servico");
            c.total= rs.getInt("total_man");
            c.status = rs.getString("status");
            c.codigo = rs.getString("cod");
            
       //     l.add(c);
        }
        
     //   return l;
    }

    public cadastra buscar(String codigoBusca) throws SQLException {
        
        String sql = "Select * from cadastro where cod = '" + codigoBusca + "'";
        ResultSet rs = Banco.executaConsulta(sql);
        
        while (rs.next()) {//next permite ir para a proxima
            cadastra c = new cadastra();
            c.equipamento = rs.getString("equipamento");
            c.proprietario = rs.getString("proprietario");
            c.data= rs.getString("data_manutencao");
            c.materiais = rs.getString("materiais");
            c.servico = rs.getString("servico");
            c.status = rs.getString("status");
            c.codigo = rs.getString("cod");
            
            return c;
        }
        
        return null;
    }
    
    
    
    public String toString() {
        return codigo;
    }
    
}
