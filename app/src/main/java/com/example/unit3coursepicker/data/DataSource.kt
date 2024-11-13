import com.example.unit3coursepicker.R
import com.example.unit3coursepicker.model.Topic

class DataSource() {
    fun loadTopics(): List<Topic> {
         return listOf<Topic>(
            Topic(R.string.architecture, 58, R.drawable.architecture),
             Topic(R.string.automotive, 58, R.drawable.automotive),
             Topic(R.string.biology, 58, R.drawable.biology),
            Topic(R.string.crafts, 121, R.drawable.crafts),
            Topic(R.string.business, 78, R.drawable.business),
            Topic(R.string.culinary, 118, R.drawable.culinary),
            Topic(R.string.design, 423, R.drawable.design),
             Topic(R.string.ecology, 58, R.drawable.ecology),
             Topic(R.string.engineering, 58, R.drawable.engineering),
            Topic(R.string.fashion, 92, R.drawable.fashion),
             Topic(R.string.finance, 58, R.drawable.finance),
            Topic(R.string.film, 165, R.drawable.film),
            Topic(R.string.gaming, 164, R.drawable.gaming),
             Topic(R.string.geology, 58, R.drawable.geology),
            Topic(R.string.drawing, 326, R.drawable.drawing),
             Topic(R.string.history, 58, R.drawable.history),
             Topic(R.string.journalism, 58, R.drawable.journalism),
             Topic(R.string.law, 58, R.drawable.law),
            Topic(R.string.lifestyle, 305, R.drawable.lifestyle),
            Topic(R.string.music, 212, R.drawable.music),
            Topic(R.string.painting, 172, R.drawable.painting),
            Topic(R.string.photography, 321, R.drawable.photography),
             Topic(R.string.physics, 58, R.drawable.physics),
            Topic(R.string.tech, 118, R.drawable.tech)
        )
    }
}