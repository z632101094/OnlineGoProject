package com.go.platform.controller

import com.go.platform.entity.UsersEntity
import com.go.platform.service.UsersService
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@CrossOrigin(origins = arrayOf("*"))
@RequestMapping("/users")
class UsersController {
    @Autowired
    private val usersService: UsersService? = null

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): List<UsersEntity> {
        val user1 = UsersEntity()
        user1.username = "xxx"

        val user2 = UsersEntity()
        user2.username = "yyy"

        val list: MutableList<UsersEntity> = ArrayList()
        list.add(user1)
        list.add(user2)

        return list
    }

    @PostMapping("/createUser")
    fun createUser(username: String, password: String): UsersEntity {
        val usersService = UsersService()
        return usersService.createUser(username, password)
    }

    @GetMapping("/getAllUsers")
    fun getAllUsers(): List<UsersEntity> {
        val usersService = UsersService()
        return usersService.getAllUsers()
    }


    @GetMapping("/getUserById")
    fun getUserById(id: Int): UsersEntity? {
        val usersService = UsersService()
        return usersService.getUserById(id)
    }


    @GetMapping("/getUserByUsername")
    fun getUserByUsername(username: String?): UsersEntity? {
        val usersService = UsersService()
        return usersService.getUserByUsername(username)
    }

}