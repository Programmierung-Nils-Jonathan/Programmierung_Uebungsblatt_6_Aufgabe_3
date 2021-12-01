public class HTree {
	private Canvas c;
	
	public static void main(String[] args) {
		HTree t=new HTree();
		t.drawHTree(600,7);
	}
	
	public HTree(){
		c=new Canvas(); //Ausrichtung ist bei Neuerstellung nach unten
	}
	
	/*Diese Methode zeichnet einen H-Tree der Tiefe n. Vor dem Aufruf der Methode 
	muss sichergestellt sein,
	dass die Canvas Zeichenrichtung nach unten gerichtet ist. */ 
	
	/*Diese Methode zeichnet einen H-Tree der Tiefe n, vor dem Aufrufen der Methode 
	muss sichergestellt sein,
	dass die Canvas Zeichenrichtung nach unten gerichtet ist. */ 
	public void drawHTree(int size, int n) {
		if(n > 0) {
			c.rotate(90);
			c.moveForward(size/2);
			c.rotate(270);
			c.drawForward(size/2);
			c.rotate(180);
			c.push();
			
			c.drawForward(size);
			c.push();
			c.rotate(180);
			c.moveForward(size/2);
			c.rotate(270);
			c.drawForward(size);
			c.rotate(90);
			c.moveForward(size/2);
			c.rotate(180);
			c.push();
			
			c.drawForward(size);
			c.rotate(180);
			c.push();
			c.pop();
			drawHTree(size/2, n-1);
			c.pop();
			drawHTree(size/2, n-1);
			c.pop();
			drawHTree(size/2, n-1);
			c.pop();
			drawHTree(size/2, n-1);
		}
	}
}
