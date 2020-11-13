// mediator design pattern
import java.util.HashMap;
import java.util.Map;

//mediator
interface ITransferHandler {
    public void sendMoney(float money,String description, int recipientId);
    void addClient(Client client);
}

// concrete mediator
class TransferHandler implements ITransferHandler {

    private Map<Integer, Client> clients = new HashMap<>();

    @Override
    public void sendMoney(float money,String description, int recipientId)
    {
        Client client = clients.get(recipientId);
        client.receiveMoney(money, description);
    }

    @Override
    public void addClient(Client client) {
        this.clients.put(client.getId(), client);
    }
}

// colleague
 abstract class Client
{
    private ITransferHandler mediator;

    private int id;
    private String name;
    private float moneyBalance;


    public Client(ITransferHandler mediator, int id, String name,float moneyBalance){
        this.mediator = mediator;
        this.id = id;
        this.name = name;
        this.moneyBalance = moneyBalance;
    }

    public abstract void sendMoney(float money,String description, int recipientId);
    public abstract void receiveMoney(float money,String description);

    public ITransferHandler getMediator() {
        return mediator;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getMoneyBalance() {
        return moneyBalance;
    }
}

//concrete colleague
class TransferClient extends Client {

    public TransferClient(ITransferHandler mediator, int id, String name, float moneyBalance) {
        super(mediator, id, name,moneyBalance);
    }

    @Override
    public void sendMoney(float money,String description, int recipientId) {
        System.out.println(this.getName() + " sends " + money + " PLN to user with id " + recipientId + " with description "+ description);
        getMediator().sendMoney(money,description, recipientId);
    }

    @Override
    public void receiveMoney(float money,String description) {
        System.out.println(this.getName() + " received " + money + " PLN with description " + description);
    }

}

 class Bank
{
    public static void main(String[] args)
    {
        ITransferHandler transferHandler = new TransferHandler();

        Client client1 = new TransferClient(transferHandler,1, "Ahmad", 450000);
        Client client2 = new TransferClient(transferHandler,2, "PJATK", 50);
        Client client3 = new TransferClient(transferHandler,3, "Sarah", 70500);

        transferHandler.addClient(client1);
        transferHandler.addClient(client2);
        transferHandler.addClient(client3);

        client1.sendMoney(7500, "Tuition Fees",2);
        client3.sendMoney(50, "Student Card",2);
    }
}

/**  Result
 Ahmad sends 7500.0 PLN to user with id 2 with description Tuition Fees
 PJATK received 7500.0 PLN with description Tuition Fees
 Sarah sends 50.0 PLN to user with id 2 with description Student Card
 PJATK received 50.0 PLN with description Student Card  **/
 
 
