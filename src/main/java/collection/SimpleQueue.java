package collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();
    private int inputSize = 0;
    private int outputSize = 0;

    public T poll() {
        if (outputSize == 0) {
            if (inputSize == 0) {
                throw new NoSuchElementException("Queue is empty");
            }
            while (inputSize != 0) {
                output.push(input.pop());
                inputSize--;
                outputSize++;
            }
        }
        outputSize--;
        return output.pop();
    }

    public void push(T value) {
        input.push(value);
        inputSize++;
    }
}
