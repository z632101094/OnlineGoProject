package com.go.platform.controller

import com.go.platform.model.Room
import com.go.platform.model.RoomList
import com.go.platform.response.ApiResult
import com.go.platform.service.RoomService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = arrayOf("*"))
@RequestMapping("/room")
class RoomController {
    @Autowired
    private val roomService: RoomService? = null


    @PostMapping("/createRoom")
    fun createRoom(roomName: String) : ApiResult {
        val roomService = RoomService()
        return roomService.createRoom(roomName)
    }

    @GetMapping("/getRoomList")
    fun getRoomList() : ApiResult {
        val roomService = RoomService()
        return roomService.getRoomList()
    }

    @PutMapping("/deleteRoom")
    fun deleteRoom(roomId: Int) : ApiResult {
        val roomService = RoomService()
        return roomService.deleteRoom(roomId)
    }

    @PutMapping("/enterRoom")
    fun enterRoom(roomId: Int) : ApiResult {
        val roomService = RoomService()
        return roomService.enterRoom(roomId)
    }




}