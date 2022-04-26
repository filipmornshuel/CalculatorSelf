import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//Ein Taschenrechner selbst mit Java Swing versucht...
public class GUI {
    //Deklarierung von frame, verschiednen Panels und Buttons sowie das Textfeld
    private JFrame frame;
    private JPanel keyPanel;
    private JPanel displayAndKeyPanel;
    private JPanel displayPanel;

    private Vector<JButton> numButtons;
    private JTextField display;

    //Konstruktor mit allen Initialisierungen
    public GUI(){
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        frame = new JFrame();
        frame.setTitle("Taschenrechner");
        keyPanel = new JPanel();
        displayAndKeyPanel= new JPanel();
        numButtons = new Vector<>();

        display = new JTextField();
        displayPanel = new JPanel();
        frame.getContentPane().setLayout(new BorderLayout());
        displayPanel.setLayout(new BorderLayout());
        //display.setEditable(false);
        display.setColumns(3);
        display.setPreferredSize(new Dimension(450, 100));
        display.setFont(font1);
        display.setHorizontalAlignment(JTextField.CENTER);
        //if (display.e)

        frame.setSize(450, 700);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.black);
        jButtons();
        keyPanel.setLayout(new GridLayout(5,5));
        displayAndKeyPanel.setLayout(new BorderLayout());





        //Dem Keypanel alle Buttons von rechts nach links dem Muster vom Taschenrechner von Windows nach, geordnet
        keyPanel.add(numButtons.elementAt(19));
        keyPanel.add(numButtons.elementAt(20));
        keyPanel.add(numButtons.elementAt(13));
        keyPanel.add(numButtons.elementAt(12));
        keyPanel.add(numButtons.elementAt(14));

        keyPanel.add(numButtons.elementAt(21));
        keyPanel.add(numButtons.elementAt(7));
        keyPanel.add(numButtons.elementAt(8));
        keyPanel.add(numButtons.elementAt(9));
        keyPanel.add(numButtons.elementAt(15));

        keyPanel.add(numButtons.elementAt(22));
        keyPanel.add(numButtons.elementAt(4));
        keyPanel.add(numButtons.elementAt(5));
        keyPanel.add(numButtons.elementAt(6));
        keyPanel.add(numButtons.elementAt(16));

        keyPanel.add(numButtons.elementAt(23));
        keyPanel.add(numButtons.elementAt(1));
        keyPanel.add(numButtons.elementAt(2));
        keyPanel.add(numButtons.elementAt(3));
        keyPanel.add(numButtons.elementAt(17));

        keyPanel.add(numButtons.elementAt(24));
        keyPanel.add(numButtons.elementAt(10));
        keyPanel.add(numButtons.elementAt(0));
        keyPanel.add(numButtons.elementAt(11));
        keyPanel.add(numButtons.elementAt(18));



        //Nach allen Elementen einen Actionlistener bzw. Keylistener erzeugt
        for (int i = 0; i < 24; i++) {
            numButtons.elementAt(i).addActionListener(new ActionListener() {
                //In dieser anonyme Klasse verschiedene abfragen gemacht um Richtigkeit der einzelnen Buttons zu gewährleisten
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Tests (JUNIT) folgen noch... und Exceptions müssen noch eingebaut werden...
                    if (e.getActionCommand().equals("C")){
                        display.setText("");
                    }
                    else if(e.getActionCommand().equals("<--")){
                        String string = display.getText();
                        display.setText("");
                        for (int i = 0; i < string.length()-1; i++) {
                            display.setText(display.getText()+string.charAt(i));
                        }
                    }
                    else if(e.getActionCommand().equals("e")) {
                        display.setText("2.7182818284590452353602874713527");
                    }
                    else if(e.getActionCommand().equals("x^2")) {
                        display.setText("2.7182818284590452353602874713527");
                    }
                    else if(e.getActionCommand().equals("x^y")) {
                        display.setText("2.7182818284590452353602874713527");
                    }
                    else if(e.getActionCommand().equals("10^x")) {
                        display.setText("2.7182818284590452353602874713527");
                    }
                    else if(e.getActionCommand().equals("sqrt")) {
                        display.setText("2.7182818284590452353602874713527");
                    }
                    else if(e.getActionCommand().equals("Pi")) {
                        display.setText("3.1415926535897932384626433832795");
                    }
                    else if(e.getActionCommand().equals(".")) {
                        display.setText("num1"+"."+"num2");
                    }
                    else if(e.getActionCommand().equals("=")) {

                    }
                    else if(!e.getActionCommand().equals("<--") || e.getActionCommand().equals("C") || e.getActionCommand().equals("=")) {
                        display.setText(display.getText().concat(e.getActionCommand()));
                    }
                }
            });
            numButtons.elementAt(i).addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    int key = e.getKeyCode();
                    if (key == KeyEvent.VK_SHIFT&&key == KeyEvent.VK_PLUS){
                        display.setText("Morn SHuel");
                    }
                }
                @Override
                public void keyPressed(KeyEvent e) {
                    int key = e.getKeyCode();
                    if (key == KeyEvent.VK_SHIFT&&key == KeyEvent.VK_PLUS){
                        display.setText("Morn SHuel");
                    }
                }
                @Override
                public void keyReleased(KeyEvent e) {
                    int key = e.getKeyCode();
                    if (key == KeyEvent.VK_SHIFT&&key == KeyEvent.VK_PLUS){
                        display.setText("Morn SHuel");
                    }
                }
            });
        }
        //Dem displaypanel das Textfeld hinzugefügt und es mittig platziert
        displayPanel.add(display, BorderLayout.CENTER);
        displayAndKeyPanel.add(keyPanel, BorderLayout.CENTER);
        //Dem Frame alle Panels hinzugefügt
        frame.getContentPane().add(displayAndKeyPanel, BorderLayout.CENTER);
        frame.getContentPane().add(displayPanel, BorderLayout.NORTH);
        //Das Frame sichtbar gemacht
        frame.setVisible(true);
    }

    //Methode zum Hinzufügen von den jeweilgen Knöpfen von 0 bis 10^x
    public void jButtons(){
        for (int i = 0; i < 10; i++) {
            numButtons.add(new JButton(""+i)); //0-9 = 10
        }
        numButtons.add(new JButton("+/-"));//11
        numButtons.add(new JButton("."));//12
        numButtons.add(new JButton("C"));//13
        numButtons.add(new JButton("<--"));//14
        numButtons.add(new JButton("/"));//15
        numButtons.add(new JButton("*"));//16
        numButtons.add(new JButton("-"));//17
        numButtons.add(new JButton("+"));//18
        numButtons.add(new JButton("="));//19
        numButtons.add(new JButton("sqrt"));//20
        numButtons.add(new JButton("Pi"));//21
        numButtons.add(new JButton("e"));//22
        numButtons.add(new JButton("x^2"));//23
        numButtons.add(new JButton("x^y"));//24
        numButtons.add(new JButton("10^x"));//25

        //Entfernen von den kleinen durchgestrichelten Linien um die Zahlen/Symbolen herum...
        for (int i = 0; i < 24; i++) {
            numButtons.elementAt(i).setFocusable(false);
        }
    }
    public void actionListener(){
        //Noch nichts
    }

}
