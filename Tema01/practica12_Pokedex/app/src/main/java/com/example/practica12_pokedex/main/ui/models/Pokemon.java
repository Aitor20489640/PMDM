package com.example.practica12_pokedex.main.ui.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Locale;

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
    private List<Stat> stats;
    @SerializedName("base_experience")
    private int exp;

    public String getIdString() {
        return String.format(new Locale("es", "ES"),"#%03d", id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return String.format(new Locale("es", "ES"),"%.1f KG", ((float) weight) / 10);
    }

    public String getHeight() {
        return String.format(new Locale("es", "ES"),"%.1f M", ((float) height) / 10);
    }

    public List<TypeResponse> getTypes() {
        return types;
    }

    public String getHpString() {
        return String.format(new Locale("es", "ES"),"%d/%d", stats.get(0).getBase_stat(), maxHp);
    }

    public String getAttackString() {
        return String.format(new Locale("es", "ES"),"%d/%d", stats.get(1).getBase_stat(), maxAttack);
    }

    public String getDefenseString() {
        return String.format(new Locale("es", "ES"),"%d/%d", stats.get(2).getBase_stat(), maxDefense);
    }

    public String getSpeedString() {
        return String.format(new Locale("es", "ES"),"%d/%d", stats.get(5).getBase_stat(), maxSpeed);
    }

    public String getExpString() {
        return String.format(new Locale("es", "ES"),"%d/%d", exp, maxExp);
    }

    public int getHp() {
        return stats.get(0).getBase_stat();
    }

    public int getAttack() {
        return stats.get(1).getBase_stat();
    }

    public int getDefense() {
        return stats.get(2).getBase_stat();
    }

    public int getSpeed() {
        return stats.get(5).getBase_stat();
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

    public class Type {
        protected String name;

        public String getName() {
            return name;
        }
    }

    public class Stat {
        protected int base_stat;

        public int getBase_stat() {
            return base_stat;
        }
    }

}
