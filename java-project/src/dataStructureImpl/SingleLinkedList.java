package dataStructureImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SingleLinkedList<T> {
	private Node head;
	private int size;
	
	/**
	 * 데이터가 없으므로 size는 0
	 */
	public SingleLinkedList() {
		head = null;//new Node<T>(null);
		size = 0;
	}
	
	/**
	 * LinkedList를 구성하는 Node class
	 */
	private class Node {
		private T data;
		private Node nextNode;
		
		Node(T data) {
			this.data = data;
			this.nextNode = null;
		}
		
		Node(T data, Node nextNode) {
			this.data = data;
			this.nextNode = nextNode;
		}
		
		protected T data() {
			return data;
		}
		
		protected Node nextNode() {
			return nextNode;
		}
		
		protected Node clone() {
			return new Node(data, nextNode);
		}
	}
	
	/**
	 * 연결리스트 가장 앞에 Node를 추가. 추가된 Node의 nextNode는 기존 head의 nextNode.
	 * head의 nextNode는 추가된 Node로 교체되고 자료구조의 크기 1증가.
	 * @param data : 새로 추가할 데이터.
	 */
	public void addFirst(T data) {
		Node tmp = head.clone();
		head = new Node(data);
		head.nextNode = tmp;
		++size;
	}
	
	/**
	 * 원하는 위치에 Node를 추가. idx가 0인 경우는 처음위치에 추가.
	 * @param idx : 원하는 위치
	 * @param data : 추가할 데이터
	 */
	public void add(int idx, T data) {
		getNode(idx).ifPresent(previousNode -> {
			Node nextNode = previousNode.nextNode;
			Node newNode = new Node(data);
			previousNode.nextNode = newNode;
			newNode.nextNode = nextNode;
			++size;
		});
	}
	
	/**
	 * 마지막 위치에 Data를 추가.
	 * @param data : 추가할 데이터
	 */
	public void addLast(T data) {
		add(size, data);
	}
	
	public void setHead(Node head) {
		this.head = head;
	}
	
	public Optional<Node> head() {
		return Optional.ofNullable(head);
	}
	
	/**
	 * return First Node's data
	 * @return data : 첫번째 Node의 data
	 */
	public Optional<T> getFirst() {
		return getNode(0).map(Node::data);
	}
	
	/**
	 * 지정한 Index번호로 검색된 data반환.
	 * @param idx : 찾고자하는 node index
	 * @return data : 찾은 data
	 */
	public Optional<T> get(int idx) {
		return getNode(idx).map(Node::data);
	}
	
	/**
	 * Index번호에 해당하는 Node를 header부터 순차탐색.
	 * @param idx : 찾고자하는 Index
	 * @return node : 찾은 Node
	 */
	private Optional<Node> getNode(int idx) {
		if (idx < 0 || idx >= size)
			return Optional.empty();
		
		Node node = head;
		for (int i = 0; i < idx; i++)
			node = node.nextNode;

		return Optional.of(node);
	}
	
	/**
	 * LinkedList의 첫번째 Node를 제거하고 삭제한 Data를 반환.
	 * @return data : 삭제된 Node의 data
	 */
	public Optional<T> removeFirst() {
		return head().map(head -> {
			T data = head.data();
			setHead(head.nextNode);
			--size;
			return data;
		});
	}
	
	/**
	 * 원하는 위치의 Node를 제거.
	 * @param idx : 제거를 원하는 위치의 Index번호
	 * @return data : 제거된 Node의 data
	 */
	public Optional<T> remove(int idx) {
		return getNode(idx).map(previousNode -> {
			Node targetNode = previousNode.nextNode;
			
			previousNode.nextNode = targetNode.nextNode;
			size--;
			
			return targetNode.data;
		});
	}
	
	/**
	 * 찾고자 하는 Data가 들어있는 Node의 Index번호를 반환
	 * Data가 List에 없는 경우 -1을 반환
	 * @param target 찾고자 하는 데이터
	 * @return idx 데이터가 들어있는 Node의 Index번호
	 */
	public Optional<Integer> getNodeIdx(T target) {
		int idx = -1;
		Optional<Node> node = head();
		while (node.isPresent()) {
			++idx;
			if (target.equals(node.get().data())) break;
			node = node.map(Node::nextNode);
		}
		
		if (0 <= idx && idx < size)
			return Optional.of(idx);
		else
			return Optional.empty();
	}
	
	/**
	 * LinkedList의 크기를 반환.
	 * @Method Name : size
	 * @return size : List의 크기
	 */
	public int size() {
		return size;
	}

	/**
	 * 이렇게 짜지 마시오 낭비 개쩔고 느림
	 */
	@Override
	public String toString() {
		Optional<Node> node = head();
		
		final List<Node> nodes = new ArrayList<>();
		while (node.isPresent()) {
			nodes.add(node.get());
			node = node.map(Node::nextNode);
		}
		
		final List<String> nodeStrings =
			nodes.stream()
				.map(Node::data)
				.map(T::toString)
				.collect(Collectors.toList());
				
		return "[" + String.join(",", nodeStrings) + "]";
	}
	
}
