import java.io.*;
import java.util.ArrayList;
import java.util.List;

class MemorySaver {
    private ArrayList<Memento> history;
    private int currentState = -1;

    public MemorySaver(){
        this.history = new ArrayList<>();
    }

    public void addMemento(Memento m) {
        history.add(m);
        currentState = history.size();
    }

    public Memento getMemento(int stateIndex) {
        return history.get(stateIndex);
    }

    public Memento undo(){
        if(currentState <=0){
            currentState = 0;
            return getMemento(0);
        }

        return getMemento(--currentState);
    }

    public Memento redo(){
        if(currentState == history.size()-1 ){
            return getMemento(currentState);
        }

        return getMemento(++currentState);
    }

    public void saveToFile(List<WebPage> webpages) throws IOException {
        addMemento(new Memento(webpages));
        FileOutputStream fos = new FileOutputStream("history.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(history);
        oos.close();
    }
    public void getFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("history.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        history = (ArrayList<Memento>) ois.readObject();
        ois.close();
    }

}