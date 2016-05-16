import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;


class MyStack<Type extends Object> implements Iterable<Type> {
	private Type[] m_data;// ������ � ���������� �����
	private int m_size; // ����� ��������� � �����
	
	class MyStackIterator implements Iterator<Type> {
		private int m_currentIdx;
		
		public MyStackIterator()
		{
			// ����� ���������� � ������
			m_currentIdx = m_data.length;
		}
		
		@Override
		public boolean hasNext() {
			return m_currentIdx >= 0;
		}

		@Override
		public Type next() {
			return m_data[m_currentIdx--];
		}
	}
	
	public MyStack(int maxSize) {
		m_data = (Type[]) new Object[0];
		m_size = 0;
		growTo(maxSize);
		System.out.println("Stack created");
	}

	// ��� ������������� ����������� ������ ����� �� ������ ��������
	public void growTo(int maxSize) {
		// ��������� ������������� ���������� �����
		if (maxSize > m_data.length) {
			int iNewDataLength = 2 * m_data.length;
			if (maxSize > iNewDataLength) {
				iNewDataLength = maxSize;
			}
			Type[] newData = (Type[]) new Object[iNewDataLength];
			// ���� �����, ��������� ��� ����������� ������
			if (m_data != null) {
				System.arraycopy(m_data, 0, newData, 0, m_data.length);
			}
			m_data = (Type[]) newData;

			System.out.println("growTo: new size=" + m_data.length);
		}
	}

	  // ��������� ������� � ����
	public void push(Type value) {
		if (m_size >= m_data.length) {
			growTo(m_data.length * 2);
		}
		m_data[m_size] = value;
		m_size++;
	}

	// ��������� ������� �� �����
	public Type pop() throws StackException {
		if (m_size > 0) {
			m_size--;
			return m_data[m_size];
		} else {
			throw new StackException(StackException.STACK_EMPTY);
		}
	}

	// ���������� ������ �����
	public int getSize() {
		return m_size;
	}

	@Override
	public Iterator<Type> iterator() {
		return this.new MyStackIterator();
	}
}