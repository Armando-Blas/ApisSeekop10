package net.sicopweb.models;


import org.json.JSONObject;

import java.time.Instant;


public class Servidor {
    // Constructor vacío
    public Servidor() {
    }

    // Método estático para crear un objeto Servidor a partir de un JSONObject
    public static Servidor fromJSONObject(JSONObject jsonObject) {
        Servidor servidor = new Servidor();
        servidor.idservidor = jsonObject.optString("idservidor", null);
        servidor.nombre = jsonObject.optString("nombre", null);
        servidor.conexionescritura = jsonObject.optString("conexionescritura", null);
        servidor.conexionlectura = jsonObject.optString("conexionlectura", null);
        servidor.user = jsonObject.optString("user", null);
        servidor.password = jsonObject.optString("password", null);
        servidor.activo = jsonObject.optBoolean("activo", false);
        //servidor.idregistro = jsonObject.optString("idregistro", null);
        // Se debe convertir el valor de registro a Instant si es necesario
        //servidor.registro = Instant.parse(jsonObject.optString("registro", null));
        //servidor.idmodificado = jsonObject.optString("idmodificado", null);
        // Se debe convertir el valor de modificado a Instant si es necesario
        //ervidor.modificado = Instant.parse(jsonObject.optString("modificado", null));
        return servidor;
    }

    private String idservidor;
    private String nombre;

    private String conexionescritura;

    private String conexionlectura;

    private String user;

    private String password;

    private Boolean activo = false;

    private String idregistro;

    private Instant registro;
    private String idmodificado;

    private Instant modificado;

    public String getIdservidor() {
        return idservidor;
    }

    public void setIdservidor(String idservidor) {
        this.idservidor = idservidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConexionescritura() {
        return conexionescritura;
    }

    public void setConexionescritura(String conexionescritura) {
        this.conexionescritura = conexionescritura;
    }

    public String getConexionlectura() {
        return conexionlectura;
    }

    public void setConexionlectura(String conexionlectura) {
        this.conexionlectura = conexionlectura;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(String idregistro) {
        this.idregistro = idregistro;
    }

    public Instant getRegistro() {
        return registro;
    }

    public void setRegistro(Instant registro) {
        this.registro = registro;
    }

    public String getIdmodificado() {
        return idmodificado;
    }

    public void setIdmodificado(String idmodificado) {
        this.idmodificado = idmodificado;
    }

    public Instant getModificado() {
        return modificado;
    }

    public void setModificado(Instant modificado) {
        this.modificado = modificado;
    }

}