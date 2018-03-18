package com.company;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {



   try {
String webUrl="https://github.com";
        URL url = new URL(webUrl);
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        Scanner scanner = new Scanner(inputStream);

        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append('\n');
        }

            System.out.println(sb);

        Pattern pattern = Pattern.compile("(http|https|ftp)://\\S*?\\.(png|jpg|bmp)");
        Matcher matcher = pattern.matcher(sb.toString());


       while (matcher.find()) {

           String imageUrl=matcher.group();

           Pattern patternimg = Pattern.compile("[^/]+$");
           Matcher matcher1 = patternimg.matcher(imageUrl);

           String filename = matcher1.group();
           URL urlImg = new URL(imageUrl);
           InputStream in = new BufferedInputStream(urlImg.openStream());
           ByteArrayOutputStream out = new ByteArrayOutputStream();
           byte[] buf = new byte[1024];
           int n = 0;
           while ((n=in.read(buf))!=-1)
           {
               out.write(buf, 0, n);
           }
           out.close();
           in.close();
           byte[] response = out.toByteArray();


           FileOutputStream fos = new FileOutputStream("/Users/victoria/IdeaProjects/Site/src/"+filename);
           fos.write(response);
           fos.close();





           System.out.println(imageUrl);

           System.out.println(matcher1.group());

       }

    } catch (IOException e) {
        e.printStackTrace();
    }

}



}
