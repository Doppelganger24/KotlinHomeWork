import com.example.kotlinhomework.ui.model.Repository
import com.example.kotlinhomework.ui.model.Weather
import com.example.kotlinhomework.ui.model.getRussianCities
import com.example.kotlinhomework.ui.model.getWorldCities


class RepositoryImpl : Repository {
    override fun getWeatherFromServer(): Weather {
        return Weather(); }

    override fun getWeatherFromLocalRussian(): List <Weather> {
        return getRussianCities(); }

    override fun getWeatherFromLocalWorld(): List <Weather> {
        return getWorldCities(); }
}