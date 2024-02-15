package net.sicopweb;

import net.sicopweb.models.Servidor;
import net.sicopweb.service.DataSourceService;

public class Main {
    public static void main(String[] args) {
        DataSourceService dataSourceService = new DataSourceService();
        Servidor servidor = dataSourceService.obtenerMensaje("BDD00");
        System.out.println(servidor.getPassword());
    }
}