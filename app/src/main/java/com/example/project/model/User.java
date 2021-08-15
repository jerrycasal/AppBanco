package com.example.project.model;


public class User {
    int id;
    String tx_nombre, tx_apellido, tx_usuario, tx_password;

    public User() {

    }

    public User(String tx_nombre, String tx_apellido, String tx_usuario, String tx_password) {
        this.tx_nombre = tx_nombre;
        this.tx_apellido = tx_apellido;
        this.tx_usuario = tx_usuario;
        this.tx_password = tx_password;
    }

    public boolean isNull(){
        if(tx_nombre.equals("")&& tx_apellido.equals("")&& tx_usuario.equals("")){
            return false;
        }else{
            return  true;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", tx_nombre='" + tx_nombre + '\'' +
                ", tx_apellido='" + tx_apellido + '\'' +
                ", tx_usuario='" + tx_usuario + '\'' +
                ", tx_password='" + tx_password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTx_nombre() {
        return tx_nombre;
    }

    public void setTx_nombre(String tx_nombre) {
        this.tx_nombre = tx_nombre;
    }

    public String getTx_apellido() {
        return tx_apellido;
    }

    public void setTx_apellido(String tx_apellido) {
        this.tx_apellido = tx_apellido;
    }

    public String getTx_usuario() {
        return tx_usuario;
    }

    public void setTx_usuario(String tx_usuario) {
        this.tx_usuario = tx_usuario;
    }

    public String getTx_password() {
        return tx_password;
    }

    public void setTx_password(String tx_password) {
        this.tx_password = tx_password;
    }
}
