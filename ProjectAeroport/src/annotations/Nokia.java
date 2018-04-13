/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotations;

/**
 *
 * @author Angelo-KabyLake
 */
@Smartphone(os = "Android", version = 7)
public class Nokia {
    String model;
    int size;

    public Nokia(String model, int size) {
        this.model = model;
        this.size = size;
    }
    
}
