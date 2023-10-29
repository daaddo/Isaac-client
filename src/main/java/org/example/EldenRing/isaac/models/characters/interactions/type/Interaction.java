package org.example.EldenRing.isaac.models.characters.interactions.type;

import org.example.EldenRing.isaac.models.characters.type.Character;

import java.util.List;
import java.util.Optional;


public interface Interaction{
    Optional<String> getImgPath();
    void use();
}
