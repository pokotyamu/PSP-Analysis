/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;

/**
 *
 * @author pokotyamu
 */
public class PSPLabel {
    private String name;
    private List<String> types;

    public PSPLabel(String name, List<String> types) {
        this.name = name;
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public List<String> getTypes() {
        return types;
    }
    
    public boolean existType(String type){
        return types.indexOf(type) > -1;
    }


    public boolean equals(PSPLabel label) {
        boolean flag1 = this.name.equals(label.getName());
        boolean flag2 = true;
        for (String type : label.getTypes()) {
            flag2 = flag2 && this.types.contains(type);
        }
        return flag1 && flag2;
    }
}
