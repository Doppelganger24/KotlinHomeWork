import com.example.kotlinhomework.ui.model.Repository
import com.example.kotlinhomework.ui.model.Weather


class RepositoryImpl : Repository {
    override fun getWeatherFromServer(): Weather {
        return Weather(); }

    override fun getWeatherFromLocal(): Weather {
        return Weather(); }
}