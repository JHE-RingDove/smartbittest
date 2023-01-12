package com.smartbit.test_smartbit

import android.content.ClipDescription
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.time.temporal.TemporalAmount

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {


    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE \"goods\" (\n" +
                "id INTEGER NOT NULL,\n" +
                "name TEXT NOT NULL UNIQUE,\n" +
                "amount INTEGER NOT NULL,\n" +
                "description TEXT NOT NULL,\n" +
                "PRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ")")
        db.execSQL(query)
        db.execSQL("insert into goods VALUES\n"+
                "(1, \"Пицца\", 12, \"Вкусно\"),\n" +
                "(2, \"Бургер\", 3, \"Вкуснятина\"),\n" +
                "(3, \"Мандарин\", 31, \"Вкуснотища\"),\n" +
                "(4, \"Лазанья\", 15, \"Вкуснота\"),\n" +
                "(5, \"Молоко\", 36, \"Кайф\"),\n" +
                "(6, \"Картоха\", 243, \"Вкуснишко\"),\n" +
                "(7, \"Конфета\", 367, \"Вкусненько\"),\n" +
                "(8, \"Шоколад\", 2001, \"Мегавкусно\")\n")
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }







    companion object{

        private const val DATABASE_NAME = "goods2.db"

        private const val DATABASE_VERSION = 9

        const val TABLE_NAME = "goods"
        const val NAME_COL = "name"
        const val AMOUNT_COL = "amount"
        const val DESCRIPTION_COL = "description"


    }
}