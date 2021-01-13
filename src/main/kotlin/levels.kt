import pt.isel.canvas.*

private const val GOLD = 14329120
private const val PINK = 16738740
private const val ORANGE = 16753920
private const val SILVER = 12632256

val levelBricks = listOf<Brick>(
        createBrick(Location(x = 32.0, y = 45.0),1, YELLOW),
        createBrick(Location(x = 64.0, y = 45.0),1, YELLOW),
        createBrick(Location(x = 96.0, y = 45.0),1, YELLOW),
        createBrick(Location(x = 160.0, y = 45.0),1, WHITE),
        createBrick(Location(x = 192.0, y = 45.0),0, GOLD),
        createBrick(Location(x = 224.0, y = 45.0),1, WHITE),
        createBrick(Location(x = 288.0, y = 45.0),1, YELLOW),
        createBrick(Location(x = 320.0, y = 45.0),1, YELLOW),
        createBrick(Location(x = 352.0, y = 45.0),1, YELLOW),

        createBrick(Location(x = 32.0, y = 60.0),1, PINK),
        createBrick(Location(x = 64.0, y = 60.0),1, PINK),
        createBrick(Location(x = 96.0, y = 60.0),1, PINK),
        createBrick(Location(x = 160.0, y = 60.0),1, ORANGE),
        createBrick(Location(x = 192.0, y = 60.0),1, ORANGE),
        createBrick(Location(x = 224.0, y = 60.0),1, ORANGE),
        createBrick(Location(x = 288.0, y = 60.0),1, PINK),
        createBrick(Location(x = 320.0, y = 60.0),1, PINK),
        createBrick(Location(x = 352.0, y = 60.0),1, PINK),

        createBrick(Location(x = 32.0, y = 75.0),1, BLUE),
        createBrick(Location(x = 64.0, y = 75.0),1, BLUE),
        createBrick(Location(x = 96.0, y = 75.0),1, BLUE),
        createBrick(Location(x = 160.0, y = 75.0),1, CYAN),
        createBrick(Location(x = 192.0, y = 75.0),1, CYAN),
        createBrick(Location(x = 224.0, y = 75.0),1, CYAN),
        createBrick(Location(x = 288.0, y = 75.0),1, BLUE),
        createBrick(Location(x = 320.0, y = 75.0),1, BLUE),
        createBrick(Location(x = 352.0, y = 75.0),1, BLUE),

        createBrick(Location(x = 32.0, y = 90.0),1, RED),
        createBrick(Location(x = 64.0, y = 90.0),1, RED),
        createBrick(Location(x = 96.0, y = 90.0),1, RED),
        createBrick(Location(x = 160.0, y = 90.0),1, GREEN),
        createBrick(Location(x = 192.0, y = 90.0),1, GREEN),
        createBrick(Location(x = 224.0, y = 90.0),1, GREEN),
        createBrick(Location(x = 288.0, y = 90.0),1, RED),
        createBrick(Location(x = 320.0, y = 90.0),1, RED),
        createBrick(Location(x = 352.0, y = 90.0),1, RED),

        createBrick(Location(x = 32.0, y = 105.0),1, GREEN),
        createBrick(Location(x = 64.0, y = 105.0),1, GREEN),
        createBrick(Location(x = 96.0, y = 105.0),1, GREEN),
        createBrick(Location(x = 160.0, y = 105.0),1, RED),
        createBrick(Location(x = 192.0, y = 105.0),1, RED),
        createBrick(Location(x = 224.0, y = 105.0),1, RED),
        createBrick(Location(x = 288.0, y = 105.0),1, GREEN),
        createBrick(Location(x = 320.0, y = 105.0),1, GREEN),
        createBrick(Location(x = 352.0, y = 105.0),1, GREEN),

        createBrick(Location(x = 32.0, y = 120.0),1, CYAN),
        createBrick(Location(x = 64.0, y = 120.0),1, CYAN),
        createBrick(Location(x = 96.0, y = 120.0),1, CYAN),
        createBrick(Location(x = 160.0, y = 120.0),1, BLUE),
        createBrick(Location(x = 192.0, y = 120.0),1, BLUE),
        createBrick(Location(x = 224.0, y = 120.0),1, BLUE),
        createBrick(Location(x = 288.0, y = 120.0),1, CYAN),
        createBrick(Location(x = 320.0, y = 120.0),1, CYAN),
        createBrick(Location(x = 352.0, y = 120.0),1, CYAN),

        createBrick(Location(x = 32.0, y = 135.0),1, ORANGE),
        createBrick(Location(x = 64.0, y = 135.0),1, ORANGE),
        createBrick(Location(x = 96.0, y = 135.0),1, ORANGE),
        createBrick(Location(x = 160.0, y = 135.0),1, PINK),
        createBrick(Location(x = 192.0, y = 135.0),1, PINK),
        createBrick(Location(x = 224.0, y = 135.0),1, PINK),
        createBrick(Location(x = 288.0, y = 135.0),1, ORANGE),
        createBrick(Location(x = 320.0, y = 135.0),1, ORANGE),
        createBrick(Location(x = 352.0, y = 135.0),1, ORANGE),

        createBrick(Location(x = 32.0, y = 150.0),1, WHITE),
        createBrick(Location(x = 64.0, y = 150.0),1, WHITE),
        createBrick(Location(x = 96.0, y = 150.0),1, WHITE),
        createBrick(Location(x = 160.0, y = 150.0),2, SILVER),
        createBrick(Location(x = 192.0, y = 150.0),2, SILVER),
        createBrick(Location(x = 224.0, y = 150.0),2, SILVER),
        createBrick(Location(x = 288.0, y = 150.0),1, WHITE),
        createBrick(Location(x = 320.0, y = 150.0),1, WHITE),
        createBrick(Location(x = 352.0, y = 150.0),1, WHITE),
)