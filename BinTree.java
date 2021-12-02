/**
* Import von Paketen, in denen benoetigte Library-Hilfsfunktionen zu finden sind
*/
import java.util.Random ;
import java.nio.file.*;
import java.io.*;
/**
 * Implementiert einen sortierten Binaerbaum mit Rotation-zur-Wurzel Optimierung.
 */
public class BinTree {
  /**
   * Wurzel des Baums
   */
  private BinTreeNode root;
  /**
   * Erstellt einen leeren Baum
   */
  public BinTree() {
    this.root = null ;
  }
  /**
   * Erstellt einen Baum mit den vorgegebenen Zahlen
   * @param xs die einzupflegenden Zahlen
   */
  public BinTree(int... xs) {
    for ( int x : xs ) {
      this.insert(x);
    }
  }
  /**
   * Test ob der Baum leer ist
   * @return true, falls der Baum leer ist, sonst false
   */
  public boolean isEmpty() {
    return this.root == null ;
  }
  /**
   * Fuegt alle Zahlen aus den Baeumen in einen neuen Baum ein und gibt diesen zurueck.
   * @param trees Die Baeume mit den einzufuegenden Zahlen.
   * @return Der neue Baum mit allen Zahlen.
   */
   public static BinTree merge(BinTree... trees) {
	   //ist die ursprüngliche Methode
	  int n= trees.length;
	  return helphelphelp_merge(n,trees);
  }
  public static BinTree helphelphelp_merge(int n,BinTree... trees) {
     
	  //führt die Method wirklich durch, durch die Variable n, kann ich den letzten Teil des Arrays quasi löschen
	  trees[0]=BinTree.help_merge(trees[0], trees[n-1]);
	  if(n>2)
		  {
		  	BinTree.helphelphelp_merge(n-1,trees);
		  }
	  return trees[0];
  }
  private static BinTree help_merge(BinTree b1,BinTree b2)
  {
	  // fügt die wurzel ein und ruft die Methode helphelp_merge auf
	  if(!(b2.root==null)) 
		 {
		  	b1.insert(b2.root.getValue());
		  }
	  
	  if(b2.root.hasLeft()) 
		 {
		  	b1 =BinTree.helphelp_merge(b1, b2.root.getLeft());
		 }
	 
	  else if(b2.root.hasRight()) 
		  {
		   b1=	BinTree.helphelp_merge(b1, b2.root.getRight());
		  }
	  return b1;
  }
  private static BinTree helphelp_merge(BinTree b1,BinTreeNode b2)
  {
	  //fügt die einzelnen Nodes eines Baumes aus dem Array in den Baum b1 ein
	  b1.insert(b2.getValue());
	  
	  if(b2.hasLeft()) 
		 {
		  	b1 = BinTree.helphelp_merge(b1, b2.getLeft());
		 }
	  if(b2.hasRight()) 
		  {
		  	b1 = BinTree.helphelp_merge(b1, b2.getRight());
		  }
	  return b1;
  }
  /**
   * Fuegt eine Zahl ein. Keine Aenderung, wenn das Element
   * schon enthalten ist.
   * @param x einzufuegende Zahl
   */
  public void insert(int x) {
    if(isEmpty()) {
      root = new BinTreeNode(x);
    } else {
      root.insert(x);
    }
  }
  /**
   * Sucht x, ohne den Baum zu veraendern.
   * @param x der gesuchte Wert
   * @return true, falls x im Baum enthalten ist, sonst false
   */
  public boolean simpleSearch(int x) {
    return root.simpleSearch(x);
  }
  /**
   * Sucht x und rotiert den Knoten, bei dem die Suche nach x endet, in die Wurzel.
   * @param x der gesuchte Wert
   * @return true, falls x im Baum enthalten ist, sonst false
   */
    public boolean search(int x) {
      System.out.println("Search x=" + x);
      return this.root.rotationSearch(x).getValue() == x;
    }
  /**
   * @return Sortierte Ausgabe aller Elemente.
   */
  public String toString() {
    String output = "tree(";
    output += root.toString();
    output += ")";

    return output;
  }
  /**
   * Wandelt den Baum in einen Graphen im dot Format um.
   * @return der umgewandelte Baum
   */
  public String toDot() {
    if ( this.isEmpty ()) {
      return "digraph { null[shape=point]; }";
    }
    StringBuilder str = new StringBuilder ();
    this.root.toDot (str, 0);
    return "digraph { " + System.lineSeparator ()
      + "graph[ordering=\"out\"]; " + System.lineSeparator ()
      + str.toString ()
      + "}" + System.lineSeparator ();
  }
  /**
   * Speichert die dot Repraesentation in einer Datei.
   *
   * @param path Pfad unter dem gespeichert werden soll (Dateiname)
   * @return true, falls erfolgreich gespeichert wurde, sonst false
   * @see toDot
   */
  public boolean writeToFile(String path) {
    boolean retval = true;
    try {
      Files.write(FileSystems.getDefault().getPath(path), this.toDot().getBytes());
    } catch (IOException x) {
      System.err.println("Es ist ein Fehler aufgetreten.");
      System.err.format("IOException: %s%n" , x);
      retval = false;
    }
    return retval;
  }
  /**
   * Main-Methode, die einige Teile der Aufgabe testet.
   *
   * @param args Liste von Dateinamen, unter denen Baeume als dot
   * gespeichert werden sollen. Es werden nur die ersten beiden verwendet.
   */
  public static void main(String[] args) {
    Random prng = new Random();
    int nodeCount = prng.nextInt(10) + 5;
    BinTree myTree = new BinTree();
    System.out.println("Aufgabe b): Zufaelliges Einfuegen");
    for(int i = 0; i < nodeCount; ++i) {
      myTree.insert(prng.nextInt(30));
    }
    myTree.insert(15);
    myTree.insert(3);
    myTree.insert(23);
    if (args.length > 0) {
      if (myTree.writeToFile(args[0])) {
        System.out.println("Baum als DOT File ausgegeben in Datei " + args [0]);
      }
    } else {
      System.out.println("Keine Ausgabe des Baums in Datei, zu wenige Aufrufparameter.");
    }
    System.out.println("Aufgabe a): Suchen nach zufaelligen Elementen");
    for(int i = 0; i < nodeCount; ++i) {
      int x = prng.nextInt (30);
      if(myTree.simpleSearch(x)) {
        System.out.println(x + " ist enthalten");
      } else {
        System.out.println(x + " ist nicht enthalten");
      }
    }
    System.out.println("Aufgabe c): geordnete String-Ausgabe");
    System.out.println(myTree.toString());
    myTree.writeToFile(args[1]);
    System.out.println("Aufgabe d): Suchen nach vorhandenen Elementen mit Rotation.");
    myTree.search(3);
    myTree.search(23);
    myTree.search(15);
    if (args.length > 1) {
      if (myTree.writeToFile(args[1])) {
        System.out.println("Baum nach Suchen von 15, 3 und 23 als DOT File ausgegeben in Datei "
            + args [1]);
      }
    } else {
      System.out.println("Keine Ausgabe des Baums in Datei, zu wenige Aufrufparameter.");
    }

    System.out.println("Aufgabe e): merge");
    BinTree tree2 = new BinTree(4, 7, 2,9 ,5);
    System.out.println(myTree.toString());
    System.out.println(tree2.toString());
    System.out.println(BinTree.merge(myTree, tree2).toString());
  }
}
