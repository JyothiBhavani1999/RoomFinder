package com.jyothi.RoomFinder.Controller;

import com.jyothi.RoomFinder.Model.Room;
import com.jyothi.RoomFinder.Repository.RoomRepository;
import com.jyothi.RoomFinder.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping
    public String hello() {
        return "Hello, Room Finder!";
    }


    @GetMapping("/add-room")
    public String showForm(){
        return "add-room";
    }

    @PostMapping("/add-room")
    public String addRoom(@ModelAttribute Room room) {
         roomService.addRoom(room);
         return "success";
    }

    @GetMapping("/rooms-list")
    public String listRooms(Model model) {
        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "rooms-list";
    }

    @GetMapping("/room/{id}")
    public String getRoomById(@PathVariable Long id, Model model){
        Room room = roomService.getRoomById(id);
        model.addAttribute("room", room);
        return "room-details";
    }

    @GetMapping("/edit-room/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
       Room room = roomService.getRoomById(id);
       model.addAttribute("room", room);
       return "edit-room";
    }

    @PostMapping("/update-room")
    public String updateRoom( @ModelAttribute Room room) {
        roomService.updateRoom( room);
        return "redirect:/rooms-list";
    }

    @GetMapping("/delete-room/{id}")
    public String deleteRoom(@PathVariable Long id){
       roomService.deleteRoom(id);
         return "redirect:/rooms-list";
    }


}
