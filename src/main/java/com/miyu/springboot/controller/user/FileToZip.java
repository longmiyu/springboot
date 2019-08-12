package com.miyu.springboot.controller.user;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipOutputStream;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.*;


public class FileToZip {
    public static void main(String[] args) throws Exception {
        String sourceFilePath = "H:\\test";
        String zipFilePath = "H:\\tmp";
        String fileName = "测试压缩文件";

        boolean flag = FileToZip.fileToZip(sourceFilePath, zipFilePath, fileName);
        if (flag) {
            System.out.println("文件打包成功!");
        } else {
            System.out.println("文件打包失败!");
        }
    }

    private static boolean fileToZip(String sourceFilePath, String zipFilePath, String fileName) throws ZipException {
        boolean flag = false;
        File sourceFile = new File(sourceFilePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        //设置压缩文件参数
        ZipParameters parameters = new ZipParameters();
        //设置压缩方法
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        //设置压缩级别
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
        //设置压缩文件是否加密
        parameters.setEncryptFiles(true);
        //设置aes加密强度
        parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
        //设置加密方法
        parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
        //设置密码
        parameters.setPassword("123");

        File file = new File(sourceFilePath);

        ZipFile zipFile = new ZipFile(zipFilePath + "/" + fileName + ".zip");
        if (file.exists()) {
            File[] arr = file.listFiles();
            for (File f : arr) {
                System.out.println(f.getName());
                zipFile.addFile(f, parameters);

            }
            flag = true;

        }



 /*        if(sourceFile.exists() == false){
            System.out.println("待压缩的文件目录："+sourceFilePath+"不存在.");
        }else{
            try {
                File zipFile = new File(zipFilePath + "/" + fileName +".zip");

                ZipFile zip = new ZipFile(zipFile);
                //设置压缩文件参数
                ZipParameters parameters = new ZipParameters();
                //设置压缩方法
                parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
                //设置压缩级别
                parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
                //设置压缩文件是否加密
                parameters.setEncryptFiles(true);
                //设置aes加密强度
                parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
                //设置加密方法
                parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
                //设置密码
                parameters.setPassword("123");



               if(zipFile.exists()){
                    System.out.println(zipFilePath + "目录下存在名字为:" + fileName +".zip" +"打包文件.");
                }else{
                    File[] sourceFiles = sourceFile.listFiles();
                    if(null == sourceFiles || sourceFiles.length<1){
                        System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
                    }else{
                        fos = new FileOutputStream(zipFile);
                        zos = new ZipOutputStream(new BufferedOutputStream(fos));



                        byte[] bufs = new byte[1024*10];
                        for(int i=0;i<sourceFiles.length;i++){
                            //创建ZIP实体，并添加进压缩包
                            ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                            zos.putNextEntry(zipEntry);
                            //读取待压缩的文件并写进压缩包里
                            fis = new FileInputStream(sourceFiles[i]);
                            bis = new BufferedInputStream(fis, 1024*10);
                            int read = 0;
                            while((read=bis.read(bufs, 0, 1024*10)) != -1){
                                zos.write(bufs,0,read);
                            }
                        }
                        flag = true;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally{
                //关闭流
                try {
                    if(null != bis) bis.close();
                    if(null != zos) zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }



        }*/
        return flag;
    }
}
