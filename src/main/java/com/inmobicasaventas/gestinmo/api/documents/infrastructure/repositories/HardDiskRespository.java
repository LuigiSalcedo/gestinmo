package com.inmobicasaventas.gestinmo.api.documents.infrastructure.repositories;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.inmobicasaventas.gestinmo.api.documents.infrastructure.configurations.StorageConfiguration;
import com.inmobicasaventas.gestinmo.api.documents.infrastructure.exceptions.UnavailableFilesService;

@Repository
public class HardDiskRespository {
    private Path path;
    private boolean init = false;

    public HardDiskRespository(StorageConfiguration storageConfiguration) {
        path = Paths.get(storageConfiguration.getLocation());
        init();
    }

    private void init() {
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            System.out.println(e);
        }
        init = true;
    }

    public List<Path> loadFilesFromFolder(String folderName) {
        if (!init) {
            throw new UnavailableFilesService();
        }
        List<Path> foundFiles;
        var folder = path.resolve(Paths.get(folderName));
        try (Stream<Path> files = Files.walk(folder)) {
            foundFiles = files.filter(Files::isRegularFile).toList();
        } catch (IOException exp) {
            return new ArrayList<>(1);
        }
        return foundFiles;
    }

    public boolean saveFile(Path fileDirection, InputStream data) {
        var destinationFile = path.resolve(fileDirection);
        try {
				Files.copy(data, destinationFile,
					StandardCopyOption.REPLACE_EXISTING);
		} catch(IOException e) {
            try{
                Files.createDirectories(destinationFile);
                Files.copy(data, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException ex) {
                System.out.println(e);
                return true;
            }
        }
        return true;
    }
}