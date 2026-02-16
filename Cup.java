import shapes.Rectangle;

/**
 * Cup: una taza apilable.
 */
public class Cup extends Rectangle implements Stackable
{
    public static final int PIXELS_PER_CM = 10;

    private int id;
    private int heightCm;

    // Posición real de Rectangle por defecto en shapes:
    // x=70, y=15. Guardamos eso para mover "absoluto".
    private int currentX;
    private int currentY;

    public Cup(int id, int heightCm)
    {
        super();
        this.id = id;
        this.heightCm = heightCm;

        // Rectangle arranca en (70,15)
        currentX = 70;
        currentY = 15;

        // changeSize(alto, ancho)
        changeSize(heightCm * PIXELS_PER_CM, 80);

        changeColor("red");
    }

    public int getId()
    {
        return id;
    }

    public int getHeight()
    {
        return heightCm;
    }

    /**
     * y es la coordenada TOP (arriba) en pixeles.
     */
    public void setPosition(int y)
    {
        moveVertical(y - currentY);
        currentY = y;
    }

    public void setX(int x)
    {
        moveHorizontal(x - currentX);
        currentX = x;
    }
}
