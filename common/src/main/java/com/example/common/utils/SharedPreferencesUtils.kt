package com.example.common.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Base64
import com.example.common.GlobalConstant
import java.io.*

class SharedPreferencesUtils {
    companion object {
        private const val PREFERENCE_NAME = GlobalConstant.SHARE_CONFIG

        fun remove(context: Context, key: String): Boolean {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            val editor = settings.edit()
            editor.remove(key)
            return editor.commit()
        }


        fun putString(context: Context, key: String, value: String) {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            val editor = settings.edit()
            editor.putString(key, value).apply()
        }


        fun putStringByCommit(context: Context, key: String, value: String): Boolean {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            val editor = settings.edit()
            editor.putString(key, value)
            return editor.commit()
        }

        fun getString(context: Context, key: String): String? {
            return getString(context, key, "")
        }

        @Suppress("UnPrivate")
        fun getString(context: Context, key: String, defaultValue: String?): String? {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            return settings.getString(key, defaultValue)
        }


        fun putInt(context: Context, key: String, value: Int) {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            val editor = settings.edit()
            editor.putInt(key, value).apply()
        }


        fun putIntByCommit(context: Context, key: String, value: Int): Boolean {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            val editor = settings.edit()
            editor.putInt(key, value)
            return editor.commit()
        }

        fun getInt(context: Context, key: String): Int {
            return getInt(context, key, -1)
        }

        @Suppress("UnPrivate")
        fun getInt(context: Context, key: String, defaultValue: Int): Int {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            return settings.getInt(key, defaultValue)
        }


        fun putLong(context: Context, key: String, value: Long) {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            val editor = settings.edit()
            editor.putLong(key, value).apply()
        }


        fun putLongByCommit(context: Context, key: String, value: Long): Boolean {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            val editor = settings.edit()
            editor.putLong(key, value)
            return editor.commit()
        }

        fun getLong(context: Context, key: String): Long {
            return getLong(context, key, -1)
        }

        @Suppress("UnPrivate")
        fun getLong(context: Context, key: String, defaultValue: Long): Long {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            return settings.getLong(key, defaultValue)
        }

        fun putFloat(context: Context, key: String, value: Float) {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            val editor = settings.edit()
            editor.putFloat(key, value).apply()
        }


        fun putFloatByCommit(context: Context, key: String, value: Float): Boolean {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            val editor = settings.edit()
            editor.putFloat(key, value)
            return editor.commit()
        }

        fun getFloat(context: Context, key: String): Float {
            return getFloat(context, key, (-1).toFloat())
        }

        @Suppress("UnPrivate")
        fun getFloat(context: Context, key: String, defaultValue: Float): Float {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            return settings.getFloat(key, defaultValue)
        }

        fun putBoolean(context: Context, key: String, value: Boolean) {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            val editor = settings.edit()
            editor.putBoolean(key, value).apply()
        }


        fun putBooleanByCommit(context: Context, key: String, value: Boolean): Boolean {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            val editor = settings.edit()
            editor.putBoolean(key, value)
            return editor.commit()
        }

        fun getBoolean(context: Context, key: String): Boolean {
            return getBoolean(context, key, false)
        }

        @Suppress("UnPrivate")
        fun getBoolean(context: Context, key: String, defaultValue: Boolean): Boolean {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            return settings.getBoolean(key, defaultValue)
        }

        fun putAny(context: Context, key: String, value: Any) {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            val editor = settings.edit()
            val outputStream = ByteArrayOutputStream()
            var out: ObjectOutputStream? = null

            try {
                out = ObjectOutputStream(outputStream)
                out.writeObject(value)
                val objectVal = String(Base64.encode(outputStream.toByteArray(), Base64.DEFAULT))
                editor.putString(key, objectVal)
                editor.apply()
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                try {
                    outputStream.close()
                    out?.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }


        }


        fun <T> getAny(context: Context, key: String): T? {
            val settings: SharedPreferences = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE
            )
            if (settings.contains(key)) {
                val objectVal = settings.getString(key, null)
                val buffer = Base64.decode(objectVal, Base64.DEFAULT)
                val inputStream = ByteArrayInputStream(buffer)
                var ois: ObjectInputStream? = null
                try {
                    ois = ObjectInputStream(inputStream)
                    return ois.readObject() as T
                } catch (e: IOException) {
                    e.printStackTrace()
                } catch (e: ClassNotFoundException) {
                    e.printStackTrace()
                } catch (e: StreamCorruptedException) {
                    e.printStackTrace()
                } finally {
                    try {
                        inputStream.close()
                        ois?.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }

            }
            return null
        }


    }
}

