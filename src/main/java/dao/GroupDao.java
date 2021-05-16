package dao;

import model.Group;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class GroupDao {

    List<Group> groups;
    private final String GROUPS_FILENAME = "groups";



    public  GroupDao(){
        groups = new LinkedList<>();

        try {
            FileInputStream fileIn = new FileInputStream(GROUPS_FILENAME);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            groups =  (List<Group>) objectIn.readObject();
            objectIn.close();
        }catch(Exception e){
        }

    }


    public List<Group> getGroups(){
        return groups;
    }

    public Group addGroup(Group group) throws Exception{
        groups.add(group);

        FileOutputStream fileOut = new FileOutputStream(GROUPS_FILENAME);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(groups);
        objectOut.close();

        return group;
    }

    public void removeGroup(String id) throws Exception {
        ListIterator<Group> it = groups.listIterator();
        while(it.hasNext()){
            Group s = it.next();
            if(s.getName().equals(id)){
                it.remove();
                break;
            }
        }

        FileOutputStream fileOut = new FileOutputStream(GROUPS_FILENAME);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(groups);
        objectOut.close();
    }

    public Group getGroup(String id) {
        ListIterator<Group> it = groups.listIterator();
        while(it.hasNext()){
            Group s = it.next();
            if(s.getName().equals(id)){
                return s;
            }
        }
        return null;
    }

    public void updateGroup(Group newGroup) throws Exception  {
        ListIterator<Group> it = groups.listIterator();
        while(it.hasNext()){
            Group s = it.next();
            if(s.getName().equals(newGroup.getName())){
                it.set(newGroup);
                break;
            }
        }
        FileOutputStream fileOut = new FileOutputStream(GROUPS_FILENAME);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(groups);
        objectOut.close();
    }
}
