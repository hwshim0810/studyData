package dataStructureImpl;

import java.lang.reflect.Array;

import dataStructureInterface.QueueInterface;

public class ArrayQueue<T> implements QueueInterface<T> {
	private int front, rear;
	private int maxSize;
	private T[] queue ;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(Class<T> c, int maxSize) {
		front = 0;
		rear = -1;
		queue = (T[]) Array.newInstance(c, maxSize);
	}
	
	/**
	 * @return boolean : Queue가 비었는지 확인
	 */
	@Override
	public boolean isEmpty() {
		return (front == rear + 1);
	}
	
	/**
	 * @return boolean : Queue가 꽉 찼는지 확인
	 */
	@Override
	public boolean isFull() {
		return (rear == maxSize - 1);
	}
	
	/**
	 * @param T data : Queue의 rear에 data추가
	 */
	@Override
	public void insert(T data) {
		if (isFull()) throw new ArrayIndexOutOfBoundsException("Full of Queue");
		queue[++rear] = data;
	}
	
	/**
	 * @return T data : Queue의 front 값을 조회
	 */
	@Override
	public T peek() {
		if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Empty of Queue");
		return queue[front];
	}
	
	/**
	 * @return T data : Queue의 front 값을 반환하고 Queue에서 삭제
	 */
	@Override
	public T remove() {
		if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Empty of Queue");
		return queue[front++];
	}
}
