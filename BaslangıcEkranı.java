import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BaslangıcEkranı extends JFrame {
    JFrame frame;
    JLabel displayField;
    ImageIcon image;
    JButton button;
    Image scaledImage;
    JLayeredPane layeredPane;


    //main menu
    public BaslangıcEkranı() {
        frame= new JFrame("Image Display Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layeredPane = new JLayeredPane();
        frame.add(layeredPane,BorderLayout.CENTER);
        try {
            image = new ImageIcon(getClass().getResource("/resources/logo.png"));
            displayField = new JLabel(image);
            displayField.setBounds(-20,-40,image.getIconWidth(),image.getIconHeight());
            layeredPane.add(displayField, Integer.valueOf(1));
        } catch (Exception e) {
            System.out.println("Image cannot be found");
        }

        //start butonu oluşturma ve ayarlama
        button= new JButton();
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/resources/start_butonu.jfif"));

        scaledImage = originalIcon.getImage().getScaledInstance(80,95, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        button.setIcon(scaledIcon);

        button.setBounds((displayField.getWidth() - 100) / 2, displayField.getHeight() - 100, 100, 50);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        layeredPane.add(button, Integer.valueOf(2));

        frame.setSize(image.getIconWidth(), image.getIconHeight());
        frame.setVisible(true);

        // butona basıldığında oyun ekranını açma başlangıç ekranını kapatma
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Oyun ekranını açacak ve oyunu başlatacak kodlar
                OyunEkrani oyunEkrani = new OyunEkrani(); // OyunEkrani sınıfınızın bir örneğini oluşturun
                oyunEkrani.setVisible(true); // Oyun ekranını görünür yapın
                frame.setVisible(false); // Mevcut başlangıç ekranını gizleyin
            }
        });
    }

}

