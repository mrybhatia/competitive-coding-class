import java.util.*;
import java.lang.*;
class heap{

	Scanner sc = new Scanner(System.in);
	int[] heapp = new int[11];
	static int capacity = 10;
	static int N = 0;
	static int swap(int a, int b){
		return a;
	}

	static void shiftup(heap obj, int k){
		while(k > 1 && obj.heapp[parent(k)] < obj.heapp[k]){
			obj.heapp[parent(k)]=swap(obj.heapp[k], obj.heapp[k]=obj.heapp[parent(k)]);
			k = parent(k);
		}
	}

	static void shiftdown(heap obj, int k){
		while(2 * k <= N){
			int j = 2 * k;
			if(j < N && obj.heapp[j] < obj.heapp[j+1])
				j++;
			if(obj.heapp[k] < obj.heapp[j])
				obj.heapp[k]=swap(obj.heapp[j], obj.heapp[j]=obj.heapp[k]);
			k = j;
		}

	}

	static int parent(int k){
		return k/2;
	}
	
	static void changeKey(heap obj, int index, int value){         //change the specified key at a given index and display after heapifying it
		int old = obj.heapp[index];
		obj.heapp[index] = value;
		if(obj.heapp[index] > old){
			shiftup(obj, index);
		}else{
			shiftdown(obj, index);
		}
	}
	                                                             
	static void insert(heap obj, int value) {       // insert an element into the heap
		if(N == capacity){
			System.out.println(" NO SPACE LEFT");
			return;
		}
		obj.heapp[++N] = value;
		shiftup(obj, N);
		
	}

	static void increaseKey(heap obj, int index, int value) {  
		obj.heapp[index] = value;
		shiftup(obj, index);
	}


	static void extractMax(heap obj) {    // remove and display max element in heap
		if(N < 1){
			System.out.println("NO ELEMENT PRESENT");
			return;
		}
		int max = obj.heapp[1];
		obj.heapp[N--] = swap(obj.heapp[1], obj.heapp[N--]=obj.heapp[1]);
		shiftdown(obj, 1);
		System.out.println(max);
	}

	static void getMax(heap obj) {          // display max element
		System.out.println(obj.heapp[1]);
	}

	static void display(heap obj) {        // display the array 
		for(int i = 1 ; i <= N ; i++) {
			System.out.print(obj.heapp[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		heap h = new heap();
		int opt, num, value, index;
		while(true){
			System.out.println(" Enter 1 to INSERT \n Enter 2 to EXTRACT MAX \n Enter 3 to GET MAX \n Enter 4 to DISPLAY \n Enter 5 to CHANGE KEY \n Enter 6 to INCREASE KEY \n Enter 7 to EXIT");
			opt = h.sc.nextInt();
			switch(opt){
				case 1: num = h.sc.nextInt();
				insert(h, num); 
				break;
				case 2: extractMax(h); break;
				case 3: getMax(h); break;
				case 4: display(h); break;
				case 5: value = h.sc.nextInt();
				index = h.sc.nextInt();
				changeKey(h, value, index); 
				break;
				case 6: value = h.sc.nextInt();
				index = h.sc.nextInt();
				increaseKey(h, value, index); 
				break;
				case 7: System.exit(0);
			}
		}
	}
}
