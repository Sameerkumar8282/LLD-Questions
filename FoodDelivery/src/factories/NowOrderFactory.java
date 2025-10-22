package factories;

import models.Cart;
import models.MenuItem;
import models.Restaurant;
import models.User;
import models.order.DeliveryOrder;
import models.order.Order;
import models.order.PickupOrder;
import strategy.PaymentStrategy;
import utils.TimeUtils;

import java.util.List;

public class NowOrderFactory implements OrderFactory{
    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems, PaymentStrategy paymentStrategy, double totalCost, String orderType) {
        Order order = null;

        if (orderType.equals("Delivery")) {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        } else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickupOrder;
        }

        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(menuItems);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(TimeUtils.getCurrentTime());
        order.setTotal(totalCost);
        return order;
    }
}
