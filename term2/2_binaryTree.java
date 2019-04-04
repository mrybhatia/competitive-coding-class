import java.util.*;
class tree{
	static class node{
		int data;
		node l,r;
		node(int data){
			this.data = data;
			l = r = null;
		}
	}
	static void printer(node root){  // print tree in spiral order
		Stack<node> s1 = new Stack<node>();
		Stack<node> s2 = new Stack<node>();
		s2.push(root);
		int t = 0;
		node temp;
		while(!s1.empty()  || !s2.empty()){
		//	if(t%2==0){
				while(!s2.empty()){
					temp = s2.pop();
					System.out.print(temp.data);
					if(temp.l != null){
						s1.push(temp.l);
					}
					if(temp.r != null){
						s1.push(temp.r);
					}
				}
		//		t++;
		//	}else{
				while(!s1.empty()){
					temp = s1.pop();
					System.out.print(temp.data);
					if(temp.r != null){
						s2.push(temp.r);
					}
					if(temp.l != null){
						s2.push(temp.l);
					}
					
				}
		//		t++;
			//}
		}
	}

	static void insert(node root, int key){
		
		Queue<node> q = new LinkedList<node>();
		q.add(root);
		node temp;
		while(q.size()!=0){
			temp = q.remove();
			if(temp.l == null){
				temp.l = new node(key);
				break;
			}else{
				q.add(temp.l);
			}

			if(temp.r == null){
				temp.r = new node(key);
				break;
			}else{
				q.add(temp.r);
			}
		}




	}

	static void deleteKey(node root, int key){
		Queue<node> q = new LinkedList<node>();
		
		q.add(root);
		node kf = null , brf = null , temp = null ;  // KeyFinder, brf(bottomRightFinder) when q.size==0 will have ref to bottom Rightmost node 
		while(q.size()!=0){
			temp = q.remove();
			brf = temp;
			if(temp.data == key){
				kf = temp;
			}
			if(temp.l != null){
				q.add(temp.l);
			}
			if(temp.r != null){
				q.add(temp.r);
			}
		}

		kf.data = brf.data;

		q.add(root);

		while(q.size()!=0){  //  deleting last node
			temp = q.remove();
			if(temp == brf){
				temp = null;
				break;
			}
			
			if(temp.l == brf){
				temp.l =null;
				break;
			}else{
				q.add(temp.l);
			}

			if(temp.r == brf){
				temp.r =null;
				break;
			}else{
				q.add(temp.r);
			}
		}
		

	}

	static void inorder(node root){
		if(root == null){
			return;
		}
		inorder(root.l);
		System.out.print(root.data + " ");
		inorder(root.r);
	}
	static node root;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] s1 = s.split(" ");
		if(root == null){
				root = new node(Integer.parseInt(s1[0]));
					
			}
		for (int i =1;i<s1.length ;i++ ) {
			
			insert(root,Integer.parseInt(s1[i]));
		}

	/*	root = new node(1);
		root.l = new node(2);
		root.r = new node(3);
		root.l.l = new node(4);
		root.l.r = new node(5);
		root.r.l = new node(6);
		root.r.r = new node(7);*/
		inorder(root);
		//printer(root);
		System.out.println();
		int d = sc.nextInt();
		deleteKey(root, d);
		inorder(root);
	}
}
