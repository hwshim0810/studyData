package dataStructureImpl;

import java.lang.reflect.Array;

import dataStructureInterface.QueueInterface;

public class CircularQueue<T> implements QueueInterface<T> {
	private int rear, front;
	private int maxSize;
	private T[] queue;
	
	@SuppressWarnings("unchecked")
	public CircularQueue(Class<T> c, int maxSize) {
		front = 0;
		rear = -1;
		//실제크기보다 1크게 지정하여 공백과 포화를 막음
		this.maxSize = maxSize + 1;
		queue = (T[]) Array.newInstance(c, maxSize);
	}
	
	/**
	 * @return boolean 
	 * Queue가 비었는지 확인
	 */
	@Override
	public boolean isEmpty() {
		return (front == rear + 1) || (front + maxSize - 1 == rear);
	}

	/**
	 * @return boolean 
	 * Queue가 꽉 찼는지 확인
	 */
	@Override
	public boolean isFull() {
		return (rear == maxSize - 1) || (front + maxSize - 2 == rear);
	}

	/**
	 * @param data
	 * rear의 data반환
	 */
	@Override
	public void insert(T data) {
		if (isFull()) throw new ArrayIndexOutOfBoundsException("Queue is full");
		
		//Rear가 마지막 위치라면 앞으로 돌린다
		if (rear == maxSize - 1)
			rear = -1;
		
		queue[++rear] = data;
	}

	/**
	 * @return data
	 * front의 data를 반환
	 */
	@Override
	public T peek() {
		if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Queue is empty");
		return queue[front];
	}

	/**
	 * @return data
	 * front의 data를 반환 후 front 증가, front가 최대 사이즈+1 이면 0으로 변경
	 */
	@Override
	public T remove() {
		T data = peek();
		++front;
		
		if (front == maxSize)
			front = 0;
		
		return data;
	}

}
