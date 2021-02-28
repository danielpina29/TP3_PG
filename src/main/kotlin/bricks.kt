import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas

data class Brick(val position : Location, val hits: Int, val colour : Int, val valueScore : Int)

const val BRICK_WIDTH = 32
const val BRICK_HEIGHT = 15

/**
 * The following function will create a brick with a determined set of parameters:
 * @param position Location where the brick is going to be created
 * @param hits The amount of hits that is going to take to destroy the Brick
 * @param colour The colour of the Brick
 * @param valueScore The value that is going to be given to the score when the brick is destroyed
 */

fun createBrick(position: Location, hits: Int, colour: Int, valueScore: Int) : Brick =
        Brick(position, hits, colour, valueScore)

/**
 * Physically draws the Brick in the arena.
 */
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
