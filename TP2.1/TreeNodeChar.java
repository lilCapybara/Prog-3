
public class TreeNodeChar {

	private char value;
	private TreeNodeChar left;
	private TreeNodeChar right;

	public TreeNodeChar(char value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}



	public TreeNodeChar getLeft() {
		return left;
	}

	public void setLeft(TreeNodeChar left) {
		this.left = left;
	}

	public TreeNodeChar getRight() {
		return right;
	}

	public void setRight(TreeNodeChar right) {
		this.right = right;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char newValue){
		this.value=newValue;
	}

	public boolean isEmpty(){
		return this.value==' ';
	}


}
