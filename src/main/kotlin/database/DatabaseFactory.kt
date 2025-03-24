package com.example.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    private val dbConfig = HikariConfig().apply {
        jdbcUrl = "jdbc:postgresql://localhost:5700/esdiac_news"
        driverClassName = "org.postgresql.Driver"
        username = "postgres"
        password = "Hassana@2001"
        maximumPoolSize = 5
    }

    private val dataSource = HikariDataSource(dbConfig)

    fun init() {
        Database.connect(dataSource)
        transaction {
            SchemaUtils.create(Users)
        }
    }
}
