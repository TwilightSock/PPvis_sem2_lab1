package com.company;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.awt.im.InputMethodHighlight;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
	  MainMenu.start();

    }
}

class  MainMenu {
    private static JFrame jFrame;
    private static  JPanel jPanel;
    private static  List list;


    private static void  restart(){
        jPanel.removeAll();
        jPanel.repaint();
        jPanel.revalidate();


        list= new ArrayList();

        list.add(SetButton("First group", () -> {
            FirstGroup();
            return null;
        }));
        list.add(SetButton("Second group", () -> {
            SecondGroup();
            return null;
        }));
        list.add(SetButton("Third group", () -> {
            ThirdGroup();
            return null;
        }));
        list.add(SetButton("Fourth group", () -> {
            FourthGroup();
            return null;
        }));
        list.add(SetButton("Fifth group", () -> {
            FifthGroup();
            return null;
        }));

        for(int i=0;i<5;i++)
        {
            jPanel.add((JButton)list.get(i));
        }
        jPanel.revalidate();
    }

    private static JButton SetButton (String text, Callable<Void> myFunc)
    {
        JButton buffer = new JButton(text);
        buffer.addActionListener( e -> {
            try{
                myFunc.call();
            } catch (Exception exception){
                exception.printStackTrace();
            }
        });
        return  buffer;
    }

    private  MainMenu (){
        SetUpJFrame();
        jPanel=new JPanel();
        jFrame.add(jPanel);
        restart();

    }

    static private void FirstGroup()
    {
        jPanel.removeAll();
        jPanel.repaint();
        JTextField jTextField= new JTextField(10);
        JButton Exit= new JButton("Exit");
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restart();

            }
        });
        jPanel.add(Exit);
        JButton jButton2 = new JButton("push");
        String[] str={"one","two","three"};
        JComboBox jComboBox= new JComboBox(str);
        jComboBox.setEditable(true);
        jPanel.add(jTextField);
        jPanel.add(jButton2);
        jPanel.add(jComboBox);

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jComboBox.getItemCount()!=0){
                    for(int i=0;i<jComboBox.getItemCount();i++){
                        String str1=jComboBox.getItemAt(i).toString();
                        String str2=jTextField.getText();
                        if(str1.equals(str2)){
                            JOptionPane.showMessageDialog(jPanel,"ERROR!Can't add the existing string","Error",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                }
                jComboBox.addItem(jTextField.getText());
            }
        });
        jPanel.revalidate();
    }

    static private void SecondGroup(){
        jPanel.removeAll();
        jPanel.repaint();
        JButton Exit= new JButton("Exit");
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restart();

            }
        });
        jPanel.add(Exit);
        JTextField jtextField = new JTextField(10);
        JButton jButton1=new JButton("Button1");
        JButton jButton2=new JButton("Button2");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str=jtextField.getText();
                jButton2.setText(str);
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text=jButton2.getText();
                jButton2.setText(jButton1.getText());
                jButton1.setText(button_text);
            }
        });
         jPanel.add(jtextField);
         jPanel.add(jButton1);
         jPanel.add(jButton2);
        jPanel.revalidate();
    }

    private static void ThirdGroup(){
        jPanel.removeAll();
        jPanel.repaint();
        JButton Exit= new JButton("Exit");
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restart();
            }
        });
        jPanel.add(Exit);
        JTextField jTextField= new JTextField(10);
        JButton jButton=new JButton("Button");
        JRadioButton jRadioButton=new JRadioButton("one");
        JRadioButton jRadioButton1=new JRadioButton("two");
        JRadioButton jRadioButton2=new JRadioButton("three");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jRadioButton.setSelected(false);
                jRadioButton1.setSelected(false);
                jRadioButton2.setSelected(false);
                if(jTextField.getText().equals("one"))
                {
                    jRadioButton.setSelected(true);
                }
                else if(jTextField.getText().equals("two"))
                {
                    jRadioButton1.setSelected(true);
                }
                else if(jTextField.getText().equals("three"))
                {
                    jRadioButton2.setSelected(true);
                }
                else {
                    JOptionPane.showMessageDialog(jPanel,"Error!","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        });

        jPanel.add(jTextField);
        jPanel.add(jButton);
        jPanel.add(jRadioButton);
        jPanel.add(jRadioButton1);
        jPanel.add(jRadioButton2);
        jPanel.revalidate();
    }

    private static void FourthGroup(){
        jPanel.removeAll();
        jPanel.repaint();
        JButton Exit= new JButton("Exit");
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restart();
            }
        });
        jPanel.add(Exit);
        JTextField jTextField=new JTextField(10);
        JButton jButton=new JButton("check");
        JCheckBox jCheckBox=new JCheckBox("one");
        JCheckBox jCheckBox1=new JCheckBox("two");
        JCheckBox jCheckBox2=new JCheckBox("three");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox buffer;
                if(jTextField.getText().equals("one"))
                {
                    buffer=jCheckBox;

                }
                else if(jTextField.getText().equals("two"))
                {
                    buffer=jCheckBox1;
                }
                else if(jTextField.getText().equals("three"))
                {
                    buffer=jCheckBox2;
                }
                else {
                    JOptionPane.showMessageDialog(jPanel,"Error!","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(buffer.isSelected())
                {
                    buffer.setSelected(false);
                }
                else {
                    buffer.setSelected(true);
                }
            }
        });
        jPanel.add(jButton);
        jPanel.add(jCheckBox);
        jPanel.add(jCheckBox1);
        jPanel.add(jCheckBox2);
        jPanel.add(jTextField);
        jPanel.revalidate();
    }

    static private void FifthGroup(){
        jPanel.removeAll();
        jPanel.repaint();
        JButton Exit=new JButton("Exit");
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restart();
            }
        });
        jPanel.add(Exit);
        JTextField jTextField =new JTextField(20);
        JButton jButton1=new JButton("JButton1");
        JButton jButton2=new JButton("JButton2");
        JButton jButton3=new JButton("JButton3");
        JTable jTable=new JTable(new String[][]{{" "," "}},new String[]{" "," "});
        jTable.setName("Table");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTable.setValueAt(jTextField.getText(),0,0);
                jTable.setValueAt("",0,1);
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTable.setValueAt(jTable.getValueAt(0,0),0,1);
                jTable.setValueAt("",0,0);
            }
        });
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTable.setValueAt(jTable.getValueAt(0,1),0,0);
                jTable.setValueAt("",0,1);
            }
        });

        jPanel.add(jTextField);
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(jTable);
        jPanel.revalidate();
    }

    public static void  SetUpJFrame(){
        jFrame=new JFrame("Lab 1");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit= Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setPreferredSize(dimension);
        jFrame.pack();
        jFrame.setVisible(true);

    }

    public static void start(){
       new MainMenu();
    }
}


class Frame1 extends JFrame implements ActionListener
{
    JButton b=new JButton("New Frame");

    public Frame1()
    {
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(b);

        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae)
    {
        Frame1 obj2=new Frame1();
        //dispose();
    }
}
