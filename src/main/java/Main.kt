import com.parcel.harddrivers.Commutator

fun nain(args: Array<String>)
{

    val dev = Commutator("Anna")
    if (dev.findPort() == "ERROR") {
        println("Ошибка поиска порта")
        return
    }
    else
    {
        val db = DataBase()
        while (true) {
            val data = dev.analogRead()
            if (data != null) {
                db.write(data.data)
            }
        }
    }

}