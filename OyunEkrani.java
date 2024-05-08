import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class OyunEkrani extends JFrame {
    private ArrayList<String> sorular;
    private JPanel soruPaneli;
    public ArrayList<String> karakterler;
    public int secilenKarakterIndex;
    private ArrayList<JButton> karakterButonlari = new ArrayList<>();
    private ArrayList<JButton> soruButonları = new ArrayList<>();
    private JLabel soruEtiketi;

    public OyunEkrani() {
        //karakter listesi methodunu çağırma
        fillCharacterList();
        setTitle("Oyun Ekranı");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        initializeGame();

        //Arka plan ayarlama
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/resources/background.jpg"));
        JLabel backgroundLabel = new JLabel(backgroundImage);
        add(backgroundLabel, BorderLayout.CENTER);
        backgroundLabel.setLayout(new BorderLayout());

        // Karakterleri ve karakter butonlarını oluştma ve ekleme
        JPanel karakterPaneli = new JPanel(new GridLayout(0, 4, 10, 10));
        karakterPaneli.setOpaque(false);
        karakterButonlari = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            JLayeredPane layeredPane = new JLayeredPane();
            layeredPane.setPreferredSize(new Dimension(250, 300)); // Set this to the size of your character images

            ImageIcon frontImage = new ImageIcon(getClass().getResource("/karakterler/karakter_" + (i + 1) + ".png"));
            ImageIcon backImage = new ImageIcon(getClass().getResource("/resources/back_layer.png")); // Replace with your back image path
            JLabel frontLabel = new JLabel(frontImage);
            JLabel backLabel = new JLabel(backImage);
            frontLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            frontLabel.setBounds(10, 10, frontImage.getIconWidth(), frontImage.getIconHeight());
            backLabel.setBounds(10, 10, backImage.getIconWidth(), backImage.getIconHeight());

            layeredPane.add(frontLabel, JLayeredPane.DEFAULT_LAYER);
            layeredPane.add(backLabel, JLayeredPane.PALETTE_LAYER);
            backLabel.setVisible(false); // Initially, the back label is not visible

            JButton karakterButonu = createGuessButton(i, frontLabel, backLabel);
            karakterButonu.setBounds(50, 220, karakterButonu.getPreferredSize().width, karakterButonu.getPreferredSize().height); // Adjust position as needed
            layeredPane.add(karakterButonu, JLayeredPane.MODAL_LAYER);

            karakterPaneli.add(layeredPane);
            karakterButonlari.add(karakterButonu);

            //flip effect methodunu çağırma
            addFlipEffect(frontLabel, backLabel);
        }

        backgroundLabel.add(karakterPaneli, BorderLayout.CENTER);

        // Restart game butonunu oluşturma
        JButton restartButton = new JButton("Restart Game");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        add(restartButton, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    //karakterelri tanımladığımız method
    public void fillCharacterList() {
        karakterler = new ArrayList<>();
        karakterler.add("Jason");
        karakterler.add("Telly");
        karakterler.add("Opus");
        karakterler.add("Umberto");
        karakterler.add("Gina");
        karakterler.add("Celia");
        karakterler.add("Edith");
        karakterler.add("Finnian");
    }

    // tahmin butonlarını oluşturma ve üstüne its me imagesini ekleme
    private JButton createGuessButton(int karakterIndex, JLabel frontLabel, JLabel backLabel) {
        ImageIcon image = new ImageIcon(getClass().getResource("/resources/start_butonu.jfif"));
        Image scaledImage = image.getImage().getScaledInstance(80, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JButton karakterButonu = new JButton(scaledIcon);

        //tahiminin doğru veya yanlış olduğunu kullanıcıya bildirme
        karakterButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (karakterIndex == secilenKarakterIndex) {
                    JOptionPane.showMessageDialog(null, "Doğru tahmin!");
                    frontLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                } else {
                    JOptionPane.showMessageDialog(null, "Yanlış tahmin!");
                    frontLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                }
                backLabel.setVisible(true);
                frontLabel.setVisible(false);
            }
        });
        karakterButonu.setBounds(15, frontLabel.getHeight() + 10, 80, 30);
        return karakterButonu;
    }

    //karakterlerin üstüne basarak eleme yapma
    private void addFlipEffect(JLabel frontLabel, JLabel backLabel) {
        MouseAdapter flipListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (frontLabel.isVisible()) {
                    frontLabel.setVisible(false);
                    backLabel.setVisible(true);
                } else {
                    frontLabel.setVisible(true);
                    backLabel.setVisible(false);
                }
            }
        };
        frontLabel.addMouseListener(flipListener);
        backLabel.addMouseListener(flipListener);
    }

    // oyunun başlangıcında soruları tanımlayan ve karıştıran method
    private void initializeGame() {
        // Randomly select a character
        Random rnd = new Random();
        secilenKarakterIndex = rnd.nextInt(karakterler.size());

        // Shuffle the questions
        sorular = new ArrayList<>();
        sorular.add("Karakterin başında şapka var mı?");
        sorular.add("Karakter mor renkli mi?");
        sorular.add("Karakterin burnu var mı?");
        sorular.add("Karakter kız mı?");
        sorular.add("Karakterin iki gözünden fazlası var mı?");
        Collections.shuffle(sorular);

        // Set the initial text for the question label
        soruEtiketi = new JLabel(" ");
        soruPaneli = new JPanel(new FlowLayout());
        soruPaneli.setOpaque(false);
        soruPaneli.add(soruEtiketi);
        add(soruPaneli, BorderLayout.NORTH);

        // Create and add the question buttons
        soruButonları.clear(); // Clear the previous list to avoid duplicates
        for (int i = 0; i < 3; i++) {
            JButton soruButonu = getsoruButonu(i);
            soruPaneli.add(soruButonu);
            soruButonları.add(soruButonu);
        }

        // Set the initial visibility of character buttons
        setCharacterButtonVisibility(true);
    }

    // yeni oyun oluşturan method
    private void resetGame() {
        dispose();

        OyunEkrani yeniOyunEkrani = new OyunEkrani();
        yeniOyunEkrani.setVisible(true);

    }

    //soru butonlarına soruları atayan method
    private JButton getsoruButonu(int i) {
        JButton soruButonu = new JButton("Soru " + (i + 1));
        int finalI = i;
        soruButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KarakterSorulari karakterSorulari = new KarakterSorulari();
                fillCharacterList();
                if (secilenKarakterIndex < karakterler.size()) {
                    String cevap = karakterSorulari.soruyaCevapVer(karakterler.get(secilenKarakterIndex), sorular.get(finalI));
                    soruEtiketi.setText(sorular.get(finalI) + " : " + cevap);
                } else {
                    soruEtiketi.setText("Liste boyutları dışında bir indeks seçildi.");
                }
            }
        });
        return soruButonu;
    }
    private void setCharacterButtonVisibility(boolean visible) {
        for (JButton button : karakterButonlari) {
            button.setVisible(visible);
        }
    }
}

