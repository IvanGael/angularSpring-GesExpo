package com.project.GesExpo.services.impl;

import com.project.GesExpo.services.def.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        //File name
        String name = file.getOriginalFilename();

        //Random name generate file
        String randomId = UUID.randomUUID().toString();
        String filename = randomId.concat(name.substring(name.lastIndexOf(".")));

        //Fullpath
        String filepath = path + File.separator + filename;

        //Create folder if not created
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }

        //File copy
        Files.copy(file.getInputStream(), Paths.get(filepath));

        return filename;
    }

    @Override
    public InputStream getResource(String path, String filename) throws FileNotFoundException {
        String fullpath = path + File.separator + filename;
        InputStream is = new FileInputStream(fullpath);
        return is;
    }
}
