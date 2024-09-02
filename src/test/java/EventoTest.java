import org.example.Evento;
import org.junit.Test;

public class EventoTest {
   @Test
    public void main() {
        Evento evento = new Evento();

        // 1
        System.out.println("Verificar edad de fila 0: " + evento.verificarEdad(0)); // true

        // 2
        System.out.println("Verificar boleto de fila 1: " + evento.verificarBoleto(1)); // VIP

        // 3
        System.out.println("Validar invitados de fila 1: " + evento.validarInvitados(1)); // true

        // 4
        System.out.println("Aforo disponible en sala VIP: " + evento.aforoDisponible("VIP")); // 10

        // 5
        System.out.println("Permitir entrada de fila 1: " + evento.permitirEntrada(1)); // true

        // 6
        System.out.println("Persona en fila 1 ingresada: " + evento.matrizEventos[1][4]); // True

        // 7
        evento.removerPersona(1);
        System.out.println("Persona en fila 1 después de remover: " + evento.matrizEventos[1][4]); // False
    }
}

