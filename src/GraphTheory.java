import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTheory {
	
	private Node root;
	
	public GraphTheory() {
		
	}
	
	public void generateTree(){
		root = null;
		root = new Node('A');
		Node a = new Node('l');
		Node b = new Node('s');
		Node c = new Node('t');
		Node d = new Node('z');
		Node e = new Node('y');
		Node f = new Node('f');
		Node g = new Node('k');
		Node h = new Node('h');
		Node i = new Node('n');
		Node j = new Node('i');
		Node k = new Node('j');
		Node l = new Node('m');
		Node m = new Node('o');
		Node n = new Node('p');
		k.setFinish();
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.left = e;
		c.left = f;
		d.right = g;
		g.left = h;
		h.right = j;
		f.left = i;
		i.left = k;
		i.right = l;
		l.left = m;
		k.left = n;
	}
	
	/**
	 * Returns left child if not visited otherwise right
	 * @param n Node to look at
	 * @return child node
	 */
	public Node getUnvisitedChild(Node n){
		Node left = n.left;
		Node right = n.right;
		if((left!=null)&&(!left.isVisited())){
			return left;
		}
		else if((right!=null)&&(!right.isVisited())){
			return right;
		}
		else{
			return null;
		}
	}
	public Node DFS(){
		int steps = 0;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		root.visit();
		System.out.println(root.getData());
		while(!stack.isEmpty()){
			Node node = stack.peek();
			steps++;
			Node child = getUnvisitedChild(node);
			if(child != null && !(child.isFinishLine())){
				child.visit();
				System.out.println(child.getData());
				stack.push(child);
			}
			else if((child!=null) && (child.isFinishLine())){
				System.out.println(child.getData()+" is Finish line \nFound the endpoint in "+steps+" steps");
				return child;
				
			}
			else{
				stack.pop();
			}
		}
		return null;
	}
	
	public Node DFS(char data){
		int steps = 0;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		root.visit();
		System.out.println(root.getData());
		while(!stack.isEmpty()){
			Node node = stack.peek();
			steps++;
			Node child = getUnvisitedChild(node);
			if(child != null && child.getData()!=data){
				child.visit();
				System.out.println(child.getData());
				stack.push(child);
			}
			else if((child!=null) && (child.getData()==data)){
				System.out.println(child.getData()+" is Finish line \nFound the endpoint in "+steps+" steps");
				return child;
				
			}
			else{
				stack.pop();
			}
		}
		System.out.println("Node with "+data+" Not found in Graph");
		return null;
	}
	
	public Node BFS(){
		int steps = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		root.visit();
		System.out.println(root.getData());
		while(!queue.isEmpty()){
			Node node = queue.remove();
			Node child = null;
			while((child = getUnvisitedChild(node)) != null){
				steps++;
				child.visit();
				System.out.println(child.getData());
				queue.add(child);
				if(child.isFinishLine()){
					System.out.println("Found finish line at Node "+child.getData()+" in "+steps+" steps");
					return child;
				}
			}
			
		}
		return null;
	}
	
	/**
	 * Searches Tree for Nodes with intended data
	 * @param data The Node to search for
	 */
	public Node BFS(char data){
		int steps = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		root.visit();
		System.out.println(root.getData());
		while(!queue.isEmpty()){
			Node node = queue.remove();
			Node child = null;
			while((child = getUnvisitedChild(node)) != null){
				steps++;
				child.visit();
				System.out.println(child.getData());
				queue.add(child);
				if(child.getData() == data){
					System.out.println("Found node "+child.getData()+" in "+steps+" steps");
					return child;
				}
			}
		}
		System.out.println("Node with "+data+" Not found in Graph");
		return null;

	}
	public static void main(String[] args) {
		GraphTheory gt = new GraphTheory();
		gt.generateTree();
		System.out.println("DFS");
		gt.DFS('z');
		gt.generateTree();
		System.out.println("\n BFS");
		gt.BFS('z');
	}

}
