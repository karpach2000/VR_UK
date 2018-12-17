package com.vr

import java.sql.*

class DataBase
{

    protected lateinit var resSet: ResultSet
    protected lateinit var statmt: Statement
    private val url = "jdbc:sqlite:data.db"
    lateinit var conn: Connection
    init
    {

        conn  = DriverManager.getConnection(url)
        statmt = conn.createStatement()
        conn.close();


    }
    fun write(vals :IntArray)
    {


        var i=0
        conn  = DriverManager.getConnection(url)
        val statement = conn.createStatement()
        for(v in vals)
        {
            val sql = "UPDATE ArduinoData SET value = \"$v\" WHERE dataName = \"A$i\";"
            try {


                val comand = (sql)
                statement.executeUpdate(comand)


            } catch (ex: SQLException) {
                print(ex)
            }
            i++
        }
        conn.close()
    }


}