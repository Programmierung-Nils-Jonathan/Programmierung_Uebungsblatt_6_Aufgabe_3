/**
 * Ein Knoten in einem binaeren Baum.
 *
 * Der gespeicherte Wert ist unveraenderlich,
 * die Referenzen auf die Nachfolger koennen aber
 * geaendert werden.
 *
 * Die Klasse bietet Methoden, um Werte aus einem Baum
 * zu suchen und einzufuegen. Die Methode zur Suche gibt
 * es noch in einer optimierten Variante, um
 * rotate-to-root Baeume zu verwalten.
 */
public class BinTreeNode {
  /**
   * Linker Nachfolger
   */
  private BinTreeNode left;
  /**
   * Rechter Nachfolger
   */
  private BinTreeNode right;
  /**
   * Wert, der in diesem Knoten gespeichert ist
   */
  private final int value;

  /**
   * Erzeugt einen neuen Knoten ohne Nachfolger
   * @param val Wert des neuen Knotens
   */
  public BinTreeNode(int val) {
    this.value = val;
    this.left = null;
    this.right = null;
  }

  /**
   * Erzeugt einen neuen Knoten mit den gegebenen Nachfolgern
   * @param val Wert des neuen Knotens
   * @param left linker Nachfolger des Knotens
   * @param right rechter Nachfolger des Knotens
   */
  public BinTreeNode(int val, BinTreeNode left, BinTreeNode right) {
    this.value = val;
    this.left = left;
    this.right = right;
  }
  
  /**
  * @return Wert des aktuellen Knotens
  *
  */	
  public int getValue() {
    return this.value;
  }

  /**
   * @return Der gespeicherte Wert, umgewandelt in einen String
   */
  public String getValueString() {
    return Integer.toString(this.value);
  }

  /**
   * @return true, falls der Knoten einen linken Nachfolger hat, sonst false 
   */	
  public boolean hasLeft() {
    return this.left != null;
  }
  /**
   * @return true, falls der Knoten einen rechten Nachfolger hat, sonst false 
   */	
  public boolean hasRight() {
    return this.right != null;
  }


  /**
   * @return linker Nachfolger des aktuellen Knotens
   */		
  public BinTreeNode getLeft() {
    return this.left;
  }
  /**
   * @return rechter Nachfolger des aktuellen Knotens
   */	
  public BinTreeNode getRight() {
    return this.right;
  }

  /**
   * Sucht in diesem Teilbaum nach x, ohne den Baum zu veraendern.
   * @param x der gesuchte Wert
   * @return true, falls x enthalten ist, sonst false
   */
  public boolean simpleSearch(int x) {
    //TODO
  }

  /**
   * Fuegt x in diesen Teilbaum ein.
   * @param x der einzufuegende Wert
   */
  public void insert(int x) {
   //TODO
  }

  /**
   * Sucht in diesem Teilbaum nach x und rotiert den Endpunkt der Suche in die
   * Wurzel.
   * @param x der gesuchte Wert
   * @return die neue Wurzel des Teilbaums
   */
  public BinTreeNode rotationSearch(int x) {
   //TODO
  }

  /**
   * @return Geordnete Liste aller Zahlen, die in diesem Teilbaum gespeichert sind.
   */
  public String toString() {
    //TODO
  }
 
  /**
   * Erzeugt eine dot Repraesentation in str
   * @param str Stringbuilder Objekt zur Konstruktion der Ausgabe
   * @param nullNodes Hilfsvariable, um Nullknoten zu indizieren. Anfangswert sollte 0 sein. 
   * @return Den nullNodes Wert fuer den behandelten Baum
   */
  public int toDot(StringBuilder str, int nullNodes) {
    if(this.hasLeft()) {
      str.append(this.getValueString() + " -> " + this.left.getValueString() + ";"
        + System.lineSeparator());
      nullNodes = this.left.toDot(str, nullNodes);
    } else {
      str.append("null" + nullNodes + "[shape=point]" + System.lineSeparator()
        + this.getValueString() + " -> null" + nullNodes + ";" + System.lineSeparator());
      nullNodes += 1;
    }
    if(this.hasRight()) {
      str.append(this.getValueString() + " -> " + this.right.getValueString() + ";"
        + System.lineSeparator());
      nullNodes = this.right.toDot(str, nullNodes);
    } else {
      str.append("null" + nullNodes + "[shape=point]" + System.lineSeparator()
        + this.getValueString() + " -> null" + nullNodes + ";" + System.lineSeparator());
      nullNodes += 1;
    }
    return nullNodes;
  }

}
