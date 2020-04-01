package go.com.test;

import java.util.ArrayList;
import java.util.List;

public class Test {

         private static List<FileInfo> fileList= new ArrayList<FileInfo>();

         public static void main(String[] args) throws InterruptedException {

                   createFileInfo();

                   long startTime=System.currentTimeMillis();

                   for(FileInfo fi:fileList){

                            Thread.sleep(1);

                   }

                   long endTime=System.currentTimeMillis();

                   System.out.println("单线程耗时："+(endTime-startTime)+"ms");

         }

        

         private static void createFileInfo(){

                   for(int i=0;i<30000;i++){

                            fileList.add(new FileInfo("身份证正面照","jpg","101522","md5"+i,"1"));

                   }

         }

}