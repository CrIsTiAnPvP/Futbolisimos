package cristianac.live.liga;

import cristianac.live.personas.Futbolista;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partido {

    private List<Equipo> equipos;
    private Equipo equipoLoc;
    private Equipo equipoVis;
    private Map<Futbolista, Integer> golesLoc;
    private Map<Futbolista, Integer> golesVis;

    public Partido(List<Equipo> equipos) {
        if (equipos.size() != 2) {
            throw new IllegalArgumentException("Un partido debe tener dos equipos");
        } else if (equipos.get(0) == equipos.get(1)) {
            throw new IllegalArgumentException("Un partido no se puede jugar contra el mismo equipo");
        }
        this.equipos = equipos;
        this.equipoLoc = equipos.getFirst();
        this.equipoVis = equipos.getLast();
        this.golesLoc = new HashMap<>();
        this.golesVis = new HashMap<>();
    }

    // Getters
    public List<Equipo> getEquipos() { return equipos; }
    public Equipo getLocal() { return equipoLoc; }
    public Equipo getVisitante() { return equipoVis; }
    public Map<Futbolista, Integer> getGolLocal() { return golesLoc; }
    public Map<Futbolista, Integer> getGolVisitante() { return golesVis; }
}
