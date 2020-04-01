/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.model;

/**
 *
 * @author vasco
 */
public class SessaoUsuario {
    
    
    
    public static int id;
    public static String  nome;
    public static String user;
    public static String cargo;

    public static String getCargo() {
        return cargo;
    }

    public static void setCargo(String cargo) {
        SessaoUsuario.cargo = cargo;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        SessaoUsuario.id = id;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        SessaoUsuario.nome = nome;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String email) {
        SessaoUsuario.user = user;
    }
    
    
}
