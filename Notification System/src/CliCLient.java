import model.ChannelType;
import model.Notification;
import model.User;
import service.NotifiactionService;
import strategy.impl.InstantStrategy;

import java.util.List;
import java.util.UUID;

public class CliCLient {
    public static void main(String[] args) {

        NotifiactionService notifiactionService = new NotifiactionService(new InstantStrategy());

        User sam = new User("Sameer", ChannelType.EMAIL);
        User neeraj = new User("Neeraj",ChannelType.PUSH);

        notifiactionService.subscribe(sam);
        notifiactionService.subscribe(neeraj);

        Notification notification = new Notification("Sale","50% off on clothes");
        notifiactionService.notifyAll(List.of(sam,neeraj),notification);

    }
}