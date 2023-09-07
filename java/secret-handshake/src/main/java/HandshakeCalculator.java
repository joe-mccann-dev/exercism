import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// derived from https://exercism.org/tracks/java/exercises/secret-handshake/solutions/Grrlie
class HandshakeCalculator {
    public List<Signal> calculateHandshake(int number) {
        List<Signal> actionSequence = new ArrayList<>();

        if (shouldPerformSignal(number, 0))
            actionSequence.add(Signal.WINK);

        if (shouldPerformSignal(number, 1))
            actionSequence.add(Signal.DOUBLE_BLINK);

        if (shouldPerformSignal(number, 2))
            actionSequence.add(Signal.CLOSE_YOUR_EYES);
        
        if (shouldPerformSignal(number, 3))
            actionSequence.add(Signal.JUMP);
        
        if (shouldPerformSignal(number, 4))
            Collections.reverse(actionSequence);


        return actionSequence;
    }

    private boolean shouldPerformSignal(int number, int bitIndex) {
        int rightShiftedBinaryAsDecimal = number >> bitIndex; 

        return (rightShiftedBinaryAsDecimal & 1) == 1;
    }
}
