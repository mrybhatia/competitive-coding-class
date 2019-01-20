#include <iostream>
using namespace std;

int N = 0, heap[11], capacity = 10;

int parent(int k){
	return k/2;
}


void shiftup(int k){
	while(k > 1 && heap[parent(k)] < heap[k]){
		swap(heap[parent(k)], heap[k]);
		k = parent(k);
	}
}

void shiftdown(int k){
	while(2 * k <= N){
		int j = 2 * k;
		if(j < N && heap[j] < heap[j+1])
			j++;
		if (heap[k] > heap[j]){
			swap(heap[k], heap[j]);
		}
		k = j;
	}
}

void display(){
	for (int i = 1; i <= N; i++) {
		cout<<heap[i]<<" ";
	}
	cout<<endl;
}

int getMax(){
	return heap[1];
}

int extractMax(){
	if(N < 1){
		cout<<"TRYING TO EXTRACT FROM EMPTY HEAP"<<endl;
		return -1;
	}
		int MAX = heap[1];
		swap(heap[1], heap[N--]);
		shiftdown(1);
		return MAX;
	
}

void ins(int num){
	if(N == capacity){
		cout<<"MAX CAPACITY REACHED"<<endl;
		return;
	}
	heap[++N] = num;
	shiftup(N);
}

void increaseKey(int index, int value){
	heap[index] = value;
	shiftup(index);
}

void changeKey(int index, int value){
	int old = heap[index];
	heap[index] = value;
	if(heap[index] > old){
		shiftup(index);
	}else if(heap[index] < old){
		shiftdown(index);
	}
}

int main(){
	int ch, num, value, index;
	while(1){
		cout<<"1.INSERT"<<endl;
		cout<<"2.GET MAX"<<endl;
		cout<<"3.DISPLAY"<<endl;
		cout<<"4.EXTRACT MAX"<<endl;
		cout<<"5.INCREASE KEY"<<endl;
		cout<<"6.CHANGE KEY"<<endl;
		cout<<"7.EXIT"<<endl;
		cout<<"ENTER CHOICE"<<endl;
		cin>>ch;
		switch(ch){
			case 1 : cout<< "ENTER NUMBER" << endl;
			cin>>num;
			ins(num);
			break;
			case 2 : cout << "MAX ELEMENT: " << getMax() << endl;
			break;
			case 3 : display();
			break;
			case 4 : cout<< "MAX ELEMENT: " << extractMax() << endl;
			break;
			case 5 : cout<< "ENTER VALUE AND INDEX" << endl;
			cin >> value >> index;
			increaseKey(index, value);
			break;
			case 6 : cout<< "ENTER VALUE AND INDEX" << endl;
			cin >> value >> index;
			changeKey(index, value);
			break;
			case 7 : exit(0);
		}
	}
}
