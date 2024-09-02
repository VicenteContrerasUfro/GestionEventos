package org.example;

public class Evento {
    public String[][] matrizEventos;
    private final int aforoVIP = 10;
    private final int aforoGeneral = 10;

    public Evento() {
        this.matrizEventos = new String[10][5];
        matrizEventos[0] = new String[]{"Felipe Iturra", "22", "General", "0", "False"};
        matrizEventos[1] = new String[]{"Gabriela Jara", "19", "VIP", "2", "False"};
        matrizEventos[2] = new String[]{"Carlos Diaz", "17", "False", "0", "False"};
        matrizEventos[3] = new String[]{"Vicente Torres", "30", "General", "0", "False"};
        matrizEventos[4] = new String[]{"Luis Perez", "25", "VIP", "2", "False"};

    }

    public boolean verificarEdad(int fila) {
        int edad = Integer.parseInt(matrizEventos[fila][1]);
        return edad >= 18;
    }

    public String verificarBoleto(int fila) {
        return matrizEventos[fila][2];
    }

    public boolean validarInvitados(int fila) {
        if (matrizEventos[fila][2].equals("VIP")) {
            int invitados = Integer.parseInt(matrizEventos[fila][3]);
            return invitados >= 0 && invitados <= 2;
        }
        return true;
    }

    public int aforoDisponible(String sala) {
        int ocupadas = 0;
        for (String[] persona : matrizEventos) {
            if (persona[4] != null && persona[4].equals("True") && persona[2].equals(sala)) {
                ocupadas++;
                if (sala.equals("VIP")) {
                    ocupadas += Integer.parseInt(persona[3]);
                }
            }
        }

        if (sala.equals("VIP")) {
            return aforoVIP - ocupadas;
        } else {
            return aforoGeneral - ocupadas;
        }
    }

    public void ingresarPersona(int fila) {
        matrizEventos[fila][4] = "True";
    }

    public boolean permitirEntrada(int fila) {
        if (!verificarEdad(fila)) {
            return false;
        }

        String tipoEntrada = verificarBoleto(fila);
        if (!tipoEntrada.equals("General") && !tipoEntrada.equals("VIP")) {
            return false;
        }

        String sala = tipoEntrada.equals("VIP") ? "VIP" : "General";
        int aforoRestante = aforoDisponible(sala);

        if (aforoRestante <= 0) {
            return false;
        }

        if (tipoEntrada.equals("VIP") && !validarInvitados(fila)) {
            return false;
        }

        ingresarPersona(fila);
        return true;
    }

    public void removerPersona(int fila) {
        if (matrizEventos[fila][2].equals("VIP")) {
            int invitados = Integer.parseInt(matrizEventos[fila][3]);
            matrizEventos[fila][4] = "False";
        } else {
            matrizEventos[fila][4] = "False";
        }
    }
}
