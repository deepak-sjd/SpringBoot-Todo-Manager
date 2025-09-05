package com.spring.todo.TodoManager.controllers;


import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class FileController {



    Logger logger = LoggerFactory.getLogger(FileController.class);
    @PostMapping("/single")
    public String uploadSingleFile(
            @RequestParam("image")MultipartFile file){
        logger.info("Name: {}",file.getName());
        logger.info("ContentType: {}",file.getContentType());
        logger.info("Original File Name: {}",file.getOriginalFilename());
        logger.info("File Size: {}",file.getSize());
       // file.getInputStream(). to help read and write file
//        InputStream inputStream = file.getInputStream();
//        FileOutputStream fileOutputStream = new FileOutputStream("data.png");
//        byte data[] = new byte[inputStream.available()];
//        fileOutputStream.write(data);

        return "File Test";


    }

    // for multiple file handle
    @PostMapping("/multiple")
    public String uploadMultipleFile(@RequestParam("files")MultipartFile[]files){ // MultiplePartFile is make array to store multiple file
        Arrays.stream(files).forEach(file -> {
            logger.info("Fine Name: {}", file.getOriginalFilename());
            logger.info("File Type: {}", file.getContentType());
            logger.info("File Size: {}", file.getSize());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            // call service to upload files and pass file object
        });
        return "Handling multiple file";

    }
    // serving image files in response

    @GetMapping("/serve-image")
    public void serveImageHandler(HttpServletResponse response){
        // image
        try {
         InputStream fileInputStream =  new FileInputStream("images/w18.jpg");
          response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(fileInputStream, response.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
