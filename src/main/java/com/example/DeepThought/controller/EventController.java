/*
 * Author Name: Jaival
 * Date: 25-05-2023
 * Createdd with IntelliJ IDEA Community Editiion
 */
package com.example.DeepThought.controller;

import com.example.DeepThought.domain.Event;
import com.example.DeepThought.repository.EventRepository;
import com.example.DeepThought.service.IEventService;
import com.example.DeepThought.util.ImageUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v3/app")
public class EventController {
    private final IEventService iEventService;
    private final EventRepository eventRepository;

    @Autowired
    public EventController(IEventService iEventService,
                           EventRepository eventRepository) {
        this.iEventService = iEventService;
        this.eventRepository = eventRepository;
    }

//    @PostMapping("/saveEvent")
//    public ResponseEntity<?> saveFunc(@RequestBody Event event) {
//        return new ResponseEntity<>(iEventService.saveEvent(event), HttpStatus.CREATED);
//    }

    @GetMapping("/fetch")
    public ResponseEntity<?> fetchFunc() {
        return new ResponseEntity<>(iEventService.getAllEvents(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteEvent/{uid}")
    public ResponseEntity<?> saveFunction(@PathVariable int uid) {
        iEventService.deleteEvent(uid);
        return new ResponseEntity<>("Event Record Deleted", HttpStatus.OK);
    }

    @GetMapping("/fetchbyid/{uid}")
    public ResponseEntity<?> fetchFunction(@PathVariable int uid) {
        return new ResponseEntity<>(iEventService.fetchById(uid), HttpStatus.OK);
    }

    @PutMapping("/updateEvent/{uid}")
    public ResponseEntity<?> updateById(@RequestBody Event event, @PathVariable int uid) {
        return new ResponseEntity<>(iEventService.updateEvent(event, uid), HttpStatus.ACCEPTED);
    }

    @PostMapping("/saveEvent")
    public ResponseEntity<?> saveUserProfile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("event") String userData

    ) throws IOException {

        Event event = new ObjectMapper().readValue(userData, Event.class);
        event.setImageName(file.getOriginalFilename());
        event.setType(file.getContentType());
        event.setImage(ImageUtility.compressImage(file.getBytes()));
        Event dbUser = iEventService.saveEvent(event);
        if (dbUser != null) {
            return new ResponseEntity<>(new ImageUploadResponse("User is saved"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ImageUploadResponse("User is not saved"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = {"/get/image/{uid}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("uid") int uid) throws IOException {

        final Optional<Event> dbImage = eventRepository.findById(uid);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(ImageUtility.decompressImage(dbImage.get().getImage()));
    }
}
