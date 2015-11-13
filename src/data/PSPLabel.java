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
    private String label;
    private List<String> types;

    public PSPLabel(String label, List<String> types) {
        this.label = label;
        this.types = types;
    }

    public String getLabel() {
        return label;
    }

    public List<String> getTypes() {
        return types;
    }
    
    public boolean existType(String type){
        return types.indexOf(type) > -1;
    }
}
