package exercise.algorithms4.e1_3;

public class DoublyLinkedList {

	private DoubleNode<String> first;
	private int size = 0;
	
	/**
	 * 在链表尾增加节点
	 * @param value
	 */
	public void add(String value){
		if(isEmpty()){
			first = new DoubleNode<>();
			first.value = value;
			first.pre = first;
			first.next = first;
		}else{
			DoubleNode<String> p = first.pre;
//			while(p.next != first){
//				p = p.next;
//			}
			DoubleNode<String> temp = new DoubleNode<>();
			temp.value = value;
			temp.pre = p;
			temp.next = p.next;
			p.next = temp;
			first.pre = temp;
		}
		size++;
	}
	/**
	 * 在链表头增加节点
	 * @param value
	 */
	public void addFirst(String value){
		if(isEmpty()){
			first = new DoubleNode<>();
			first.value = value;
			first.pre = first;
			first.next = first;
		}else{
			DoubleNode<String> p = first.pre;
//			while(p.next != first){
//				p = p.next;
//			}
			DoubleNode<String> temp = new DoubleNode<>();
			temp.value = value;
			temp.pre = p;
			temp.next = p.next;
			p.next = temp;
			first.pre = temp;
			first = temp; // 将链表首节点指向新增的节点
		}
		size++; 
	}
	/**
	 * 从链表尾删除节点
	 * @return
	 */
	public String delete(){
		if(isEmpty()) return null;
		String item = null;
		if(size == 1){
			item = first.value;
			first = null;
		}else{
			DoubleNode<String> p = first.pre;
			DoubleNode<String> temp = p.pre;
			temp.next = first;
			first.pre = temp;
			item = p.value;
		}
		size--;
		return item;
	}
	/**
	 * 从链表头删除节点
	 * @return
	 */
	public String deleteFirst(){
		if(isEmpty()) return null;
		String item = null;
		if(size == 1){
			item = first.value;
			first = null;
		}else{
			DoubleNode<String> p = first.pre;
			DoubleNode<String> temp = first.next;
			temp.pre = p;
			p.next = temp;
			item = first.value;
			first = temp;
		}
		size--;
		return item;
	}
	/**
	 * 指定节点前插入节点
	 * @param index
	 * @param value
	 * @return 实际位置
	 */
	public int insertBefore(int index, String value){
		if(isEmpty()) {
			add(value);
			return 1;
		}
		if(index == 1){
			addFirst(value);
			return 1;
		}
		int i = 1;
		DoubleNode<String> p = first;
		// 查找index节点
		while(i < index && p.next != first){
			p = p.next;
			i++;
		}
		DoubleNode<String> temp = new DoubleNode<>();
		temp.value = value;
		if(i != index){ // 没有找到index节点，那么新增加的节点作为最后一个节点
			add(value);
			return i + 1;
//			temp.pre = p;
//			temp.next = first;
//			p.next = temp;
//			first.pre = temp;
		}else{
			temp.pre = p.pre;
			temp.next = p;
			p.pre.next = temp;
			p.pre = temp;
		}
		size++;
		return index;
	}
	/**
	 * 指定节点后插入节点
	 * @param index
	 * @param value
	 * @return 实际位置
	 */
	public int insertAfter(int index, String value){
		return insertBefore(index + 1, value);
	}
	public String delete(int index){
		String item = null;
		if(index == 1) {
			item = deleteFirst();
		}else{
			DoubleNode<String> p = first;
			int i = 1;
			// 查找index节点
			while(i < index && p.next != first){
				p = p.next;
				i++;
			}
			// 找到index节点
			if(i == index){
				item = p.value;
				p.pre.next = p.next;
				p.next.pre = p.pre;
			}
		}
		return item;
	}
	/**
	 * 获取链表的首节点
	 * @return
	 */
	public DoubleNode<String> getFirstNode(){
		return first;
	}
	/**
	 * 判断链表是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
}
