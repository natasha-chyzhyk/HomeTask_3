package com.natasha.sourceit.task9;

/**
 * Created by Stas on 30.11.2016.
 */
public class Angel extends BaseMonster implements Flying{
    public Angel(int health, int attackPower, int maxMoveDistance, int maxAttackDistance) {
        super(health, attackPower, maxMoveDistance, maxAttackDistance);
    }

    @Override
    protected CharacterAction getAttack(Character character) {
        return new MagicAttack(character, attackPower);
    }
}