import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Łukasz on 2016-06-07.
 */
public class FontTester
{
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FontTester();
            }
        });
    }

    JFrame mainWindow = new JFrame();

    JPanel mainPanel = new JPanel();
    JPanel fontStyleSelectionPanel = new JPanel();
    JPanel fontSizeSelectionPanel = new JPanel();
    JPanel fontNameSelectionPanel = new JPanel();

    JLabel mainLabelText = new JLabel("Tekst do przetestowania.");

    JCheckBox boldCheckBox = new JCheckBox("Pogrubienie");
    JCheckBox italicCheckBox = new JCheckBox("Kursywa");

    JRadioButton smallRadioButton = new JRadioButton("Mała");
    JRadioButton mediumRadioButton = new JRadioButton("Średnia");
    JRadioButton bigRadioButton = new JRadioButton("Duża");
    JRadioButton extraRadioButton = new JRadioButton("XXL");
    ButtonGroup fontSizeGroup = new ButtonGroup();

    JComboBox<String> fontNameBox = new JComboBox<>();

    LayoutManager lManager = new GridBagLayout();
    GridBagConstraints GBC = new GridBagConstraints();

    int mainStyle = Font.PLAIN;
    int mainSize = 18;
    String mainFontName = "Arial";
    Font mainFont = new Font(mainFontName, mainStyle, mainSize);

    Toolkit mainToolkit = Toolkit.getDefaultToolkit();

    FontTester() {
        Dimension resolution = mainToolkit.getScreenSize();
        mainWindow.setLocation((int)resolution.getWidth()/2 - 150 , (int)resolution.getHeight()/2 - 150);
        mainWindow.setSize(new Dimension(300, 300));
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setTitle("Tester czcionek");
        mainWindow.setResizable(false);
        mainWindow.setVisible(true);

        mainLabelText.setHorizontalTextPosition(SwingConstants.CENTER);
        mainLabelText.setFont(mainFont);

        mainPanel.setPreferredSize(new Dimension(300, 150));
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.add(mainLabelText);

        fontStyleSelectionPanel.setLayout(new FlowLayout());
        fontStyleSelectionPanel.add(boldCheckBox);
        fontStyleSelectionPanel.add(italicCheckBox);
        fontStyleSelectionPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2), "Styl czcionki"));
        fontStyleSelectionPanel.setPreferredSize(new Dimension(300, 60));

        boldCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (boldCheckBox.isSelected()) {
                    mainStyle += Font.BOLD;
                } else {
                    mainStyle -= Font.BOLD;
                }
                mainFont = new Font(mainFontName, mainStyle, mainSize);
                mainLabelText.setFont(mainFont);
            }
        });

        italicCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (italicCheckBox.isSelected()) {
                    mainStyle += Font.ITALIC;
                } else {
                    mainStyle -= Font.ITALIC;
                }
                mainFont = new Font(mainFontName, mainStyle, mainSize);
                mainLabelText.setFont(mainFont);
            }
        });

        fontSizeGroup.add(smallRadioButton);
        fontSizeGroup.add(mediumRadioButton);
        fontSizeGroup.add(bigRadioButton);
        fontSizeGroup.add(extraRadioButton);

        smallRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainSize = 15;
                mainFont = new Font(mainFontName, mainStyle, mainSize);
                mainLabelText.setFont(mainFont);
            }
        });

        mediumRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainSize = 18;
                mainFont = new Font(mainFontName, mainStyle, mainSize);
                mainLabelText.setFont(mainFont);
            }
        });

        bigRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainSize = 21;
                mainFont = new Font(mainFontName, mainStyle, mainSize);
                mainLabelText.setFont(mainFont);
            }
        });

        extraRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainSize = 24;
                mainFont = new Font(mainFontName, mainStyle, mainSize);
                mainLabelText.setFont(mainFont);
            }
        });

        fontSizeSelectionPanel.setLayout(new FlowLayout());
        fontSizeSelectionPanel.add(smallRadioButton);
        fontSizeSelectionPanel.add(mediumRadioButton);
        fontSizeSelectionPanel.add(bigRadioButton);
        fontSizeSelectionPanel.add(extraRadioButton);
        fontSizeSelectionPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2), "Rozmiar czcionki"));
        fontSizeSelectionPanel.setPreferredSize(new Dimension(300, 60));

        fontNameBox.addItem("Arial");
        fontNameBox.addItem("Baghdad");
        fontNameBox.addItem("Century");
        fontNameBox.addItem("Dialog");
        fontNameBox.addItem("Futura");
        fontNameBox.addItem("Helvetica");
        fontNameBox.addItem("MS Gothic");
        fontNameBox.addItem("SansSerif");
        fontNameBox.addItem("Stencil");
        fontNameBox.addItem("Verdana");
        fontNameSelectionPanel.add(fontNameBox);
        fontNameSelectionPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2), "Nazwa czcionki"));
        fontNameSelectionPanel.setPreferredSize(new Dimension(300, 60));

        fontNameBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFontName = fontNameBox.getItemAt(fontNameBox.getSelectedIndex());
                mainFont = new Font(mainFontName, mainStyle, mainSize);
                mainLabelText.setFont(mainFont);
            }
        });

        mainWindow.setLayout(lManager);
        GBC.anchor = GridBagConstraints.WEST;
        mainWindow.add(mainPanel, GBC);
        GBC.gridy = 1;
        mainWindow.add(fontStyleSelectionPanel, GBC);
        GBC.gridy = 2;
        mainWindow.add(fontSizeSelectionPanel, GBC);
        GBC.gridy = 3;
        mainWindow.add(fontNameSelectionPanel, GBC);

        mainWindow.pack();
    }
}
