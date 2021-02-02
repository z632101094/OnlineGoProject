package com.go.platform.service

import com.go.platform.model.Room
import com.go.platform.model.RoomList
import com.go.platform.response.ApiResult
import org.springframework.stereotype.Service

@Service
class RoomService {

    fun createRoom(roomName: String) : ApiResult {

        var room = Room(roomName, 1, false)
        var roomList = RoomList.roomList
        roomList.add(room)

        var apiResult = ApiResult()
        apiResult.isSuccess = true
        apiResult.message = "success"
        apiResult.code = 1
        apiResult.data = roomList
        return apiResult
    }

    fun getRoomList() : ApiResult {

        var apiResult = ApiResult()
        apiResult.isSuccess = true
        apiResult.message = "success"
        apiResult.code = 1
        apiResult.data = RoomList.roomList
        return apiResult
    }

    fun deleteRoom(roomId: Int) : ApiResult {
        var roomList = RoomList.roomList
        var roomListSet = RoomList.roomListSet
        for (room in roomList) {
            if (room.roomId == roomId) {
                roomList.remove(room)
                roomListSet.add(roomId)

                var apiResult = ApiResult()
                apiResult.isSuccess = true
                apiResult.message = "success"
                apiResult.code = 1
                apiResult.data = true
                return apiResult
            }
        }

        var apiResult = ApiResult()
        apiResult.isSuccess = false
        apiResult.message = "false"
        apiResult.code = 1
        apiResult.data = false
        return apiResult
    }

    fun enterRoom(roomId: Int) : ApiResult {
        var roomList = RoomList.roomList
        var roomListSet = RoomList.roomListSet
        for (room in roomList) {
            if (room.roomId == roomId) {
                room.players = 2

                var apiResult = ApiResult()
                apiResult.isSuccess = true
                apiResult.message = "success"
                apiResult.code = 1
                apiResult.data = true
                return apiResult

            }
        }

        var apiResult = ApiResult()
        apiResult.isSuccess = false
        apiResult.message = "false"
        apiResult.code = 1
        apiResult.data = false
        return apiResult
    }



}