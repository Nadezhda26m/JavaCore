package org.example.task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;

import static java.nio.file.StandardCopyOption.*;

public class Main {

    public static void main(String[] args) {
        makeBackupFiles("Homework5", BACKUP_FOLDER);

    }

    /**
     * Путь до папки, в которую будут копироваться файлы<br>
     * "JavaCore\backup"
     */
    private static final String BACKUP_FOLDER = "backup";

    /**
     * Скопировать файлы из указанной папки в папку назначения без поддерикторий.
     * Если файл с таким назвнием уже существует в папке назначения, то он будет заменен.
     *
     * @param pathToSrcFolder    абсолютный или относительный путь до папки,
     *                           содержимое которой нужно скопировать
     * @param pathToTargetFolder абсолютный или относительный путь до папки,
     *                           в которую будут помещены копии файлов
     */
    public static void makeBackupFiles(String pathToSrcFolder, String pathToTargetFolder) {
        File folder = new File(pathToSrcFolder);
        if (folder.exists() && folder.isDirectory()) {
            LinkedList<File> files = getFilesInsideFolder(folder);
            File backupDir = new File(pathToTargetFolder);
            if (!backupDir.exists()) {
                backupDir.mkdirs();
                System.out.println("Создана директория для резервных копий: "
                        + backupDir.getAbsolutePath());
            }

            pathToTargetFolder = backupDir.getAbsolutePath() + File.separatorChar;
            File destFile;
            for (File file : files) {
                try {
                    destFile = new File(pathToTargetFolder + file.getName());
                    Files.copy(file.toPath(), destFile.toPath(), REPLACE_EXISTING);
                } catch (IOException e) {
                    System.out.println("Не удалось скопировать файл " + file.getPath());
                }
            }
        } else {
            System.out.println("Неверно указан путь к папке-источнику");
        }
    }

    /**
     * Получить список файлов в директории без поддиректорий.
     *
     * @param folder ссылка на директорию
     * @return список файлов в указанной директории
     */
    private static LinkedList<File> getFilesInsideFolder(File folder) {
        LinkedList<File> files = new LinkedList<>();
        File[] content = folder.listFiles();
        if (content != null) {
            for (File file : content) {
                if (!file.isDirectory()) {
                    files.add(file);
                }
            }
        }
        return files;
    }

}
