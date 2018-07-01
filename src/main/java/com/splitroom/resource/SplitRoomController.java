package com.splitroom.resource;

import com.splitroom.model.Expenditure;
import com.splitroom.model.Room;
import com.splitroom.repository.ExpenditureRepository;
import com.splitroom.repository.ItemRepository;
import com.splitroom.repository.MemberRepository;
import com.splitroom.repository.RoomRepository;
import javassist.compiler.MemberResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SplitRoomController {

    private RoomRepository roomRepository;
    private ItemRepository itemRepository;
    private MemberRepository memberRepository;
    private ExpenditureRepository expenditureRepository;

    @Autowired
    public SplitRoomController(RoomRepository roomRepository, ItemRepository itemRepository,
                               MemberRepository memberRepository, ExpenditureRepository expenditureRepository) {
        this.roomRepository = roomRepository;
        this.itemRepository = itemRepository;
        this.memberRepository = memberRepository;
        this.expenditureRepository = expenditureRepository;
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        Room room = roomRepository.findOne(id);
        if (room == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(room);
    }

    @RequestMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @PostMapping(value = "/rooms", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Room addRoom(@Valid @RequestBody Room room) {
        return roomRepository.save(room);
    }


    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable Long id) {
        Room room = roomRepository.findOne(id);
        if (room == null) {
            return ResponseEntity.notFound().build();
        }
        roomRepository.delete(room);
        return ResponseEntity.ok().build();
    }


}
