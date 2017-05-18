package main.lim95.study.core.io;

/**
 * Created by lim9527 on 5/10 0010.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 *
 */
public class Notepad extends JFrame {

    //定义界面组件
    JTextArea jTextArea_main = null;
    JMenuBar jMenuBar = null;
    JMenu jMenu_file = null;
    JMenuItem jMenuItem_open = null;
    JMenuItem jMenuItem_save = null;

    public Notepad() {
        jTextArea_main = new JTextArea();
        jMenuBar = new JMenuBar();
        jMenu_file = new JMenu("文件");
        jMenu_file.setMnemonic('F');
        jMenuItem_open = new JMenuItem("打开");
        jMenuItem_save = new JMenuItem("保存");

        this.setJMenuBar(jMenuBar);
        jMenuBar.add(jMenu_file);
        jMenu_file.add(jMenuItem_open);
        jMenu_file.add(jMenuItem_save);

        jMenuItem_open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setDialogTitle("请选择文件");
                jFileChooser.showOpenDialog(null);
                jFileChooser.setVisible(true);

                String filePath = jFileChooser.getSelectedFile().getAbsolutePath();
                jTextArea_main.setText(readTxt(filePath));
            }
        });

        jMenuItem_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setDialogTitle("另存为");
                int value = jFileChooser.showSaveDialog(null);
                jFileChooser.setVisible(true);

                if (value == JFileChooser.APPROVE_OPTION){
                    String savePath = jFileChooser.getSelectedFile().getAbsolutePath();
                    saveTxt(savePath, jTextArea_main.getText());
                }
            }
        });



        this.add(jTextArea_main);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);

    }


    /**
     * 读取文本文件
     */
    public static String readTxt(String path){
        FileReader fr = null;
        BufferedReader br = null;

        String allCon = "";

        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String line = "";

            while((line = br.readLine()) != null){
                allCon += line + "\r\n";
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) fr.close();
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return allCon;

    }


    /**
     * 保存文本文件
     */
    public static void saveTxt(String path, String txt){
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(path);
            bw = new BufferedWriter(fw);

            bw.write(txt);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) bw.close();
                if (fw != null) fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
