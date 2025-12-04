package proiect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfataGrafica extends JFrame {

    // Listele cu date (referinte catre listele din Main)
    private ArrayList<Object> listaCondimente;
    private ArrayList<Object> listaOtet;
    private ArrayList<Object> listaSirop;
    private ArrayList<Object> listaDulceata;

    // Componente vizuale
    private JComboBox<String> comboTipProdus;
    private JTextField txtPretMaxim;
    private JTextField txtTara;
    private JTextArea areaAfisare;
    private JButton btnFiltreaza;

    // Filtrele
    private FiltruPret filtruPret = new FiltruPret();
    private FiltruTara filtruTara = new FiltruTara();

    public InterfataGrafica(ArrayList<Object> lc, ArrayList<Object> lo, ArrayList<Object> ls, ArrayList<Object> ld) {
        this.listaCondimente = lc;
        this.listaOtet = lo;
        this.listaSirop = ls;
        this.listaDulceata = ld;

        setTitle("Proiect POO - Gestiune Produse");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- ZONA DE SUS (INPUT) ---
        JPanel panelNord = new JPanel();
        panelNord.setLayout(new GridLayout(4, 2, 10, 10)); // 4 randuri, 2 coloane
        panelNord.setBorder(BorderFactory.createTitledBorder("Filtrare Produse"));

        // 1. Selectare Categorie
        panelNord.add(new JLabel("Alege Categoria:"));
        String[] categorii = {"Condimente", "Otet Balsamic", "Sirop", "Dulceata"};
        comboTipProdus = new JComboBox<>(categorii);
        panelNord.add(comboTipProdus);

        // 2. Input Pret
        panelNord.add(new JLabel("Pret Maxim (0 = ignora):"));
        txtPretMaxim = new JTextField("0");
        panelNord.add(txtPretMaxim);

        // 3. Input Tara
        panelNord.add(new JLabel("Tara Origine (gol = ignora):"));
        txtTara = new JTextField("");
        panelNord.add(txtTara);

        // 4. Buton
        btnFiltreaza = new JButton("FILTREAZA ACUM");
        panelNord.add(new JLabel("")); // Spacer gol
        panelNord.add(btnFiltreaza);

        add(panelNord, BorderLayout.NORTH);

        // --- ZONA DE MIJLOC (AFISARE) ---
        areaAfisare = new JTextArea();
        areaAfisare.setEditable(false);
        areaAfisare.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        // Scroll pane ca sa putem da scroll daca sunt multe produse
        JScrollPane scroll = new JScrollPane(areaAfisare);
        scroll.setBorder(BorderFactory.createTitledBorder("Rezultate"));
        add(scroll, BorderLayout.CENTER);

        // --- LOGICA BUTONULUI ---
        btnFiltreaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                efectueazaFiltrare();
            }
        });

        setVisible(true);
    }

    private void efectueazaFiltrare() {
        areaAfisare.setText(""); // Curatam ecranul
        
        // 1. Identificam ce lista folosim
        String selectie = (String) comboTipProdus.getSelectedItem();
        ArrayList<Object> listaSelectata = new ArrayList<>();

        if (selectie.equals("Condimente")) listaSelectata = listaCondimente;
        else if (selectie.equals("Otet Balsamic")) listaSelectata = listaOtet;
        else if (selectie.equals("Sirop")) listaSelectata = listaSirop;
        else if (selectie.equals("Dulceata")) listaSelectata = listaDulceata;

        // 2. Luam datele din input
        double pretMax = 0;
        try {
            pretMax = Double.parseDouble(txtPretMaxim.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Pretul trebuie sa fie numar!");
            return;
        }
        String taraCautata = txtTara.getText().trim();

        // 3. Aplicam Filtrele (CHAINING - LE STACKAM)
        ArrayList<Object> rezultatIntermediar;
        
        // Daca utilizatorul a scris o tara, filtram dupa tara. Daca nu, luam tot.
        if (!taraCautata.isEmpty()) {
            rezultatIntermediar = filtruTara.filtreazaDupaTara(listaSelectata, taraCautata);
        } else {
            rezultatIntermediar = new ArrayList<>(listaSelectata); // Copie la toata lista
        }

        // Acum filtram rezultatul dupa pret (daca pret > 0)
        ArrayList<Object> rezultatFinal;
        if (pretMax > 0) {
            rezultatFinal = filtruPret.filtreazaDupaPret(rezultatIntermediar, pretMax);
        } else {
            rezultatFinal = rezultatIntermediar;
        }

        // 4. Afisare
        if (rezultatFinal.isEmpty()) {
            areaAfisare.append("Nu s-au gasit produse conform criteriilor.\n");
        } else {
            for (Object obj : rezultatFinal) {
                areaAfisare.append(obj.toString() + "\n--------------------------------------------------\n");
            }
        }
    }
}