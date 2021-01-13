import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas

data class Brick(val position : Location, val maxHits: Int, val Colour : Int)

const val BRICK_WIDTH = 32
const val BRICK_HEIGHT = 15

fun createBrick(position: Location, maxHits: Int, colour: Int) : Brick =
        Brick(position, maxHits, colour)

fun drawBrick(position: Location, colour: Int, arena: Canvas){
    arena.drawRect(
            x = position.x.toInt(),
            y = position.y.toInt(),
            width = BRICK_WIDTH,
            height = BRICK_HEIGHT,
            color = colour
    )
    arena.drawRect(
            x = position.x.toInt(),
            y = position.y.toInt(),
            width = BRICK_WIDTH - 2,
            height = BRICK_HEIGHT - 2,
            color = BLACK,
            thickness = 1

    )

}
