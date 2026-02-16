import shapes.Rectangle;

/**
 * Tapa apilable (siempre 1 cm de alto).
 * Puede estar sola o encima de su taza (si la taza está en la torre).
 */
public class Lid extends Rectangle implements Stackable
{
    public static final int PIXELS_PER_CM = 10;

    private int id;

    private int currentX;
    private int currentY;

    private int widthPx;
    private String colorName;

    public Lid(int id, String colorName, int widthPx)
    {
        super();
        this.id = id;
        this.colorName = colorName;
        this.widthPx = widthPx;

        currentX = 20;
        currentY = 15;

        changeSize(PIXELS_PER_CM, widthPx);
        changeColor(colorName);
    }

    public int getId()
    {
        return id;
    }

    public int getHeight()
    {
        return 1;
    }

    public void setVisible(boolean visible)
    {
        if (visible) makeVisible();
        else makeInvisible();
    }

    public void setPosition(int y)
    {
        int delta = y - currentY;
        moveVertical(delta);
        currentY = y;
    }

    public void setX(int x)
    {
        int delta = x - currentX;
        moveHorizontal(delta);
        currentX = x;
    }
}
