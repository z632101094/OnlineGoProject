package com.go.platform.dao

import com.go.platform.entity.UsersEntity
import org.hibernate.cfg.Configuration

class UsersDao {
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