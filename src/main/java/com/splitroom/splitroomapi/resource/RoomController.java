package com.splitroom.splitroomapi.resource;

import com.splitroom.splitroomapi.model.RoomMember;
import com.splitroom.splitroomapi.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @RequestMapping("/")
    public String sayHello() {
        return "Hi";
    }


    @GetMapping("/rooms")
    public List<RoomMember> getAllrooms() {
        return roomRepository.findAll();
    }


    @GetMapping("/rooms/{id}")
    public ResponseEntity<RoomMember> getRoomById(@PathVariable Long id) {
        RoomMember roomMember = roomRepository.findOne(id);
        if (roomMember == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(roomMember);
    }


    @PostMapping(value = "/rooms", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RoomMember addRoom(@Valid @RequestBody RoomMember roomMember) {
        return roomRepository.save(roomMember);
    }


    @PutMapping("/rooms/{id}")
    public ResponseEntity<RoomMember> updateRoom(@PathVariable Long id,
                                                 @Valid @RequestBody RoomMember roomDetails) {
        RoomMember roomMember = roomRepository.findOne(id);
        if (roomMember == null) {
            return ResponseEntity.notFound().build();
        }
        roomMember.setRoomId(roomMember.getRoomId());
        roomMember.setName(roomMember.getName());
        RoomMember updatedRoom = roomRepository.save(roomMember);
        return ResponseEntity.ok(updatedRoom);
    }


    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<RoomMember> deleteRoom(@PathVariable Long id) {
        RoomMember roomMember = roomRepository.findOne(id);
        if (roomMember == null) {
            return ResponseEntity.notFound().build();
        }

        roomRepository.delete(roomMember);
        return ResponseEntity.ok().build();
    }

}
