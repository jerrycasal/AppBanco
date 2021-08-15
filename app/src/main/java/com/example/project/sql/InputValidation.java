package com.example.project.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.project.model.User;

import java.util.ArrayList;

public class InputValidation {


    Context c;
    User u;
    ArrayList<User> lista;
    SQLiteDatabase sql;
    String bd = "BDUsuarios";
    String tabla = "create table if not exists usuarios (id integer primary key autoincrement, usuario text, pass text, nombre text, apellido text)";


    public InputValidation (Context c){
        this.c = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u = new User();
    }

    public boolean insertUser(User u){
        if(buscar(u.getTx_usuario())==0){
            ContentValues cv = new ContentValues();
            cv.put("usuario",u.getTx_usuario());
            cv.put("pass",u.getTx_password());
            cv.put("nombre",u.getTx_nombre());
            cv.put("apellido",u.getTx_apellido());
            return (sql.insert("usuarios",null,cv)>0);

        }else{
            return false;
        }
    }

    public int buscar(String u){
        int x=0;
        lista = selectUser();
        for (User us:lista)
        {
            if(us.getTx_usuario().equals(u)){
                x++;
            }

        }
        return x;
    }

    public ArrayList<User> selectUser(){
        ArrayList<User> lista = new ArrayList<User>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from usuarios ",null);
        if(cr!=null && cr.moveToFirst()){
            do{
                User  u = new User();
                u.setId(cr.getInt(0));
                u.setTx_usuario(cr.getString(1));
                u.setTx_password(cr.getString(2));
                u.setTx_nombre(cr.getString(3));
                u.setTx_apellido(cr.getString(4));
                lista.add(u);

            }while(cr.moveToNext());
        }
        return lista;
    }


    //Para validar el usuario que inicie sesión
    public int login (String u, String p){

        int a = 0;
        Cursor cr = sql.rawQuery("select * from usuarios ",null);
        if(cr!=null && cr.moveToFirst()){
            do{
                if(cr.getString(1).equals(u)&&cr.getString(2).equals(p)){
                    a++;
                }

            }while(cr.moveToNext());
        }
        return a;

    }


    //Para retornar el dato del usuario que inicio sesión por usuario y contraseña
    public User getUsuario(String u, String p){

        lista = selectUser();
        for (User us:lista) {
            if(us.getTx_usuario().equals(u)&&us.getTx_password().equals(p)){
                return  us;
            }
            
        }
        return null;
    }

    //Para retornar el dato del usuario que inicio sesión por el id unico
    public User getUsuarioById(int id){

        lista = selectUser();
        for (User us:lista) {
            if(us.getId()==id){
                return  us;
            }

        }
        return null;
    }



}
