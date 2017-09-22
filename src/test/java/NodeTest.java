import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NodeTest {
    private Node arrayToList(int[] array) {
        if (array.length == 0) {
            return null;
        }
        Node head = new Node();
        Node current = head;
        for (int i = 0; i < array.length; i++) {
            current.value = array[i];
            if (i < array.length - 1) {
                current.next = new Node();
                current = current.next;
            }
        }
        return head;
    }

    private int[] listToArray(Node head) {
        int length = 0;
        Node lengthIterator = head;
        while (lengthIterator != null) {
            length++;
            lengthIterator = lengthIterator.next;
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = head.value;
            head = head.next;
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void reverse(int[] input, int[] expected) {
        Node list = Node.reverse(arrayToList(input));
        int[] result = listToArray(list);
        assertArrayEquals(expected, result);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{}, new int[]{}));
    }
}