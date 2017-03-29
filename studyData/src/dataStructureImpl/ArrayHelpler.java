package dataStructureImpl;

public class ArrayHelpler {
	private Object[] dataArray;
	private int count;

	/**
	 * 지정한 사이즈의 배열을 생성
	 * @param maxSize : 생성할 배열의 크기 - 음수일 경우 예외발생 
	 */
	public ArrayHelpler(int maxSize) {
		if (maxSize < 0) throw new IllegalArgumentException("Illegal Size : " + maxSize);
		
		this.dataArray = new Object[maxSize];
		this.count = 0;
	}
	
	public ArrayHelpler() {
		try {
			throw new Exception("need ArraySize");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 배열의 끝에 데이터를 삽입
	 * @Method Name : add
	 * @param data : 배열의 끝에 삽입할 데이터
	 */
	public void add(Object data) {
		if (count >= dataArray.length)
			throw new ArrayIndexOutOfBoundsException(count + " >= " + dataArray.length);
		
		dataArray[count++] = data;
	}
	
	/**
	 * index위치에 데이터를 삽입, 기존데이터는 밀려남
	 * @Method Name : add
	 * @param index : 삽입할 위치
	 * @param data : 삽입할 데이터
	 */
	public void add(int index, Object data) {
		if (index >= dataArray.length)
			throw new ArrayIndexOutOfBoundsException(index + " >= " + dataArray.length);
		else if (index < 0)
			throw new ArrayIndexOutOfBoundsException(index + " < 0");
		
		for (int i = index; i < dataArray.length; i++)
			dataArray[i+1] = dataArray[i];
		
		count++;
		dataArray[index] = data;
	}
	
	/**
	 * index위치의 데이터를 삭제
	 * @Method Name : delete
	 * @param index : 데이터를 삭제할 위치
	 */
	public void delete(int index) {
		if (index >= dataArray.length)
			throw new ArrayIndexOutOfBoundsException(index + " >= " + dataArray.length);
		else if (index < 0)
			throw new ArrayIndexOutOfBoundsException(index + " < 0");
		
		for (int i = index; i < count-1; i++)
			dataArray[i] = dataArray[i+1];
		
		count--;
		dataArray[count] = null;
	}
	
	/**
	 * 데이터를 찾아서 삭제
	 * @Method Name : delete
	 * @param data : 삭제할 데이터
	 */
	public void delete(Object data) {
		int index = find(data);
		delete(index);
	}
	
	/**
	 * 지정한 데이터의 index return, 없을경우 -1 return
	 * @Method Name : find
	 * @param data : 찾을 데이터
	 * @return index : 찾은 데이터의 위치
	 */
	public int find(Object data) {
		for (int i = 0; i < count; i++)
			if (dataArray[i].equals(data)) return i;
		
		return -1;
	}
	
	/**
	 * 지정한 위치의 데이터 반환
	 * @Method Name : get
	 * @param index : 지정할 위치
	 * @return data : 지정한 위치의 데이터
	 */
	public Object get(int index) {
		if (index >= dataArray.length)
			throw new ArrayIndexOutOfBoundsException(index + " >= " + dataArray.length);
		else if (index < 0)
			throw new ArrayIndexOutOfBoundsException(index + " < 0");
		
		return dataArray[index];
	}
	
    public String toString(){
        StringBuffer str = new StringBuffer("[");
        if(count > 0){
            str.append(dataArray[0]);
            for(int i = 1; i < count; i++)
            	str.append(", ").append(dataArray[i]);
        } else {
        	str.append(" not enough data ");
        }
        str.append("]");
        return str.toString();
    }
}
