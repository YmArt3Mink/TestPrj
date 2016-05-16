import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;


class MyStack<Type extends Object> implements Iterable<Type> {
	private Type[] m_data;// массив с элементами стека
	private int m_size; // число элементов в стеке
	
	class MyStackIterator implements Iterator<Type> {
		private int m_currentIdx;
		
		public MyStackIterator()
		{
			// будем перебирать с головы
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

	// при необходимости увеличивает размер стека до нужной величины
	public void growTo(int maxSize) {
		// Проверяем необходимость расширения стека
		if (maxSize > m_data.length) {
			int iNewDataLength = 2 * m_data.length;
			if (maxSize > iNewDataLength) {
				iNewDataLength = maxSize;
			}
			Type[] newData = (Type[]) new Object[iNewDataLength];
			// Если нужно, переносим уже накопленные данные
			if (m_data != null) {
				System.arraycopy(m_data, 0, newData, 0, m_data.length);
			}
			m_data = (Type[]) newData;

			System.out.println("growTo: new size=" + m_data.length);
		}
	}

	  // добавляет элемент в стек
	public void push(Type value) {
		if (m_size >= m_data.length) {
			growTo(m_data.length * 2);
		}
		m_data[m_size] = value;
		m_size++;
	}

	// извлекает элемент из стека
	public Type pop() throws StackException {
		if (m_size > 0) {
			m_size--;
			return m_data[m_size];
		} else {
			throw new StackException(StackException.STACK_EMPTY);
		}
	}

	// возвращает размер стека
	public int getSize() {
		return m_size;
	}

	@Override
	public Iterator<Type> iterator() {
		return this.new MyStackIterator();
	}
}