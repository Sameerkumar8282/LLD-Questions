package factories;

import models.Cart;
import models.MenuItem;
import models.Restaurant;
import models.User;
import models.order.Order;
import strategy.PaymentStrategy;

import java.util.List;

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> items,
                      PaymentStrategy paymentStrategy, double totalPrice, String orderType);
}
