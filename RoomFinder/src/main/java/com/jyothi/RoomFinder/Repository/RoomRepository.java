package com.jyothi.RoomFinder.Repository;

import com.jyothi.RoomFinder.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
