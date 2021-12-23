
public interface UANode {
	int getKey();
	String getName();
	String getEmail();
	UANode getLeft();
	UANode getRight();
	UANode getParent();
	void setKey(int key);
	void setName(String name);
	void setEmail(String email);
	void setLeft(UANode left);
	void setRight(UANode right);
	void setParent(UANode parent);

}
