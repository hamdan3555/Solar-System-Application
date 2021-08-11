package Utils;

import java.util.Random;

public class price_picker {
    int current_color = 0;
    String[] prices = {"1200 PKR", "5000 PKR", "1000 PKR", "2500 PKR", "3500 PKR", "500 PKR"};
    public String get_price(){
        Random rand = new Random();
        current_color = rand.nextInt(prices.length-1);
        return prices[current_color];
    }
}
