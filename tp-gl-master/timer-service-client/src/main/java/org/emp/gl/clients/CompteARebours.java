package org.emp.gl.clients;

import java.beans.PropertyChangeEvent;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;

public class CompteARebours implements TimerChangeListener {

    private final String name;
    private final TimerService timerService;
    private int compteur;

    public CompteARebours(String name, int valeurInitiale) {
        this.name = name;
        this.compteur = valeurInitiale;

        this.timerService = new DummyTimeServiceImpl();
        timerService.addTimeChangeListener(this);

        System.out.println("Compte à rebours " + name + " initialisé à " + compteur + " secondes.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (TimerChangeListener.SECONDE_PROP.equals(evt.getPropertyName())) {
            if (compteur >= 0) {
                System.out.println(name + " : " + compteur);
                compteur--;
            }
            if (compteur < 0) {
                System.out.println(name + " terminé !");
                timerService.removeTimeChangeListener(this);
            }
        }
    }
}
