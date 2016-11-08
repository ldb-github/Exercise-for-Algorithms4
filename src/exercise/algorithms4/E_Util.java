package exercise.algorithms4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class E_Util {

	/**
	 * ��ʼ��һά�������飬ȡֵ��Χ��[0, n)
	 * @param a
	 * @param n
	 */
	public static void initIntArray(int[] a, int n){
		for(int i = 0; i < a.length; i++){
			a[i] = StdRandom.uniform(n);
		}
	}
	/**
	 * ��ʼ����ά��������
	 * @param a
	 * @return
	 */
	public static void initBooleanArray(boolean[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (StdRandom.bernoulli(0.1))
					a[i][j] = true;
				else
					a[i][j] = false;
			}
		}
	}
	/**
	 * ������a��ɾ��ָ�����±�index
	 * �������鱣��ɾ��ָ���±������飬����a�������ݲ��ᱻ�ı�
	 * @param a
	 * @param index
	 * @return ����ɾ��ָ���±�������
	 */
	public static int[] deleteFromArray(int[] a, int index){
		if(index < 0 || index >= a.length) return a;
		
		int[] afterDelete = new int[a.length - 1];
		for(int i = 0; i < afterDelete.length; i++){
			if(i < index)
				afterDelete[i] = a[i];
			else
				afterDelete[i] = a[i + 1];
		}
		return afterDelete;
	}
	/**
	 * ��value���ӵ�����a��
	 * �������鱣����������֮������飬����a�������ݲ��ᱻ�ı�
	 * @param a
	 * @param value
	 * @return ������������֮�������
	 */
	public static int[] addToArray(int[] a, int value) {
		int[] afterAdd = new int[a.length + 1];
		for(int i = 0; i < a.length; i++){
			afterAdd[i] = a[i];
		}
		afterAdd[afterAdd.length - 1] = value;
		return afterAdd;
	}
	/**
	 * ��lo��hi�ķ�Χ�ڣ�ʹ�� ���ֲ��ҷ�������������key���±�
	 * @param key ��Ҫ���ҵ�ֵ
	 * @param a �����ҵ����ݼ���
	 * @param lo ��ʼ�±�
	 * @param hi �����±�
	 * @return ����ҵ��򷵻��±�ֵ�����򷵻�-1
	 */
	public static int rank(int key, int[] a, int lo, int hi){
		if(lo > hi) return -1;
		int mid = lo + (hi - lo) / 2 ;
		if( key < a[mid]) 
			return rank(key, a, lo, mid - 1);
		else if(key > a[mid]) 
			return rank(key, a, mid + 1, hi);
		else 
			return mid;
	}
	/**
	 * ���ֲ��� 
	 * ������������
	 * @param key ��Ҫ���ҵ�ֵ
	 * @param a �����ҵ����ݼ���
	 * @return
	 */
	public static int rank(int key, int[] a) {
		return rank(key, a, 0, a.length - 1);
	}
	/**
	 * �ڷ�Χlo��hi�ڣ�ʹ�ö��ֲ��ҷ�����������a�б�keyС��ֵ������±�
	 * @param key ��Ҫ���ҵ�ֵ
	 * @param a �����ҵ����ݼ���
	 * @param lo ��ʼ�±�
	 * @param hi �����±�
	 * @return
	 */
	public static int rankForMaxIndexLessThan(int key, int[] a, int lo, int hi){
		StdOut.println(lo + " -- " + hi);
		if(lo > hi) return lo;
		
		int mid = lo + (hi - lo) / 2 ;
		
		if(a[mid] < key){ 
			if(mid + 1 < a.length && a[mid + 1] < key){ // ��֤a[lo] < key
				return rankForMaxIndexLessThan(key, a, mid + 1, hi);
			}
			return mid;
		}else{
			if(mid - 1 >= 0 && a[mid - 1] >= key){ // ��֤a[hi] >= key
				return rankForMaxIndexLessThan(key, a, lo, mid - 1);
			}
			return mid - 1;
		}
	}
	/**
	 * ʹ�ö��ֲ��ҷ�����������a�б�keyС��ֵ������±�
	 * @param key ��Ҫ���ҵ�ֵ
	 * @param a �����ҵ����ݼ���
	 * @return
	 */
	public static int rankForMaxIndexLessThan(int key, int[] a) {
		return rankForMaxIndexLessThan(key, a, 0, a.length - 1);
	}
	/**
	 * �ڷ�Χlo��hi�ڣ�ʹ�ö��ֲ��ҷ�����������a�б�key���ֵ����С�±�
	 * @param key ��Ҫ���ҵ�ֵ
	 * @param a �����ҵ����ݼ���
	 * @param lo ��ʼ�±�
	 * @param hi �����±�
	 * @return
	 */
	public static int rankForMinIndexGreaterThan(int key, int[] a, int lo, int hi){
		StdOut.println(lo + " -- " + hi);
		if(lo > hi) {
			if(hi < 0){ // keyС�ڵ�һ����  0 -- -1
				return 0;
			}else{ // key���ڻ�������һ����  a.length -- a.length - 1
				return -1;
			}
		}
		
		int mid = lo + (hi - lo) / 2 ;
		
		if(a[mid] <= key){ 
			if(mid + 1 < a.length && a[mid + 1] > key){ // ��֤a[lo] <= key
				return mid + 1;
			}
			return rankForMinIndexGreaterThan(key, a, mid + 1, hi);
			
		}else{
			if(mid - 1 >= 0 && a[mid - 1] <= key){ // ��֤a[hi] > key
				return mid;
			}
			return rankForMinIndexGreaterThan(key, a, lo, mid - 1);
			
		}
	}
	/**
	 * ʹ�ö��ֲ��ҷ�����������a�б�key���ֵ����С�±�
	 * @param key 
	 * @param a
	 * @return
	 */
	public static int rankForMinIndexGreaterThan(int key, int[] a) {
		return rankForMinIndexGreaterThan(key, a, 0, a.length - 1);
	}
	/**
	 * ʹ�ö��ֲ��ҷ�����������a��key���ֵĴ���
	 * @param key
	 * @param a
	 * @return
	 */
	public static int rankForCount(int key, int[] a){
		int count = 0;
		
		// key����a�еĿ�����С�±�
		int minIndex = rankForMaxIndexLessThan(key, a) + 1;
		// key����a�еĿ�������±�
		int maxIndex = rankForMinIndexGreaterThan(key, a) - 1;
		if(maxIndex < -1 ){ // ���ڻ����a�е����ֵ
			maxIndex = a.length - 1; 
		}
		if(maxIndex >= minIndex){
			count = maxIndex - minIndex + 1;
		}
		
		return count;
	}
	/**
	 * ��a��b�����Լ����greatest common divisor��
	 * @param a
	 * @param b
	 * @return
	 */
	public static int gcd(int a, int b){
		if(a < b){
			int temp = a;
			a = b;
			b = temp;
		}
		StdOut.println(a + " -- " + b);
		if(b == 0) return 0;
		if(a % b == 0) return b;
		return gcd(a, a % b);
	}
}