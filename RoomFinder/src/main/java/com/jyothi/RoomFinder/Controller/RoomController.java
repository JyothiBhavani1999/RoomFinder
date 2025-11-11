package com.jyothi.RoomFinder.Controller;

import com.jyothi.RoomFinder.Model.Room;
import com.jyothi.RoomFinder.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomController {
    @Autowired
    RoomRepository roomRepository;

    @GetMapping
    public String hello() {
        return "Hello, Room Finder!";
    }

    @GetMapping("/rooms-list")
    public String listRooms(Model model) {
        List<Room> rooms = roomRepository.findAll();
        model.addAttribute("rooms", rooms);
        return "rooms-list";
    }

    @GetMapping("/add-room")
    public String showForm(){
        return "add-room";
    }

    @PostMapping("/add-room")
    public String addRoom(@ModelAttribute Room room) {
         roomRepository.save(room);
         return "success";
    }

}
