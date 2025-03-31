package cristianac.live.creators;

import cristianac.live.liga.Equipo;
import cristianac.live.personas.Futbolista;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.*;

public class Jugadores {
    private List<Futbolista> jugadores = new ArrayList<>();
    private List<Equipo> equipos = new ArrayList<>();

    public Jugadores() {
        // Load futbolistas from JSON file
        try {
            readFutbolistas();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo de jugadores");
        }
    }

    // Read futbolistas from JSON file
    private void readFutbolistas() throws FileNotFoundException {
        try (FileReader fr = new FileReader("src/main/resources/datos.json")) {
            JSONTokener tokener = new JSONTokener(fr);
            JSONObject json = new JSONObject(tokener);
            JSONArray jsonArray = json.getJSONArray("jugadores");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String nombre = jsonObject.getString("nombre");
                String dni = jsonObject.getString("dni");
                int edad = jsonObject.getInt("edad");
                int numero = jsonObject.getInt("numero");
                String posicion = jsonObject.getString("posicion");
                int num_lesiones = jsonObject.getInt("num_lesiones");
                float resistencia_inicial = jsonObject.getInt("resistencia_inicial");
                jugadores.add(new Futbolista(nombre, dni, edad, numero, posicion, num_lesiones, resistencia_inicial));
                String nombre_equipo = jsonObject.getString("equipo");
                Equipo equipo = equipos.stream().filter(e -> e.getNombre().equals(nombre_equipo)).findFirst().orElse(null);
                if (equipo == null) {
                    equipo = new Equipo(nombre_equipo, "Mundo", null, null, new ArrayList<>());
                    equipos.add(equipo);
                }
            }
        } catch (IOException e) {
            throw new FileNotFoundException("No se ha encontrado el archivo de jugadores");
        }
    }

    static {
        new Jugadores();
    }

    public List<Futbolista> getJugadores() {
        return jugadores;
    }


}
