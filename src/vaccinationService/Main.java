package vaccinationService;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame myFrame = new VaccinationMenu();
        myFrame.setTitle("Vaccination Menu");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
}
