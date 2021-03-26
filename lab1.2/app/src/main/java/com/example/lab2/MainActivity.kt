import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val coordinate = CoordinateBB(50, 20, -10, Direction.LENGTH)
        val coordinate1 = CoordinateBB(12, 24, 30, Direction.LENGTH)
        val content1 = Content()
        println(content1.main())
        val a = coordinate.getDegreesSecondsMinutesDirection()
        val b = coordinate.getDegreesSecondsMinutesDirectionDouble()
        val c = coordinate.averageCoordinate(coordinate1)
        val d = coordinate.averageCoordinateTwoParameters(coordinate, coordinate1)
    }
}