import java.util.ArrayList;

public class List {
    public ArrayList<Object> elements;

    public List(ArrayList<Object> newElements) {
        this.elements = new ArrayList<>();
        for(Object newElement : newElements)
            this.elements.add(getNewObject(newElement));
    }

    public List(List that) {
        this(that.elements);
    }

    private Object getNewObject(Object o) {
        if(o instanceof List)
            return new List((List) o);
        else
            return o;
    }

    public Object getElement(int index) {
        return this.elements.get(index);
    }

    public int getSize() {return this.elements.size();}

    public void addElement(Object o) {this.elements.add(getNewObject(o));}

}