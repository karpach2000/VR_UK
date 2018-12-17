package com.vr

import com.google.gson.GsonBuilder
import java.io.File
import java.lang.Exception

class Settings {
    var plataName = "Anna"






    /**
     * Обновить настройки из файла.
     */
    fun update() : Boolean
    {
        /**
         *  Собрать файл из стрингов.
         */
        fun fromString(json: String)  : Boolean
        {
            try {
                var builder = GsonBuilder()
                var gson = builder.create()
                var pgs = gson.fromJson(json, Settings().javaClass)
                this.plataName = pgs.plataName

                return true
            }
            catch (e: Exception)
            {
                e.printStackTrace()
                return false
            }
        }//fun fromString(json: String)  : Boolean
        try {
            val file = File("Settings.txt")
            //проверяем, что если файл не существует то создаем его
            if (file.exists())
            {
                return  fromString(file.readText())
            }
            else
            {
                println("File not found")
                return false
            }
            return true
        }
        catch (e: Exception)
        {
            e.printStackTrace()
            return false
        }

    }

}