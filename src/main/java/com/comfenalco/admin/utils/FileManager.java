/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rockerW7
 */
public abstract class FileManager {

    private final static Logger LOGGER = Logger.
            getLogger(FileManager.class.getName());

    private static Path absolutePath;
    private static Path file;

    public static void saveFile(String path, List<String> info) {

        try {

            absolutePath = Paths.get(path);

            Files.deleteIfExists(absolutePath);//Eliminamos el archivo maestro si éste ya existe
            file = Files.createFile(absolutePath);

            PrintWriter pw = new PrintWriter(file.toFile());

            for (String line : info) {

                pw.print(line);
                pw.println();

                System.out.println("Line: " + line);
            }

            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
