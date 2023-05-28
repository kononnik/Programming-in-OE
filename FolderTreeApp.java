package org.example;

import java.io.File;

public class FolderTreeApp {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        System.out.println(currentDir);
        printFolderTree(currentDir, 1);
    }

    private static void printFolderTree(String path, int indentLevel) {
        File directory = new File(path);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printIndent(indentLevel);
                    System.out.println(file.getName());
                    printFolderTree(file.getAbsolutePath(), indentLevel + 1);
                } else {
                    printIndent(indentLevel);
                    System.out.println(file.getName());
                }
            }
        }
    }

    private static void printIndent(int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("\t");
        }
    }
}
