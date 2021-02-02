package com.go.platform.model

class Room {
    var roomId: Int
    var roomName: String? = null
    var players = 0
    var start = false


    @JvmOverloads
    constructor(
                roomName: String,
                players: Int,
                start: Boolean) : super() {
        this.roomId = assignRoomId()
        this.roomName = roomName
        this.players = players
        this.start = start
    }

    fun assignRoomId() : Int{
        var roomListSet = RoomList.roomListSet
        var id = roomListSet.shuffled().take(1)[0]
        return id
    }

}