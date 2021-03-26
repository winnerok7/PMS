class CoordinateBB {

    constructor(seconds: Int, minutes: Int, degrees: Int, direction: Direction) {
        this.direction = direction
        this.degrees = degrees
        this.minutes = minutes
        this.seconds = seconds

    }

    constructor() {
    }

    var direction: Direction? = null
    var minutes = 0
        set(value) {
            if (value in 1..59) {
                field = value
            }

        }
    var seconds = 0
        set(value) {
            if (value in 1..59) {
                field = value
            }
        }

    var degrees = 0
        set(value) {
            if (direction == Direction.LENGTH) {
                if (value in -90..90) {
                    field = value
                }
            }
            if (direction == Direction.WIDTH) {
                if (value in -180..180) {
                    field = value
                }
            }
        }
    fun getDegreesSecondsMinutesDirection(): String {
        return "" + this.degrees + " " + this.minutes + " " + this.seconds + " " + Z(this) + "\n "
    }
    fun getDegreesSecondsMinutesDirectionDouble(): String {
        return  "" + this.degrees.toDouble() + " " + this.minutes.toDouble() + " " + this.seconds.toDouble() + " " + Z(this) + "\n "
    }
    fun averageCoordinate( y: CoordinateBB): CoordinateBB?{
        when{
            this.direction == Direction.LENGTH && y.direction == Direction.LENGTH -> {
                return CoordinateBB((this.seconds+y.seconds)/2, (this.minutes+y.minutes)/2, (this.degrees+y.degrees)/2, Direction.LENGTH)
            }
            this.direction == Direction.WIDTH && y.direction == Direction.WIDTH -> {
                return CoordinateBB((this.seconds+y.seconds)/2, (this.minutes+y.minutes)/2, (this.degrees+y.degrees)/2,Direction.WIDTH)
            }
        }
        return null
    }

    fun averageCoordinateTwoParameters(x: CoordinateBB, y: CoordinateBB): CoordinateBB?{
        when{
            x.direction == Direction.LENGTH && y.direction == Direction.LENGTH -> {
                return CoordinateBB((x.seconds+y.seconds)/2, (x.minutes+y.minutes)/2, (x.degrees+y.degrees)/2, Direction.LENGTH)
            }
            x.direction == Direction.WIDTH && y.direction == Direction.WIDTH -> {
                return CoordinateBB((x.seconds+y.seconds)/2, (x.minutes+y.minutes)/2, (x.degrees+y.degrees)/2, Direction.WIDTH)
            }
        }
        return null
    }

    override fun toString(): String {
        return "CoordinateBB(direction=$direction, minutes=$minutes, seconds=$seconds, degrees=$degrees)"
    }


}


enum class Direction {
    LENGTH, WIDTH
}

fun Z(x: CoordinateBB): String {
    when {
        x.direction == Direction.LENGTH -> {
            if (x.degrees > 0) {
                return "W"
            }

            if (x.degrees < 0) {
                return "E"
            } else {
                if (x.minutes > 0) {
                    return "W"
                }
                if (x.minutes < 0) {
                    return "E"
                } else {
                    if (x.seconds > 0) {
                        return "W"
                    }
                    if (x.seconds < 0) {
                        return "E"
                    } else return "Point did not move"
                }
            }
        }
        x.direction == Direction.WIDTH -> {
            if (x.degrees > 0) {
                return "S"
            }
            if (x.degrees < 0) {
                return "N"
            } else {
                if (x.minutes > 0) {
                    return "S"
                }
                if (x.minutes < 0) {
                    return "N"
                } else {
                    if (x.seconds > 0) {
                        return "S"
                    }
                    if (x.seconds < 0) {
                        return "N"
                    } else return "Point did not move"
                }
            }
        }
    }
    return "Error"
}