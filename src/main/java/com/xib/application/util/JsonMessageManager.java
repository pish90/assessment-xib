package com.xib.application.util;


import com.fasterxml.jackson.databind.*;
import com.xib.application.model.Manager;

import java.io.*;


public class JsonMessageManager {
    public void extractKeys(String jsonFilename) {
        try {
            String lineInfo;
            String[] splitter;

            BufferedReader bReader = new BufferedReader(new FileReader(jsonFilename));

            while ((lineInfo = bReader.readLine()) != null) {
                splitter = lineInfo.split(":");
                splitter[0] = splitter[0].replaceAll("\"", "");

                System.out.println(splitter[0].trim());
            }
        } catch (Exception e) {
            System.out.println("Unable to extract keys: " + e.getMessage());
        }
    }

    public void createJsonMessage() {
        Manager manager = new Manager();

        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            System.out.println(jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(manager));
        } catch (Exception e) {
            System.out.println("Creation Failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Function Started");
        System.out.println("----------------");

        JsonMessageManager msgManager = new JsonMessageManager();

        msgManager.createJsonMessage();

        System.out.println("----------------");
        System.out.println("Function Complete");
    }
}