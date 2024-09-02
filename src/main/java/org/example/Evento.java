package org.example;

public class Evento {
    public String[][] matrizEventos;

    public Evento() {
        this.matrizEventos = new String[10][5];
        matrizEventos[0] = new String[]{"Felipe Iturra", "22", "General", "0", "False"};
        matrizEventos[1] = new String[]{"Gabriela Jara", "19", "VIP", "2", "False"};
        matrizEventos[2] = new String[]{"Carlos Diaz", "17", "False", "0", "False"};
        matrizEventos[3] = new String[]{"Vicente Torres", "30", "General", "0", "False"};
        matrizEventos[4] = new String[]{"Luis Perez", "25", "VIP", "2", "False"};
    }

    // 1
    public boolean verificarEdad(int fila) {
        int edad = Integer.parseInt(matrizEventos[fila][1]);
        return edad >= 18;
    }

    // 2
    public String verificarBoleto(int fila) {
        return matrizEventos[fila][2];
    }

    // 3
    public boolean validarInvitados(int fila) {
        if (matrizEventos[fila][2].equals("VIP")) {
            int invitados = Integer.parseInt(matrizEventos[fila][3]);
            return invitados >= 0 && invitados <= 2;
        }
        return true;
    }

    // 4
    public int aforoDisponible(String sala) {
        int aforoMaximo = 10;
        int ocupadas = 0;
        return aforoMaximo - ocupadas;
    }

    // 5
    public void ingresarPersona(int fila) {
        matrizEventos[fila][4] = "True";
    }

    // 6
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

        if (tipoEntrada.equals("VIP")) {
            if (!validarInvitados(fila)) {
                return false;
            }
        }

        ingresarPersona(fila);
        return true;
    }

    // 7
    public void removerPersona(int fila) {
        if (matrizEventos[fila][2].equals("VIP")) {
            int invitados = Integer.parseInt(matrizEventos[fila][3]);
            for (int i = 0; i <= invitados; i++) {
                matrizEventos[fila + i][4] = "False";
            }
        } else {
            matrizEventos[fila][4] = "False";
        }
    }

}