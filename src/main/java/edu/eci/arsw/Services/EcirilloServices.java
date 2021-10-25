package edu.eci.arsw.Services;

import edu.eci.arsw.Model.Room;
import edu.eci.arsw.Model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EcirilloServices {

    private HashMap<Integer,Room> rooms;
    private List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
    private Random aleatorio;

    public Boolean Answer(String attempt, Integer roomId){
        if (attempt.equals(rooms.get(roomId).getActualWord())){
            return true;
        }
        return false;
    }

    public String RandomWord(Integer roomId){
         aleatorio=new Random(list.size());
         return list.get(aleatorio.nextInt());
    }

    public String winner(Integer roomId){
        return rooms.get(roomId).getUsers().get(0).getName();
    }

    public EcirilloServices get(){
        return this;
    }
}
