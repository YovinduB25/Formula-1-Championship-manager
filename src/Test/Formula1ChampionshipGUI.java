package Test;
//UoW - 1837849
//IIT - 20200870

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Formula1ChampionshipGUI implements ActionListener
{   //Graphical user interface class of F1 Championship

    String name;
    //I referred this https://www.javatpoint.com/java-swing to do below GUI project
    JFrame frame;   //Main Frame

    //Buttons for the GUI
    JButton button1 = new JButton("Descending Order");
    JButton button2 = new JButton("Ascending Order");
    JButton button3 = new JButton("First positions");
    JButton button4 = new JButton("Add Race");
    JButton button5 = new JButton("Add Race with random position");
    JButton button6 = new JButton("Ascending order of date played");
    JButton button7 = new JButton("Search");

    //Text field for the GUI
    JTextField textF1 = new JTextField(20); //search text field

    //Table model and tables for the GUI
    DefaultTableModel tableModel;
    JTable table1;  //driver table
    JTable table2;  //race date table
    JTable table3;  //ran pos table
    JTable table4;  //search driver table

    //Scroll panes for the GUI
    JScrollPane spane; //driver table
    JScrollPane spane1; //race date table
    JScrollPane spane2; //ran pos table
    JScrollPane spane3; //search driver table

    //Panels for the GUI
    JPanel panel1;  //button panel
    JPanel panel2;  //table panel

    //Layered pane for the GUI
    JLayeredPane layeredPane = new JLayeredPane();  //layered pane

    public Formula1ChampionshipGUI ()
    {
        //Image in GUI
        ImageIcon image = new ImageIcon("formula1logo.png");

        //Label for the Topic
        JLabel label1 = new JLabel();
        label1.setText("Formula 1 Championship");
        label1.setFont(new Font("Poppins", Font.BOLD, 20));
        label1.setForeground(new Color(255,0,0));
        label1.setBounds(20,40,300,100);
        label1.setIcon(image);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setIconTextGap(20);


        //Default font for all buttons
        Font guiFont = new Font("Poppins", Font.BOLD, 14);  //Fonts for the program

        //GUI Frame Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("formula1logo.png");


        //Text field to get driver name
        textF1.setBounds(12,160,260,25);
        textF1.setForeground(Color.black);


        //Button for the search drivers name
        button7.setFont(guiFont);
        button7.setBounds(12,190, 260,25);
        button7.setForeground(Color.white);
        button7.setBackground(Color.black);
        button7.setOpaque(true);
        button7.addActionListener(this);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    ////switching scrollpane 3
                sDriver(name);
                layeredPane.add(spane3);
                tableSwitcher(spane3);
            }
        });


        //Label "Driver Table"
        JLabel label2 = new JLabel();
        label2.setText("Driver Table");
        label2.setFont(new Font("Poppins", Font.BOLD, 14));
        label2.setForeground(new Color(178,34,34));
        label2.setBounds(15,240,100,20);


        //Button for the Descending Oder
        button1.setFont(guiFont);
        button1.setBounds(12,260, 260,25);
        button1.setForeground(Color.white);
        button1.setBackground(Color.black);
        button1.setOpaque(true);
        button1.addActionListener(this);


        //Button for the Ascending Oder
        button2.setFont(guiFont);
        button2.setBounds(12,290, 260,25);
        button2.setForeground(Color.white);
        button2.setBackground(Color.black);
        button2.setOpaque(true);
        button2.addActionListener(this);


        //Button for the First position Descending Oder
        button3.setFont(guiFont);
        button3.setBounds(12,320, 260,25);
        button3.setForeground(Color.white);
        button3.setBackground(Color.black);
        button3.setOpaque(true);
        button3.addActionListener(this);


        //Label "Start New Race"
        JLabel label3 = new JLabel();
        label3.setText("Start New Race");
        label3.setFont(new Font("Poppins", Font.BOLD, 14));
        label3.setForeground(new Color(255,140,0));
        label3.setBounds(15,355,120,20);


        //Button for the add race
        button4.setFont(guiFont);
        button4.setBounds(12,375, 260,25);
        button4.setForeground(Color.white);
        button4.setBackground(Color.black);
        button4.setOpaque(true);
        button4.addActionListener(this);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    //switching scrollpane 1
                addRace();
                layeredPane.add(spane1);
                tableSwitcher(spane1);
            }
        });


        //Button for the random race position
        button5.setFont(guiFont);
        button5.setBounds(12,405, 260,25);
        button5.setForeground(Color.white);
        button5.setBackground(Color.black);
        button5.setOpaque(true);
        button5.addActionListener(this);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    //switching scrollpane 2
                addRandomPos();
                layeredPane.add(spane2);
                tableSwitcher(spane2);
            }
        });


        //Label "Sort By Date"
        JLabel label4 = new JLabel();
        label4.setText("Sort By Date");
        label4.setFont(new Font("Poppins", Font.BOLD, 14));
        label4.setForeground(new Color(34,139,34));
        label4.setBounds(15,440,100,20);


        //Button for the Ascending Oder by Date
        button6.setFont(guiFont);
        button6.setBounds(12,460, 260,25);
        button6.setForeground(Color.white);
        button6.setBackground(Color.black);
        button6.setOpaque(true);
        button6.addActionListener(this);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    //switching scrollpane 1
                addRace();
                layeredPane.add(spane1);
                tableSwitcher(spane1);
            }
        });

        //Formula1ChampionshipManager object
        Formula1ChampionshipManager f1champ = new Formula1ChampionshipManager();
        f1champ.readFile(); //Load previous data


        //Column for the table1
        String[] column = {"Name","Location","Team","1st","2nd","3rd","Races","Points"};

        //Rows for tha table1
        Object [][] data = new Object[Formula1ChampionshipManager.Formula1DriverArrayList.size()][8];
        for (int i = 0; i < data.length; i++)
        {
            data[i][0] = Formula1ChampionshipManager.Formula1DriverArrayList.get(i).getName();
            data[i][1] = Formula1ChampionshipManager.Formula1DriverArrayList.get(i).getLocation();
            data[i][2] = Formula1ChampionshipManager.Formula1DriverArrayList.get(i).getTeam();
            data[i][3] = String.valueOf(Formula1ChampionshipManager.Formula1DriverArrayList.get(i).getFirstPosition());
            data[i][4] = String.valueOf(Formula1ChampionshipManager.Formula1DriverArrayList.get(i).getSecondPosition());
            data[i][5] = String.valueOf(Formula1ChampionshipManager.Formula1DriverArrayList.get(i).getThirdPosition());
            data[i][6] = String.valueOf(Formula1ChampionshipManager.Formula1DriverArrayList.get(i).getTotalRaces());
            data[i][7] = String.valueOf(Formula1ChampionshipManager.Formula1DriverArrayList.get(i).getTotalPoints());
        }

        //Table for GUI
        tableModel = new DefaultTableModel(data, column);
        table1 = new JTable(tableModel);
        table1.setEnabled(false);
        table1.setModel(tableModel);

        spane = new JScrollPane(table1);
        spane.setBounds(25,25,520,270);

        //layeredpane
        layeredPane.setBounds(20,310,580,300);
        layeredPane.setBackground(Color.WHITE);

        //Panel 2
        panel2 = new JPanel();
        panel2.add(spane);

        panel2.setPreferredSize(new Dimension(600, 600));
        panel2.setLayout(null);
        panel2.setBackground(new Color(112,128,144));
        panel2.add(layeredPane);

        //Panel for the Button side
        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(300, 600));
        panel1.setLayout(null);
        panel1.setBackground(new Color(192,192,192));

        //adding buttons and labels to the panel
        panel1.add(label1);
        panel1.add(textF1);
        panel1.add(button7);
        panel1.add(button1);
        panel1.add(label2);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(label3);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(label4);
        panel1.add(button6);

        //Frame for GUI
        frame = new JFrame("Formula 1 Racing Car Championship");
        frame.setSize(900, 600);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel1, BorderLayout.WEST);
        frame.setIconImage(icon);

    }

    private void sDriver(String textFieldText)
    {   //Search driver table
        int pos = 0;
        String[] column3 = {"Race Dates", "Race Position"};

        Object [][] data3 = new Object[Formula1ChampionshipManager.raceArray.size()][2];
        for (int p = 0; p < data3.length; p++)
        {
            data3[p][0] = Formula1ChampionshipManager.raceArray.get(p).getrDate();
            String[] driverNames = Formula1ChampionshipManager.raceArray.get(p).getDriverNames();
            for (int i = 0; i<driverNames.length;i++ )
            {
                if (driverNames[i].equals(textFieldText))
                {
                    pos = i;
                }
            }
            data3[p][1] = Formula1ChampionshipManager.raceArray.get(p).getRacePos()[pos];   //Getting position of the driver
        }

        tableModel = new DefaultTableModel(data3, column3);
        table4 = new JTable(tableModel);
        table4.setEnabled(false);
        table4.setModel(tableModel);

        spane3 = new JScrollPane(table4);
        spane3.setBounds(70,0,400,200);
    }

    private void addRace()
    {   //Random race table
        String[] column1 = {"Race Dates"};

        Object [][] data1 = new Object[Formula1ChampionshipManager.raceArray.size()][1];

        for (int l = 0; l < data1.length; l++)
        {
            data1[l][0] = Formula1ChampionshipManager.raceArray.get(l).getrDate();
        }

        tableModel = new DefaultTableModel(data1, column1);
        table2 = new JTable(tableModel);
        table2.setEnabled(false);
        table2.setModel(tableModel);

        spane1 = new JScrollPane(table2);
        spane1.setBounds(75,0,400,200);
    }

    public void addRandomPos()
    {//Probability race table
        String[] column2 = {"Race Dates", "Driver Name", "Race Starting Position", "Race Ending Position"};

        Object [][] data2 = new Object[Formula1ChampionshipManager.raceArray.size()][4];

        for (int p = 0; p < data2.length; p++)
        {
            data2[p][0] = Formula1ChampionshipManager.raceArray.get(p).getrDate();
            data2[p][1] = Formula1ChampionshipManager.raceArray.get(p).getDriverNames();
        }

        tableModel = new DefaultTableModel(data2, column2);
        table3 = new JTable(tableModel);
        table3.setEnabled(false);
        table3.setModel(tableModel);

        spane2 = new JScrollPane(table3);
        spane2.setBounds(10,0,520,200);
    }

    public void tableSwitcher(JScrollPane spane)
    {// Switching Tables
        layeredPane.removeAll();
        layeredPane.add(spane);
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    //Action performer
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == button1)
        {   //https://www.codejava.net/java-se/swing/6-techniques-for-sorting-jtable-you-should-know
            //Button 1
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(table1.getModel());
            table1.setRowSorter(sorter);
            List<RowSorter.SortKey> sortKeys = new ArrayList<>();

            int columnIndexToSort = 7;
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));

            sorter.setSortKeys(sortKeys);
            sorter.sort();

        } else if (e.getSource() == button2)
        { //Button 2
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(table1.getModel());
            table1.setRowSorter(sorter);
            List<RowSorter.SortKey> sortKeys = new ArrayList<>();

            int columnIndexToSort = 7;
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

            sorter.setSortKeys(sortKeys);
            sorter.sort();

        } else if (e.getSource() == button3)
        { //Button 3
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(table1.getModel());
            table1.setRowSorter(sorter);
            List<RowSorter.SortKey> sortKeys = new ArrayList<>();

            int columnIndexToSort = 3;
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));

            sorter.setSortKeys(sortKeys);
            sorter.sort();

        } else if (e.getSource() == button4)
        { //Button 4
            Race race;
            String[] driverNames = new String[Formula1ChampionshipManager.Formula1DriverArrayList.size()];
            int[] racePos =new int[Formula1ChampionshipManager.Formula1DriverArrayList.size()];

            for (int k = 0; k < Formula1ChampionshipManager.Formula1DriverArrayList.size(); k++)
            {
                int randomRacePosition = (int) ((Math.random() * (9)) + 1);
                int [] pointArr = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1}; //Array to hold points for index
                if (randomRacePosition == 1)
                {//updating the place value
                    Formula1ChampionshipManager.Formula1DriverArrayList.get(k).setFirstPosition(Formula1ChampionshipManager.Formula1DriverArrayList.get(k).getFirstPosition() + 1);
                }
                else if (randomRacePosition == 2)
                {
                    Formula1ChampionshipManager.Formula1DriverArrayList.get(k).setSecondPosition(Formula1ChampionshipManager.Formula1DriverArrayList.get(k).getSecondPosition() + 1);
                }
                else if (randomRacePosition == 3)
                {
                    Formula1ChampionshipManager.Formula1DriverArrayList.get(k).setThirdPosition(Formula1ChampionshipManager.Formula1DriverArrayList.get(k).getThirdPosition() + 1);
                }
                driverNames[k]= Formula1ChampionshipManager.Formula1DriverArrayList.get(k).getName();
                racePos[k]=randomRacePosition;
                Formula1ChampionshipManager.Formula1DriverArrayList.get(k).setTotalRaces(Formula1ChampionshipManager.Formula1DriverArrayList.get(k).getTotalRaces() + 1);    //updating the total race
                Formula1ChampionshipManager.Formula1DriverArrayList.get(k).setTotalPoints(Formula1ChampionshipManager.Formula1DriverArrayList.get(k).getTotalPoints() + pointArr[randomRacePosition-1]);
            }

            for (int r =0; r < Formula1ChampionshipManager.Formula1DriverArrayList.size(); r++ )
            {
                table1.setValueAt(Formula1ChampionshipManager.Formula1DriverArrayList.get(r).getFirstPosition(), r, 3);
                table1.setValueAt(Formula1ChampionshipManager.Formula1DriverArrayList.get(r).getSecondPosition(), r, 4);
                table1.setValueAt(Formula1ChampionshipManager.Formula1DriverArrayList.get(r).getThirdPosition(), r, 5);
                table1.setValueAt(Formula1ChampionshipManager.Formula1DriverArrayList.get(r).getTotalPoints(), r, 6);
                table1.setValueAt(Formula1ChampionshipManager.Formula1DriverArrayList.get(r).getTotalPoints(), r, 7);
            }
            race = new Race();
            race.setRacePos(racePos);
            race.setDriverNames(driverNames);

            DefaultTableModel model = (DefaultTableModel) table2.getModel();
            RaceDate raceDate = dateGenerator();
            race.setrDate(raceDate);
            Formula1ChampionshipManager.raceArray.add(race);


        } else if (e.getSource() == button5)
        { //Button 5
//            Race race;
//            Random random = new Random();
//            ArrayList<Formula1Driver> startPos = new ArrayList<>();
//            ArrayList<Formula1Driver> endPos = new ArrayList<>();
//
//            for (Formula1Driver driver:Formula1ChampionshipManager.Formula1DriverArrayList)
//            {
//                startPos.add(driver);
//            }
//            int randPos = random.nextInt(100);
//
//            if (randPos <= 40)
//            {
//                endPos.add(startPos.get(0));
//                startPos.remove(0);
//            }
//            else if (randPos <= 70)
//            {
//                endPos.add(startPos.get(1));
//                startPos.remove(1);
//            }
//            else if (randPos <= 80)
//            {
//                endPos.add(startPos.get(2));
//                startPos.remove(2);
//            }
//            else if (randPos <= 90)
//            {
//                endPos.add(startPos.get(3));
//                startPos.remove(3);
//            }
//            else if (randPos <= 92)
//            {
//                endPos.add(startPos.get(4));
//                startPos.remove(4);
//            }
//            else if (randPos <= 94)
//            {
//                endPos.add(startPos.get(5));
//                startPos.remove(5);
//            }
//            else if (randPos <= 96)
//            {
//                endPos.add(startPos.get(6));
//                startPos.remove(6);
//            }
//            else if (randPos <= 98)
//            {
//                endPos.add(startPos.get(7));
//                startPos.remove(7);
//            }
//            else if (randPos <= 100)
//            {
//                endPos.add(startPos.get(8));
//                startPos.remove(8);
//            }
//
//            Collections.shuffle(startPos);  //shuffling driver start positions
//
//            for (int h = 0; h < Formula1ChampionshipManager.Formula1DriverArrayList.size(); h++)
//            {
//                int [] pointArr = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1}; //Array to hold points for index
//                if (randomRacePosition == 1)
//                {//updating the place value
//                    Formula1ChampionshipManager.Formula1DriverArrayList.get(h).setFirstPosition(Formula1ChampionshipManager.Formula1DriverArrayList.get(h).getFirstPosition() + 1);
//                }
//                else if (randomRacePosition == 2)
//                {
//                    Formula1ChampionshipManager.Formula1DriverArrayList.get(h).setSecondPosition(Formula1ChampionshipManager.Formula1DriverArrayList.get(h).getSecondPosition() + 1);
//                }
//                else if (randomRacePosition == 3)
//                {
//                    Formula1ChampionshipManager.Formula1DriverArrayList.get(h).setThirdPosition(Formula1ChampionshipManager.Formula1DriverArrayList.get(h).getThirdPosition() + 1);
//                }
//                driverNames[h]= Formula1ChampionshipManager.Formula1DriverArrayList.get(h).getName();
//                racePos[h]=randomRacePosition;
//                Formula1ChampionshipManager.Formula1DriverArrayList.get(h).setTotalRaces(Formula1ChampionshipManager.Formula1DriverArrayList.get(h).getTotalRaces() + 1);    //updating the total race
//                Formula1ChampionshipManager.Formula1DriverArrayList.get(h).setTotalPoints(Formula1ChampionshipManager.Formula1DriverArrayList.get(h).getTotalPoints() + pointArr[randomRacePosition-1]);
//            }
//
//            for (int r =0; r < Formula1ChampionshipManager.Formula1DriverArrayList.size(); r++ )
//            {
//                table1.setValueAt(Formula1ChampionshipManager.Formula1DriverArrayList.get(r).getFirstPosition(), r, 3);
//                table1.setValueAt(Formula1ChampionshipManager.Formula1DriverArrayList.get(r).getSecondPosition(), r, 4);
//                table1.setValueAt(Formula1ChampionshipManager.Formula1DriverArrayList.get(r).getThirdPosition(), r, 5);
//                table1.setValueAt(Formula1ChampionshipManager.Formula1DriverArrayList.get(r).getTotalPoints(), r, 6);
//                table1.setValueAt(Formula1ChampionshipManager.Formula1DriverArrayList.get(r).getTotalPoints(), r, 7);
//            }
//
//            race = new Race();
//            race.setRacePos(endPos);
//            race.setDriverNames(driver);
//
//            DefaultTableModel model = (DefaultTableModel) table2.getModel();
//            RaceDate raceDate = dateGenerator();
//            race.setrDate(raceDate);
//            Formula1ChampionshipManager.raceArray.add(race);

            
        } else if (e.getSource() == button6)
        { //Button 6
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(table2.getModel());
            table2.setRowSorter(sorter);
            List<RowSorter.SortKey> sortKeys = new ArrayList<>();

            int columnIndexToSort = 0;
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

            sorter.setSortKeys(sortKeys);
            sorter.sort();

        } else if (e.getSource() == button7)
        { //Button 7
            name = textF1.getText();

            for (int s=0; s < Formula1ChampionshipManager.Formula1DriverArrayList.size(); s++)
            {
                if (Formula1ChampionshipManager.Formula1DriverArrayList.get(s).getName().equalsIgnoreCase(name))
                {
                    name = Formula1ChampionshipManager.Formula1DriverArrayList.get(s).getName();
                }
            }
        }
    }

    //TODO "When driver name search, Change the color of the raw"
//https://stackoverflow.com/questions/3875607/change-the-background-color-of-a-row-in-a-jtable
//    final Color[] rowColors = new Color[] {randomColor(), randomColor(), randomColor()};
//    public static Color randomColor() {
//        Random rnd = new Random();
//        return new Color(rnd.nextInt(256),
//                rnd.nextInt(256), rnd.nextInt(256));
//    }
//    for (int i=0; i<table1.getRowCount(); i++)
//    {
//        for(int j=0; j<table1.getColumnCount(); j++)
//        {
//            table1.;
//        }
//    }

    public static RaceDate dateGenerator()
    {//Method random race date generator -> https://stackoverflow.com/questions/3985392/generate-random-date-of-birth
        Random random = new Random();
        int minDay = (int) LocalDate.of(2021, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2021, 12, 30).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        int year =randomBirthDate.getYear();
        int month = randomBirthDate.getMonthValue();
        int day = randomBirthDate.getDayOfMonth();
        RaceDate date = new RaceDate(year,month,day);
        return date;
    }

    public static void main(String[] args)
    { //Main for the GUI
        new Formula1ChampionshipGUI();
    }
}