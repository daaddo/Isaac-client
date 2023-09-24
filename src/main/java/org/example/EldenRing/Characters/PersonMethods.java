package org.example.EldenRing.Characters;

import org.example.EldenRing.other.IoDeadException;
import org.example.EldenRing.exceptions.DeadException;

public interface PersonMethods {
    public void combattimento(Person b)throws IoDeadException;
    public boolean attack(Person attaccato, int count)throws DeadException;

}
