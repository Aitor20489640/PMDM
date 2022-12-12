package com.example.practica12_pokedex.ui.main.models;

import java.util.List;
import java.util.Random;

public class Pokemon {
    //contantes
    public final int maxHp = 300;
    public final int maxAttack = 300;
    public final int maxDefense = 300;
    public final int maxSpeed = 300;
    public final int maxExp = 1000;

    //Atributos
    private int id;
    private String name;
    private int height;
    private int weight;
    private List<TypeResponse> types;
    private final int hp = new Random().nextInt(maxHp);
    private final int attack = new Random().nextInt(maxAttack);
    private final int defense = new Random().nextInt(maxDefense);
    private final int speed = new Random().nextInt(maxSpeed);
    private final int exp = new Random().nextInt(maxExp);
    private List<Move> moves;

    public String getId() {
        return String.format("#%03d", id);
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return String.format("%.1f KG", ((float) weight) / 10);
    }

    public String getHeight() {
        return String.format("%.1f M", ((float) height) / 10);
    }

    public List<TypeResponse> getTypes() {
        return types;
    }

    public String getHpString() {
        return String.format("%d/%d", hp, maxHp);
    }

    public String getAttackString() {
        return String.format("%d/%d", attack, maxAttack);
    }

    public String getDefenseString() {
        return String.format("%d/%d", defense, maxDefense);
    }

    public String getSpeedString() {
        return String.format("%d/%d", speed, maxSpeed);
    }

    public String getExpString() {
        return String.format("%d/%d", exp, maxExp);
    }

    public List<Move> getMoves() {
        return moves;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getExp() {
        return exp;
    }

    public class TypeResponse {
        protected int slot;
        protected Type type;

        public Type getType() {
            return type;
        }
    }

    public class Type{
        protected String name;

        public String getName() {
            return name;
        }
    }

    class Move{
        protected String name;

        public String getName() {
            return name;
        }
    }
}
