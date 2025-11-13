package com.jyothi.RoomFinder.Service;

import com.jyothi.RoomFinder.Model.Room;
import com.jyothi.RoomFinder.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public void addRoom(Room room){
        if(room.getRent() <=750){
            throw new IllegalArgumentException("Rent must be greater than 750");
        }
        roomRepository.save(room);
    }

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id){
        return  roomRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Room not found with id: " + id));
    }

    public void updateRoom(Room room){
       Room existingRoom =roomRepository.findById(room.getId()).orElseThrow(() -> new IllegalArgumentException("Room not found with id: " + room.getId()));
         existingRoom.setCity(room.getCity());
         existingRoom.setAddress(room.getAddress());
         existingRoom.setRent(room.getRent());
            roomRepository.save(existingRoom);
    }




}
