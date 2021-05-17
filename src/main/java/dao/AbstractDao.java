package dao;


import java.io.*;
import java.util.*;


public abstract class AbstractDao<T extends HasId> {

    private final String STORE_FILENAME;

    public AbstractDao() {
        STORE_FILENAME = this.getClass().getSimpleName() + ".data";
    }

    public List<T> findAll(){
        return loadStateFromDisk();
    }


    public T save(T element){
        if(element.getId() == null){
            String newId = UUID.randomUUID().toString();
            element.setId(newId);
        }
        List<T> currentElements = loadStateFromDisk();

        ListIterator<T> it = currentElements.listIterator();
        while(it.hasNext()){
            T curr = it.next();
            if(curr.getId().equals(element.getId())){
                // update
                it.set(element);
                persistStateOnDisk(currentElements);
                return element;
            }
        }
        // add new element
        currentElements.add(element);
        persistStateOnDisk(currentElements);
        return element;
    }

    public void deleteById(String id){
        List<T> elements = loadStateFromDisk();
        ListIterator<T> it = elements.listIterator();
        while(it.hasNext()){
            T s = it.next();
            if(s.getId().equals(id)){
                it.remove();
                break;
            }
        }
        persistStateOnDisk(elements);
    }


    public T findById(String id){
        List<T> elements = loadStateFromDisk();
        for(T e : elements)
            if(e.getId().equals(id)) return e;
        return null;
    }


    private void persistStateOnDisk(List<T> elements){
        try{
            FileOutputStream fileOut = new FileOutputStream(STORE_FILENAME);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(elements);
            objectOut.close();
        }catch(Exception e){
            throw new IllegalStateException("failed to persist state on disk");
        }
    }

    private List<T> loadStateFromDisk(){
        try {
            FileInputStream fileIn = new FileInputStream(STORE_FILENAME);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            List<T>  elements =  (List<T>) objectIn.readObject();
            objectIn.close();
            return elements;
        }catch(FileNotFoundException e){
            return new LinkedList<>();
        }catch(Exception e){
            throw new IllegalStateException("Unable to load state from disk");
        }
    }

}
