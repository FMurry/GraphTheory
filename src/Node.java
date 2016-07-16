
public class Node {
	private char data;
	public Node left, right;
	private boolean visited;
	private boolean finish;
	
	
	public Node(char data){
		this.data = data;
		this.right = null;
		this.left = null;
		visited = false;
		finish = false;
	}
	
	public char getData(){
		return data;
	}
	
	public void visit(){
		visited = true;
	}
	public boolean isVisited(){
		return visited;
	}
	
	public void setFinish(){
		finish = true;
	}
	
	public boolean isFinishLine(){
		return finish;
	}
}
