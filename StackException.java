
public class StackException extends Exception {
	// ����� ���������� ����� ������
	public final static int STACK_OVERFLOW = 0;
	public final static int STACK_EMPTY = 1;

	// ��� ������
	private int m_code;

	public StackException(int code) {
		m_code = code;
	}

	// �������� ��������� �� ������
	public String getMessage() {
		switch (m_code) {
		case STACK_OVERFLOW: {
			return "Error: Stack is full.";
		}
		case STACK_EMPTY: {
			return "Error: Stack is empty.";
		}
		default: {
			return "Error: Unknown error.";
		}
		}
	}
}
