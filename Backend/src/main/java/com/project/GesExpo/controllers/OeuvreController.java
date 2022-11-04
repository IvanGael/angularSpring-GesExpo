package com.project.GesExpo.controllers;

import com.project.GesExpo.dto.OeuvreDto;
import com.project.GesExpo.response.ApiResponse;
import com.project.GesExpo.services.def.FileService;
import com.project.GesExpo.services.def.OeuvreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/oeuvre")
public class OeuvreController {

    @Autowired
    private OeuvreService oeuvreService;

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    //POST - CREATE OEUVRE
    @PostMapping("/create")
    public ResponseEntity<OeuvreDto> createOeuvre(@Valid @RequestBody OeuvreDto oeuvreDto ){
        oeuvreDto.setDateCreation(LocalDate.now());
        oeuvreDto.setImage("default.png");
        OeuvreDto createdOeuvreDto = this.oeuvreService.createOeuvre(oeuvreDto);
        return new ResponseEntity<OeuvreDto>(createdOeuvreDto, HttpStatus.CREATED);
    }

    //POST - POST OEUVRE IMAGE
    @PostMapping("/{oeuvreId}/post/image")
    public ResponseEntity<OeuvreDto> postImage(
            @RequestParam("image") MultipartFile image,
            @PathVariable("oeuvreId") Long oeuvreId) throws IOException {

        OeuvreDto oeuvreDto = this.oeuvreService.getOeuvreById(oeuvreId);
        String filename = this.fileService.uploadImage(path, image);
        oeuvreDto.setImage(filename);
        OeuvreDto updatedOeuvreDto = this.oeuvreService.updateOeuvre(oeuvreDto, oeuvreId);
        return new ResponseEntity<OeuvreDto>(updatedOeuvreDto, HttpStatus.OK);
    }

    //GET - GET OEUVRE IMAGE
    @GetMapping(value = "/{oeuvreId}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(
            HttpServletResponse response,
            @PathVariable("oeuvreId") Long oeuvreId) throws IOException{
        OeuvreDto oeuvreDto = this.oeuvreService.getOeuvreById(oeuvreId);
        InputStream resource = this.fileService.getResource(path, oeuvreDto.getImage());
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource, response.getOutputStream());
    }

    //PUT - UPDATE OEUVRE
    @PutMapping("/update/{oeuvreId}")
    public ResponseEntity<OeuvreDto> updateOeuvre(@Valid @RequestBody OeuvreDto oeuvreDto, @PathVariable("oeuvreId") Long oeuvreId){
        OeuvreDto updatedOeuvreDto = this.oeuvreService.updateOeuvre(oeuvreDto,oeuvreId);
        return ResponseEntity.ok(updatedOeuvreDto);
    }

    //DELETE - DELETE OEUVRE
    @DeleteMapping("/{oeuvreId}")
    public ResponseEntity<ApiResponse> deleteOeuvre(@PathVariable("oeuvreId") Long oeuvreId){
        this.oeuvreService.deleteOeuvre(oeuvreId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Oeuvre deleted successfully", true), HttpStatus.OK);
    }

    //GET - GET SINGLE OEUVRE
    @GetMapping(value = "/{oeuvreId}")
    public ResponseEntity<OeuvreDto> getSingleOeuvre(@PathVariable("oeuvreId") Long oeuvreId) {
        OeuvreDto oeuvreDto = this.oeuvreService.getOeuvreById(oeuvreId);
        return ResponseEntity.ok(oeuvreDto);
    }


    //GET - GET LIST OEUVRE
    @GetMapping("/all")
    public ResponseEntity<List<OeuvreDto>> getAllOeuvres(){
        return ResponseEntity.ok(this.oeuvreService.getAllOeuvres());
    }

}
