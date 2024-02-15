package net.sicopweb.service;

import net.sicopweb.models.Servidor;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Servicio para obtener mensajes en diferentes idiomas.
 */
public class DataSourceService {


    /**
     * Método para obtener un mensaje en el idioma y país configurados.
     *
     * @param idBD Identificador de la base de datos.
     * @return Mensaje traducido.
     */
    public Servidor obtenerMensaje(String idBD) {
        try {
            // Construir la URL con los argumentos
            Servidor servidor = new Servidor();
            String url = construirUrl(idBD);
            System.out.println(url);

            // Crear una conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

            // Configurar la solicitud como GET
            connection.setRequestMethod("GET");

            // Obtener la respuesta
            int responseCode = connection.getResponseCode();

            // Leer la respuesta
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                System.out.println("Peticion Exitosa obtenerMensaje: " + " - " + response.toString());

                // Analizar la respuesta JSON
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONObject servidorJson = jsonResponse.optJSONObject("response");

                // Obtener el valor de la propiedad "response"
                servidor = Servidor.fromJSONObject(servidorJson);

            } else {
                System.out.println("Error en la solicitud. Código de respuesta: " + responseCode);
            }
            connection.disconnect();
            return servidor;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método para construir la URL con los argumentos.
     *
     * @param idBD Identificador Base de datos para la URL.
     * @return URL construida.
     */
    private String construirUrl(String idBD) {
        String dominio = "seekop10.sicopweb.net";
        String local = "localhost:8080";
        return "http://" + dominio + "/api/10.0.0/api-datasorces/search-bd/idbd=" + idBD;
    }
}
