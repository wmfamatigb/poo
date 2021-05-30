package dao;


import java.util.*;


public abstract class AbstractDao<T extends HasId> {

    private List<T> elements = new LinkedList<>();

    protected AbstractDao() {
    }

    public List<T> findAll(){
        return elements;
    }

    public T save(T element){
        if(element.getId() == null){
            String newId = UUID.randomUUID().toString();
            element.setId(newId);
        }

        // see if we already have the element in the collection (by comparing ids), if so, update
        ListIterator<T> it = elements.listIterator(); // use the list iterator object to loop over the list elements
        while(it.hasNext()){
            T curr = it.next();
            if(curr.getId().equals(element.getId())){ // found an object with the same id
                // update
                it.set(element);
                return element;
            }
        }
        // we don't already have the object in store, so add new element
        elements.add(element);
        return element;
    }


    /**
     * search the element by id in the list, if found, remove it
     * returns true if an element is deleted
     */
    public boolean deleteById(String id){
        ListIterator<T> it = elements.listIterator(); // use list iterator object to loop over list elements
        while(it.hasNext()){
            T s = it.next(); // get the next element in the list
            if(s.getId().equals(id)){
                it.remove();
                return true;
            }
        }
        return false; // no element is found with the given id
    }


    /**
     * Search element in the list by id, if not found, returns null.
     */
    public T findById(String id){
        for(T e : elements)
            if(e.getId().equals(id)) return e;

        return null; // no element having the given id has been found after iterating on the list
    }
}
