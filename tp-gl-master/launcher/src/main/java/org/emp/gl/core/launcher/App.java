package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge;
import org.emp.gl.clients.CompteARebours;

public class App {

    public static void main(String[] args) {
        testDuTimeService();
    }

    private static void testDuTimeService() {
        Horloge h1 = new Horloge("Horloge 1");
        Horloge h2 = new Horloge("Horloge 2");

        CompteARebours c1 = new CompteARebours("Rebours 1", 5);

        // Exemple : plusieurs comptes à rebours aléatoires
        for (int i = 0; i < 3; i++) {
            new CompteARebours("Rebours " + i, 10 + (int) (Math.random() * 10));
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
