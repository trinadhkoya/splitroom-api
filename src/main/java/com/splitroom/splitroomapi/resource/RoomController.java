package com.splitroom.splitroomapi.resource;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.splitroom.splitroomapi.model.Room;
import com.splitroom.splitroomapi.repository.RoomRepository;



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
	public List<Room> getAllrooms() {
		return roomRepository.findAll();
	}


	@GetMapping("/rooms/{id}")
	public ResponseEntity<Room> getroomById(@PathVariable Long id) {
		Room room = roomRepository.findOne(id);
		if (room == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(room);
	}


	@PostMapping(value = "/rooms", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Room createroom(@Valid @RequestBody Room room) {
		return roomRepository.save(room);
	}


	@PutMapping("/rooms/{id}")
	public ResponseEntity<Room> updateroom(@PathVariable Long id,
			@Valid @RequestBody Room roomDetails) {
		Room room = roomRepository.findOne(id);
		if (room == null) {
			return ResponseEntity.notFound().build();
		}
		room.setRoomName(roomDetails.getRoomName());
		room.setIsRoomActive(roomDetails.getIsRoomActive());

		Room updatedRoom = roomRepository.save(room);
		return ResponseEntity.ok(updatedRoom);
	}


	@DeleteMapping("/rooms/{id}")
	public ResponseEntity<Room> deleteroom(@PathVariable Long id) {
		Room room = roomRepository.findOne(id);
		if (room == null) {
			return ResponseEntity.notFound().build();
		}

		roomRepository.delete(room);
		return ResponseEntity.ok().build();
	}

}
