
public class StackException extends Exception {
	// Набор допустимых кодов ошибок
	public final static int STACK_OVERFLOW = 0;
	public final static int STACK_EMPTY = 1;

	// Код ошибки
	private int m_code;

	public StackException(int code) {
		m_code = code;
	}

	// Печатает сообщение об ошибке
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
