package com.go.platform.dao

import com.go.platform.entity.UsersEntity
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class UsersDao {

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


    fun getUserByUsername(username: String?): UsersEntity {
        val sf = Configuration().configure().buildSessionFactory()
        val session = sf.openSession()
        session.beginTransaction()

        val hql = "from UsersEntity WHERE username = :username "
        val query = session.createQuery(hql)
        query.setParameter("username", username)
        val user = query.singleResult as UsersEntity

        session.transaction.commit()
        return user
    }
}