package Day11;

import java.util.List;

public class SeatMapper {
    List<String> rawInput;
    final char emptySeat = 'L';
    final char occupiedSeat = '#';
    final char floor = '.';

    public SeatMapper(List<String> rawInput) {
        this.rawInput = rawInput;
    }

    public List<String> getRawInput() {
        return rawInput;
    }
}
