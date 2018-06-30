package com.splitroom.splitroomapi.resource;

import com.splitroom.splitroomapi.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @RequestMapping("/")
    public String sayHello() {
        return "Hi";
    }


}
