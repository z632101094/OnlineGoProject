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
        val sf = Configuration().configure().buildSessionFactory()
        val session = sf.openSession()
        session.beginTransaction()


        val user = UsersEntity()
        user.username = username
        user.password = BCryptPasswordEncoder().encode(password)
        session.save(user)

        session.transaction.commit()
        return user
    }

    fun getAllUsers(): List<UsersEntity> {

        val sf: SessionFactory = Configuration().configure().buildSessionFactory()
        val session: Session = sf.openSession()
        session.beginTransaction()

        val users: List<UsersEntity> = session.createQuery("from UsersEntity", UsersEntity::class.java).getResultList()

        session.getTransaction().commit()

        return users
    }



    fun getUserById(id: Int?): UsersEntity? {
        val sf = Configuration().configure().buildSessionFactory()
        val session = sf.openSession()
        session.beginTransaction()

        val user = session.get(UsersEntity::class.java, id) as UsersEntity?

        session.transaction.commit()
        return user
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