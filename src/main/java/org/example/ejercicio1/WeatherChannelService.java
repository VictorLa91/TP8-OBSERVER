package org.example.ejercicio1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherChannelService implements ClimaOnline {

    private static final String API_KEY = "11d37e4df57bb37a049408ca44bd25f8";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    @Override
    public String temperatura() {
        try {
            String lat = "-40.8135";
            String lon = "-62.9967";
            String units = "metric"; // Para obtener la temperatura en Celsius
            String urlString = String.format("%s?lat=%s&lon=%s&units=%s&appid=%s", BASE_URL, lat, lon, units, API_KEY);

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                conn.disconnect();

                JSONObject jsonResponse = new JSONObject(content.toString());
                double temp = jsonResponse.getJSONObject("main").getDouble("temp");
                return String.format("%.2f °C", temp);
            } else {
                return "Error: No se pudo obtener la temperatura";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: No se pudo obtener la temperatura";
        }
    }
}
