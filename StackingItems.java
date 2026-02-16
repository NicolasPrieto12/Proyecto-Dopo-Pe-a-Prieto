import javax.swing.JOptionPane;

/**
 * Clase principal.
 */
public class StackingItems
{
    private Tower tower;

    public StackingItems()
    {
        tower = null;
    }

    /**
     * Crea la torre.
     */
    public void createTower(int width, int height)
    {
        tower = new Tower(width, height);
    }

    /**
     * Agrega una taza.
     */
    public void addCup(int id, int height)
    {
        if (tower == null)
        {
            JOptionPane.showMessageDialog(null, "Primero cree la torre.");
            return;
        }

        Cup cup = new Cup(id, height);
        cup.makeVisible();

        boolean ok = tower.addCup(cup);

        if (!ok)
        {
            cup.makeInvisible();
            JOptionPane.showMessageDialog(null, "No cabe la taza.");
        }
    }

    /**
     * Consulta información.
     */
    public String consultInformation()
    {
        if (tower == null)
            return "No hay torre.";

        return tower.getInformation();
    }
}

