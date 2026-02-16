import java.util.ArrayList;
import shapes.Rectangle;

/**
 * Tower: maneja los elementos apilados
 * y dibuja las marcas de centímetros.
 */
public class Tower
{
    private int heightCm;
    private ArrayList<Stackable> items;
    private ArrayList<Rectangle> marks;

    private int baseX;
    private int baseY;

    public Tower(int width, int height)
    {
        heightCm = height;
        items = new ArrayList<Stackable>();
        marks = new ArrayList<Rectangle>();

        // Ajustadas para que todo quede centrado
        baseX = 180;
        baseY = 320;

        buildMarks();
    }

    /**
     * Agrega una taza si cabe en la torre.
     */
    public boolean addCup(Cup cup)
    {
        if (getCurrentHeight() + cup.getHeight() > heightCm)
            return false;

        items.add(cup);
        reposition();
        return true;
    }

    /**
     * Retorna la altura actual en cm.
     */
    public int getCurrentHeight()
    {
        int total = 0;
        for (Stackable s : items)
            total += s.getHeight();
        return total;
    }

    /**
     * Reposiciona las tazas desde el suelo hacia arriba.
     */
    private void reposition()
    {
        int currentFloorY = baseY;

        for (Stackable s : items)
        {
            int heightPixels = s.getHeight() * Cup.PIXELS_PER_CM;
            int topY = currentFloorY - heightPixels;

            s.setX(baseX);
            s.setPosition(topY);

            currentFloorY = topY;
        }
    }

    /**
     * Construye las marcas de centímetros.
     */
    private void buildMarks()
    {
        for (int cm = 0; cm <= heightCm; cm++)
        {
            Rectangle line = new Rectangle();
            line.changeColor("black");

            int tickWidth;
            if (cm % 5 == 0)
                tickWidth = 20;
            else
                tickWidth = 12;

            // changeSize(alto, ancho)
            line.changeSize(2, tickWidth);

            int targetX = baseX - 50;
            int targetY = baseY - (cm * Cup.PIXELS_PER_CM);

            // Rectangle inicia en (70,15)
            line.moveHorizontal(targetX - 70);
            line.moveVertical(targetY - 15);

            line.makeVisible();
            marks.add(line);
        }
    }

    /**
     * Información básica de la torre.
     */
    public String getInformation()
    {
        return "Capacidad: " + heightCm + " cm\n" +
               "Altura actual: " + getCurrentHeight() + " cm\n" +
               "Cantidad de tazas: " + items.size();
    }
}
