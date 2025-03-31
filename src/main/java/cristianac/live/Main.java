package cristianac.live;

import cristianac.live.creators.Jugadores;
import cristianac.live.liga.Equipo;
import cristianac.live.personas.Futbolista;
import cristianac.live.utils.Colors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Futbolista> ConvocarJugadores(Equipo equipo) {
        if (equipo.getJugadores().size() < 11) {
            throw new IllegalArgumentException("Un equipo debe tener al menos 11 jugadores");
        }
        Scanner sc = new Scanner(System.in);
        List<Futbolista> futbolistas = new ArrayList<>(equipo.getNoLesionados());
        List<Futbolista> jugadoresConvocados = new ArrayList<>();

        int convocados = 0;

        while (convocados <= 18) {
            if (futbolistas.isEmpty()) {
                break;
            }
            System.out.print(Colors.PURPLE + "Ingrese el dorsal del jugador que desea convocar: " + Colors.CYAN);
            int dorsal = sc.nextInt();
            Futbolista f = futbolistas.stream().filter(j -> j.getNumero() == dorsal).findFirst().orElse(null);
            if (f == null) {
                if (jugadoresConvocados.stream().anyMatch(e -> e.getNumero() == dorsal)) {
                    System.out.println(Colors.RED + "El jugador con dorsal " + dorsal + " ya ha sido convocado" + Colors.RESET);
                    continue;
                }
                System.out.println(Colors.RED + "El jugador con dorsal " + dorsal + " no existe o está lesionado" + Colors.RESET);
            } else {
                jugadoresConvocados.add(f);
                futbolistas.remove(f);
                convocados++;
            }
            if (f != null) {
                System.out.println(Colors.GREEN + "Jugador ("+Colors.YELLOW_BACKGROUND+Colors.CYAN+ f.getNombre()+Colors.RESET+Colors.GREEN+") convocado" + Colors.RESET);
            }
        }

        return jugadoresConvocados;
    }

    public static void mostrarJugadores(Equipo equipo, Boolean todos) {
        if (todos){
            System.out.println(Colors.WHITE_BACKGROUND + Colors.CYAN + equipo.getNombre() + Colors.RESET);
            List<Futbolista> lesionados = equipo.getLesionados();
            int counter = 0;
            for (Futbolista f : equipo.getJugadores()) {
                if (lesionados.contains(f)) {
                    System.out.print(Colors.YELLOW + f.getNumero() + Colors.PURPLE + " - " + Colors.RED + f.getNombre() + " (Lesionado) " + Colors.RESET);
                } else {
                    System.out.print(Colors.YELLOW + f.getNumero() + Colors.PURPLE + " - " + Colors.BLUE + f.getNombre() + Colors.RESET + " ");
                }
                counter++;
                if (counter % 6 == 0) {
                    System.out.println();
                }

            }
        } else {
            System.out.println(Colors.WHITE_BACKGROUND + Colors.CYAN + equipo.getNombre() + Colors.RESET);
            for (Futbolista f : equipo.getNoLesionados()) {
                System.out.print(Colors.YELLOW + f.getNumero() + Colors.PURPLE + " - " + Colors.BLUE + f.getNombre() + Colors.RESET);
            }
        }
        System.out.println();
    }


}
