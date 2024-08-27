import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OlympicCandles{

    List<Integer> candlez = new ArrayList<>();

    public int numberOfNights(int[] candles){

        for(int candle: candles) candlez.add(candle);

        candlez.sort(Comparator.reverseOrder());

        int nights = 0;

        while(burn(nights + 1)) {
            nights++;
        }

        return nights;

    }

    private boolean burn(int nights) {

        if(nights > candlez.size()) return false;

        for(int i = 0; i < nights; i++) {
            if(candlez.get(i) == 0) {
                return false;
            } else {
                candlez.set(i, candlez.get(i) - 1);
            }
        }

        candlez.sort(Comparator.reverseOrder());
        return true;
    }
}