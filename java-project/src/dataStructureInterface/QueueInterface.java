package dataStructureInterface;

public interface QueueInterface<T> {
	/**
	 * @return boolean : Queue가 비었는지 확인
	 */
	public boolean isEmpty();
	
	/**
	 * @return boolean : Queue가 꽉 찼는지 확인
	 */
	public boolean isFull();
	
	/**
	 * @param T data : Queue의 rear에 data추가
	 */
	public void insert(T data);
	
	/**
	 * @return T data : Queue의 front 값을 조회
	 */
	public T peek();
	
	/**
	 * @return T data : Queue의 front 값을 반환하고 Queue에서 삭제
	 */
	public T remove();
}
