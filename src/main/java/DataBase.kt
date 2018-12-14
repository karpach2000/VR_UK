import java.sql.*

class DataBase
{

    protected lateinit var resSet: ResultSet
    protected lateinit var statmt: Statement
    lateinit var conn: Connection
    init
    {
        val url = "jdbc:sqlite:data.db"
        val conn  = DriverManager.getConnection(url)
        statmt = conn.createStatement()

    }
    fun write(vals :IntArray)
    {


        for(v in vals)
        {
            val sql = "UPDATE ArduinoData SET value = \"$v\", readed = \"false\");"
            try {
                conn.use { conn ->
                    conn.prepareStatement(sql).use {
                        System.out.printf("Activity recorded")
                    }
                }
            } catch (e: SQLException) {
                println(e.message)
            }
        }
    }
}