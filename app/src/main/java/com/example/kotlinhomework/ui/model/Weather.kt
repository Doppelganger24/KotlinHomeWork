package com.example.kotlinhomework.ui.model

import android.os.Parcelable
import com.example.kotlinhomework.R
import kotlinx.android.parcel.Parcelize

@Parcelize
class Weather(val city: City = getDefaultCity(), val temperature: Int = 22, val feelsLike: Int = 24) :
    Parcelable

fun getDefaultCity() = City("Новосибирск", 55.00835259999999, 82.93573270000002,R.drawable.cloud_lightning_snow)
@Parcelize
data class City(val name: String, val lat: Double, val long: Double, val drawable: Int):Parcelable

fun getWorldCities(): List<Weather> {
    return listOf(
        Weather(City("Лондон", 51.5085300, -0.1257400,R.drawable.cloud_lightning_snow), 1, 2),
        Weather(City("Токио", 35.6895000, 139.6917100,R.drawable.moon_cloud_rain__wind), 3, 4),
        Weather(City("Париж", 48.8534100, 2.3488000,R.drawable.lightning), 5, 6),
        Weather(City("Берлин", 52.52000659999999, 13.404953999999975,R.drawable.moon_rain_wind), 7, 8),
        Weather(City("Рим", 41.9027835, 12.496365500000024,R.drawable.rain), 9, 10),
        Weather(City("Минск", 53.90453979999999, 27.561524400000053,R.drawable.sun_cloud), 11, 12),
        Weather(City("Стамбул", 41.0082376, 28.97835889999999,R.drawable.sun), 13, 14),
        Weather(City("Вашингтон", 38.9071923, -77.03687070000001,R.drawable.cloud_lightning_snow), 15, 16),
        Weather(City("Киев", 50.4501, 30.523400000000038,R.drawable.moon_wind), 17, 18),
        Weather(City("Пекин", 39.90419989999999, 116.40739630000007,R.drawable.sun_cloud), 19, 20)
    )
}

fun getRussianCities(): List<Weather> {
    return listOf(
        Weather(City("Москва", 55.755826, 37.617299900000035,R.drawable.cloud_lightning_snow), 1, 2),
        Weather(City("Санкт-Петербург", 59.9342802, 30.335098600000038,R.drawable.moon_rain_wind), 3, 3),
        Weather(City("Екатеринбург", 56.83892609999999, 60.60570250000001,R.drawable.lightning), 7, 8),
        Weather(City("Нижний Новгород", 56.2965039, 43.936059,R.drawable.moon_stars_wind), 9, 10),
        Weather(City("Казань", 55.8304307, 49.06608060000008,R.drawable.sun_cloud_wind), 11, 12),
        Weather(City("Челябинск", 55.1644419, 61.4368432,R.drawable.sun_cloud_rain), 13, 14),
        Weather(City("Омск", 54.9884804, 73.32423610000001,R.drawable.moon_and_rain), 15, 16),
        Weather(City("Ростов-на-Дону", 47.2357137, 39.701505,R.drawable.sun_wind), 17, 18),
        Weather(City("Уфа", 54.7387621, 55.972055400000045,R.drawable.sun), 19, 20)
    )
}

