/**
 * Elemento apilable en la torre.
 * La altura se maneja en cm (lógico) y la posición en pixeles (visual).
 */
public interface Stackable
{
    int getId();
    int getHeight();            // cm (lógico)
    void setPosition(int y);    // y en pixeles (visual)
    void setX(int x);           // x en pixeles (visual)
}
