package vaccinationService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VaccinationMenu extends JFrame {
    ActionListener listener;
    JPanel vaccinationSubmitPanel;
    JPanel searchVaccinationPanel;
    JPanel datePanel;
    JPanel dateSearchPanel;
    JPanel cityPanel;
    JPanel citySearchPanel;
    JPanel pfizerPanel;
    JPanel modernaPanel;
    JPanel astraZenecaPanel;
    JPanel buttonPanel;
    JPanel resultPanel;
    JPanel reportPanel;

    JTextArea textArea;

    JScrollPane scrollPane;

    JLabel dateLabel;
    JLabel cityLabel;
    JLabel pfizerLabel;
    JLabel modernaLabel;
    JLabel astraZenecaLabel;
    JLabel phizerResultLabel;
    JLabel modernaResultLabel;
    JLabel astraZenecaResultLabel;

    JTextField dateText;
    JTextField searchDateText;
    JTextField cityText;
    JTextField searchCityText;
    JTextField pfizerText;
    JTextField modernaText;
    JTextField astraZenecaText;
    JTextField reportSearch;

    JButton submitButton;
    JButton searchButton;
    JButton generateReport;

    JRadioButton byDate;
    JRadioButton byCity;
    JRadioButton byVaccine;

    String cityName;
    Date date;
    ArrayList<Pfizer> pfizerArrayList = new ArrayList<>();
    ArrayList<Moderna> modernaArrayList = new ArrayList<>();
    ArrayList<AstraZeneca> astraZenecaArrayList = new ArrayList<>();


    VaccinationMenu() {
        setSize(650, 500);
        class ButtonListener implements ActionListener {

            //to create the action listener
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (e.getSource() == submitButton) {
                        submitVaccinationDetails();
                    } else if (e.getSource() == searchButton) {
                        searchVaccineDetails();
                    } else if (e.getSource() == generateReport) {
                        generateVaccineReport();
                    }

                } catch (FileNotFoundException | ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        listener = new ButtonListener();
        createTabbedPane();
    }

    public void createTabbedPane() {
        //this function creates tabs for 3 different things and shows panel respectively for each tab
        JTabbedPane tabPane = new JTabbedPane();

        createPanel("addVaccination");
        createPanel("searchVaccination");
        createPanel("viewByFilter");

        tabPane.addTab("Add Vaccine", null, vaccinationSubmitPanel, "Add Vaccination details");
        tabPane.setMnemonicAt(0, KeyEvent.VK_1);

        tabPane.addTab("Search Vaccine", null, searchVaccinationPanel, "Search Vaccination details");
        tabPane.setMnemonicAt(1, KeyEvent.VK_1);

        tabPane.addTab("View Report", null, reportPanel, "Find reports");
        tabPane.setMnemonicAt(2, KeyEvent.VK_1);

        add(tabPane, BorderLayout.CENTER);
    }

    public void createPanel(String panelType) {
        //this function crates panes for each tab,
        //adds form to the first tab and second tab and radio buttons and jtextarea to the third tab
        if (panelType == "addVaccination") {
            vaccinationSubmitPanel = new JPanel();
            datePanel = new JPanel();
            cityPanel = new JPanel();
            pfizerPanel = new JPanel();
            modernaPanel = new JPanel();
            astraZenecaPanel = new JPanel();
            buttonPanel = new JPanel();

            dateLabel = new JLabel("Date of Vaccination");
            dateText = new JTextField(1);

            cityLabel = new JLabel("Name of city");
            cityText = new JTextField(10);

            pfizerLabel = new JLabel("Number fo Pfizer doses administered: ");
            pfizerText = new JTextField(1);

            modernaLabel = new JLabel("Number fo Moderna doses administered: ");
            modernaText = new JTextField(1);

            astraZenecaLabel = new JLabel("Number fo AstraZeneca doses administered: ");
            astraZenecaText = new JTextField(1);

            submitButton = new JButton("Submit");
            submitButton.addActionListener(listener);

            datePanel.add(dateLabel);
            datePanel.add(dateText);

            cityPanel.add(cityLabel);
            cityPanel.add(cityText);

            pfizerPanel.add(pfizerLabel);
            pfizerPanel.add(pfizerText);

            modernaPanel.add(modernaLabel);
            modernaPanel.add(modernaText);

            astraZenecaPanel.add(astraZenecaLabel);
            astraZenecaPanel.add(astraZenecaText);

            buttonPanel.add(submitButton);

            //sets grid layout to display label on one side and the input area on the right side.
            datePanel.setLayout(new GridLayout(1, 2));
            cityPanel.setLayout(new GridLayout(1, 2));
            pfizerPanel.setLayout(new GridLayout(1, 2));
            modernaPanel.setLayout(new GridLayout(1, 2));
            astraZenecaPanel.setLayout(new GridLayout(1, 2));

            vaccinationSubmitPanel.add(datePanel);
            vaccinationSubmitPanel.add(cityPanel);
            vaccinationSubmitPanel.add(pfizerPanel);
            vaccinationSubmitPanel.add(modernaPanel);
            vaccinationSubmitPanel.add(astraZenecaPanel);
            vaccinationSubmitPanel.add(buttonPanel);

            vaccinationSubmitPanel.setLayout(new GridLayout(6, 2));


        } else if (panelType == "searchVaccination") {
            searchVaccinationPanel = new JPanel();
            dateSearchPanel = new JPanel();
            citySearchPanel = new JPanel();
            buttonPanel = new JPanel();
            resultPanel = new JPanel();

            searchButton = new JButton("Search");
            searchButton.addActionListener(listener);

            dateLabel = new JLabel("Date of Vaccination");
            searchDateText = new JTextField(1);

            cityLabel = new JLabel("Name of city");
            searchCityText = new JTextField(10);

            phizerResultLabel = new JLabel("Number of Phizer doses administered: ");
            modernaResultLabel = new JLabel("Number of Moderna doses administered: ");
            astraZenecaResultLabel = new JLabel("Number of AstraZeneca doses administered: ");

            dateSearchPanel.add(dateLabel);
            dateSearchPanel.add(searchDateText);

            citySearchPanel.add(cityLabel);
            citySearchPanel.add(searchCityText);

            buttonPanel.add(searchButton);

            resultPanel.add(phizerResultLabel);
            resultPanel.add(modernaResultLabel);
            resultPanel.add(astraZenecaResultLabel);

            dateSearchPanel.setLayout(new GridLayout(1, 2));
            citySearchPanel.setLayout(new GridLayout(1, 2));
            resultPanel.setLayout(new GridLayout(3, 1));

            searchVaccinationPanel.add(dateSearchPanel);
            searchVaccinationPanel.add(citySearchPanel);
            searchVaccinationPanel.add(buttonPanel);
            searchVaccinationPanel.add(resultPanel);

            searchVaccinationPanel.setLayout(new GridLayout(4, 2));
        } else {
            //this part is to generate the report depending on the search criteria
            reportPanel = new JPanel();
            generateReport = new JButton("Generate Report");
            generateReport.addActionListener(listener);

            reportSearch = new JTextField(10);


            byDate = new JRadioButton("By Date");
            byCity = new JRadioButton("By City");
            byVaccine = new JRadioButton("By Vaccine");


            textArea = new JTextArea(25, 60);
            JScrollPane scrollPane = new JScrollPane(textArea);
            setPreferredSize(new Dimension(450, 110));

            reportPanel.add(byDate);
            reportPanel.add(byCity);
            reportPanel.add(byVaccine);
            reportPanel.add(reportSearch);
            reportPanel.add(generateReport);
            reportPanel.add(scrollPane, BorderLayout.CENTER);
        }

    }

    public void submitVaccinationDetails() throws FileNotFoundException, ParseException {
        //checks validation for the form
        if (dateText.getText().isEmpty() || cityText.getText().isEmpty() || pfizerText.getText().contains("-") ||
                modernaText.getText().contains("-") || astraZenecaText.getText().contains("-")) {
            JOptionPane.showMessageDialog(this, "Please enter correct data",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            //if all good adds respective number of objects of the vaccine to the arraylist and then display the size of array
            date = new SimpleDateFormat("dd/mm/yy").parse(dateText.getText());

            for (int i = 0; i < Integer.parseInt(pfizerText.getText()); i++) {
                pfizerArrayList.add(new Pfizer(date, cityText.getText()));
            }

            for (int i = 0; i < Integer.parseInt(modernaText.getText()); i++) {
                modernaArrayList.add(new Moderna(date, cityText.getText()));
            }

            for (int i = 0; i < Integer.parseInt(astraZenecaText.getText()); i++) {
                astraZenecaArrayList.add(new AstraZeneca(date, cityText.getText()));
            }

            File file = new File("src/vaccinationService/vaccinationDetails.txt");
            PrintWriter writer = new PrintWriter(file);
            writer.println("Date:" + dateText.getText());
            writer.println("City: " + cityText.getText());
            writer.println("Number of Pfizer doeses administered: " + pfizerText.getText());
            writer.println("Number of Moderna doeses administered: " + modernaText.getText());
            writer.println("Number of AstraZeneca doeses administered: " + astraZenecaText.getText());

            JOptionPane.showMessageDialog(this, "Saved vaccine details for " +
                    cityText.getText() + " on " +
                    date, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

            writer.close();
        }
    }

    public void searchVaccineDetails() throws ParseException {
        //search vaccination based on the city name and the date. So filters the array based on condition and display
        //the size of the filtered array.

        date = new SimpleDateFormat("dd/mm/yy").parse(searchDateText.getText());

        ArrayList<Pfizer> filteredPfizer = new ArrayList<>();
        ArrayList<Moderna> filteredModerna = new ArrayList<>();
        ArrayList<AstraZeneca> filteredAstraZeneca = new ArrayList<>();

        System.out.println(searchCityText.getText());

        pfizerArrayList.forEach(dose -> {
            if (dose.getCityName().equalsIgnoreCase(searchCityText.getText())
                    && dose.getVaccinationDate().equals(date)) {
                filteredPfizer.add(dose);
            }
        });

        modernaArrayList.forEach(dose -> {
            if (dose.getCityName().equalsIgnoreCase(searchCityText.getText())
                    && dose.getVaccinationDate().equals(date)) {
                filteredModerna.add(dose);
            }
        });

        astraZenecaArrayList.forEach(dose -> {
            if (dose.getCityName().equalsIgnoreCase(searchCityText.getText())
                    && dose.getVaccinationDate().equals(date)) {
                filteredAstraZeneca.add(dose);
            }
        });

        phizerResultLabel.setText("Number of Pfizer doeses administered: " + filteredPfizer.size());
        modernaResultLabel.setText("Number of Moderna doeses administered: " + filteredModerna.size());
        astraZenecaResultLabel.setText("Number of AstraZeneca doeses administered: " + filteredAstraZeneca.size());

        resultPanel.revalidate();

    }

    public void generateVaccineReport() throws ParseException {
        //generates the report for the vaccine based on the chosen criteria
        textArea.removeAll();
        String searchCriteria = reportSearch.getText();
        if (byDate.isSelected()) {
            date = new SimpleDateFormat("dd/mm/yy").parse(searchCriteria);
            pfizerArrayList.forEach(dose -> {
                if (dose.getVaccinationDate().equals(date)) {
                    textArea.append(dose.toString());
                }
            });
            modernaArrayList.forEach(dose -> {
                if (dose.getVaccinationDate().equals(date)) {
                    textArea.append(dose.toString());
                }
            });
            astraZenecaArrayList.forEach(dose -> {
                if (dose.getVaccinationDate().equals(date)) {
                    textArea.append(dose.toString());
                }
            });
        } else if (byCity.isSelected()) {
            pfizerArrayList.forEach(dose -> {
                if (dose.getCityName().equals(searchCriteria)) {
                    textArea.append(dose.toString());
                }
            });
            modernaArrayList.forEach(dose -> {
                if (dose.getCityName().equals(searchCriteria)) {
                    textArea.append(dose.toString());
                }
            });
            astraZenecaArrayList.forEach(dose -> {
                if (dose.getCityName().equals(searchCriteria)) {
                    textArea.append(dose.toString());
                }
            });
        } else {
            if (searchCriteria.equalsIgnoreCase("pfizer")) {
                pfizerArrayList.forEach(dose -> textArea.append(dose.toString()));
            } else if (searchCriteria.equalsIgnoreCase("moderna")) {
                modernaArrayList.forEach(dose -> textArea.append(dose.toString()));
            } else {
                astraZenecaArrayList.forEach(dose -> textArea.append(dose.toString()));
            }
        }
    }

}
