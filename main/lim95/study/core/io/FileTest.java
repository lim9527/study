package main.lim95.study.core.io;

import java.io.*;

/**
 * Created by lim9527 on 5/10 0010.
 */
public class FileTest {


    public static void main(String[] args){
        String url = "G:\\知乎\\有一群漂亮的朋友是什么体验？";
        String url2 = "g:\\1.txt";

        //traverseDires("G:\\知乎\\有一群漂亮的朋友是什么体验？");
        //readFile(url+"\\0.jpg");

        //copyFile(url+"\\0.jpg", url + "\\1.jpg");
        //copyFile("g:\\1.txt", "g:\\2.txt");
        copyFileChar("g:\\1.txt", "g:\\3.txt");

    }


    public static void copyFileBuf(String ori, String copy){

        BufferedReader br = null;
        FileReader fr = null;

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fr = new FileReader(ori);
            br = new BufferedReader(fr);

            fw = new FileWriter(copy);
            bw = new BufferedWriter(fw);

            String s = "";
            while ((s=br.readLine()) != null){
                System.out.println(""+s);
                bw.write(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) fr.close();
                if (br != null) br.close();
                if (fw != null) fw.close();
                if (bw != null) bw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }


    public static void copyFileChar(String ori, String copy){
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader(ori);
            fw = new FileWriter(copy);

            char[] chars = new char[512];
            int len = 0;

            while((len = fr.read(chars)) != -1){
                fw.write(chars, 0, len);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) fr.close();
                if (fw != null) fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


    /**
     * 复制文件
     * @param ori_url
     * @param cp_url
     */
    public static void copyFile(String ori_url, String cp_url){
        File file_in = new File(ori_url);
        File file_cp = new File(cp_url);

        if(file_cp.exists()){
            System.out.println("该文件名已存在！"+file_cp.getName());
            return;
        }


        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(file_in);
            fos = new FileOutputStream(file_cp);

            byte[] bytes = new byte[1024];
            int len = 0;

            while((len = fis.read(bytes)) != -1){
                fos.write(bytes, 0 , len);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 读取文件
     */
    public static void readFile(String url){
        File file = new File(url);

        try {
            FileInputStream fis = new FileInputStream(file);
            fis.read();
            byte[] bytes = new byte[1024];

            int len = 0 ;
            while((len = fis.read(bytes)) != -1){

                String s = new String(bytes, 0, len);

                System.out.println(s);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("找不到文件");
        } catch (IOException e){

        }


    }


    /**
     * 遍历文件夹，读取里面的文件
     * @param url
     */
    public static void traverseDires(String url){
        File file = new File(url);

        File[] fileList = file.listFiles();
        for (File f : fileList){
            System.out.println("文件名："+f.getName());
        }
    }


    /**
     * 创建文件夹
     */
    public static void createDirs(){
        File file = new File("G:\\java_io_测试\\123\\456\\789");

        if (!file.isDirectory()){
            System.out.println("file.isDirectory;");
            if (!file.exists()){
                file.mkdirs();
                System.out.println("file.mkdir();");
            }

        }
    }
}
