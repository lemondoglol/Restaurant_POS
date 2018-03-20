/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;


/**
 *
 * @author Ryan
 */
public class Main_Menu extends javax.swing.JFrame {
    
    /**
     * Creates new form Main_Menu
     */
    
    private static int ticket = 0;
    HashMap<String, Double> menu;
    private static int id = 0;
    boolean BOSS_STATUS = false;
    private Map<Integer, Order> customers = new HashMap<>();
    private static double total_income = 0;
    // table number,    order, num
    Map<String, Map<String,Integer>> all_tables;
    
    double total = 0;
    boolean check_signal = false;
    String CURRENT_TABLE;
    private final int cur_order_button_size_width = 160;
    private final int cur_order_button_size_height = 30;
    
    

    
    
    public Main_Menu(String bossname) {
        if(bossname.equals("Ryan")){
            BOSS_STATUS  = true;
        }
        initComponents();
        setSize(830,630);
        setResizable(false);
        setLocationRelativeTo(null);
        make_button_invisible();
        initialize_menu();
        this.setTitle("Welcome to Ryan's Restaurant System");
    }
    //initialize menu
    private void initialize_menu(){
        menu = new HashMap<>();
        init_menu();

        all_tables = new HashMap<>();
        //test
        Map<String, Integer> m1 = new HashMap<>();
        all_tables.put("table_1",m1);
        Map<String, Integer> m2 = new HashMap<>();
        all_tables.put("table_2",m2);
        Map<String, Integer> m3 = new HashMap<>();
        all_tables.put("table_3",m3);
        Map<String, Integer> m4 = new HashMap<>();
        all_tables.put("table_4",m4);
        Map<String, Integer> m5 = new HashMap<>();
        all_tables.put("table_5",m5);
    }
    // initialize menu, read from CSV file
    private void init_menu(){
        String fileName = "C:\\Users\\Ryan\\Documents\\NetBeansProjects\\Restaurant\\src\\restaurant\\menu.txt";
        String line = null;
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null){
                String[] temp = line.split(",");
                menu.put(temp[0], Double.parseDouble(temp[1]));
                //System.out.print(temp[0] + "    " + temp[1]);
            }
            br.close();
        }catch(Exception ex){
            System.out.println("Can't find menu file!!!");
        }
    }
    // print recipt, write into CSV file
    private void print_recipt(String in, int name){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String path = "C:\\Users\\Ryan\\Documents\\NetBeansProjects\\Restaurant\\src\\restaurant\\";
        String fileName = path + "Ticket" + name + "-" + dateFormat.format(date) + ".txt";
        //System.out.print(fileName);
        try{
            File fr = new File(fileName);
            //Create the file
            fr.createNewFile();
            FileWriter frr = new FileWriter(fr);
            BufferedWriter br = new BufferedWriter(frr);
            String[] temp = in.split("\n");
            for(String s : temp){   
                br.write(s);
                br.newLine();
            }
            
            br.close();
        }catch(Exception e){
            System.out.println("Can't save CSV file!!!");
        }
    }
    
    
    private void make_button_invisible(){

    }
    
    public HashMap<String,Double> getMenu(){
        return this.menu;
    }
    public double getTotal_Income(){
        return this.total_income;
    }
    
    
    
    private void addToTable(Order ob){
        //DefaultTableModel model = (DefaultTableModel) Table.getModel();
        int t_id = ob.getId();
        double price = ob.getPrice();
        //model.addRow(new Object[]{t_id, price});
        
    }
    
    private void refresh_table(){
        Map<String, Integer> temp = all_tables.get(CURRENT_TABLE);
        for(String s : temp.keySet()){
            JButton t = new JButton(s + "  " + temp.get(s));
            t.setPreferredSize(new Dimension(cur_order_button_size_width,cur_order_button_size_height));
            this.current_order.add(t);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Check = new javax.swing.JButton();
        ConFirm_Pay = new javax.swing.JButton();
        Total_Income = new javax.swing.JButton();
        Main_Menu = new javax.swing.JTabbedPane();
        appetizer = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Fries = new javax.swing.JButton();
        main_menu = new javax.swing.JPanel();
        Beef_Broccoli = new javax.swing.JButton();
        Shrimp_Fried_Rice = new javax.swing.JButton();
        special = new javax.swing.JPanel();
        SPI1 = new javax.swing.JButton();
        SPI2 = new javax.swing.JButton();
        drink = new javax.swing.JPanel();
        table = new javax.swing.JPanel();
        current_order = new javax.swing.JPanel();
        table_number = new javax.swing.JLabel();
        all_table = new javax.swing.JPanel();
        Table_1 = new javax.swing.JButton();
        Table_2 = new javax.swing.JButton();
        Table_5 = new javax.swing.JButton();
        Table_4 = new javax.swing.JButton();
        Table_3 = new javax.swing.JButton();
        Table_6 = new javax.swing.JButton();
        Table_7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        message = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        change = new javax.swing.JTextArea();
        pay = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        Check.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        Check.setText("Check");
        Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckActionPerformed(evt);
            }
        });
        getContentPane().add(Check);
        Check.setBounds(10, 487, 100, 102);

        ConFirm_Pay.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        ConFirm_Pay.setText("<html>Confirm<br/>Pay</html>");
        ConFirm_Pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConFirm_PayActionPerformed(evt);
            }
        });
        getContentPane().add(ConFirm_Pay);
        ConFirm_Pay.setBounds(116, 487, 91, 102);

        Total_Income.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        Total_Income.setText("<html>Total<br/>Income</html>");
        Total_Income.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total_IncomeActionPerformed(evt);
            }
        });
        getContentPane().add(Total_Income);
        Total_Income.setBounds(713, 487, 87, 102);

        Main_Menu.setBackground(new java.awt.Color(0, 255, 255));

        jButton2.setText("<html>Nuggets<br/>$ 3.50</html>");
        jButton2.setPreferredSize(new java.awt.Dimension(65, 55));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        jButton3.setText("<html>BBQ Bun<br/>$ 2.50</html>");
        jButton3.setPreferredSize(new java.awt.Dimension(65, 55));

        jButton4.setText("<html>Apple Pie<br/>$ 1.50</html>");
        jButton4.setPreferredSize(new java.awt.Dimension(65, 55));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton4KeyPressed(evt);
            }
        });

        jButton5.setText("<html>Meat Balls<br/>$ 4.50</html>");
        jButton5.setPreferredSize(new java.awt.Dimension(65, 55));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("<html>Chicken Feet<br/>$ 3.50</html>");
        jButton6.setPreferredSize(new java.awt.Dimension(65, 55));

        Fries.setText("<html>Fries<br/>$ 2.50</html>");
        Fries.setPreferredSize(new java.awt.Dimension(65, 55));
        Fries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FriesActionPerformed(evt);
            }
        });
        Fries.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FriesKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout appetizerLayout = new javax.swing.GroupLayout(appetizer);
        appetizer.setLayout(appetizerLayout);
        appetizerLayout.setHorizontalGroup(
            appetizerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appetizerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(appetizerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(Fries, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(appetizerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );
        appetizerLayout.setVerticalGroup(
            appetizerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appetizerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(appetizerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(appetizerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Fries, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(appetizerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(305, Short.MAX_VALUE))
        );

        Main_Menu.addTab("Appetizer", appetizer);

        Beef_Broccoli.setText("<html>Beef Brocooli<br/>$ 10.50</html>");
        Beef_Broccoli.setPreferredSize(new java.awt.Dimension(65, 55));
        Beef_Broccoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Beef_BroccoliActionPerformed(evt);
            }
        });
        Beef_Broccoli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Beef_BroccoliKeyPressed(evt);
            }
        });

        Shrimp_Fried_Rice.setText("<html>Shrimp Fried Rice<br/>$ 9.50</html>");
        Shrimp_Fried_Rice.setPreferredSize(new java.awt.Dimension(65, 55));
        Shrimp_Fried_Rice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Shrimp_Fried_RiceActionPerformed(evt);
            }
        });
        Shrimp_Fried_Rice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Shrimp_Fried_RiceKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout main_menuLayout = new javax.swing.GroupLayout(main_menu);
        main_menu.setLayout(main_menuLayout);
        main_menuLayout.setHorizontalGroup(
            main_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Shrimp_Fried_Rice, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Beef_Broccoli, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addGap(157, 157, 157))
        );
        main_menuLayout.setVerticalGroup(
            main_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(main_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Beef_Broccoli, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Shrimp_Fried_Rice, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(371, Short.MAX_VALUE))
        );

        Main_Menu.addTab("Main Menu", main_menu);

        SPI1.setText("<html>Chef Sepcial<br/>$ 10.50</html>");
        SPI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPI1ActionPerformed(evt);
            }
        });

        SPI2.setText("<html>Chef Sepcial<br/>$ 11.50</html>");
        SPI2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPI2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout specialLayout = new javax.swing.GroupLayout(special);
        special.setLayout(specialLayout);
        specialLayout.setHorizontalGroup(
            specialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SPI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SPI2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
        );
        specialLayout.setVerticalGroup(
            specialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(specialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SPI2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SPI1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(376, Short.MAX_VALUE))
        );

        Main_Menu.addTab("Special", special);
        Main_Menu.addTab("Drink", drink);

        getContentPane().add(Main_Menu);
        Main_Menu.setBounds(383, 11, 425, 470);

        table.setLayout(null);

        current_order.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 65, 2));

        table_number.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        table_number.setForeground(new java.awt.Color(255, 0, 153));
        table_number.setPreferredSize(new java.awt.Dimension(180, 20));
        current_order.add(table_number);

        table.add(current_order);
        current_order.setBounds(121, 0, 240, 470);

        Table_1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        Table_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/table_icon.png"))); // NOI18N
        Table_1.setText("1");
        Table_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Table_1ActionPerformed(evt);
            }
        });

        Table_2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        Table_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/table_icon.png"))); // NOI18N
        Table_2.setText("2");
        Table_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Table_2ActionPerformed(evt);
            }
        });

        Table_5.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        Table_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/table_icon.png"))); // NOI18N
        Table_5.setText("5");
        Table_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Table_5ActionPerformed(evt);
            }
        });

        Table_4.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        Table_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/table_icon.png"))); // NOI18N
        Table_4.setText("4");

        Table_3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        Table_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/table_icon.png"))); // NOI18N
        Table_3.setText("3");
        Table_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Table_3ActionPerformed(evt);
            }
        });

        Table_6.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        Table_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/table_icon.png"))); // NOI18N
        Table_6.setText("6");

        Table_7.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        Table_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/table_icon.png"))); // NOI18N
        Table_7.setText("7");

        javax.swing.GroupLayout all_tableLayout = new javax.swing.GroupLayout(all_table);
        all_table.setLayout(all_tableLayout);
        all_tableLayout.setHorizontalGroup(
            all_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Table_7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Table_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Table_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Table_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Table_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Table_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Table_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        all_tableLayout.setVerticalGroup(
            all_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(all_tableLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Table_1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Table_2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Table_3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Table_4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Table_5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Table_6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Table_7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        table.add(all_table);
        all_table.setBounds(0, 0, 119, 470);

        getContentPane().add(table);
        table.setBounds(10, 11, 367, 470);

        message.setColumns(20);
        message.setRows(5);
        jScrollPane1.setViewportView(message);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(428, 487, 279, 102);

        change.setColumns(20);
        change.setRows(5);
        jScrollPane2.setViewportView(change);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(215, 532, 207, 57);

        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });
        pay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                payKeyPressed(evt);
            }
        });
        getContentPane().add(pay);
        pay.setBounds(215, 487, 207, 39);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/bg1.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 840, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckActionPerformed
        if(CURRENT_TABLE != null){
            double total = 0;
            StringBuilder detail = new StringBuilder();
            Map<String,Integer> temp = this.all_tables.get(CURRENT_TABLE);
            for(String s : temp.keySet()){
                detail.append("Item : " + s + "   ----  Quantity : " + temp.get(s) + "\n");
                total += menu.get(s)*temp.get(s);
            }
            //this.total_income += total;
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            this.message.setText("Total Price For " + CURRENT_TABLE + " is $" + total + "\n" + dateFormat.format(date)  +"\n" + detail);
            
            
        }
    }//GEN-LAST:event_CheckActionPerformed

    private void ConFirm_PayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConFirm_PayActionPerformed
        //"Total Price For " + CURRENT_TABLE + " is $" + total + "\n" + detail
        if(this.message.getText() == null || this.message.getText().length() == 0) return;
        String[] arr =this.message.getText().split("\n");
        String s = this.message.getText();
        print_recipt(s,ticket);
        ticket++;
        String[] money = arr[0].split("\\$");
        this.total_income += Double.parseDouble(money[1]);
        if(CURRENT_TABLE != null){
            Map<String, Integer> m = new HashMap<>();
            this.all_tables.put(CURRENT_TABLE, m);
            this.current_order.removeAll();
            this.current_order.revalidate();
            this.current_order.repaint();
        }
    }//GEN-LAST:event_ConFirm_PayActionPerformed

    private void Total_IncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Total_IncomeActionPerformed
        // TODO add your handling code here:
        if(BOSS_STATUS == true){
            //System.out.println(total_income);
            Check_Total_Income ob = new Check_Total_Income(this,true,total_income);
        }else{
            JOptionPane.showMessageDialog(this,"You dont have permission!","Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_Total_IncomeActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String name = "Nuggets";
        // TODO add your handling code here:
        if(CURRENT_TABLE != null){
            Map<String, Integer> temp = all_tables.get(CURRENT_TABLE);
            if(temp.containsKey(name)){
                temp.put(name,temp.get(name) + 1);
                this.current_order.removeAll();
                this.table_number.setText(CURRENT_TABLE);
                this.current_order.add(this.table_number);
                this.refresh_table();
                this.current_order.revalidate();
                this.current_order.repaint();
            }else{
                temp.put(name, 1);
                JButton t = new JButton(name + "  " + 1);
                t.setPreferredSize(new Dimension(cur_order_button_size_width,cur_order_button_size_height));
                this.current_order.removeAll();
                this.table_number.setText(CURRENT_TABLE);
                this.current_order.add(this.table_number);
                this.refresh_table();
                this.current_order.revalidate();
                this.current_order.repaint();
            }
            this.all_tables.put(CURRENT_TABLE, temp);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Table_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Table_1ActionPerformed
        
        this.current_order.removeAll();
        this.current_order.revalidate();
        this.current_order.repaint();
        CURRENT_TABLE = "table_1";
        Map<String, Integer> temp = all_tables.get("table_1");
        this.table_number.setText(CURRENT_TABLE);
        this.current_order.add(this.table_number);
        if(temp != null){
            for(String s : temp.keySet()){
                JButton t = new JButton(s + "  " + temp.get(s));
                t.setPreferredSize(new Dimension(cur_order_button_size_width,cur_order_button_size_height));
                this.current_order.add(t);
            }
            Color grey = new Color(191,191,191);
            if(temp.size() != 0) this.Table_1.setBackground(Color.orange);
            else this.Table_1.setBackground(grey);
        }
        
    }//GEN-LAST:event_Table_1ActionPerformed

    private void Table_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Table_2ActionPerformed
        // TODO add your handling code here:
        this.current_order.removeAll();
        this.current_order.revalidate();
        this.current_order.repaint();
        CURRENT_TABLE = "table_2";
        Map<String, Integer> temp = all_tables.get("table_2");
        this.table_number.setText(CURRENT_TABLE);
        this.current_order.add(this.table_number);
        if(temp != null){
            for(String s : temp.keySet()){
                JButton t = new JButton(s + "  " + temp.get(s));
                t.setPreferredSize(new Dimension(cur_order_button_size_width,cur_order_button_size_height));
                this.current_order.add(t);
            }
            Color grey = new Color(191,191,191);
            if(temp.size() != 0) this.Table_2.setBackground(Color.orange);
            else this.Table_2.setBackground(grey);
        }
    }//GEN-LAST:event_Table_2ActionPerformed

    private void FriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FriesActionPerformed
        String name = "Fries";
        // TODO add your handling code here:
        if(CURRENT_TABLE != null){
            Map<String, Integer> temp = all_tables.get(CURRENT_TABLE);
            if(temp.containsKey(name)){
                temp.put(name,temp.get(name) + 1);
                this.current_order.removeAll();
                this.table_number.setText(CURRENT_TABLE);
                this.current_order.add(this.table_number);
                this.refresh_table();
                this.current_order.revalidate();
                this.current_order.repaint();
            }else{
                temp.put(name, 1);
                JButton t = new JButton(name + "  " + 1);
                t.setPreferredSize(new Dimension(cur_order_button_size_width,cur_order_button_size_height));
                this.current_order.removeAll();
                this.table_number.setText(CURRENT_TABLE);
                this.current_order.add(this.table_number);
                this.refresh_table();
                this.current_order.revalidate();
                this.current_order.repaint();
            }
            this.all_tables.put(CURRENT_TABLE, temp);
        }
        
    }//GEN-LAST:event_FriesActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String name = "Apple_Pie";
        // TODO add your handling code here:
        if(CURRENT_TABLE != null){
            Map<String, Integer> temp = all_tables.get(CURRENT_TABLE);
            if(temp.containsKey(name)){
                temp.put(name,temp.get(name) + 1);
                this.current_order.removeAll();
                this.table_number.setText(CURRENT_TABLE);
                this.current_order.add(this.table_number);
                this.refresh_table();
                this.current_order.revalidate();
                this.current_order.repaint();
            }else{
                temp.put(name, 1);
                JButton t = new JButton(name + "  " + 1);
                t.setPreferredSize(new Dimension(cur_order_button_size_width,cur_order_button_size_height));
                this.current_order.removeAll();
                this.table_number.setText(CURRENT_TABLE);
                this.current_order.add(this.table_number);
                this.refresh_table();
                this.current_order.revalidate();
                this.current_order.repaint();
            }
            this.all_tables.put(CURRENT_TABLE, temp);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void Table_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Table_3ActionPerformed
        this.current_order.removeAll();
        this.current_order.revalidate();
        this.current_order.repaint();
        CURRENT_TABLE = "table_3";
        Map<String, Integer> temp = all_tables.get("table_3");
        this.table_number.setText(CURRENT_TABLE);
        this.current_order.add(this.table_number);
        if(temp != null){
            for(String s : temp.keySet()){
                JButton t = new JButton(s + "  " + temp.get(s));
                t.setPreferredSize(new Dimension(cur_order_button_size_width,cur_order_button_size_height));
                this.current_order.add(t);
            }
            Color grey = new Color(191,191,191);
            if(temp.size() != 0) this.Table_3.setBackground(Color.orange);
            else this.Table_3.setBackground(grey);
        }
    }//GEN-LAST:event_Table_3ActionPerformed

    private void Beef_BroccoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Beef_BroccoliActionPerformed
        String name = "Beef_Broccoli";
        // TODO add your handling code here:
        if(CURRENT_TABLE != null){
            Map<String, Integer> temp = all_tables.get(CURRENT_TABLE);
            if(temp.containsKey(name)){
                temp.put(name,temp.get(name) + 1);
                this.current_order.removeAll();
                this.table_number.setText(CURRENT_TABLE);
                this.current_order.add(this.table_number);
                this.refresh_table();
                this.current_order.revalidate();
                this.current_order.repaint();
            }else{
                temp.put(name, 1);
                JButton t = new JButton(name + "  " + 1);
                t.setPreferredSize(new Dimension(cur_order_button_size_width,cur_order_button_size_height));
                this.current_order.removeAll();
                this.table_number.setText(CURRENT_TABLE);
                this.current_order.add(this.table_number);
                this.refresh_table();
                this.current_order.revalidate();
                this.current_order.repaint();
            }
            this.all_tables.put(CURRENT_TABLE, temp);
        }
    }//GEN-LAST:event_Beef_BroccoliActionPerformed

    private void Shrimp_Fried_RiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Shrimp_Fried_RiceActionPerformed
        String name = "Shrimp_Fried_Rice";
        // TODO add your handling code here:
        if(CURRENT_TABLE != null){
            Map<String, Integer> temp = all_tables.get(CURRENT_TABLE);
            if(temp.containsKey(name)){
                temp.put(name,temp.get(name) + 1);
                this.current_order.removeAll();
                this.table_number.setText(CURRENT_TABLE);
                this.current_order.add(this.table_number);
                this.refresh_table();
                this.current_order.revalidate();
                this.current_order.repaint();
            }else{
                temp.put(name, 1);
                JButton t = new JButton(name + "  " + 1);
                t.setPreferredSize(new Dimension(cur_order_button_size_width,cur_order_button_size_height));
                this.current_order.removeAll();
                this.table_number.setText(CURRENT_TABLE);
                this.current_order.add(this.table_number);
                this.refresh_table();
                this.current_order.revalidate();
                this.current_order.repaint();
            }
            this.all_tables.put(CURRENT_TABLE, temp);
        }
    }//GEN-LAST:event_Shrimp_Fried_RiceActionPerformed

    private void SPI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPI1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_SPI1ActionPerformed

    private void SPI2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPI2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_SPI2ActionPerformed

    private void Table_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Table_5ActionPerformed
        this.current_order.removeAll();
        this.current_order.revalidate();
        this.current_order.repaint();
        CURRENT_TABLE = "table_5";
        Map<String, Integer> temp = all_tables.get("table_5");
        this.table_number.setText(CURRENT_TABLE);
        this.current_order.add(this.table_number);
        if(temp != null){
            for(String s : temp.keySet()){
                JButton t = new JButton(s + "  " + temp.get(s));
                t.setPreferredSize(new Dimension(cur_order_button_size_width,cur_order_button_size_height));
                this.current_order.add(t);
            }
            Color grey = new Color(191,191,191);
            if(temp.size() != 0) this.Table_5.setBackground(Color.orange);
            else this.Table_5.setBackground(grey);
        }
    }//GEN-LAST:event_Table_5ActionPerformed

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        
    }//GEN-LAST:event_payActionPerformed

    private void payKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_payKeyPressed
        String money_pay = this.pay.getText();
        if(evt.getKeyCode() == KeyEvent.VK_ENTER && money_pay != null && money_pay.length() != 0){
            String[] arr =this.message.getText().split("\n");
            String s = this.message.getText();
            String[] mon = arr[0].split("\\$");
            double mon_d = Double.parseDouble(mon[1]);
            double total = Double.parseDouble(money_pay);
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                this.change.setText("Change $" + (total - mon_d));
            }
        }
    }//GEN-LAST:event_payKeyPressed

    private void FriesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FriesKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_C){
            String name = "Fries";
            if(CURRENT_TABLE != null){
                Map<String, Integer> temp = all_tables.get(CURRENT_TABLE);
                if(temp.containsKey(name) && temp.get(name) >= 1){
                    temp.put(name,temp.get(name) - 1);
                    this.current_order.removeAll();
                    this.table_number.setText(CURRENT_TABLE);
                    this.current_order.add(this.table_number);
                    this.refresh_table();
                    this.current_order.revalidate();
                    this.current_order.repaint();
                }
                this.all_tables.put(CURRENT_TABLE, temp);
            }
        }else if(evt.getKeyCode() == KeyEvent.VK_P && this.BOSS_STATUS == true){
            
            String price = this.pay.getText();
            this.menu.put("Fries", Double.parseDouble(price));
            this.Fries.setText("<html>Fries<br/>$ "+price+"</html>");
            
        }
    }//GEN-LAST:event_FriesKeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_C){
            String name = "Nuggets";
            if(CURRENT_TABLE != null){
                Map<String, Integer> temp = all_tables.get(CURRENT_TABLE);
                if(temp.containsKey(name) && temp.get(name) >= 1){
                    temp.put(name,temp.get(name) - 1);
                    this.current_order.removeAll();
                    this.table_number.setText(CURRENT_TABLE);
                    this.current_order.add(this.table_number);
                    this.refresh_table();
                    this.current_order.revalidate();
                    this.current_order.repaint();
                }
                this.all_tables.put(CURRENT_TABLE, temp);
            }
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_C){
            String name = "Apple_Pie";
            if(CURRENT_TABLE != null){
                Map<String, Integer> temp = all_tables.get(CURRENT_TABLE);
                if(temp.containsKey(name) && temp.get(name) >= 1){
                    temp.put(name,temp.get(name) - 1);
                    this.current_order.removeAll();
                    this.table_number.setText(CURRENT_TABLE);
                    this.current_order.add(this.table_number);
                    this.refresh_table();
                    this.current_order.revalidate();
                    this.current_order.repaint();
                }
                this.all_tables.put(CURRENT_TABLE, temp);
            }
        }
    }//GEN-LAST:event_jButton4KeyPressed

    private void Shrimp_Fried_RiceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Shrimp_Fried_RiceKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_C){
            String name = "Shrimp_Fried_Rice";
            if(CURRENT_TABLE != null){
                Map<String, Integer> temp = all_tables.get(CURRENT_TABLE);
                if(temp.containsKey(name) && temp.get(name) >= 1){
                    temp.put(name,temp.get(name) - 1);
                    this.current_order.removeAll();
                    this.table_number.setText(CURRENT_TABLE);
                    this.current_order.add(this.table_number);
                    this.refresh_table();
                    this.current_order.revalidate();
                    this.current_order.repaint();
                }
                this.all_tables.put(CURRENT_TABLE, temp);
            }
        }
    }//GEN-LAST:event_Shrimp_Fried_RiceKeyPressed

    private void Beef_BroccoliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Beef_BroccoliKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_C){
            String name = "Beef_Broccoli";
            if(CURRENT_TABLE != null){
                Map<String, Integer> temp = all_tables.get(CURRENT_TABLE);
                if(temp.containsKey(name) && temp.get(name) >= 1){
                    temp.put(name,temp.get(name) - 1);
                    this.current_order.removeAll();
                    this.table_number.setText(CURRENT_TABLE);
                    this.current_order.add(this.table_number);
                    this.refresh_table();
                    this.current_order.revalidate();
                    this.current_order.repaint();
                }
                this.all_tables.put(CURRENT_TABLE, temp);
            }
        }
    }//GEN-LAST:event_Beef_BroccoliKeyPressed
    
        
    /**
     * @param args the command line arguments
     */

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Menu("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Beef_Broccoli;
    private javax.swing.JButton Check;
    private javax.swing.JButton ConFirm_Pay;
    private javax.swing.JButton Fries;
    private javax.swing.JTabbedPane Main_Menu;
    private javax.swing.JButton SPI1;
    private javax.swing.JButton SPI2;
    private javax.swing.JButton Shrimp_Fried_Rice;
    private javax.swing.JButton Table_1;
    private javax.swing.JButton Table_2;
    private javax.swing.JButton Table_3;
    private javax.swing.JButton Table_4;
    private javax.swing.JButton Table_5;
    private javax.swing.JButton Table_6;
    private javax.swing.JButton Table_7;
    private javax.swing.JButton Total_Income;
    private javax.swing.JPanel all_table;
    private javax.swing.JPanel appetizer;
    private javax.swing.JTextArea change;
    private javax.swing.JPanel current_order;
    private javax.swing.JPanel drink;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel main_menu;
    private javax.swing.JTextArea message;
    private javax.swing.JTextField pay;
    private javax.swing.JPanel special;
    private javax.swing.JPanel table;
    private javax.swing.JLabel table_number;
    // End of variables declaration//GEN-END:variables
}
