
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCase1 {
	public void main(String[] args) {
		try {
			doTest4();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void doTest1() throws StackException {
		MyStack<Integer> stack = new MyStack<Integer>(2);
		stack.push(new Integer(1488));
		stack.push(new Integer(1337));
		stack.push(new Integer(228));
		assertEquals(stack.pop(), (Integer) 228);
		assertEquals(stack.pop(), (Integer) 1337);
		assertEquals(stack.pop(), (Integer) 1488);
	}

	@Test
	public void doTest2() throws StackException {
		MyStack<String> stack = new MyStack<String>(2);
		stack.push("Two");
		stack.push("Four");
		stack.push("Three");
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
	}

	@Test
	public void doTest3() throws StackException {
		MyStack<Object> stack = new MyStack<Object>(2);
		stack.push(new Integer(69));
		stack.push("Three");
		stack.push(Boolean.TRUE);
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
	}

	@Test
	public void doTest4() throws StackException {
		MyStack<Object> stack = new MyStack<Object>(2);
		stack.push(1337);
		stack.push("Four");
		stack.push(Boolean.FALSE);
		for (Object elem : stack) {
			System.out.println(elem.toString());
		}
	}

}