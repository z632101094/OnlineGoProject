package com.go.platform.service

import com.go.platform.dao.UsersDao
import com.go.platform.entity.UsersEntity
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*


@Service
class UsersService: UserDetailsService {
    fun createUser(username: String?, password: String?): UsersEntity {
        val userDao = UsersDao()
        return userDao.createUser(username, password)
    }

    fun getAllUsers(): List<UsersEntity> {
        val userDao = UsersDao()
        return userDao.getAllUsers()
    }


    fun getUserById(id: Int?): UsersEntity? {
        val userDao = UsersDao()
        return userDao.getUserById(id)
    }

    fun getUserByUsername(username: String?): UsersEntity? {
        val userDao = UsersDao()
        return username?.let { userDao.getUserByUsername(it) }
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val userDao = UsersDao()
        val user = userDao.getUserByUsername(username)
        val simpleGrantedAuthorities: MutableList<SimpleGrantedAuthority> = ArrayList()
        simpleGrantedAuthorities.add(SimpleGrantedAuthority("normal"))
        return org.springframework.security.core.userdetails.User(user.username, user.password, true, true, true, true, simpleGrantedAuthorities)
    }
}