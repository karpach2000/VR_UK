package com.vr

import com.parcel.harddrivers.Commutator


var dbBuisy = false
val db = DataBase()
fun main()
{

    val settings= Settings()
    settings.update()
    println("Plata name: ${settings.plataName}")
    val dev = Commutator(settings.plataName)
    if (dev.findPort() == "ERROR") {
        println("Ошибка поиска порта")
        return
    }
    else
    {

        while (true) {
            val data = dev.analogRead()
            if (data != null) {
                val thread = Thread(Runnable { putToDb(data.data) })
                while(dbBuisy)
                {
                    Thread.sleep(0)
                }
                thread.start()

            }
        }
    }

}
fun putToDb(data :IntArray)
{
    dbBuisy=true
    db.write(data)
    dbBuisy=false
}