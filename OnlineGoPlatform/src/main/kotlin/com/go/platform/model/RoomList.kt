package com.go.platform.model

import java.util.ArrayList

object RoomList {
    val total = 9999
    var roomListSet: MutableSet<Int> = setInit(total)
    var roomList: MutableList<Room> = ArrayList()

    fun setInit(total: Int): MutableSet<Int> {           //initial the rooms index
        var roomListSet: MutableSet <Int> = HashSet()
        for (i in 1..total) {
            roomListSet.add(i)
        }
        return roomListSet
    }
}