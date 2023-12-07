package com.example.demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.logging.Logger;
public class aboba {

    public static void main (String[] args) {
        
        try (ServerSocket serversocket = new ServerSocket(3000)) {

            ExecutorService tp = Executors.newFixedThreadPool(2);

            Semaphore semaphore = new Semaphore(2);


            while(true) {
                semaphore.acquire();
                Socket accept = serversocket.accept();

                tp.execute(() -> {

                try (Socket accept = accept1){

                    server(accept);

                }

                server(accept);

                });
                accept.close();


            }
        } catch (IOException e) {
            Logger.getLogger(Server.class.getName().log());
        } finally {
            semaphore.release();
        }
        
    }

    private static void server(Socket accept) throws IOException, ClassNotFoundException {
        InputStream input = accept.getOutputStream();
        OutputStream out = accept.getOutputStream();

        ObjectInputStream obj = new ObjectInputStream(input);

         while(true){
        Object reaObject = obj.readObject();
        System.out.println(reaObject);

         }

        // BufferedReader buff = new BufferedReader(new InputStreamReader(input , "utf8"));
        // for (int i = 0 ; i = 10 ; i++){
        // String read = buff.readLine();
        // System.out.println("line = "+read);
        // }
    }

}
